package com.uf88.admin.service;

import com.uf88.admin.pojo.Admin;
import com.uf88.admin.pojo.AdminQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>AdminService<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
public interface AdminService {

	public GenericResult<String> addAdmin(Admin admin);
	
    public BasicResult modifyAdmin(Admin admin);
    
    public GenericResult<Admin> findByPriKey(String adminname);
    
    public BasicResult checkLogin(String name,String passwd);
    
    public BasicResult deleteByPriKey(String adminname);
    
    public ListResult<Admin> searchAdmin(Query<AdminQuery> query);
    
    public PageListResult<Admin> searchPageAdmin(PageQuery<AdminQuery> pageQuery);
	
}
