package com.ambitious.seckill.exception;

/**
 * 自定义异常类
 * @author wangjian1
 * @date 日期：2017年6月27日
*  @version 1.0
 */
public class SeckillException extends RuntimeException{
	public SeckillException(String message){
		super(message);
	}
	public SeckillException(String message, Throwable cause){
		super(message, cause);
	}
}
