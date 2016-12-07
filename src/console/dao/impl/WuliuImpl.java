package console.dao.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import console.dao.WuliuDao;
import console.dao.vo.Wuliu;
import console.util.FileUtils;
import console.util.GZipUtils;

public class WuliuImpl implements WuliuDao {

	private static final String wuliuPath = "wuliu.conf";

	private static List<Wuliu> list;

	{
		list = new ArrayList<Wuliu>();
		initWuliuDao();
	}

	/**
	 * 初始化list表格
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean initWuliuDao() {
		File file = new File(wuliuPath);
		if (file.exists()) {
			list = (List<Wuliu>) GZipUtils.decompressObject(FileUtils.readInputStream(wuliuPath));
			return true;
		} else {
			if (list.isEmpty())
				return false;
			FileUtils.writeOutputStream(wuliuPath, GZipUtils.compressObject(list));
		}
		return false;
	}

	@Override
	public boolean addWuliu(Wuliu wuliu) {
		if (isExitWuliu(wuliu))
			return false;
		list.add(wuliu);
		saveWuliu();
		return true;
	}

	@Override
	public boolean isExitWuliu(Wuliu wuliu) {
		if (list.isEmpty())
			return false;
		Iterator<Wuliu> it = list.iterator();
		while (it.hasNext()) {
			if (it.next().equals(wuliu)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean saveWuliu() {
		FileUtils.writeOutputStream(wuliuPath, GZipUtils.compressObject(list));
		return false;
	}

	@Override
	public boolean updateWuliu(Wuliu wuliu) {
		if (isExitWuliu(wuliu)) {
			list.remove(wuliu);
			list.add(wuliu);
			saveWuliu();
			return true;
		}
		return false;
	}

	@Override
	public boolean delWuliu(Wuliu wuliu) {
		if (isExitWuliu(wuliu)) {
			list.remove(wuliu);
			saveWuliu();
			return true;
		}
		return false;
	}

	@Override
	public Wuliu getWuliuById(int id) {
		Iterator<Wuliu> it = list.iterator();
		Wuliu wuliu = new Wuliu();
		while (it.hasNext()) {
			if (id == (wuliu = it.next()).getId()) {
				return wuliu;
			}
		}
		return null;
	}

	@Override
	public List<Wuliu> getAllWuliu() {
		return list;
	}

}
