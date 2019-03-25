package com.uf88.admin.service;

import com.uf88.admin.pojo.StuPingjiaTeacher;
import com.uf88.admin.pojo.StuPingjiaTeacherQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>StuPingjiaTeacherService<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface StuPingjiaTeacherService {

	public GenericResult<String> addStuPingjiaTeacher(StuPingjiaTeacher stuPingjiaTeacher);
	
    public BasicResult modifyStuPingjiaTeacher(StuPingjiaTeacher stuPingjiaTeacher);
    
    public GenericResult<StuPingjiaTeacher> findByPriKey(Integer id);
    
    public BasicResult deleteByPriKey(Integer id);
    
    public ListResult<StuPingjiaTeacher> searchStuPingjiaTeacher(Query<StuPingjiaTeacherQuery> query);
    
    public PageListResult<StuPingjiaTeacher> searchPageStuPingjiaTeacher(PageQuery<StuPingjiaTeacherQuery> pageQuery);
	
}
