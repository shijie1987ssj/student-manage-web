package com.uf88.admin.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uf88.admin.manager.EfeiManager;
import com.uf88.admin.dao.EfeiDao;
import com.uf88.admin.pojo.Efei;
import com.uf88.admin.pojo.EfeiQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;


/**
 * 描述：</b>EfeiManagerImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
@Component("efeiManager")
public class EfeiManagerImpl implements EfeiManager {
	private final static Logger log= LoggerFactory.getLogger(EfeiManagerImpl.class);
	@Autowired
	private EfeiDao efeiDao;

	@Override
	public void insertEfei(Efei efei) {
		efeiDao.insert(efei);
	}
	
	@Override
	public void updateEfei(Efei efei) {
		efeiDao.update(efei);
	}
	
	@Override
	public void deleteEfeiByPriKey(Integer id) {
		efeiDao.deleteByPriKey(id);
	}
	
	@Override
	public Efei findEfeiByPriKey(Integer id) {
		return efeiDao.findByPriKey(id);
	}
	
	@Override
	public List<Efei> searchEfeiList(Query<EfeiQuery> query) {
		return efeiDao.getAllList(query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<EfeiQuery> pageQuery) {
		return efeiDao.getItemCount(pageQuery);
	}
	
	@Override
	public List<Efei> searchPageEfeiList(PageQuery<EfeiQuery> pageQuery) {
		//Integer itemCount = getItemCount(pageQuery);
		return efeiDao.getPageList(pageQuery, 0);
	}
}
