package com.ambitious.seckill.entity;

import java.util.Date;

/**
 * 秒杀成功订单信息实体类
 * @author wangjian1
 *
 */
public class SuccessKilled {

	private long seckillId;
	private long userPhone;
	private short stat;
	private Date createTime;
	
	//多对一，因为一件商品在库存中有很多数量，对应的购物明细也有
	private Seckill seckill;

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public short getStat() {
		return stat;
	}

	public void setStat(short stat) {
		this.stat = stat;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	@Override
	public String toString() {
		return "SuccessKilled [seckillId=" + seckillId + ", userPhone=" + userPhone + ", stat=" + stat + ", createTime="
				+ createTime + ", seckill=" + seckill + "]";
	}
	
	
}
