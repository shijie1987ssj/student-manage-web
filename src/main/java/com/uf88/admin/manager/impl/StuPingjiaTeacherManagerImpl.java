package com.uf88.admin.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uf88.admin.manager.StuPingjiaTeacherManager;
import com.uf88.admin.dao.StuPingjiaTeacherDao;
import com.uf88.admin.pojo.StuPingjiaTeacher;
import com.uf88.admin.pojo.StuPingjiaTeacherQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;


/**
 * 描述：</b>StuPingjiaTeacherManagerImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Component("stuPingjiaTeacherManager")
public class StuPingjiaTeacherManagerImpl implements StuPingjiaTeacherManager {
	private final static Logger log= LoggerFactory.getLogger(StuPingjiaTeacherManagerImpl.class);
	@Autowired
	private StuPingjiaTeacherDao stuPingjiaTeacherDao;

	@Override
	public void insertStuPingjiaTeacher(StuPingjiaTeacher stuPingjiaTeacher) {
		stuPingjiaTeacherDao.insert(stuPingjiaTeacher);
	}
	
	@Override
	public void updateStuPingjiaTeacher(StuPingjiaTeacher stuPingjiaTeacher) {
		stuPingjiaTeacherDao.update(stuPingjiaTeacher);
	}
	
	@Override
	public void deleteStuPingjiaTeacherByPriKey(Integer id) {
		stuPingjiaTeacherDao.deleteByPriKey(id);
	}
	
	@Override
	public StuPingjiaTeacher findStuPingjiaTeacherByPriKey(Integer id) {
		return stuPingjiaTeacherDao.findByPriKey(id);
	}
	
	@Override
	public List<StuPingjiaTeacher> searchStuPingjiaTeacherList(Query<StuPingjiaTeacherQuery> query) {
		return stuPingjiaTeacherDao.getAllList(query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<StuPingjiaTeacherQuery> pageQuery) {
		return stuPingjiaTeacherDao.getItemCount(pageQuery);
	}
	
	@Override
	public List<StuPingjiaTeacher> searchPageStuPingjiaTeacherList(PageQuery<StuPingjiaTeacherQuery> pageQuery) {
		//Integer itemCount = getItemCount(pageQuery);
		return stuPingjiaTeacherDao.getPageList(pageQuery, 0);
	}
}
