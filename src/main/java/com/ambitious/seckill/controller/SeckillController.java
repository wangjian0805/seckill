package com.ambitious.seckill.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ambitious.seckill.dto.Exposer;
import com.ambitious.seckill.dto.SeckillExecution;
import com.ambitious.seckill.dto.SeckillResult;
import com.ambitious.seckill.entity.Seckill;
import com.ambitious.seckill.enums.SeckillStatEnum;
import com.ambitious.seckill.exception.RepeatKillException;
import com.ambitious.seckill.exception.SeckillCloseException;
import com.ambitious.seckill.service.SeckillService;



/**
 * 控制器
 * @author wangjian1
 * @date 日期：2017年6月27日
*  @version 1.0
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {
	
	@Autowired
	private SeckillService seckillService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model){
		List<Seckill> list = seckillService.getSeckillList();
		model.addAttribute("list",list);
		return "list";
	}
	
	@RequestMapping(value="/{seckillId}/detail", method=RequestMethod.GET)
	public String detail(@PathVariable("seckillId") Long seckillId, Model model){
		if(seckillId==null){
			return "redirect:/seckill/list";
		}
		Seckill seckill = seckillService.getById(seckillId);
		if(seckill == null){
			return "forward/seckill/list";
		}
		model.addAttribute("seckill",seckill);
		return "detail";
	}
	
	@ResponseBody
	@RequestMapping(value="/{seckillId}/exposer",
								  method=RequestMethod.POST,
								  produces={"application/json;charset=UTF-8"})
	public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId){
		SeckillResult<Exposer> result;
		try{
			Exposer exposer = seckillService.exportSeckillUrl(seckillId);
			result = new SeckillResult<Exposer>(true, exposer);
		}catch(Exception e){
			e.printStackTrace();
			result = new SeckillResult<Exposer>(false, e.getMessage());
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/{seckillId}/{md5}/execution",
								  method=RequestMethod.POST,
								  produces={"application/json;charset=UTF-8"})
	public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") Long seckillId,
																			@PathVariable("md5") String md5,
																			@CookieValue(value="killPhone",required=false) Long phone){
		if(phone==null){
			return new SeckillResult<SeckillExecution>(false, "未注册");
		}
		try{
			SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, phone, md5);
			return new SeckillResult<SeckillExecution>(true, seckillExecution);
		}catch(RepeatKillException e1){
			SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStatEnum.REPEATE_KILL);
			return new SeckillResult<SeckillExecution>(true,seckillExecution);
		}catch(SeckillCloseException e2){
			SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStatEnum.END);
			return new SeckillResult<SeckillExecution>(true, seckillExecution);
		}catch(Exception e){
			SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
			return new SeckillResult<SeckillExecution>(true, seckillExecution);
			
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/time/now",method=RequestMethod.GET)
	public SeckillResult<Long> time(){
		System.out.println("进入获取时间controller");
		Date now = new Date();
		return new SeckillResult<Long>(true,now.getTime());
	}
}
