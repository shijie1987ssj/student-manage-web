package com.uf88.admin.service;

import com.uf88.admin.pojo.Efei;
import com.uf88.admin.pojo.EfeiQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>EfeiService<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
public interface EfeiService {

	public GenericResult<String> addEfei(Efei efei);
	
    public BasicResult modifyEfei(Efei efei);
    
    public GenericResult<Efei> findByPriKey(Integer id);
    
    public BasicResult deleteByPriKey(Integer id);
    
    public ListResult<Efei> searchEfei(Query<EfeiQuery> query);
    
    public PageListResult<Efei> searchPageEfei(PageQuery<EfeiQuery> pageQuery);
	
}
