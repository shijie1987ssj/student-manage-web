package com.uf88.admin.service;

import com.uf88.admin.pojo.ClassInfo;
import com.uf88.admin.pojo.ClassInfoQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>ClassInfoService<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
public interface ClassInfoService {

	public GenericResult<String> addClassInfo(ClassInfo classInfo);
	
    public BasicResult modifyClassInfo(ClassInfo classInfo);
    
    public GenericResult<ClassInfo> findByPriKey(String classname);
    
    public BasicResult deleteByPriKey(String classname);
    
    public ListResult<ClassInfo> searchClassInfo(Query<ClassInfoQuery> query);
    
    public PageListResult<ClassInfo> searchPageClassInfo(PageQuery<ClassInfoQuery> pageQuery);
	
}
