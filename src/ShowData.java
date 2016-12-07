import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import console.dao.UserFactory;
import console.dao.WuliuFactory;
import console.dao.vo.User;
import console.dao.vo.Wuliu;

public class ShowData {
	private static List<User> ulist = new ArrayList<>();

	private static List<Wuliu> wulist = new ArrayList<>();

	/**
	 * 显示原始数据
	 */
	public static void showAllData() {
		List<User> list = UserFactory.getInstance().getAllUser();
		if (list.isEmpty()) {
			System.out.println("还没有日志记录消息！");
		} else {
			System.out.println("日志的原始记录如下：");
			Collections.sort(list, new SortByTime());
			for (User user : list) {
				System.out.println(user);
			}
		}

		List<Wuliu> wlist = WuliuFactory.getInstance().getAllWuliu();
		if (wlist.isEmpty()) {
			System.out.println("还没有记录物流信息！");
		} else {
			System.out.println("物流的原始信息如下：");
			Collections.sort(wlist, new SortByTime1());
			for (Wuliu wuliu : wlist) {
				System.out.println(wuliu);
			}
		}

	}

	/**
	 * 匹配数据
	 */

	public static void piPei() {
		System.out.println("数据配置中...");
		ulist = UserFactory.getInstance().getAllUser();
		if (ulist.isEmpty()) {
			System.out.println("匹配了0条日志记录");
		} else {
			Collections.sort(ulist, new SortByTime());
			Collections.sort(ulist, new SortByName2());
			System.out.println("匹配了" + ulist.size() + "条日志记录");
		}

		wulist = WuliuFactory.getInstance().getAllWuliu();
		if (wulist.isEmpty()) {
			System.out.println("匹配了0条物流信息");
		} else {
			Collections.sort(wulist, new SortByTime1());
			Collections.sort(wulist, new SortByName());
			System.out.println("匹配了" + wulist.size() + "条物流信息");
		}
	}

	/**
	 * 显示匹配后的数据
	 */
	public static void showPi() {
		if (ulist.isEmpty()) {
			System.out.println("没有匹配好的日志，检查是否选择了数据匹配");
		} else {
			System.out.println("匹配的日志如下：");
			for (User user : ulist) {
				System.out.println(user);
			}
		}
		if (wulist.isEmpty()) {
			System.out.println("没有匹配好的物流信息，检查是否选择了数据匹配");
		} else {
			System.out.println("匹配的物流信息如下：");
			for (Wuliu wl : wulist) {
				System.out.println(wl);
			}
		}

	}
}

class SortByTime implements Comparator<User> {
	public int compare(User o1, User o2) {
		if (o1.getCreateTime().getTime() > o2.getCreateTime().getTime())
			return 1;
		return 0;
	}
}

class SortByName2 implements Comparator<User> {
	public int compare(User o1, User o2) {
		return o1.getUsername().compareTo(o2.getUsername());
	}
}

class SortByTime1 implements Comparator<Wuliu> {
	public int compare(Wuliu o1, Wuliu o2) {
		return o1.getCreateTime().compareTo(o2.getCreateTime());
	}
}

class SortByName implements Comparator<Wuliu> {
	@Override
	public int compare(Wuliu o1, Wuliu o2) {
		return o1.getToName().compareTo(o2.getToName());
	}
}