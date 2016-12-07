package console.dao.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import console.dao.UserDao;
import console.dao.vo.User;
import console.util.FileUtils;
import console.util.GZipUtils;

public class UserImpl implements UserDao {

	private static final String userPath = "user.conf";

	private static List<User> list;

	{
		list = new ArrayList<User>();
		initUserDao();
	}

	/**
	 * ��ʼ��User�û���
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean initUserDao() {
		File file = new File(userPath);
		if (file.exists()) {
			list = (List<User>) GZipUtils.decompressObject(FileUtils.readInputStream(userPath));
			return true;
		} else {
			if (list.isEmpty())
				return false;
			FileUtils.writeOutputStream(userPath, GZipUtils.compressObject(list));
		}
		return false;
	}

	/**
	 * ����û�
	 */
	@Override
	public boolean addUser(User user) {
		if (isExitUser(user))
			return false;
		list.add(user);
		saveUser();
		return true;
	}

	/**
	 * �Ƿ������ͬ��user
	 */
	@Override
	public boolean isExitUser(User user) {
		if (list.isEmpty())
			return false;
		Iterator<User> it = list.iterator();
		while (it.hasNext()) {
			if (it.next().equals(user)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �����û����ļ�
	 */
	@Override
	public boolean saveUser() {
		FileUtils.writeOutputStream(userPath, GZipUtils.compressObject(list));
		return true;
	}

	/**
	 * ɾ���û�
	 */
	@Override
	public boolean delUser(User user) {
		Iterator<User> it = list.iterator();
		while (it.hasNext()) {
			if (it.next().equals(user)) {
				list.remove(user);
				saveUser();
				return true;
			}
		}
		return false;
	}

	/**
	 * ͨ��ID��ȡ�û���Ϣ
	 */
	@Override
	public User getUserById(int id) {
		Iterator<User> it = list.iterator();
		User user = new User();
		while (it.hasNext()) {
			if (id == (user = it.next()).getId()) {
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		if (isExitUser(user)) {
			list.remove(getUserById(user.getId()));
			list.add(user);
			saveUser();
			return true;
		}
		return false;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * ͨ���û����õ��û���Ϣ
	 */
	@Override
	public User getUserByName(String name) {
		ListIterator<User> lit = list.listIterator();
		User user;
		while (lit.hasNext()) {
			user = lit.next();
			if ("name".equals(user.getUsername())) {
				return user;
			}
		}
		return null;
	}

}
