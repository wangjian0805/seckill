package com.ambitious.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ambitious.seckill.entity.Seckill;

public interface InocationCase {
	
	@Results({
        @Result(property = "seckillId", column = "seckill_id"),
        @Result(property = "name", column = "name"),
        @Result(property = "number", column = "number"),
        @Result(property = "startTime", column = "start_time"),
        @Result(property = "endTime", column = "end_time"),
        @Result(property = "createTime", column = "create_time"),
	})
	@Select(value = "select * from seckill where seckill_id = #{seckillId}")
	Seckill query(@Param("seckillId") long seckillId);
}
