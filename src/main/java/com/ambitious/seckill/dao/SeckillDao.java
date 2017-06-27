package com.ambitious.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ambitious.seckill.entity.Seckill;

/**
 * 秒杀时库存表Dao层
 * @author wangjian1
 *
 */
public interface SeckillDao {

	/**
	 * 减库存
	 * @param seckillId
	 * @param killTime
	 * @return 如果影响行数>=1，则减库存成功
	 */
	int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);
	
	/**
	 * 根据秒杀ID查询秒杀的商品信息
	 * @param seckillID
	 * @return
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * 根据偏移量查询秒杀商品列表
	 * @param off
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(@Param("offset") int off, @Param("limit") int limit);
	
	
}
