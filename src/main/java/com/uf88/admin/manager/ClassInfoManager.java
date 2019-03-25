package com.uf88.admin.manager;

import java.util.List;
import com.uf88.admin.pojo.ClassInfo;
import com.uf88.admin.pojo.ClassInfoQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>ClassInfoManager<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
public interface ClassInfoManager {

	public void insertClassInfo(ClassInfo classInfo);
    
    public void updateClassInfo(ClassInfo classInfo);
    
    public void deleteClassInfoByPriKey(String classname);
	
    public ClassInfo findClassInfoByPriKey(String classname);
    
    public List<ClassInfo> searchClassInfoList(Query<ClassInfoQuery> query);
	
	public Integer getItemCount(PageQuery<ClassInfoQuery> pageQuery);
    
    public List<ClassInfo> searchPageClassInfoList(PageQuery<ClassInfoQuery> pageQuery);
}
