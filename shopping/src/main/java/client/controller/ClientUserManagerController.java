package client.controller;

import javax.annotation.Resource;

import org.ql.shopping.code.Code;
import org.ql.shopping.exception.ParamsErrorException;
import org.ql.shopping.exception.PasswordErrorException;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.pojo.user.UserLogin;
import org.ql.shopping.service.user.IUserClientManagerService;
import org.ql.shopping.service.user.IUserLoginService;
import org.ql.shopping.util.ResultHintUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import client.pojo.user.UserLoginSearch;
import client.service.user.IUserManagerService;
import client.utils.TokenUtils;

@Controller
@RequestMapping("/user/manager")
public class ClientUserManagerController {

	private Logger logger = LoggerFactory.getLogger(ClientUserManagerController.class);
	
	
	@Resource
	private IUserManagerService mUserManagerService;
	
	
	@RequestMapping("/login")
	@ResponseBody
	public Result login(UserLoginSearch params){
		Result result = new Result();
		
		try{
			checkLoginParams(params);
			
			String account = params.getAccount();
			String pw = params.getPw();
			
			UserLoginSearch user = mUserManagerService.selectyByAccountAndPw(account, pw);
			if( user == null){
				throw new PasswordErrorException("账号或密码不正确");
			}
			result.setCode(Code.SUCCESS);
			
			UserLoginSearch token = new UserLoginSearch();
			String tokenStr= TokenUtils.createToken(account,pw,user.getId());
			token.setToken(tokenStr);
			result.setData(token);
			
		}catch(Exception e){
			logger.error("login",e);
			ResultHintUtils.setSystemError(result,e);
		}
		
		return result;
	}


	private void checkLoginParams(UserLogin params) {
		String account = params.getAccount();
		String pw = params.getPw();
		if(StringUtils.isEmpty(account) || StringUtils.isEmpty(pw)){
				throw new ParamsErrorException("参数不正确");
		}
	}
}
