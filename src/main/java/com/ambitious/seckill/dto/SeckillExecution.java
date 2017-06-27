package com.ambitious.seckill.dto;

import com.ambitious.seckill.entity.SuccessKilled;
import com.ambitious.seckill.enums.SeckillStatEnum;

/**
 * 用户执行秒杀操作后的结果（包括是否秒杀成功等）
 * @author wangjian1
 * @date 日期：2017年6月27日
*  @version 1.0
 */
public class SeckillExecution {

	private long seckillId;
	
	private int state;
	
	private String stateInfo;
	
	private SuccessKilled successKilled;//秒杀成功后的用户购买明细

	//秒杀成功构造方法
	public SeckillExecution(long seckillId, SeckillStatEnum seckillStatEnum, SuccessKilled successKilled) {
		super();
		this.seckillId = seckillId;
		this.state = seckillStatEnum.getState();
		this.stateInfo = seckillStatEnum.getInfo();
		this.successKilled = successKilled;
	}
	
	//秒杀失败构造方法
	public SeckillExecution(long seckillId, SeckillStatEnum seckillStatEnum) {
		super();
		this.seckillId = seckillId;
		this.state = seckillStatEnum.getState();
		this.stateInfo = seckillStatEnum.getInfo();
	}



	public long getSeckillId() {
		return seckillId;
	}


	@Override
	public String toString() {
		return "SeckillExecution [seckillId=" + seckillId + ", state=" + state + ", stateInfo=" + stateInfo
				+ ", successKilled=" + successKilled + "]";
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}
	

	
	
	
}
