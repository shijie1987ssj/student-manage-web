package com.uf88.admin.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.uf88.admin.dao.GradeDao;
import com.uf88.admin.pojo.Grade;
import com.uf88.admin.pojo.GradeQuery;
import com.uf88.uf88core.common.dao.BaseDao;
import com.uf88.uf88core.common.exception.Uf88Exception;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.PageQueryWrapper;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation;

 /**
 * 描述：</b>GradeDaoImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Repository("gradeDao")
public class GradeDaoImpl extends BaseDao implements GradeDao {
	private final static Logger log= LoggerFactory.getLogger(GradeDaoImpl.class);
	
	@Override
	public void insert(Grade grade){
		Object o =insert("GRADE.insert", grade);
		 
	}
	
	@Override
	public void update(Grade grade){
		update("GRADE.update", grade); 
	}
	
	@Override
	public void updateAndCheck(Grade grade){
		updateAndCheck("GRADE.update", grade); 
	}
	
	@Override
	public void deleteByPriKey(String gradename){
		Grade grade = new Grade();
		grade.setGradename(gradename);
		delete("GRADE.deleteByPriKey", grade); 
	}
	
	@Override
	public void deleteByPriKeyAndCheck(String gradename){
		Grade grade = new Grade();
		grade.setGradename(gradename);
		deleteAndCheck("GRADE.deleteByPriKey", grade);  
	}
	
	@Override
	public Grade findByPriKey(String gradename){
		Grade grade = new Grade();
		grade.setGradename(gradename);
		grade = (Grade)this.queryForObject("GRADE.findByPriKey", grade);
		return grade;
	}
	
	@Override
	public List<Grade> getAllList(Query<GradeQuery> query) {
		return this.queryForList("GRADE.getAllList",query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<GradeQuery> pageQuery) {
		return (Integer) queryForObject("GRADE.getItemCount",pageQuery);
	}
	
	@Override
	public List<Grade> getPageList(PageQuery<GradeQuery> pageQuery, Integer itemCount) {
		PageQueryWrapper<GradeQuery> wrapper = new PageQueryWrapper<GradeQuery>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery(), pageQuery.getSort());
		return this.queryForList("GRADE.getPagenationList",wrapper);
	}
}
