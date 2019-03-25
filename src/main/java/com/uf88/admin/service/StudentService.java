package com.uf88.admin.service;

import com.uf88.admin.pojo.Student;
import com.uf88.admin.pojo.StudentQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>StudentService<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分09秒 星期三
 * @version:1.0
 */
public interface StudentService {

	public GenericResult<String> addStudent(Student student);

	public BasicResult modifyStudent(Student student);

	public GenericResult<Student> findByPriKey(Integer stuid);

	public BasicResult checkLogin(String name, String passwd);

	public BasicResult deleteByPriKey(Integer stuid);

	public ListResult<Student> searchStudent(Query<StudentQuery> query);

	public PageListResult<Student> searchPageStudent(PageQuery<StudentQuery> pageQuery);

}
