package com.uf88.admin.manager;

import java.util.List;
import com.uf88.admin.pojo.Stuscore;
import com.uf88.admin.pojo.StuscoreQuery;
import com.uf88.admin.pojo.StuscoreSum;
import com.uf88.admin.pojo.StuscoreVo;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>StuscoreManager<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分09秒 星期三
 * @version:1.0
 */
public interface StuscoreManager {

	public void insertStuscore(Stuscore stuscore);

	public void updateStuscore(Stuscore stuscore);

	public void deleteStuscoreByPriKey(Integer stuid);

	public StuscoreVo findStuscoreByPriKey(Integer stuid);

	public List<Stuscore> searchStuscoreList(Query<StuscoreQuery> query);

	public List<StuscoreSum> searchStuscoreListSum(Query<StuscoreQuery> query);

	public Integer getItemCount(PageQuery<StuscoreQuery> pageQuery);

	public List<StuscoreVo> searchPageStuscoreList(PageQuery<StuscoreQuery> pageQuery);
}
