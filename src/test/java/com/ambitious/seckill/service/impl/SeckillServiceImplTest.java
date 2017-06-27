package com.ambitious.seckill.service.impl;

import com.ambitious.seckill.dto.Exposer;
import com.ambitious.seckill.dto.SeckillExecution;
import com.ambitious.seckill.entity.Seckill;
import com.ambitious.seckill.exception.RepeatKillException;
import com.ambitious.seckill.exception.SeckillCloseException;
import com.ambitious.seckill.service.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ambitous on 2017/6/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                "classpath:spring/spring-service.xml"})
public class SeckillServiceImplTest {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> seckills=seckillService.getSeckillList();
        System.out.println(seckills);
        logger.info("list={}",seckills);

    }

    @Test
    public void getById() throws Exception {

        long seckillId=1000;
        Seckill seckill=seckillService.getById(seckillId);
        System.out.println(seckill);
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        long seckillId=1000;
        Exposer exposer=seckillService.exportSeckillUrl(seckillId);
        System.out.println(exposer);
    }

    @Test
    public void executeSeckill() throws Exception {
        long seckillId=1000;
        long userPhone=13476191876L;
        String md5="fd75b59e270b032c474357c9dd7740bd";

        try {
            SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);


            System.out.println(seckillExecution);
        }catch (RepeatKillException e)
        {
            e.printStackTrace();
        }catch (SeckillCloseException e1)
        {
            e1.printStackTrace();
        }
    }

    @Test//完整逻辑代码测试，注意可重复执行
    public void testSeckillLogic() throws Exception {
        long seckillId=1000;
        Exposer exposer=seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed())
        {
            System.out.println(exposer);
            long userPhone=13476191876L;
            String md5=exposer.getMd5();

            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
                System.out.println(seckillExecution);
            }catch (RepeatKillException e)
            {
                e.printStackTrace();
            }catch (SeckillCloseException e1)
            {
                e1.printStackTrace();
            }
        }else {
            //秒杀未开启
            System.out.println(exposer);
        }
    }
}