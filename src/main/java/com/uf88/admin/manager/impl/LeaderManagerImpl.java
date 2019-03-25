package com.uf88.admin.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uf88.admin.manager.LeaderManager;
import com.uf88.admin.dao.LeaderDao;
import com.uf88.admin.pojo.Leader;
import com.uf88.admin.pojo.LeaderQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;


/**
 * 描述：</b>LeaderManagerImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Component("leaderManager")
public class LeaderManagerImpl implements LeaderManager {
	private final static Logger log= LoggerFactory.getLogger(LeaderManagerImpl.class);
	@Autowired
	private LeaderDao leaderDao;

	@Override
	public void insertLeader(Leader leader) {
		leaderDao.insert(leader);
	}
	
	@Override
	public void updateLeader(Leader leader) {
		leaderDao.update(leader);
	}
	
	@Override
	public void deleteLeaderByPriKey(String leadername) {
		leaderDao.deleteByPriKey(leadername);
	}
	
	@Override
	public Leader findLeaderByPriKey(String leadername) {
		return leaderDao.findByPriKey(leadername);
	}
	
	@Override
	public List<Leader> searchLeaderList(Query<LeaderQuery> query) {
		return leaderDao.getAllList(query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<LeaderQuery> pageQuery) {
		return leaderDao.getItemCount(pageQuery);
	}
	
	@Override
	public List<Leader> searchPageLeaderList(PageQuery<LeaderQuery> pageQuery) {
		//Integer itemCount = getItemCount(pageQuery);
		return leaderDao.getPageList(pageQuery, 0);
	}
}
