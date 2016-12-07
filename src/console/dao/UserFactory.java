package console.dao;

import console.dao.impl.UserImpl;

public class UserFactory {

	private static UserDao userdao = null;

	public static UserDao getInstance() {
		if (userdao == null) {
			userdao = new UserImpl();
		}
		return userdao;
	}

}
