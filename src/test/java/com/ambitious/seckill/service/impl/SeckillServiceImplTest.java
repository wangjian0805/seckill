package com.ambitious.seckill.service.impl;

import java.util.List;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import com.ambitious.seckill.dao.SeckillDao;
import com.ambitious.seckill.dao.SuccessKilledDao;
import com.ambitious.seckill.dto.Exposer;
import com.ambitious.seckill.dto.SeckillExecution;
import com.ambitious.seckill.entity.Seckill;
import com.ambitious.seckill.exception.RepeatKillException;
import com.ambitious.seckill.exception.SeckillCloseException;
import com.ambitious.seckill.exception.SeckillException;
import com.ambitious.seckill.service.SeckillService;

/**
 * The class <code>SeckillServiceImplTest</code> contains tests for the class <code>{@link SeckillServiceImpl}</code>.
 *
 * @generatedBy CodePro at 17-6-27 下午3:52
 * @author wangjian1
 * @version $Revision: 1.0 $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
									   "classpath:spring/spring-service.xml"})
public class SeckillServiceImplTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;
	
	@Test
	public void getSeckillList() throws Exception{
		List<Seckill> seckills = seckillService.getSeckillList();
		System.out.println(seckills);
		logger.info("list={}",seckills);
	}
	@Test
	public void testSeckillLogic() throws Exception {
		long seckillId = 1000;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		if(exposer.isExposed()){
			System.out.println(exposer);
			long userPhone = 13598764756L;
			String md5 = exposer.getMd5();
			
			try{
				SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
				System.out.println(seckillExecution);
			}catch(RepeatKillException e){
				e.printStackTrace();
			}catch(SeckillCloseException e1){
				e1.printStackTrace();
			}
		}else{
			System.out.println(exposer);
		}
	}
	/**
	 * Run the SeckillServiceImpl() constructor test.
	 *
	 * @generatedBy CodePro at 17-6-27 下午3:52
	 */
	@Test
	public void testSeckillServiceImpl_1()
		throws Exception {
		SeckillServiceImpl result = new SeckillServiceImpl();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the SeckillExecution executeSeckill(long,long,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17-6-27 下午3:52
	 */
	@Test(expected = com.ambitious.seckill.exception.SeckillException.class)
	public void testExecuteSeckill_1()
		throws Exception {
		SeckillServiceImpl fixture = new SeckillServiceImpl();
		fixture.seckillDao = null;
		fixture.successKilledDao = null;
		long seckillId = 1L;
		long userPhone = 1L;
		String md5 = null;

		SeckillExecution result = fixture.executeSeckill(seckillId, userPhone, md5);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the SeckillExecution executeSeckill(long,long,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17-6-27 下午3:52
	 */
	@Test(expected = com.ambitious.seckill.exception.SeckillException.class)
	public void testExecuteSeckill_2()
		throws Exception {
		SeckillServiceImpl fixture = new SeckillServiceImpl();
		fixture.seckillDao = null;
		fixture.successKilledDao = null;
		long seckillId = 1L;
		long userPhone = 1L;
		String md5 = "";

		SeckillExecution result = fixture.executeSeckill(seckillId, userPhone, md5);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the SeckillExecution executeSeckill(long,long,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17-6-27 下午3:52
	 */
	@Test(expected = com.ambitious.seckill.exception.SeckillException.class)
	public void testExecuteSeckill_3()
		throws Exception {
		SeckillServiceImpl fixture = new SeckillServiceImpl();
		fixture.seckillDao = null;
		fixture.successKilledDao = null;
		long seckillId = 1L;
		long userPhone = 1L;
		String md5 = "";

		SeckillExecution result = fixture.executeSeckill(seckillId, userPhone, md5);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Exposer exportSeckillUrl(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17-6-27 下午3:52
	 */
	@Test
	public void testExportSeckillUrl_1()
		throws Exception {
		SeckillServiceImpl fixture = new SeckillServiceImpl();
		fixture.seckillDao = null;
		fixture.successKilledDao = null;
		long seckillId = 1L;

		Exposer result = fixture.exportSeckillUrl(seckillId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ambitious.seckill.service.impl.SeckillServiceImpl.exportSeckillUrl(SeckillServiceImpl.java:53)
		assertNotNull(result);
	}

	/**
	 * Run the Exposer exportSeckillUrl(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17-6-27 下午3:52
	 */
	@Test
	public void testExportSeckillUrl_2()
		throws Exception {
		SeckillServiceImpl fixture = new SeckillServiceImpl();
		fixture.seckillDao = null;
		fixture.successKilledDao = null;
		long seckillId = 1L;

		Exposer result = fixture.exportSeckillUrl(seckillId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ambitious.seckill.service.impl.SeckillServiceImpl.exportSeckillUrl(SeckillServiceImpl.java:53)
		assertNotNull(result);
	}

	/**
	 * Run the Exposer exportSeckillUrl(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17-6-27 下午3:52
	 */
	@Test
	public void testExportSeckillUrl_3()
		throws Exception {
		SeckillServiceImpl fixture = new SeckillServiceImpl();
		fixture.seckillDao = null;
		fixture.successKilledDao = null;
		long seckillId = 1L;

		Exposer result = fixture.exportSeckillUrl(seckillId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ambitious.seckill.service.impl.SeckillServiceImpl.exportSeckillUrl(SeckillServiceImpl.java:53)
		assertNotNull(result);
	}

	/**
	 * Run the Exposer exportSeckillUrl(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17-6-27 下午3:52
	 */
	@Test
	public void testExportSeckillUrl_4()
		throws Exception {
		SeckillServiceImpl fixture = new SeckillServiceImpl();
		fixture.seckillDao = null;
		fixture.successKilledDao = null;
		long seckillId = 1L;

		Exposer result = fixture.exportSeckillUrl(seckillId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ambitious.seckill.service.impl.SeckillServiceImpl.exportSeckillUrl(SeckillServiceImpl.java:53)
		assertNotNull(result);
	}

	/**
	 * Run the Seckill getById(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17-6-27 下午3:52
	 */
	@Test
	public void testGetById_1()
		throws Exception {
		SeckillServiceImpl fixture = new SeckillServiceImpl();
		fixture.seckillDao = null;
		fixture.successKilledDao = null;
		long seckillId = 1L;

		Seckill result = fixture.getById(seckillId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ambitious.seckill.service.impl.SeckillServiceImpl.getById(SeckillServiceImpl.java:45)
		assertNotNull(result);
	}

	/**
	 * Run the List<Seckill> getSeckillList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17-6-27 下午3:52
	 */
	@Test
	public void testGetSeckillList_1()
		throws Exception {
		SeckillServiceImpl fixture = new SeckillServiceImpl();
		fixture.seckillDao = null;
		fixture.successKilledDao = null;

		List<Seckill> result = fixture.getSeckillList();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ambitious.seckill.service.impl.SeckillServiceImpl.getSeckillList(SeckillServiceImpl.java:40)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 17-6-27 下午3:52
	 */
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
	 * @generatedBy CodePro at 17-6-27 下午3:52
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 17-6-27 下午3:52
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SeckillServiceImplTest.class);
	}
}