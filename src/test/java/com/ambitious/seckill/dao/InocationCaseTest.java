package com.ambitious.seckill.dao;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import com.ambitious.seckill.entity.Seckill;

/**
 * The class <code>InocationCaseTest</code> contains tests for the class <code>{@link InocationCase}</code>.
 *
 * @generatedBy CodePro at 17-6-27 下午1:48
 * @author wangjian1
 * @version $Revision: 1.0 $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class InocationCaseTest {
	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 17-6-27 下午1:48
	 */
	@Resource
	private InocationCase inocationCase;
	
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 17-6-27 下午1:48
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	@Test
	public void query(){
		long seckillId = 1000L;
		Seckill seckill = inocationCase.query(seckillId);
		if(seckill == null)	System.out.println("seckill is null");
		System.out.println(seckill);
		
	}
	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 17-6-27 下午1:48
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(InocationCaseTest.class);
	}
}