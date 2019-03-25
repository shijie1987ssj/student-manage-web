package com.uf88.admin.dao;

import java.util.List;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.admin.pojo.Stuscore;
import com.uf88.admin.pojo.StuscoreQuery;
import com.uf88.admin.pojo.StuscoreSum;
import com.uf88.admin.pojo.StuscoreVo;

/**
 * 描述：</b>StuscoreDao<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分09秒 星期三
 * @version:1.0
 */
public interface StuscoreDao {

	public void insert(Stuscore stuscore);

	public void update(Stuscore stuscore);

	public void updateAndCheck(Stuscore stuscore);

	public void deleteByPriKey(Integer stuid);

	public void deleteByPriKeyAndCheck(Integer stuid);

	public StuscoreVo findByPriKey(Integer stuid);

	public List<Stuscore> getAllList(Query<StuscoreQuery> query);

	public List<StuscoreSum> getAllListSum(Query<StuscoreQuery> query);

	public Integer getItemCount(PageQuery<StuscoreQuery> pageQuery);

	public List<StuscoreVo> getPageList(PageQuery<StuscoreQuery> pageQuery, Integer itemCount);
}
