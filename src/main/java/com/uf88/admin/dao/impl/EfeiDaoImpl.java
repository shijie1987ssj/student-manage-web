package com.uf88.admin.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.uf88.admin.dao.EfeiDao;
import com.uf88.admin.pojo.Efei;
import com.uf88.admin.pojo.EfeiQuery;
import com.uf88.uf88core.common.dao.BaseDao;
import com.uf88.uf88core.common.exception.Uf88Exception;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.PageQueryWrapper;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation;

 /**
 * 描述：</b>EfeiDaoImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
@Repository("efeiDao")
public class EfeiDaoImpl extends BaseDao implements EfeiDao {
	private final static Logger log= LoggerFactory.getLogger(EfeiDaoImpl.class);
	
	@Override
	public void insert(Efei efei){
		Object o =insert("EFEI.insert", efei);
		 
	}
	
	@Override
	public void update(Efei efei){
		update("EFEI.update", efei); 
	}
	
	@Override
	public void updateAndCheck(Efei efei){
		updateAndCheck("EFEI.update", efei); 
	}
	
	@Override
	public void deleteByPriKey(Integer id){
		Efei efei = new Efei();
		efei.setId(id);
		delete("EFEI.deleteByPriKey", efei); 
	}
	
	@Override
	public void deleteByPriKeyAndCheck(Integer id){
		Efei efei = new Efei();
		efei.setId(id);
		deleteAndCheck("EFEI.deleteByPriKey", efei); 
	}
	
	@Override
	public Efei findByPriKey(Integer id){
		Efei efei = new Efei();
		efei.setId(id);
		efei = (Efei)this.queryForObject("EFEI.findByPriKey", efei);
		return efei;
	}
	
	@Override
	public List<Efei> getAllList(Query<EfeiQuery> query) {
		return this.queryForList("EFEI.getAllList",query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<EfeiQuery> pageQuery) {
		return (Integer) queryForObject("EFEI.getItemCount",pageQuery);
	}
	
	@Override
	public List<Efei> getPageList(PageQuery<EfeiQuery> pageQuery, Integer itemCount) {
		PageQueryWrapper<EfeiQuery> wrapper = new PageQueryWrapper<EfeiQuery>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery(), pageQuery.getSort());
		return this.queryForList("EFEI.getPagenationList",wrapper);
	}
}
