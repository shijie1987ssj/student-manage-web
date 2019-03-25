package com.uf88.admin.dao;

import java.util.List;

import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.admin.pojo.Student;
import com.uf88.admin.pojo.StudentQuery;

/**
 * 描述：</b>StudentDao<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分09秒 星期三
 * @version:1.0
 */
public interface StudentDao {

	public void insert(Student student);

	public void update(Student student);

	public void updateAndCheck(Student student);

	public void deleteByPriKey(Integer stuid);

	public void deleteByPriKeyAndCheck(Integer stuid);

	public Student findByPriKey(Integer stuid);

	public List<Student> getAllList(Query<StudentQuery> query);

	public Integer getItemCount(PageQuery<StudentQuery> pageQuery);

	public List<Student> getPageList(PageQuery<StudentQuery> pageQuery, Integer itemCount);
}
