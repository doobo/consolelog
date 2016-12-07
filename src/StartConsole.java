import java.util.Date;
import java.util.Scanner;

import console.dao.UserFactory;
import console.dao.WuliuFactory;
import console.dao.vo.User;
import console.dao.vo.Wuliu;
import console.util.CheckAll;

public class StartConsole {

	private static Scanner sc;

	public static void main(String[] args) {
		int select = 0;
		boolean tg = false;
		while (true) {
			if (tg)
				getScannerToString("输入任意字符继续.....................");
			tg = true;
			toMume();
			select = getScannerToInt("");
			switch (select) {
			case 1:
				handleCai();
				break;
			case 2:
				ShowData.piPei();
				break;

			case 3:
				toShowAll();
				break;
			case 4:
				ShowData.showPi();
				break;
			case 5:
				System.out.println("已经退出应用，欢迎再次使用！");
				return;
			default:
				System.out.println("你输入的整数超出范围，请重新输入：");
				break;
			}
		}
	}

	// 处理数据采集
	private static void handleCai() {
		int sel = getScannerToInt("请选择数据采集的类型：1.日志  2.物流 \n");
		switch (sel) {
		case 1:
			System.out.println("你选择的是添加日志记录");
			String flay = "y";
			while ("y".equals(flay)) {
				int id = getScannerToInt("请输入ID\n");
				while (UserFactory.getInstance().getUserById(id) != null) {
					id = getScannerToInt("ID已经存在，请重新输入ID：");
				}
				String address = getScannerToString("请输入地址\n");
				String name = getScannerToString("请输入用户名\n");

				String ipadd = getScannerToString("请输入IP地址\n");
				while (!CheckAll.isIPAddr(ipadd)) {
					ipadd = getScannerToString("你输入的IP地址无效，请重新输入：\n");
				}
				int type = getScannerToInt("请选择日志类型:1.登录  0.登出\n");
				while (type != 1 && type != 0) {
					type = getScannerToInt("日志类型不再范围（1，0）中，请重新输入\n");
				}
				if (UserFactory.getInstance().addUser(new User(id, new Date(), address, name, ipadd, type))) {
					System.out.println("成功添加日志记录。");
				} else {
					System.out.println("保存错误！");
					return;
				}
				System.out.print("是否继续添加记录（y/n）：");
				flay = getScannerToString("").toLowerCase();
			}
			return;
		case 2:
			System.out.println("你选择的是添加物流信息");
			flay = "y";
			while ("y".equals(flay)) {
				int id = getScannerToInt("请输入ID：\n");
				while (WuliuFactory.getInstance().getWuliuById(id) != null) {
					id = getScannerToInt("该ID已经存在，请重新输入ID：");
				}
				String address = getScannerToString("请输入地址：\n");
				String crossName = getScannerToString("请输入收货经手人：\n");
				String toName = getScannerToString("请输入收货人：\n");
				int type = getScannerToInt("请输入物流状态：1发货中，2送货中，3已签收\n");
				while (type != 1 && type != 2 && type != 3) {
					type = getScannerToInt("物流状态不再范围（1，2，3）中，请重新输入\n");
				}
				if (WuliuFactory.getInstance().addWuliu(new Wuliu(id, new Date(), address, crossName, toName, type))) {
					System.out.println("成功添加物流信息！");
				} else {
					System.out.println("保存出错！");
				}
				System.out.print("是否继续添加物流信息（y/n）：");
				flay = getScannerToString("").toLowerCase();
			}
			return;
		default:
			System.out.print("你输入的整数超出范围，");
			break;
		}
	}

	// 显示所有采集的原始数据
	private static void toShowAll() {
		System.out.println("你选择的是显示所有的原始数据记录：");
		ShowData.showAllData();
	}

	// 获取输入的字符(不含空格，含空格需要另外实现)
	public static String getScannerToString(String info) {
		System.out.print(info);
		sc = new Scanner(System.in);
		return sc.next();
	}

	// 获取输入的数据
	public static int getScannerToInt(String info) {
		sc = new Scanner(System.in);
		System.out.print(info);
		try {
			int i = sc.nextInt();
			return i;
		} catch (Exception e) {
			System.out.println("你输入的不是数据，请重新输入");
			return getScannerToInt("");
		}
	}

	// 显示菜单项目
	public static void toMume() {
		int lx = 35;
		for (int i = 0; i < lx; i++)
			System.out.print("*");
		System.out.println();

		System.out.println("*1、数据采集\t2、数据匹配*");
		System.out.println("*3、初始记录\t4、匹配显示*");
		System.out.println("*5、退出应用*");

		for (int i = 0; i < lx; i++)
			System.out.print("*");
		System.out.println();

		System.out.println("请输入菜单项（1-5）：");
	}

}
