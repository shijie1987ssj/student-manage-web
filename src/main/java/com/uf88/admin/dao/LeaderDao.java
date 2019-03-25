package com.uf88.admin.dao;

import java.util.List;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.admin.pojo.Leader;
import com.uf88.admin.pojo.LeaderQuery;

/**
 * 描述：</b>LeaderDao<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface LeaderDao {
	
	public void insert(Leader leader);
	
	public void update(Leader leader);
	
	public void updateAndCheck(Leader leader);
	
	public void deleteByPriKey(String leadername);
	public void deleteByPriKeyAndCheck(String leadername);
	
	public Leader findByPriKey(String leadername);
	
	public List<Leader> getAllList(Query<LeaderQuery> query);
	
	public Integer getItemCount(PageQuery<LeaderQuery> pageQuery);
	
	public List<Leader> getPageList(PageQuery<LeaderQuery> pageQuery, Integer itemCount);
}
