package com.uf88.admin.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uf88.admin.manager.StudentManager;
import com.uf88.admin.dao.StudentDao;
import com.uf88.admin.pojo.Student;
import com.uf88.admin.pojo.StudentQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;


/**
 * 描述：</b>StudentManagerImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Component("studentManager")
public class StudentManagerImpl implements StudentManager {
	private final static Logger log= LoggerFactory.getLogger(StudentManagerImpl.class);
	@Autowired
	private StudentDao studentDao;

	@Override
	public void insertStudent(Student student) {
		studentDao.insert(student);
	}
	
	@Override
	public void updateStudent(Student student) {
		studentDao.update(student);
	}
	
	@Override
	public void deleteStudentByPriKey(Integer stuid) {
		studentDao.deleteByPriKey(stuid);
	}
	
	@Override
	public Student findStudentByPriKey(Integer stuid) {
		return studentDao.findByPriKey(stuid);
	}
	
	@Override
	public List<Student> searchStudentList(Query<StudentQuery> query) {
		return studentDao.getAllList(query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<StudentQuery> pageQuery) {
		return studentDao.getItemCount(pageQuery);
	}
	
	@Override
	public List<Student> searchPageStudentList(PageQuery<StudentQuery> pageQuery) {
		//Integer itemCount = getItemCount(pageQuery);
		return studentDao.getPageList(pageQuery, 0);
	}
}
