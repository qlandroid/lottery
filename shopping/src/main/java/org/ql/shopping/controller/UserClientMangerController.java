package org.ql.shopping.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.ql.shopping.HttpUrl;
import org.ql.shopping.code.Code;
import org.ql.shopping.exception.AccountErrorException;
import org.ql.shopping.pojo.Result;
import org.ql.shopping.pojo.UserClient;
import org.ql.shopping.pojo.params.UserClientManagerParams;
import org.ql.shopping.pojo.result.UrlResult;
import org.ql.shopping.service.IUserClientManagerService;
import org.ql.shopping.util.ResultHintUtils;
import org.ql.shopping.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/userClient")
public class UserClientMangerController {
	private Logger logger = LoggerFactory.getLogger(UserClientMangerController.class);

	@Resource
	private IUserClientManagerService mUserClientManagerService;

	
	@RequestMapping("/addView")
	public ModelAndView showAddView(){
		ModelAndView mav =new ModelAndView();
		mav.setViewName("/page/user_client_add.jsp");
		mav.addObject("addUrl", HttpUrl.replaceUrl("/userClient/operate/addUser"));
		return mav;
	}
	
	/**
	 * 通过条件进行分页查询所有用户
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView getUserList(UserClientManagerParams params) {
		ModelAndView mav = new ModelAndView();
		try {
			Long page = params.getPage();
			if (page == null || page <= 0) {
				page = 1L;
				params.setPage(page);
			}
			Integer pageSize = params.getPageSize();
			if (pageSize == null || pageSize <= 0) {
				pageSize = 10;
				params.setPageSize(pageSize);
			}
			
			List<UserClient> list = mUserClientManagerService.findUser(params);
			Long total = mUserClientManagerService.getTotalCount(params);
			total = total/params.getPageSize() +1;
			mav.addObject("total", total);
			mav.addObject("addUrl",HttpUrl.replaceUrl("/userClient/"));
			mav.addObject("page",params.getPage());
			mav.addObject("userList",list);
			mav.addObject("params",params);
			mav.setViewName("page/user_client_manager.jsp");
		} catch (Exception e) {
			logger.error("getUserList",e);
		}

		return mav;
	}
	
	@RequestMapping(value="/operate/addUser",method=RequestMethod.POST)
	@ResponseBody
	public Result addUser(HttpServletRequest request,UserClientManagerParams params){
		Result result = new Result();
		try{
			String account = params.getAccount();
			String pw = params.getPw();
			if(StringUtils.isEmpty(account)){
				throw new AccountErrorException("账号不能为空");
			}
			if(StringUtils.isEmpty(pw)){
				throw new AccountErrorException("密码不能为空");
			}
			
			mUserClientManagerService.inserte(params);
			UrlResult url = new UrlResult();
			url.setUrl(HttpUrl.replaceUrl("/userClient/list"));
			result.setCode(Code.SUCCESS);
			result.setData(url);
			
		}catch(Exception e){
			logger.error("addUser",e);
			ResultHintUtils.setSystemError(result,e);
		}
		
		
		return result;
	}

}
