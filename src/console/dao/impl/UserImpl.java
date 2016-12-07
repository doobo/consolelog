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
	 * 初始化User用户表
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
	 * 添加用户
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
	 * 是否存在相同的user
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
	 * 保存用户到文件
	 */
	@Override
	public boolean saveUser() {
		FileUtils.writeOutputStream(userPath, GZipUtils.compressObject(list));
		return true;
	}

	/**
	 * 删除用户
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
	 * 通过ID获取用户信息
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
	 * 通过用户名得到用户信息
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
