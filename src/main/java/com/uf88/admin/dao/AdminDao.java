package com.uf88.admin.dao;

import java.util.List;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.admin.pojo.Admin;
import com.uf88.admin.pojo.AdminQuery;

/**
 * 描述：</b>AdminDao<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
public interface AdminDao {
	
	public void insert(Admin admin);
	
	public void update(Admin admin);
	
	public void updateAndCheck(Admin admin);
	
	public void deleteByPriKey(String adminname);
	public void deleteByPriKeyAndCheck(String adminname);
	
	public Admin findByPriKey(String adminname);
	
	public List<Admin> getAllList(Query<AdminQuery> query);
	
	public Integer getItemCount(PageQuery<AdminQuery> pageQuery);
	
	public List<Admin> getPageList(PageQuery<AdminQuery> pageQuery, Integer itemCount);
}
