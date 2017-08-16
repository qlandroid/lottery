package org.ql.shopping.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Service.Mode;

import org.ql.shopping.code.Code;
import org.ql.shopping.pojo.Result;
import org.ql.shopping.pojo.Rows;
import org.ql.shopping.pojo.User;
import org.ql.shopping.pojo.params.ListParams;
import org.ql.shopping.service.IUserClientService;
import org.ql.shopping.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/page/user")
public class UserManagerController {
	private Logger logger = LoggerFactory.getLogger(UserManagerController.class);

	@Resource
	IUserService mUserService;
	@Resource
	IUserClientService mUserClientService;

	@RequestMapping("/manager")
	public String userMangerView(HttpServletRequest request,Model model){
		
		return "/page/user_manager.jsp";
	}
	
	@RequestMapping("/addUser")
	public String addUserView(HttpServletRequest requset,Model model){
		return "/page/add_user.jsp";
	}
	
	@RequestMapping("findAll.do")
	@ResponseBody
	public Rows findAll(ListParams params) {
		Rows result = new Rows();
		List<User> list = mUserService.findAll(params);
		result.setCode(Code.SUCCESS);
		long total = mUserService.queryTotalCount();
		System.out.println("total" + total);
		total = total % params.getPageSize() + 1;
		result.setTotal(total);

		result.setList(list);
		return result;
	}
	
	@RequestMapping("deleteUser")
	@ResponseBody
	public Result deleteById(HttpServletRequest request,User user){
		Result result = new Result();
		
		long deleteRows = mUserService.deleteUser(user.getId());
		result.setCode(Code.SUCCESS);
		return result;
	}
}
