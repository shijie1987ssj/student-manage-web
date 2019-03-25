package com.uf88.admin.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uf88.admin.manager.TeacherscoreManager;
import com.uf88.admin.dao.TeacherscoreDao;
import com.uf88.admin.pojo.Teacherscore;
import com.uf88.admin.pojo.TeacherscoreQuery;
import com.uf88.admin.pojo.TeacherscoreSum;
import com.uf88.admin.pojo.TeacherscoreVo;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>TeacherscoreManagerImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分10秒 星期三
 * @version:1.0
 */
@Component("teacherscoreManager")
public class TeacherscoreManagerImpl implements TeacherscoreManager {
	private final static Logger log = LoggerFactory.getLogger(TeacherscoreManagerImpl.class);
	@Autowired
	private TeacherscoreDao teacherscoreDao;

	@Override
	public void insertTeacherscore(Teacherscore teacherscore) {
		teacherscoreDao.insert(teacherscore);
	}

	@Override
	public void updateTeacherscore(Teacherscore teacherscore) {
		teacherscoreDao.update(teacherscore);
	}

	@Override
	public void deleteTeacherscoreByPriKey(Integer teacherid) {
		teacherscoreDao.deleteByPriKey(teacherid);
	}

	@Override
	public Teacherscore findTeacherscoreByPriKey(Integer teacherid) {
		return teacherscoreDao.findByPriKey(teacherid);
	}

	@Override
	public List<Teacherscore> searchTeacherscoreList(Query<TeacherscoreQuery> query) {
		return teacherscoreDao.getAllList(query);
	}

	@Override
	public Integer getItemCount(PageQuery<TeacherscoreQuery> pageQuery) {
		return teacherscoreDao.getItemCount(pageQuery);
	}

	@Override
	public List<TeacherscoreVo> searchPageTeacherscoreList(PageQuery<TeacherscoreQuery> pageQuery) {
		// Integer itemCount = getItemCount(pageQuery);
		return teacherscoreDao.getPageList(pageQuery, 0);
	}

	@Override
	public List<TeacherscoreSum> searchTeacherscoreListSum(Query<TeacherscoreQuery> query) {
		return teacherscoreDao.getAllListSum(query);
	}
}
