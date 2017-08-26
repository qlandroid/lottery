package org.ql.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageIndexController {

	@RequestMapping("/index")
	public String indexView() {
		return "page/index.jsp";
	}
}
