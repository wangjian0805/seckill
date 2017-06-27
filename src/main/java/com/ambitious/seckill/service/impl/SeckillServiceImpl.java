package com.ambitious.seckill.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ambitious.seckill.dao.SeckillDao;
import com.ambitious.seckill.dao.SuccessKilledDao;
import com.ambitious.seckill.dto.Exposer;
import com.ambitious.seckill.dto.SeckillExecution;
import com.ambitious.seckill.entity.Seckill;
import com.ambitious.seckill.entity.SuccessKilled;
import com.ambitious.seckill.enums.SeckillStatEnum;
import com.ambitious.seckill.exception.RepeatKillException;
import com.ambitious.seckill.exception.SeckillCloseException;
import com.ambitious.seckill.exception.SeckillException;
import com.ambitious.seckill.service.SeckillService;
import com.ambitious.seckill.util.MD5Utils;



@Service
public class SeckillServiceImpl implements SeckillService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SeckillDao seckillDao;
	
	@Autowired
	SuccessKilledDao successKilledDao;
	
	public List<Seckill> getSeckillList() {
		return seckillDao.queryAll(0, 10);
	}

	public Seckill getById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}

	
	/**
	 * 返回商品的秒杀接口，如未开始秒杀，返回系统时间和秒杀时间
	 */
	public Exposer exportSeckillUrl(long seckillId) {
		Seckill seckill = seckillDao.queryById(seckillId);
		if(seckill == null){
			return new Exposer(false, seckillId);//没有这个秒杀商品
		}
		Date startTime = seckill.getStartTime();
		Date endTime= seckill.getEndTime();
		Date nowTime = new Date();
		if(startTime.getTime()>nowTime.getTime() || endTime.getTime()<nowTime.getTime()){
			//不在秒杀时间内
			return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
		}
		//这个商品在秒杀时间内
		String md5 = MD5Utils.getMD5(seckillId);
		return new Exposer(true, md5,seckillId);
	}

	@Transactional
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, SeckillCloseException, RepeatKillException {
		if(md5 == null || !md5.equals(MD5Utils.getMD5(seckillId))){
			throw new SeckillException("seckill data rewrite");
		}
		Date nowTime = new Date();
		
		try{
			int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
			if(updateCount <= 0){
				throw new SeckillCloseException("seckill is closed");
			}else{
				int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
				if(insertCount<=0){
					throw new RepeatKillException("seckill repeat");
				}else{
					SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
					return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS,successKilled);
				}
			}
		}catch (SeckillCloseException e1){
			throw e1;
		}catch (RepeatKillException e2){
			throw e2;
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			throw new SeckillException("seckill inner error:"+e.getMessage());
		}
	}
	

}
