package console.test;


import org.junit.Test;

import console.dao.UserDao;
import console.dao.UserFactory;
import console.dao.WuliuFactory;
import console.dao.vo.Wuliu;

public class DaoTest {

	private UserDao  ud = null;
	{
		ud = UserFactory.getInstance();
	}
	
	@Test
	public void delDate(){
		Wuliu wl = new Wuliu();
		
		wl = WuliuFactory.getInstance().getWuliuById(4);
		System.out.println(wl);
		WuliuFactory.getInstance().delWuliu(wl);
		
	}
	
	@Test
	public void test() {
//		User user =  new User(3, "adkdskdksk", "admin", "192.168.1.0");
		
//		ud.addUser(user);
//		ud.addUser(new User(2, "dskkk", "root", "192.168.1.1"));
//	
//		System.out.println(ud.addUser(new User(3, "dskkk", "root", "192.168.1.1")));
		
//		System.out.println(ud.getUserById(4));
		
//		User user =ud.getUserById(1);
//		user.setCreateTime(new Date());
//		System.out.println(ud.updateUser(user));
		System.out.println(ud.getUserById(1));
		
	}
	
	
	@Test
	public void testWuliu(){
/*		Wuliu wl = new Wuliu();
		wl.setCreateTime(new Date());
		wl.setId(0);
		wl.setCroassName("addd");
		wl.setToName("admin");
		WuliuFactory.getInstance().addWuliu(wl);*/
		
		System.out.println(WuliuFactory.getInstance().getWuliuById(0));
	}

}
