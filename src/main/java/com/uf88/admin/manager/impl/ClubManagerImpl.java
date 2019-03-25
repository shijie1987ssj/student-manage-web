package com.uf88.admin.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uf88.admin.manager.ClubManager;
import com.uf88.admin.dao.ClubDao;
import com.uf88.admin.pojo.Club;
import com.uf88.admin.pojo.ClubQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;


/**
 * 描述：</b>ClubManagerImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
@Component("clubManager")
public class ClubManagerImpl implements ClubManager {
	private final static Logger log= LoggerFactory.getLogger(ClubManagerImpl.class);
	@Autowired
	private ClubDao clubDao;

	@Override
	public void insertClub(Club club) {
		clubDao.insert(club);
	}
	
	@Override
	public void updateClub(Club club) {
		clubDao.update(club);
	}
	
	@Override
	public void deleteClubByPriKey(String clubname) {
		clubDao.deleteByPriKey(clubname);
	}
	
	@Override
	public Club findClubByPriKey(String clubname) {
		return clubDao.findByPriKey(clubname);
	}
	
	@Override
	public List<Club> searchClubList(Query<ClubQuery> query) {
		return clubDao.getAllList(query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<ClubQuery> pageQuery) {
		return clubDao.getItemCount(pageQuery);
	}
	
	@Override
	public List<Club> searchPageClubList(PageQuery<ClubQuery> pageQuery) {
		//Integer itemCount = getItemCount(pageQuery);
		return clubDao.getPageList(pageQuery, 0);
	}
}
