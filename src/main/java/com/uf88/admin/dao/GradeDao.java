package com.uf88.admin.dao;

import java.util.List;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.admin.pojo.Grade;
import com.uf88.admin.pojo.GradeQuery;

/**
 * 描述：</b>GradeDao<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface GradeDao {
	
	public void insert(Grade grade);
	
	public void update(Grade grade);
	
	public void updateAndCheck(Grade grade);
	
	public void deleteByPriKey(String gradename);
	public void deleteByPriKeyAndCheck(String gradename);
	
	public Grade findByPriKey(String gradename);
	
	public List<Grade> getAllList(Query<GradeQuery> query);
	
	public Integer getItemCount(PageQuery<GradeQuery> pageQuery);
	
	public List<Grade> getPageList(PageQuery<GradeQuery> pageQuery, Integer itemCount);
}
