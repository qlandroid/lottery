package org.ql.shopping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lottery")
public class LotteryManagerController {

	@RequestMapping("/lottery0")
	public String lotteryMangerView(HttpServletRequest request){
		return "/page/lottery_0.jsp";
	}
}
