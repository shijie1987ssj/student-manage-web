package com.uf88.admin.service;

import com.uf88.admin.pojo.Leader;
import com.uf88.admin.pojo.LeaderQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>LeaderService<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface LeaderService {

	public GenericResult<String> addLeader(Leader leader);
	
    public BasicResult modifyLeader(Leader leader);
    
    public GenericResult<Leader> findByPriKey(String leadername);
    
    public BasicResult checkLogin(String name,String passwd);
    
    public BasicResult deleteByPriKey(String leadername);
    
    public ListResult<Leader> searchLeader(Query<LeaderQuery> query);
    
    public PageListResult<Leader> searchPageLeader(PageQuery<LeaderQuery> pageQuery);
	
}
