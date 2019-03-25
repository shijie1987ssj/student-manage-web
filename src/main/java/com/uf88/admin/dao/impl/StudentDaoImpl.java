package com.uf88.admin.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.uf88.admin.dao.StudentDao;
import com.uf88.admin.pojo.Student;
import com.uf88.admin.pojo.StudentQuery;
import com.uf88.uf88core.common.dao.BaseDao;
import com.uf88.uf88core.common.exception.Uf88Exception;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.PageQueryWrapper;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation;

 /**
 * 描述：</b>StudentDaoImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Repository("studentDao")
public class StudentDaoImpl extends BaseDao implements StudentDao {
	private final static Logger log= LoggerFactory.getLogger(StudentDaoImpl.class);
	
	@Override
	public void insert(Student student){
		Object o =insert("STUDENT.insert", student);
		 
	}
	
	@Override
	public void update(Student student){
		update("STUDENT.update", student); 
	}
	
	@Override
	public void updateAndCheck(Student student){
		updateAndCheck("STUDENT.update", student); 
	}
	
	@Override
	public void deleteByPriKey(Integer stuid){
		Student student = new Student();
		student.setStuid(stuid);
		delete("STUDENT.deleteByPriKey", student); 
	}
	
	@Override
	public void deleteByPriKeyAndCheck(Integer stuid){
		Student student = new Student();
		student.setStuid(stuid);
		deleteAndCheck("STUDENT.deleteByPriKey", student); 
	}
	
	@Override
	public Student findByPriKey(Integer stuid){
		Student student = new Student();
		student.setStuid(stuid);
		student = (Student)this.queryForObject("STUDENT.findByPriKey", student);
		return student;
	}
	
	@Override
	public List<Student> getAllList(Query<StudentQuery> query) {
		return this.queryForList("STUDENT.getAllList",query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<StudentQuery> pageQuery) {
		return (Integer) queryForObject("STUDENT.getItemCount",pageQuery);
	}
	
	@Override
	public List<Student> getPageList(PageQuery<StudentQuery> pageQuery, Integer itemCount) {
		PageQueryWrapper<StudentQuery> wrapper = new PageQueryWrapper<StudentQuery>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery(), pageQuery.getSort());
		return this.queryForList("STUDENT.getPagenationList",wrapper);
	}
}
