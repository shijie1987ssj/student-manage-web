package com.uf88.admin.dao;

import java.util.List;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.admin.pojo.ClassInfo;
import com.uf88.admin.pojo.ClassInfoQuery;

/**
 * 描述：</b>ClassInfoDao<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
public interface ClassInfoDao {
	
	public void insert(ClassInfo classInfo);
	
	public void update(ClassInfo classInfo);
	
	public void updateAndCheck(ClassInfo classInfo);
	
	public void deleteByPriKey(String classname);
	public void deleteByPriKeyAndCheck(String classname);
	
	public ClassInfo findByPriKey(String classname);
	
	public List<ClassInfo> getAllList(Query<ClassInfoQuery> query);
	
	public Integer getItemCount(PageQuery<ClassInfoQuery> pageQuery);
	
	public List<ClassInfo> getPageList(PageQuery<ClassInfoQuery> pageQuery, Integer itemCount);
}
