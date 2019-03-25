package com.uf88.admin.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uf88.admin.manager.GradeManager;
import com.uf88.admin.dao.GradeDao;
import com.uf88.admin.pojo.Grade;
import com.uf88.admin.pojo.GradeQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;


/**
 * 描述：</b>GradeManagerImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Component("gradeManager")
public class GradeManagerImpl implements GradeManager {
	private final static Logger log= LoggerFactory.getLogger(GradeManagerImpl.class);
	@Autowired
	private GradeDao gradeDao;

	@Override
	public void insertGrade(Grade grade) {
		gradeDao.insert(grade);
	}
	
	@Override
	public void updateGrade(Grade grade) {
		gradeDao.update(grade);
	}
	
	@Override
	public void deleteGradeByPriKey(String gradename) {
		gradeDao.deleteByPriKey(gradename);
	}
	
	@Override
	public Grade findGradeByPriKey(String gradename) {
		return gradeDao.findByPriKey(gradename);
	}
	
	@Override
	public List<Grade> searchGradeList(Query<GradeQuery> query) {
		return gradeDao.getAllList(query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<GradeQuery> pageQuery) {
		return gradeDao.getItemCount(pageQuery);
	}
	
	@Override
	public List<Grade> searchPageGradeList(PageQuery<GradeQuery> pageQuery) {
		//Integer itemCount = getItemCount(pageQuery);
		return gradeDao.getPageList(pageQuery, 0);
	}
}
