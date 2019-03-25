package com.uf88.admin.manager;

import java.util.List;
import com.uf88.admin.pojo.Club;
import com.uf88.admin.pojo.ClubQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>ClubManager<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
public interface ClubManager {

	public void insertClub(Club club);
    
    public void updateClub(Club club);
    
    public void deleteClubByPriKey(String clubname);
	
    public Club findClubByPriKey(String clubname);
    
    public List<Club> searchClubList(Query<ClubQuery> query);
	
	public Integer getItemCount(PageQuery<ClubQuery> pageQuery);
    
    public List<Club> searchPageClubList(PageQuery<ClubQuery> pageQuery);
}
