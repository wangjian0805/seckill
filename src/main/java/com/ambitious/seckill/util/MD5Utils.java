package com.ambitious.seckill.util;

import org.springframework.util.DigestUtils;

public class MD5Utils {

	private final static String SALT = "lfjeljawe#$#$^#<><254254";
	
	public static String getMD5(long seckillId){
		String base = seckillId+"/"+SALT;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}
}
