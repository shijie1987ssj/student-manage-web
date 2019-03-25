package com.uf88.admin.dao.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.uf88.admin.dao.AdminDao;
import com.uf88.admin.pojo.Admin;
import com.uf88.admin.pojo.AdminQuery;
import com.uf88.uf88core.common.dao.BaseDao;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.PageQueryWrapper;
import com.uf88.uf88core.Query;

 /**
 * 描述：</b>AdminDaoImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
@Repository("adminDao")
public class AdminDaoImpl extends BaseDao implements AdminDao {
	private final static Logger log= LoggerFactory.getLogger(AdminDaoImpl.class);
	
	@Override
	public void insert(Admin admin){
		Object o =insert("ADMIN.insert", admin);
		 
	}
	
	@Override
	public void update(Admin admin){
		update("ADMIN.update", admin); 
	}
	
	@Override
	public void updateAndCheck(Admin admin){
		updateAndCheck("ADMIN.update", admin); 
	}
	
	@Override
	public void deleteByPriKey(String adminname){
		Admin admin = new Admin();
		admin.setAdminname(adminname);
		delete("ADMIN.deleteByPriKey", admin); 
	}
	
	@Override
	public void deleteByPriKeyAndCheck(String adminname){
		Admin admin = new Admin();
		admin.setAdminname(adminname);
		deleteAndCheck("ADMIN.deleteByPriKey", admin);  
	}
	
	@Override
	public Admin findByPriKey(String adminname){
		Admin admin = new Admin();
		admin.setAdminname(adminname);
		admin = (Admin)this.queryForObject("ADMIN.findByPriKey", admin);
		return admin;
	}
	
	@Override
	public List<Admin> getAllList(Query<AdminQuery> query) {
		return this.queryForList("ADMIN.getAllList",query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<AdminQuery> pageQuery) {
		return (Integer) queryForObject("ADMIN.getItemCount",pageQuery);
	}
	
	@Override
	public List<Admin> getPageList(PageQuery<AdminQuery> pageQuery, Integer itemCount) {
		PageQueryWrapper<AdminQuery> wrapper = new PageQueryWrapper<AdminQuery>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery(), pageQuery.getSort());
		return this.queryForList("ADMIN.getPagenationList",wrapper);
	}
}
