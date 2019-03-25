package com.uf88.admin.manager;

import java.util.List;
import com.uf88.admin.pojo.Leader;
import com.uf88.admin.pojo.LeaderQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>LeaderManager<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface LeaderManager {

	public void insertLeader(Leader leader);
    
    public void updateLeader(Leader leader);
    
    public void deleteLeaderByPriKey(String leadername);
	
    public Leader findLeaderByPriKey(String leadername);
    
    public List<Leader> searchLeaderList(Query<LeaderQuery> query);
	
	public Integer getItemCount(PageQuery<LeaderQuery> pageQuery);
    
    public List<Leader> searchPageLeaderList(PageQuery<LeaderQuery> pageQuery);
}
