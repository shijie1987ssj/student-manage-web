package com.uf88.admin.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uf88.admin.manager.StuscoreManager;
import com.uf88.admin.dao.StuscoreDao;
import com.uf88.admin.pojo.Stuscore;
import com.uf88.admin.pojo.StuscoreQuery;
import com.uf88.admin.pojo.StuscoreSum;
import com.uf88.admin.pojo.StuscoreVo;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>StuscoreManagerImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分09秒 星期三
 * @version:1.0
 */
@Component("stuscoreManager")
public class StuscoreManagerImpl implements StuscoreManager {
	private final static Logger log = LoggerFactory.getLogger(StuscoreManagerImpl.class);
	@Autowired
	private StuscoreDao stuscoreDao;

	@Override
	public void insertStuscore(Stuscore stuscore) {
		stuscoreDao.insert(stuscore);
	}

	@Override
	public void updateStuscore(Stuscore stuscore) {
		stuscoreDao.update(stuscore);
	}

	@Override
	public void deleteStuscoreByPriKey(Integer stuid) {
		stuscoreDao.deleteByPriKey(stuid);
	}

	@Override
	public StuscoreVo findStuscoreByPriKey(Integer stuid) {
		return stuscoreDao.findByPriKey(stuid);
	}

	@Override
	public List<Stuscore> searchStuscoreList(Query<StuscoreQuery> query) {
		return stuscoreDao.getAllList(query);
	}

	@Override
	public Integer getItemCount(PageQuery<StuscoreQuery> pageQuery) {
		return stuscoreDao.getItemCount(pageQuery);
	}

	@Override
	public List<StuscoreVo> searchPageStuscoreList(PageQuery<StuscoreQuery> pageQuery) {
		// Integer itemCount = getItemCount(pageQuery);
		return stuscoreDao.getPageList(pageQuery, 0);
	}

	@Override
	public List<StuscoreSum> searchStuscoreListSum(Query<StuscoreQuery> query) {
		return stuscoreDao.getAllListSum(query);
	}
}
