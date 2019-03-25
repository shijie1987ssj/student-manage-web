package com.uf88.admin.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.uf88.admin.dao.StuPingjiaTeacherDao;
import com.uf88.admin.pojo.StuPingjiaTeacher;
import com.uf88.admin.pojo.StuPingjiaTeacherQuery;
import com.uf88.uf88core.common.dao.BaseDao;
import com.uf88.uf88core.common.exception.Uf88Exception;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.PageQueryWrapper;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation;

 /**
 * 描述：</b>StuPingjiaTeacherDaoImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Repository("stuPingjiaTeacherDao")
public class StuPingjiaTeacherDaoImpl extends BaseDao implements StuPingjiaTeacherDao {
	private final static Logger log= LoggerFactory.getLogger(StuPingjiaTeacherDaoImpl.class);
	
	@Override
	public void insert(StuPingjiaTeacher stuPingjiaTeacher){
		Object o =insert("STU_PINGJIA_TEACHER.insert", stuPingjiaTeacher);
		 
	}
	
	@Override
	public void update(StuPingjiaTeacher stuPingjiaTeacher){
		update("STU_PINGJIA_TEACHER.update", stuPingjiaTeacher); 
	}
	
	@Override
	public void updateAndCheck(StuPingjiaTeacher stuPingjiaTeacher){
		updateAndCheck("STU_PINGJIA_TEACHER.update", stuPingjiaTeacher); 
	}
	
	@Override
	public void deleteByPriKey(Integer id){
		StuPingjiaTeacher stuPingjiaTeacher = new StuPingjiaTeacher();
		stuPingjiaTeacher.setId(id);
		delete("STU_PINGJIA_TEACHER.deleteByPriKey", stuPingjiaTeacher); 
	}
	
	@Override
	public void deleteByPriKeyAndCheck(Integer id){
		StuPingjiaTeacher stuPingjiaTeacher = new StuPingjiaTeacher();
		stuPingjiaTeacher.setId(id);
		deleteAndCheck("STU_PINGJIA_TEACHER.deleteByPriKey", stuPingjiaTeacher); 
	}
	
	@Override
	public StuPingjiaTeacher findByPriKey(Integer id){
		StuPingjiaTeacher stuPingjiaTeacher = new StuPingjiaTeacher();
		stuPingjiaTeacher.setId(id);
		stuPingjiaTeacher = (StuPingjiaTeacher)this.queryForObject("STU_PINGJIA_TEACHER.findByPriKey", stuPingjiaTeacher);
		return stuPingjiaTeacher;
	}
	
	@Override
	public List<StuPingjiaTeacher> getAllList(Query<StuPingjiaTeacherQuery> query) {
		return this.queryForList("STU_PINGJIA_TEACHER.getAllList",query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<StuPingjiaTeacherQuery> pageQuery) {
		return (Integer) queryForObject("STU_PINGJIA_TEACHER.getItemCount",pageQuery);
	}
	
	@Override
	public List<StuPingjiaTeacher> getPageList(PageQuery<StuPingjiaTeacherQuery> pageQuery, Integer itemCount) {
		PageQueryWrapper<StuPingjiaTeacherQuery> wrapper = new PageQueryWrapper<StuPingjiaTeacherQuery>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery(), pageQuery.getSort());
		return this.queryForList("STU_PINGJIA_TEACHER.getPagenationList",wrapper);
	}
}
