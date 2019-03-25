package com.uf88.admin.manager;

import java.util.List;
import com.uf88.admin.pojo.Student;
import com.uf88.admin.pojo.StudentQuery;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>StudentManager<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分09秒 星期三
 * @version:1.0
 */
public interface StudentManager {

	public void insertStudent(Student student);

	public void updateStudent(Student student);

	public void deleteStudentByPriKey(Integer stuid);

	public Student findStudentByPriKey(Integer stuid);

	public List<Student> searchStudentList(Query<StudentQuery> query);

	public Integer getItemCount(PageQuery<StudentQuery> pageQuery);

	public List<Student> searchPageStudentList(PageQuery<StudentQuery> pageQuery);
}
