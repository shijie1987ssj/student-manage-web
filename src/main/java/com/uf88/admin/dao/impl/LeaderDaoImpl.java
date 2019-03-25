package com.uf88.admin.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.uf88.admin.dao.LeaderDao;
import com.uf88.admin.pojo.Leader;
import com.uf88.admin.pojo.LeaderQuery;
import com.uf88.uf88core.common.dao.BaseDao;
import com.uf88.uf88core.common.exception.Uf88Exception;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.PageQueryWrapper;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation;

 /**
 * 描述：</b>LeaderDaoImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Repository("leaderDao")
public class LeaderDaoImpl extends BaseDao implements LeaderDao {
	private final static Logger log= LoggerFactory.getLogger(LeaderDaoImpl.class);
	
	@Override
	public void insert(Leader leader){
		Object o =insert("LEADER.insert", leader);
		 
	}
	
	@Override
	public void update(Leader leader){
		update("LEADER.update", leader); 
	}
	
	@Override
	public void updateAndCheck(Leader leader){
		updateAndCheck("LEADER.update", leader); 
	}
	
	@Override
	public void deleteByPriKey(String leadername){
		Leader leader = new Leader();
		leader.setLeadername(leadername);
		delete("LEADER.deleteByPriKey", leader); 
	}
	
	@Override
	public void deleteByPriKeyAndCheck(String leadername){
		Leader leader = new Leader();
		leader.setLeadername(leadername);
		deleteAndCheck("LEADER.deleteByPriKey", leader);  
	}
	
	@Override
	public Leader findByPriKey(String leadername){
		Leader leader = new Leader();
		leader.setLeadername(leadername);
		leader = (Leader)this.queryForObject("LEADER.findByPriKey", leader);
		return leader;
	}
	
	@Override
	public List<Leader> getAllList(Query<LeaderQuery> query) {
		return this.queryForList("LEADER.getAllList",query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<LeaderQuery> pageQuery) {
		return (Integer) queryForObject("LEADER.getItemCount",pageQuery);
	}
	
	@Override
	public List<Leader> getPageList(PageQuery<LeaderQuery> pageQuery, Integer itemCount) {
		PageQueryWrapper<LeaderQuery> wrapper = new PageQueryWrapper<LeaderQuery>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery(), pageQuery.getSort());
		return this.queryForList("LEADER.getPagenationList",wrapper);
	}
}
