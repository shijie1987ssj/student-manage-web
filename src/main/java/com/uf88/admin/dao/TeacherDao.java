package com.uf88.admin.dao;

import java.util.List;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.admin.pojo.Teacher;
import com.uf88.admin.pojo.TeacherQuery;

/**
 * 描述：</b>TeacherDao<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface TeacherDao {
	
	public void insert(Teacher teacher);
	
	public void update(Teacher teacher);
	
	public void updateAndCheck(Teacher teacher);
	
	public void deleteByPriKey(Integer teacherid);
	public void deleteByPriKeyAndCheck(Integer teacherid);
	
	public Teacher findByPriKey(Integer teacherid);
	
	public List<Teacher> getAllList(Query<TeacherQuery> query);
	
	public Integer getItemCount(PageQuery<TeacherQuery> pageQuery);
	
	public List<Teacher> getPageList(PageQuery<TeacherQuery> pageQuery, Integer itemCount);
}
