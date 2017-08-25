package org.ql.shopping.controller.lottery;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.code.C;
import org.ql.shopping.code.Code;
import org.ql.shopping.exception.LotteryException;
import org.ql.shopping.pojo.lottery.LotteryClazz;
import org.ql.shopping.pojo.lottery.LotteryClazzSearch;
import org.ql.shopping.pojo.lottery.LotteryTypeWithBLOBs;
import org.ql.shopping.pojo.result.LotteryClazzTree;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.pojo.result.ResultClazzTree;
import org.ql.shopping.pojo.result.Rows;
import org.ql.shopping.service.lottery.ILotteryClazzService;
import org.ql.shopping.util.HttpUrl;
import org.ql.shopping.util.ResultHintUtils;
import org.ql.shopping.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lottery/clazz")
public class LotteryClazzController {

	private Logger logger = LoggerFactory
			.getLogger(LotteryClazzController.class);

	private String url(String url) {
		return HttpUrl.replaceUrl("/lottery/clazz/" + url);
	}

	@Resource
	private ILotteryClazzService mLotteryClazzService;

	@RequestMapping("/view/add")
	public String showAddClazzView(Model model) {
		model.addAttribute("clazzUrl", url("operate/clazzAll"));
		model.addAttribute("addUrl", url("operate/add"));
		return "page/lottery/lottery_clazz_add.jsp";
	}

	@RequestMapping("/view/list")
	public String showListView(Model model) {
		model.addAttribute("addClassUrl", url("view/add"));
		model.addAttribute("treeAll", url("operate/all"));
		model.addAttribute("addTypeUrl",HttpUrl.replaceUrl("/lottery/type/view/add"));
		model.addAttribute("addFillUrl",HttpUrl.replaceUrl("/lottery/fill/view/add"));
		return "page/lottery/lottery_clazz_list.jsp";
	}

	@RequestMapping("/operate/add")
	@ResponseBody
	public Result addClazz(LotteryClazzSearch params) {

		Result result = new Result();

		try {
			if (params.getLotteryClazzName() == null) {
				throw new LotteryException("参数不正确");
			}
			if (params.getLotteryClazzParentId() != null) {
				LotteryClazz parentClazz = mLotteryClazzService
						.selectByKey(params.getLotteryClazzParentId());
				if (parentClazz == null) {
					throw new LotteryException("参数不正确");
				}
			}
			mLotteryClazzService.addClazz(params);
			result.setCode(Code.SUCCESS);
		} catch (Exception e) {
			logger.error("addClazz", e);
			ResultHintUtils.setSystemError(result, e);
		}
		return result;
	}

	/**
	 * 添加大类参数检测
	 * 
	 * @param params
	 */
	private void checkAddClazzParams(LotteryClazzSearch params) {
		/*
		 * 必须传入 名称 如parentId == null 就修改为最外层
		 */
		if (StringUtils.isEmpty(params.getLotteryClazzName())) {
			throw new LotteryException("名称不能为空");
		}

	}

	@RequestMapping("/operate/clazzAll")
	@ResponseBody
	public Rows getClazzAll() {

		Rows result = new Rows();
		try {
			LotteryClazzTree findClazzByParentId = mLotteryClazzService
					.findClazzByParentId();
			List<ResultClazzTree> tree = replaceTreeClazzResult(
					findClazzByParentId.getClazzList());
			result.setList(tree);
			result.setCode(Code.SUCCESS);
		} catch (Exception e) {
			logger.error("getClazzAll", e);
			ResultHintUtils.setSystemError(result, e);
		}
		return result;
	}

	@RequestMapping("/operate/all")
	@ResponseBody
	public Rows getTreeAll() {

		Rows result = new Rows();
		try {
			LotteryClazzTree findClazzByParentId = mLotteryClazzService
					.findClazzByParentId();
			List<ResultClazzTree> tree = replaceTreeResult(
					findClazzByParentId.getClazzList(),
					findClazzByParentId.getTypeList());
			result.setList(tree);
			result.setCode(Code.SUCCESS);
		} catch (Exception e) {
			logger.error("getClazzAll", e);
			ResultHintUtils.setSystemError(result, e);
		}
		return result;
	}

	private List<ResultClazzTree> replaceTreeResult(
			List<LotteryClazzTree> list, List<LotteryTypeWithBLOBs> tyepList) {

		List<ResultClazzTree> MainTree = new ArrayList<ResultClazzTree>();

		for (LotteryClazzTree item : list) {
			ResultClazzTree tree = new ResultClazzTree();
			tree.setName(item.getLotteryClazzName());
			tree.setSpread(true);
			tree.setType(ResultClazzTree.TYPE_CLAZZ);
			tree.setId(item.getLotteryClazzId());
			List<ResultClazzTree> l = replaceTreeResult(item.getClazzList(),
					item.getTypeList());
			tree.setChildren(l);
			MainTree.add(tree);
		}
		
		if (tyepList != null) {
			for (LotteryTypeWithBLOBs itemType : tyepList) {
				ResultClazzTree tree = new ResultClazzTree();
				tree.setName(itemType.getLotteryName());
				tree.setType(ResultClazzTree.TYPE_TYPE);
				tree.setId(tree.getId());
				MainTree.add(tree);
			}
		}

		return MainTree;
	}
	private List<ResultClazzTree> replaceTreeClazzResult(
			List<LotteryClazzTree> list) {

		List<ResultClazzTree> MainTree = new ArrayList<ResultClazzTree>();

		for (LotteryClazzTree item : list) {
			ResultClazzTree tree = new ResultClazzTree();
			tree.setName(item.getLotteryClazzName());
			tree.setSpread(true);
			tree.setType(ResultClazzTree.TYPE_CLAZZ);
			tree.setId(item.getLotteryClazzId());
			List<ResultClazzTree> l = replaceTreeClazzResult(item.getClazzList());
			tree.setChildren(l);
			MainTree.add(tree);
		}

		return MainTree;
	}

}
