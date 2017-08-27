package org.ql.shopping.controller.lottery;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ql.shopping.code.Code;
import org.ql.shopping.exception.LotteryException;
import org.ql.shopping.exception.PowerException;
import org.ql.shopping.pojo.lottery.StaticLotteryType;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.pojo.user.UserManager;
import org.ql.shopping.service.lottery.IStaticLotteryTypeService;
import org.ql.shopping.service.user.IUserServiceManagerService;
import org.ql.shopping.util.HttpUrl;
import org.ql.shopping.util.ResultHintUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/static/lottery/type")
public class StaticLotteryTypeController {

	private Logger logger = LoggerFactory.getLogger(StaticLotteryTypeController.class);
	
	private String url(String url){
		return HttpUrl.replaceUrl("/static/lottery/type/" + url);
	}
	
	
	@Resource
	private IStaticLotteryTypeService mStaticLotteryTypeService;
	@Resource 
	private IUserServiceManagerService mUserServiceManagerService;
	
	@RequestMapping("/view/add")
	public String showAddView(Model model){
		model.addAttribute("addUrl",url("/operate/add"));
		return "static/static_lottery_type_add.jsp";
	}
	
	@RequestMapping(value = "/operate/add",method=RequestMethod.POST)
	@ResponseBody
	public Result addType(HttpServletRequest request,StaticLotteryType params){
		Result result = new Result();
		try{
			HttpSession session = request.getSession();
			Integer id = (Integer) session.getAttribute("userId");
			UserManager createUser = mUserServiceManagerService.findUserById(id);
			if(createUser == null){
				throw new LotteryException("没有登陆");
			}
			String power = createUser.getPower();
			if(!"0".equals(power)){
				throw new PowerException("权限不足");
			}
			mStaticLotteryTypeService.insert(params);
			result.setCode(Code.SUCCESS);
		}catch(Exception e){
			logger.error("addType",e);
			ResultHintUtils.setSystemError(result,e);
			
		}
		return result;
	}
}
