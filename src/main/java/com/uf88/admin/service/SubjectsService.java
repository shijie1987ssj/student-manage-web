package com.uf88.admin.service;

import com.uf88.admin.pojo.Subjects;
import com.uf88.admin.pojo.SubjectsQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>SubjectsService<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface SubjectsService {

	public GenericResult<String> addSubjects(Subjects subjects);
	
    public BasicResult modifySubjects(Subjects subjects);
    
    public GenericResult<Subjects> findByPriKey(String subjectname);
    
    public BasicResult deleteByPriKey(String subjectname);
    
    public ListResult<Subjects> searchSubjects(Query<SubjectsQuery> query);
    
    public PageListResult<Subjects> searchPageSubjects(PageQuery<SubjectsQuery> pageQuery);
	
}
