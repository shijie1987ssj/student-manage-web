package com.uf88.admin.service;

import com.uf88.admin.pojo.Grade;
import com.uf88.admin.pojo.GradeQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>GradeService<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface GradeService {

	public GenericResult<String> addGrade(Grade grade);
	
    public BasicResult modifyGrade(Grade grade);
    
    public GenericResult<Grade> findByPriKey(String gradename);
    
    public BasicResult deleteByPriKey(String gradename);
    
    public ListResult<Grade> searchGrade(Query<GradeQuery> query);
    
    public PageListResult<Grade> searchPageGrade(PageQuery<GradeQuery> pageQuery);
	
}
