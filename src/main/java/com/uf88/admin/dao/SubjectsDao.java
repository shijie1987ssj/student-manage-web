package com.uf88.admin.dao;

import java.util.List;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.admin.pojo.Subjects;
import com.uf88.admin.pojo.SubjectsQuery;

/**
 * 描述：</b>SubjectsDao<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface SubjectsDao {
	
	public void insert(Subjects subjects);
	
	public void update(Subjects subjects);
	
	public void updateAndCheck(Subjects subjects);
	
	public void deleteByPriKey(String subjectname);
	public void deleteByPriKeyAndCheck(String subjectname);
	
	public Subjects findByPriKey(String subjectname);
	
	public List<Subjects> getAllList(Query<SubjectsQuery> query);
	
	public Integer getItemCount(PageQuery<SubjectsQuery> pageQuery);
	
	public List<Subjects> getPageList(PageQuery<SubjectsQuery> pageQuery, Integer itemCount);
}
