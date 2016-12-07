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
				getScannerToString("���������ַ�����.....................");
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
				System.out.println("�Ѿ��˳�Ӧ�ã���ӭ�ٴ�ʹ�ã�");
				return;
			default:
				System.out.println("�����������������Χ�����������룺");
				break;
			}
		}
	}

	// �������ݲɼ�
	private static void handleCai() {
		int sel = getScannerToInt("��ѡ�����ݲɼ������ͣ�1.��־  2.���� \n");
		switch (sel) {
		case 1:
			System.out.println("��ѡ����������־��¼");
			String flay = "y";
			while ("y".equals(flay)) {
				int id = getScannerToInt("������ID\n");
				while (UserFactory.getInstance().getUserById(id) != null) {
					id = getScannerToInt("ID�Ѿ����ڣ�����������ID��");
				}
				String address = getScannerToString("�������ַ\n");
				String name = getScannerToString("�������û���\n");

				String ipadd = getScannerToString("������IP��ַ\n");
				while (!CheckAll.isIPAddr(ipadd)) {
					ipadd = getScannerToString("�������IP��ַ��Ч�����������룺\n");
				}
				int type = getScannerToInt("��ѡ����־����:1.��¼  0.�ǳ�\n");
				while (type != 1 && type != 0) {
					type = getScannerToInt("��־���Ͳ��ٷ�Χ��1��0���У�����������\n");
				}
				if (UserFactory.getInstance().addUser(new User(id, new Date(), address, name, ipadd, type))) {
					System.out.println("�ɹ������־��¼��");
				} else {
					System.out.println("�������");
					return;
				}
				System.out.print("�Ƿ������Ӽ�¼��y/n����");
				flay = getScannerToString("").toLowerCase();
			}
			return;
		case 2:
			System.out.println("��ѡ��������������Ϣ");
			flay = "y";
			while ("y".equals(flay)) {
				int id = getScannerToInt("������ID��\n");
				while (WuliuFactory.getInstance().getWuliuById(id) != null) {
					id = getScannerToInt("��ID�Ѿ����ڣ�����������ID��");
				}
				String address = getScannerToString("�������ַ��\n");
				String crossName = getScannerToString("�������ջ������ˣ�\n");
				String toName = getScannerToString("�������ջ��ˣ�\n");
				int type = getScannerToInt("����������״̬��1�����У�2�ͻ��У�3��ǩ��\n");
				while (type != 1 && type != 2 && type != 3) {
					type = getScannerToInt("����״̬���ٷ�Χ��1��2��3���У�����������\n");
				}
				if (WuliuFactory.getInstance().addWuliu(new Wuliu(id, new Date(), address, crossName, toName, type))) {
					System.out.println("�ɹ����������Ϣ��");
				} else {
					System.out.println("�������");
				}
				System.out.print("�Ƿ�������������Ϣ��y/n����");
				flay = getScannerToString("").toLowerCase();
			}
			return;
		default:
			System.out.print("�����������������Χ��");
			break;
		}
	}

	// ��ʾ���вɼ���ԭʼ����
	private static void toShowAll() {
		System.out.println("��ѡ�������ʾ���е�ԭʼ���ݼ�¼��");
		ShowData.showAllData();
	}

	// ��ȡ������ַ�(�����ո񣬺��ո���Ҫ����ʵ��)
	public static String getScannerToString(String info) {
		System.out.print(info);
		sc = new Scanner(System.in);
		return sc.next();
	}

	// ��ȡ���������
	public static int getScannerToInt(String info) {
		sc = new Scanner(System.in);
		System.out.print(info);
		try {
			int i = sc.nextInt();
			return i;
		} catch (Exception e) {
			System.out.println("������Ĳ������ݣ�����������");
			return getScannerToInt("");
		}
	}

	// ��ʾ�˵���Ŀ
	public static void toMume() {
		int lx = 35;
		for (int i = 0; i < lx; i++)
			System.out.print("*");
		System.out.println();

		System.out.println("*1�����ݲɼ�\t2������ƥ��*");
		System.out.println("*3����ʼ��¼\t4��ƥ����ʾ*");
		System.out.println("*5���˳�Ӧ��*");

		for (int i = 0; i < lx; i++)
			System.out.print("*");
		System.out.println();

		System.out.println("������˵��1-5����");
	}

}
