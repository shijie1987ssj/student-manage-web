package com.uf88.admin.dao;

import java.util.List;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.admin.pojo.StuPiechart;
import com.uf88.admin.pojo.StuPiechartQuery;

/**
 * 描述：</b>StuPiechartDao<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface StuPiechartDao {
	
	public void insert(StuPiechart stuPiechart);
	
	public void update(StuPiechart stuPiechart);
	
	public void updateAndCheck(StuPiechart stuPiechart);
	
	public void deleteByPriKey(Integer id);
	public void deleteByPriKeyAndCheck(Integer id);
	
	public StuPiechart findByPriKey(Integer id);
	
	public List<StuPiechart> getAllList(Query<StuPiechartQuery> query);
	
	public Integer getItemCount(PageQuery<StuPiechartQuery> pageQuery);
	
	public List<StuPiechart> getPageList(PageQuery<StuPiechartQuery> pageQuery, Integer itemCount);
}
