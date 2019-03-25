package com.uf88.admin.service;

import com.uf88.admin.pojo.Club;
import com.uf88.admin.pojo.ClubQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>ClubService<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
public interface ClubService {

	public GenericResult<String> addClub(Club club);
	
    public BasicResult modifyClub(Club club);
    
    public GenericResult<Club> findByPriKey(String clubname);
    
    public BasicResult deleteByPriKey(String clubname);
    
    public ListResult<Club> searchClub(Query<ClubQuery> query);
    
    public PageListResult<Club> searchPageClub(PageQuery<ClubQuery> pageQuery);
	
}
