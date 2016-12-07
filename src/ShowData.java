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
	 * ��ʾԭʼ����
	 */
	public static void showAllData() {
		List<User> list = UserFactory.getInstance().getAllUser();
		if (list.isEmpty()) {
			System.out.println("��û����־��¼��Ϣ��");
		} else {
			System.out.println("��־��ԭʼ��¼���£�");
			Collections.sort(list, new SortByTime());
			for (User user : list) {
				System.out.println(user);
			}
		}

		List<Wuliu> wlist = WuliuFactory.getInstance().getAllWuliu();
		if (wlist.isEmpty()) {
			System.out.println("��û�м�¼������Ϣ��");
		} else {
			System.out.println("������ԭʼ��Ϣ���£�");
			Collections.sort(wlist, new SortByTime1());
			for (Wuliu wuliu : wlist) {
				System.out.println(wuliu);
			}
		}

	}

	/**
	 * ƥ������
	 */

	public static void piPei() {
		System.out.println("����������...");
		ulist = UserFactory.getInstance().getAllUser();
		if (ulist.isEmpty()) {
			System.out.println("ƥ����0����־��¼");
		} else {
			Collections.sort(ulist, new SortByTime());
			Collections.sort(ulist, new SortByName2());
			System.out.println("ƥ����" + ulist.size() + "����־��¼");
		}

		wulist = WuliuFactory.getInstance().getAllWuliu();
		if (wulist.isEmpty()) {
			System.out.println("ƥ����0��������Ϣ");
		} else {
			Collections.sort(wulist, new SortByTime1());
			Collections.sort(wulist, new SortByName());
			System.out.println("ƥ����" + wulist.size() + "��������Ϣ");
		}
	}

	/**
	 * ��ʾƥ��������
	 */
	public static void showPi() {
		if (ulist.isEmpty()) {
			System.out.println("û��ƥ��õ���־������Ƿ�ѡ��������ƥ��");
		} else {
			System.out.println("ƥ�����־���£�");
			for (User user : ulist) {
				System.out.println(user);
			}
		}
		if (wulist.isEmpty()) {
			System.out.println("û��ƥ��õ�������Ϣ������Ƿ�ѡ��������ƥ��");
		} else {
			System.out.println("ƥ���������Ϣ���£�");
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