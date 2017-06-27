package com.ambitious.seckill.service;

import java.util.List;

import com.ambitious.seckill.dto.Exposer;
import com.ambitious.seckill.dto.SeckillExecution;
import com.ambitious.seckill.entity.Seckill;
import com.ambitious.seckill.exception.RepeatKillException;
import com.ambitious.seckill.exception.SeckillCloseException;
import com.ambitious.seckill.exception.SeckillException;

/**
 * 秒杀服务层
 * @author wangjian1
 * @date 日期：2017年6月27日
*  @version 1.0
 */
public interface SeckillService {

	/**
	 * 查询全部的商品记录
	 * @return
	 */
	List<Seckill> getSeckillList();
	
	/**
	 * 查询单个秒杀商品
	 * @param seckillId
	 * @return
	 */
	Seckill getById(long seckillId);
	
	/**
	 * 获取商品的购买接口
	 * @param seckillId
	 * @return
	 */
	Exposer exportSeckillUrl(long seckillId);
	
	
	SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
				throws SeckillException,SeckillCloseException,RepeatKillException;
}
