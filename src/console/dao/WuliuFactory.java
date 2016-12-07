package console.dao;

import console.dao.impl.WuliuImpl;

public class WuliuFactory {

	private static WuliuDao wd = null;

	public static WuliuDao getInstance() {
		if (wd == null) {
			wd = new WuliuImpl();
		}
		return wd;
	}
}
