package com.uf88.admin.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uf88.admin.manager.TeacherManager;
import com.uf88.admin.dao.TeacherDao;
import com.uf88.admin.pojo.Teacher;
import com.uf88.admin.pojo.TeacherQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;


/**
 * 描述：</b>TeacherManagerImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Component("teacherManager")
public class TeacherManagerImpl implements TeacherManager {
	private final static Logger log= LoggerFactory.getLogger(TeacherManagerImpl.class);
	@Autowired
	private TeacherDao teacherDao;

	@Override
	public void insertTeacher(Teacher teacher) {
		teacherDao.insert(teacher);
	}
	
	@Override
	public void updateTeacher(Teacher teacher) {
		teacherDao.update(teacher);
	}
	
	@Override
	public void deleteTeacherByPriKey(Integer teacherid) {
		teacherDao.deleteByPriKey(teacherid);
	}
	
	@Override
	public Teacher findTeacherByPriKey(Integer teacherid) {
		return teacherDao.findByPriKey(teacherid);
	}
	
	@Override
	public List<Teacher> searchTeacherList(Query<TeacherQuery> query) {
		return teacherDao.getAllList(query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<TeacherQuery> pageQuery) {
		return teacherDao.getItemCount(pageQuery);
	}
	
	@Override
	public List<Teacher> searchPageTeacherList(PageQuery<TeacherQuery> pageQuery) {
		//Integer itemCount = getItemCount(pageQuery);
		return teacherDao.getPageList(pageQuery, 0);
	}
}
