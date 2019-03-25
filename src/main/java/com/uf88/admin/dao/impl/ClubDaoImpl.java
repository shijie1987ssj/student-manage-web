package com.uf88.admin.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.uf88.admin.dao.ClubDao;
import com.uf88.admin.pojo.Club;
import com.uf88.admin.pojo.ClubQuery;
import com.uf88.uf88core.common.dao.BaseDao;
import com.uf88.uf88core.common.exception.Uf88Exception;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.PageQueryWrapper;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation;

 /**
 * 描述：</b>ClubDaoImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
@Repository("clubDao")
public class ClubDaoImpl extends BaseDao implements ClubDao {
	private final static Logger log= LoggerFactory.getLogger(ClubDaoImpl.class);
	
	@Override
	public void insert(Club club){
		Object o =insert("CLUB.insert", club);
		 
	}
	
	@Override
	public void update(Club club){
		update("CLUB.update", club); 
	}
	
	@Override
	public void updateAndCheck(Club club){
		updateAndCheck("CLUB.update", club); 
	}
	
	@Override
	public void deleteByPriKey(String clubname){
		Club club = new Club();
		club.setClubname(clubname);
		delete("CLUB.deleteByPriKey", club); 
	}
	
	@Override
	public void deleteByPriKeyAndCheck(String clubname){
		Club club = new Club();
		club.setClubname(clubname);
		deleteAndCheck("CLUB.deleteByPriKey", club); 
	}
	
	@Override
	public Club findByPriKey(String clubname){
		Club club = new Club();
		club.setClubname(clubname);
		club = (Club)this.queryForObject("CLUB.findByPriKey", club);
		return club;
	}
	
	@Override
	public List<Club> getAllList(Query<ClubQuery> query) {
		return this.queryForList("CLUB.getAllList",query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<ClubQuery> pageQuery) {
		return (Integer) queryForObject("CLUB.getItemCount",pageQuery);
	}
	
	@Override
	public List<Club> getPageList(PageQuery<ClubQuery> pageQuery, Integer itemCount) {
		PageQueryWrapper<ClubQuery> wrapper = new PageQueryWrapper<ClubQuery>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery(), pageQuery.getSort());
		return this.queryForList("CLUB.getPagenationList",wrapper);
	}
}
