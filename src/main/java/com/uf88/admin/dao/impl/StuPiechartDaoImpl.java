package com.uf88.admin.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.uf88.admin.dao.StuPiechartDao;
import com.uf88.admin.pojo.StuPiechart;
import com.uf88.admin.pojo.StuPiechartQuery;
import com.uf88.uf88core.common.dao.BaseDao;
import com.uf88.uf88core.common.exception.Uf88Exception;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.PageQueryWrapper;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation;

 /**
 * 描述：</b>StuPiechartDaoImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Repository("stuPiechartDao")
public class StuPiechartDaoImpl extends BaseDao implements StuPiechartDao {
	private final static Logger log= LoggerFactory.getLogger(StuPiechartDaoImpl.class);
	
	@Override
	public void insert(StuPiechart stuPiechart){
		Object o =insert("STU_PIECHART.insert", stuPiechart);
		 
	}
	
	@Override
	public void update(StuPiechart stuPiechart){
		update("STU_PIECHART.update", stuPiechart); 
	}
	
	@Override
	public void updateAndCheck(StuPiechart stuPiechart){
		updateAndCheck("STU_PIECHART.update", stuPiechart); 
	}
	
	@Override
	public void deleteByPriKey(Integer id){
		StuPiechart stuPiechart = new StuPiechart();
		stuPiechart.setId(id);
		delete("STU_PIECHART.deleteByPriKey", stuPiechart); 
	}
	
	@Override
	public void deleteByPriKeyAndCheck(Integer id){
		StuPiechart stuPiechart = new StuPiechart();
		stuPiechart.setId(id);
		deleteAndCheck("STU_PIECHART.deleteByPriKey", stuPiechart);  
	}
	
	@Override
	public StuPiechart findByPriKey(Integer id){
		StuPiechart stuPiechart = new StuPiechart();
		stuPiechart.setId(id);
		stuPiechart = (StuPiechart)this.queryForObject("STU_PIECHART.findByPriKey", stuPiechart);
		return stuPiechart;
	}
	
	@Override
	public List<StuPiechart> getAllList(Query<StuPiechartQuery> query) {
		return this.queryForList("STU_PIECHART.getAllList",query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<StuPiechartQuery> pageQuery) {
		return (Integer) queryForObject("STU_PIECHART.getItemCount",pageQuery);
	}
	
	@Override
	public List<StuPiechart> getPageList(PageQuery<StuPiechartQuery> pageQuery, Integer itemCount) {
		PageQueryWrapper<StuPiechartQuery> wrapper = new PageQueryWrapper<StuPiechartQuery>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery(), pageQuery.getSort());
		return this.queryForList("STU_PIECHART.getPagenationList",wrapper);
	}
}
