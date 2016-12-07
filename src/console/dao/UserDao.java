package console.dao;

import java.util.List;

import console.dao.vo.User;

public interface UserDao {

	boolean initUserDao();

	boolean addUser(User user);

	boolean isExitUser(User user);

	boolean saveUser();

	boolean updateUser(User user);

	boolean delUser(User user);

	User getUserById(int id);

	List<User> getAllUser();

	User getUserByName(String name);
}
