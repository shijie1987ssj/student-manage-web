package com.uf88.admin.manager;

import java.util.List;
import com.uf88.admin.pojo.Teacher;
import com.uf88.admin.pojo.TeacherQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>TeacherManager<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface TeacherManager {

	public void insertTeacher(Teacher teacher);
    
    public void updateTeacher(Teacher teacher);
    
    public void deleteTeacherByPriKey(Integer teacherid);
	
    public Teacher findTeacherByPriKey(Integer teacherid);
    
    public List<Teacher> searchTeacherList(Query<TeacherQuery> query);
	
	public Integer getItemCount(PageQuery<TeacherQuery> pageQuery);
    
    public List<Teacher> searchPageTeacherList(PageQuery<TeacherQuery> pageQuery);
}
