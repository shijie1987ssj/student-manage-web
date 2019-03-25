package com.uf88.admin.service;

import com.uf88.admin.pojo.StuPiechart;
import com.uf88.admin.pojo.StuPiechartQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>StuPiechartService<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface StuPiechartService {

	public GenericResult<String> addStuPiechart(StuPiechart stuPiechart);
	
    public BasicResult modifyStuPiechart(StuPiechart stuPiechart);
    
    public GenericResult<StuPiechart> findByPriKey(Integer id);
    
    public BasicResult deleteByPriKey(Integer id);
    
    public ListResult<StuPiechart> searchStuPiechart(Query<StuPiechartQuery> query);
    
    public PageListResult<StuPiechart> searchPageStuPiechart(PageQuery<StuPiechartQuery> pageQuery);
	
}
