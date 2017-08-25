package org.ql.shopping.util;

import java.util.ArrayList;
import java.util.List;

import org.ql.shopping.pojo.result.MainLeftNav;

public class MainNavFactroy {
	private static MainNavFactroy instans;
	private List<MainLeftNav> navList;
	public static MainNavFactroy getInstans() {
		if (instans == null) {
			synchronized (MainNavFactroy.class) {
				if (instans == null)
					instans = new MainNavFactroy();
			}
		}
		
		return instans;
	}
	
	public MainNavFactroy() {
		List<MainLeftNav> list = new ArrayList<MainLeftNav>();
		MainLeftNav firstIndex = new MainLeftNav();
		firstIndex.setTitle("后台首页");
		firstIndex.setIcon("&#xe622;");
		firstIndex.setHref("#");
		list.add(firstIndex);
		
		
		MainLeftNav userManager = createUserManagerNavGroup();
		list.add(userManager);
		
		MainLeftNav manifestManager = createManifestManagerNavGroup();
		list.add(manifestManager);
		
		MainLeftNav lotteryManager = createLotteryManagerNavGroup();
		list.add(lotteryManager);
		
		MainLeftNav noticeManager =createNoticeManagerNavGroup();
		list.add(noticeManager);
		
		navList = list;
	}

	public List<MainLeftNav> getMianNavList(){
		return navList;
	}




	private MainLeftNav createNoticeManagerNavGroup() {
		MainLeftNav lotteryManager = new MainLeftNav();
		lotteryManager.setTitle("公告管理");
		lotteryManager.setIcon("&#xe622;");
		lotteryManager.setHref("#");
		return lotteryManager;
	}

	private MainLeftNav createManifestManagerNavGroup() {
		MainLeftNav lotteryManager = new MainLeftNav();
		lotteryManager.setTitle("账单管理");
		lotteryManager.setIcon("&#xe622;");
		lotteryManager.setHref("");

		List<MainLeftNav> manager = new ArrayList<MainLeftNav>();
		MainLeftNav income = new MainLeftNav();
		income.setTitle("充值账单");
		income.setIcon("&#xe654;");// &#xe612;
		income.setHref(HttpUrl.replaceUrl("/income/view/list"));
		manager.add(income);

		MainLeftNav expend = new MainLeftNav();
		expend.setTitle("消费积分账单");
		expend.setIcon("&#xe61b;");// &#xe612;
		expend.setHref("#");
		manager.add(expend);

		MainLeftNav change = new MainLeftNav();
		change.setTitle("积分变更账单");
		change.setIcon("&#xe61b;");// &#xe612;
		change.setHref("lbichange/view/list");
		manager.add(change);

		lotteryManager.setChildren(manager);
		return lotteryManager;
	}

	/**
	 * 创建彩票管理导航
	 * 
	 * @return
	 */
	private MainLeftNav createLotteryManagerNavGroup() {
		MainLeftNav lotteryManager = new MainLeftNav();
		lotteryManager.setTitle("彩票管理");
		lotteryManager.setIcon("&#xe622;");
		lotteryManager.setHref("");

		List<MainLeftNav> lotteryManagerList = new ArrayList<MainLeftNav>();
		
		
		MainLeftNav clazz = new MainLeftNav();
		clazz.setTitle("彩票大类管理");
		clazz.setIcon("&#xe654;");// &#xe612;
		clazz.setHref("lottery/clazz/view/list");
		lotteryManagerList.add(clazz);
		
		
		MainLeftNav ssqOpen = new MainLeftNav();
		ssqOpen.setTitle("双色球开奖");
		ssqOpen.setIcon("&#xe654;");// &#xe612;
		ssqOpen.setHref("#");
		lotteryManagerList.add(ssqOpen);

		MainLeftNav ssqClient = new MainLeftNav();
		ssqClient.setTitle("双色球客户端");
		ssqClient.setIcon("&#xe61b;");// &#xe612;
		ssqClient.setHref("#");
		lotteryManagerList.add(ssqClient);

		lotteryManager.setChildren(lotteryManagerList);
		return lotteryManager;
	}

	/**
	 * 创建用户管理
	 * 
	 * @return
	 */
	private MainLeftNav createUserManagerNavGroup() {
		MainLeftNav userManager = new MainLeftNav();
		userManager.setTitle("用户管理");
		userManager.setIcon("&#xe613;");
		userManager.setHref("");

		List<MainLeftNav> userManagerList = new ArrayList<MainLeftNav>();
		MainLeftNav userClient = new MainLeftNav();
		userClient.setTitle("客户端用户");
		userClient.setIcon("&#xe613;");// &#xe612;
		userClient.setHref("userClient/list");
		userManagerList.add(userClient);

		MainLeftNav userManagerClient = new MainLeftNav();
		userManagerClient.setTitle("服务端用户");
		userManagerClient.setIcon("&#xe612;");// &#xe612;
		userManagerClient.setHref("userService/list");
		userManagerList.add(userManagerClient);

		userManager.setChildren(userManagerList);
		return userManager;
	}
}
