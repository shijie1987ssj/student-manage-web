package com.uf88.admin.dao;

import java.util.List;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.admin.pojo.Club;
import com.uf88.admin.pojo.ClubQuery;

/**
 * 描述：</b>ClubDao<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
public interface ClubDao {
	
	public void insert(Club club);
	
	public void update(Club club);
	
	public void updateAndCheck(Club club);
	
	public void deleteByPriKey(String clubname);
	public void deleteByPriKeyAndCheck(String clubname);
	
	public Club findByPriKey(String clubname);
	
	public List<Club> getAllList(Query<ClubQuery> query);
	
	public Integer getItemCount(PageQuery<ClubQuery> pageQuery);
	
	public List<Club> getPageList(PageQuery<ClubQuery> pageQuery, Integer itemCount);
}
