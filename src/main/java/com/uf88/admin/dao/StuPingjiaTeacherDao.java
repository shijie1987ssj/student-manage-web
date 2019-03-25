package com.uf88.admin.dao;

import java.util.List;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.admin.pojo.StuPingjiaTeacher;
import com.uf88.admin.pojo.StuPingjiaTeacherQuery;

/**
 * 描述：</b>StuPingjiaTeacherDao<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface StuPingjiaTeacherDao {
	
	public void insert(StuPingjiaTeacher stuPingjiaTeacher);
	
	public void update(StuPingjiaTeacher stuPingjiaTeacher);
	
	public void updateAndCheck(StuPingjiaTeacher stuPingjiaTeacher);
	
	public void deleteByPriKey(Integer id);
	public void deleteByPriKeyAndCheck(Integer id);
	
	public StuPingjiaTeacher findByPriKey(Integer id);
	
	public List<StuPingjiaTeacher> getAllList(Query<StuPingjiaTeacherQuery> query);
	
	public Integer getItemCount(PageQuery<StuPingjiaTeacherQuery> pageQuery);
	
	public List<StuPingjiaTeacher> getPageList(PageQuery<StuPingjiaTeacherQuery> pageQuery, Integer itemCount);
}
