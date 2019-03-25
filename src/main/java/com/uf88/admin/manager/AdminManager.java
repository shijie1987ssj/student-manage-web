package com.uf88.admin.manager;

import java.util.List;
import com.uf88.admin.pojo.Admin;
import com.uf88.admin.pojo.AdminQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>AdminManager<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
public interface AdminManager {

	public void insertAdmin(Admin admin);
    
    public void updateAdmin(Admin admin);
    
    public void deleteAdminByPriKey(String adminname);
	
    public Admin findAdminByPriKey(String adminname);
    
    public List<Admin> searchAdminList(Query<AdminQuery> query);
	
	public Integer getItemCount(PageQuery<AdminQuery> pageQuery);
    
    public List<Admin> searchPageAdminList(PageQuery<AdminQuery> pageQuery);
}
