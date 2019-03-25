package com.uf88.admin.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.uf88.admin.dao.TeacherDao;
import com.uf88.admin.pojo.Teacher;
import com.uf88.admin.pojo.TeacherQuery;
import com.uf88.uf88core.common.dao.BaseDao;
import com.uf88.uf88core.common.exception.Uf88Exception;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.PageQueryWrapper;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation;

 /**
 * 描述：</b>TeacherDaoImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Repository("teacherDao")
public class TeacherDaoImpl extends BaseDao implements TeacherDao {
	private final static Logger log= LoggerFactory.getLogger(TeacherDaoImpl.class);
	
	@Override
	public void insert(Teacher teacher){
		Object o =insert("TEACHER.insert", teacher);
		 
	}
	
	@Override
	public void update(Teacher teacher){
		update("TEACHER.update", teacher); 
	}
	
	@Override
	public void updateAndCheck(Teacher teacher){
		updateAndCheck("TEACHER.update", teacher); 
	}
	
	@Override
	public void deleteByPriKey(Integer teacherid){
		Teacher teacher = new Teacher();
		teacher.setTeacherid(teacherid);
		delete("TEACHER.deleteByPriKey", teacher); 
	}
	
	@Override
	public void deleteByPriKeyAndCheck(Integer teacherid){
		Teacher teacher = new Teacher();
		teacher.setTeacherid(teacherid);
		deleteAndCheck("TEACHER.deleteByPriKey", teacher);  
	}
	
	@Override
	public Teacher findByPriKey(Integer teacherid){
		Teacher teacher = new Teacher();
		teacher.setTeacherid(teacherid);
		teacher = (Teacher)this.queryForObject("TEACHER.findByPriKey", teacher);
		return teacher;
	}
	
	@Override
	public List<Teacher> getAllList(Query<TeacherQuery> query) {
		return this.queryForList("TEACHER.getAllList",query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<TeacherQuery> pageQuery) {
		return (Integer) queryForObject("TEACHER.getItemCount",pageQuery);
	}
	
	@Override
	public List<Teacher> getPageList(PageQuery<TeacherQuery> pageQuery, Integer itemCount) {
		PageQueryWrapper<TeacherQuery> wrapper = new PageQueryWrapper<TeacherQuery>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery(), pageQuery.getSort());
		return this.queryForList("TEACHER.getPagenationList",wrapper);
	}
}
