package com.uf88.admin.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uf88.admin.manager.StuPiechartManager;
import com.uf88.admin.dao.StuPiechartDao;
import com.uf88.admin.pojo.StuPiechart;
import com.uf88.admin.pojo.StuPiechartQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;


/**
 * 描述：</b>StuPiechartManagerImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Component("stuPiechartManager")
public class StuPiechartManagerImpl implements StuPiechartManager {
	private final static Logger log= LoggerFactory.getLogger(StuPiechartManagerImpl.class);
	@Autowired
	private StuPiechartDao stuPiechartDao;

	@Override
	public void insertStuPiechart(StuPiechart stuPiechart) {
		stuPiechartDao.insert(stuPiechart);
	}
	
	@Override
	public void updateStuPiechart(StuPiechart stuPiechart) {
		stuPiechartDao.update(stuPiechart);
	}
	
	@Override
	public void deleteStuPiechartByPriKey(Integer id) {
		stuPiechartDao.deleteByPriKey(id);
	}
	
	@Override
	public StuPiechart findStuPiechartByPriKey(Integer id) {
		return stuPiechartDao.findByPriKey(id);
	}
	
	@Override
	public List<StuPiechart> searchStuPiechartList(Query<StuPiechartQuery> query) {
		return stuPiechartDao.getAllList(query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<StuPiechartQuery> pageQuery) {
		return stuPiechartDao.getItemCount(pageQuery);
	}
	
	@Override
	public List<StuPiechart> searchPageStuPiechartList(PageQuery<StuPiechartQuery> pageQuery) {
		//Integer itemCount = getItemCount(pageQuery);
		return stuPiechartDao.getPageList(pageQuery, 0);
	}
}
