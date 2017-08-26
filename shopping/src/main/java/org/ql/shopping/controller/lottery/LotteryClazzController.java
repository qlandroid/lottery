package org.ql.shopping.controller.lottery;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.code.C;
import org.ql.shopping.code.Code;
import org.ql.shopping.exception.LotteryException;
import org.ql.shopping.pojo.lottery.LotteryClazz;
import org.ql.shopping.pojo.lottery.LotteryClazzSearch;
import org.ql.shopping.pojo.lottery.LotteryFillOpen;
import org.ql.shopping.pojo.lottery.LotteryTypeWithBLOBs;
import org.ql.shopping.pojo.result.LotteryClazzTree;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.pojo.result.ResultClazzTree;
import org.ql.shopping.pojo.result.Rows;
import org.ql.shopping.service.lottery.ILotteryClazzService;
import org.ql.shopping.service.lottery.ILotteryFillOpenService;
import org.ql.shopping.service.lottery.ILotteryTypeService;
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

	private Logger logger = LoggerFactory.getLogger(LotteryClazzController.class);

	private String url(String url) {
		return HttpUrl.replaceUrl("/lottery/clazz/" + url);
	}

	@Resource
	private ILotteryClazzService mLotteryClazzService;
	
	@Resource
	private ILotteryTypeService mLotteryTypeService;
	@Resource
	private ILotteryFillOpenService mLotteryFillOpenService;

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
		model.addAttribute("addTypeUrl", HttpUrl.replaceUrl("/lottery/type/view/add"));
		model.addAttribute("addFillUrl", HttpUrl.replaceUrl("/lottery/fill/view/add"));
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
				LotteryClazz parentClazz = mLotteryClazzService.selectByKey(params.getLotteryClazzParentId());
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
			List<LotteryClazz> clazzList = mLotteryClazzService.findClazzByParentId(C.LotteryClazz.MAIN);
			
			List<ResultClazzTree> clazzTree = replaceClazzTreeList(clazzList);
			result.setList(clazzTree);
			result.setCode(Code.SUCCESS);
		} catch (Exception e) {
			logger.error("getClazzAll", e);
			ResultHintUtils.setSystemError(result, e);
		}
		return result;
	}
	
	/**
	 * 用于遍历查询 大类树状结构
	 * 
	 * @param clazzList
	 * @return
	 */
	private List<ResultClazzTree> replaceClazzTreeList(List<LotteryClazz> clazzList){
		ArrayList<ResultClazzTree> clazzTree = new ArrayList<ResultClazzTree>();
		for (LotteryClazz item : clazzList) {
			ResultClazzTree tree = new ResultClazzTree();
			tree.setName(item.getLotteryClazzName());
			tree.setSpread(true);
			tree.setType(ResultClazzTree.TYPE_CLAZZ);
			tree.setId(item.getLotteryClazzId());
			List<LotteryClazz> childrenList = mLotteryClazzService.findClazzByParentId(item.getLotteryClazzId());
			List<ResultClazzTree> l = replaceClazzTreeList(childrenList);
			tree.setChildren(l);
			clazzTree.add(tree);
		}
		return clazzTree;
	}

	@RequestMapping("/operate/all")
	@ResponseBody
	public Rows getTreeAll() {

		Rows result = new Rows();
		try {
			List<LotteryClazz> clazzList = mLotteryClazzService.findClazzByParentId(C.LotteryClazz.MAIN);
			List<ResultClazzTree> tree = replaceTreeResult(clazzList, C.LotteryClazz.MAIN);
			result.setList(tree);
			result.setCode(Code.SUCCESS);
		} catch (Exception e) {
			logger.error("getClazzAll", e);
			ResultHintUtils.setSystemError(result, e);
		}
		return result;
	}

	/**
	 * 用于查询全部类型和大类
	 * 
	 * @param list 大类集合
	 * @param clazzId 查询当前大类所对应的彩票类型
	 * @return
	 */
	private List<ResultClazzTree> replaceTreeResult(List<LotteryClazz> list,Integer clazzId) {

		List<ResultClazzTree> mainTree = new ArrayList<ResultClazzTree>();

		for (LotteryClazz item : list) {
			ResultClazzTree tree = new ResultClazzTree();
			tree.setName(item.getLotteryClazzName());
			tree.setSpread(true);
			tree.setType(ResultClazzTree.TYPE_CLAZZ);
			tree.setId(item.getLotteryClazzId());
			List<LotteryClazz> childrenList = mLotteryClazzService.findClazzByParentId(item.getLotteryClazzId());
			List<ResultClazzTree> l = replaceTreeResult(childrenList,item.getLotteryClazzId());
			tree.setChildren(l);
			mainTree.add(tree);
			
		}
		
		List<LotteryTypeWithBLOBs> typeList = mLotteryTypeService.selectByLotteryClazzId(clazzId);
		for (LotteryTypeWithBLOBs typeItem : typeList) {
			ResultClazzTree tree = new ResultClazzTree();
			tree.setName(typeItem.getLotteryName());
			tree.setType(ResultClazzTree.TYPE_TYPE);
			tree.setId(typeItem.getLotteryTypeId());
			
			LotteryFillOpen params = new LotteryFillOpen();
			params.setLotteryTypeId(typeItem.getLotteryTypeId());
			List<LotteryFillOpen> openList = mLotteryFillOpenService.selectByParams(params);
			
			List<ResultClazzTree> fillOpenTree = replaceFillOpenTree(openList);
			tree.setChildren(fillOpenTree);
			
			mainTree.add(tree);
		}
		
		return mainTree;
	}

	/**
	 *  将彩票转化成 树型结构 用于显示
	 * @param openList
	 * @return
	 */
	private List<ResultClazzTree> replaceFillOpenTree(List<LotteryFillOpen> openList) {
		List<ResultClazzTree> treeList = new ArrayList<ResultClazzTree>();
		for (LotteryFillOpen fillItem : openList) {
			ResultClazzTree tree = new ResultClazzTree();
			tree.setName(fillItem.getLotteryFillName());
			tree.setType(ResultClazzTree.TYPE_FILL_OPEN);
			tree.setId(fillItem.getLotteryFillOpenId());
			treeList.add(tree);
		}
		
		return treeList;
	}

}
