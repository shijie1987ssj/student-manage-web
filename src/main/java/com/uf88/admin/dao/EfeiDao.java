package com.uf88.admin.dao;

import java.util.List;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.admin.pojo.Efei;
import com.uf88.admin.pojo.EfeiQuery;

/**
 * 描述：</b>EfeiDao<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
public interface EfeiDao {
	
	public void insert(Efei efei);
	
	public void update(Efei efei);
	
	public void updateAndCheck(Efei efei);
	
	public void deleteByPriKey(Integer id);
	public void deleteByPriKeyAndCheck(Integer id);
	
	public Efei findByPriKey(Integer id);
	
	public List<Efei> getAllList(Query<EfeiQuery> query);
	
	public Integer getItemCount(PageQuery<EfeiQuery> pageQuery);
	
	public List<Efei> getPageList(PageQuery<EfeiQuery> pageQuery, Integer itemCount);
}
