package com.ambitious.seckill.dao;

import org.apache.ibatis.annotations.Param;

import com.ambitious.seckill.entity.SuccessKilled;

/**
 * 秒杀成功订单信息Dao层
 * @author wangjian1
 *
 */
public interface SuccessKilledDao {

	/**
	 * 插入购买明细，如重复插入返回0
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
	
	/**
	 * 根据秒杀商品的id查询秒杀成功的订单信息对象
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
