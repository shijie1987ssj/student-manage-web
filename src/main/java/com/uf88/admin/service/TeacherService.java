package com.uf88.admin.service;

import com.uf88.admin.pojo.Teacher;
import com.uf88.admin.pojo.TeacherQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>TeacherService<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface TeacherService {

	public GenericResult<String> addTeacher(Teacher teacher);
	
    public BasicResult modifyTeacher(Teacher teacher);
    
    public GenericResult<Teacher> findByPriKey(Integer teacherid);
    
    public BasicResult checkLogin(String name,String passwd);
    
    public BasicResult deleteByPriKey(Integer teacherid);
    
    public ListResult<Teacher> searchTeacher(Query<TeacherQuery> query);
    
    public PageListResult<Teacher> searchPageTeacher(PageQuery<TeacherQuery> pageQuery);
	
}
