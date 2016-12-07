package console.dao;

import java.util.List;

import console.dao.vo.Wuliu;

public interface WuliuDao {
	boolean initWuliuDao();

	boolean addWuliu(Wuliu wuliu);

	boolean isExitWuliu(Wuliu wuliu);

	boolean saveWuliu();

	boolean updateWuliu(Wuliu wuliu);

	boolean delWuliu(Wuliu wuliu);

	Wuliu getWuliuById(int id);

	List<Wuliu> getAllWuliu();
}
