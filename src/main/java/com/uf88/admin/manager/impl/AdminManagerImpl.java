package com.uf88.admin.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uf88.admin.manager.AdminManager;
import com.uf88.admin.dao.AdminDao;
import com.uf88.admin.pojo.Admin;
import com.uf88.admin.pojo.AdminQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;


/**
 * 描述：</b>AdminManagerImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
@Component("adminManager")
public class AdminManagerImpl implements AdminManager {
	private final static Logger log= LoggerFactory.getLogger(AdminManagerImpl.class);
	@Autowired
	private AdminDao adminDao;

	@Override
	public void insertAdmin(Admin admin) {
		adminDao.insert(admin);
	}
	
	@Override
	public void updateAdmin(Admin admin) {
		adminDao.update(admin);
	}
	
	@Override
	public void deleteAdminByPriKey(String adminname) {
		adminDao.deleteByPriKey(adminname);
	}
	
	@Override
	public Admin findAdminByPriKey(String adminname) {
		return adminDao.findByPriKey(adminname);
	}
	
	@Override
	public List<Admin> searchAdminList(Query<AdminQuery> query) {
		return adminDao.getAllList(query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<AdminQuery> pageQuery) {
		return adminDao.getItemCount(pageQuery);
	}
	
	@Override
	public List<Admin> searchPageAdminList(PageQuery<AdminQuery> pageQuery) {
		//Integer itemCount = getItemCount(pageQuery);
		return adminDao.getPageList(pageQuery, 0);
	}
}
