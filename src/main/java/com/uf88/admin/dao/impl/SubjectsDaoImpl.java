package com.uf88.admin.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.uf88.admin.dao.SubjectsDao;
import com.uf88.admin.pojo.Subjects;
import com.uf88.admin.pojo.SubjectsQuery;
import com.uf88.uf88core.common.dao.BaseDao;
import com.uf88.uf88core.common.exception.Uf88Exception;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.PageQueryWrapper;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation;

 /**
 * 描述：</b>SubjectsDaoImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Repository("subjectsDao")
public class SubjectsDaoImpl extends BaseDao implements SubjectsDao {
	private final static Logger log= LoggerFactory.getLogger(SubjectsDaoImpl.class);
	
	@Override
	public void insert(Subjects subjects){
		Object o =insert("SUBJECTS.insert", subjects);
		 
	}
	
	@Override
	public void update(Subjects subjects){
		update("SUBJECTS.update", subjects); 
	}
	
	@Override
	public void updateAndCheck(Subjects subjects){
		updateAndCheck("SUBJECTS.update", subjects); 
	}
	
	@Override
	public void deleteByPriKey(String subjectname){
		Subjects subjects = new Subjects();
		subjects.setSubjectname(subjectname);
		delete("SUBJECTS.deleteByPriKey", subjects); 
	}
	
	@Override
	public void deleteByPriKeyAndCheck(String subjectname){
		Subjects subjects = new Subjects();
		subjects.setSubjectname(subjectname);
		deleteAndCheck("SUBJECTS.deleteByPriKey", subjects);  
	}
	
	@Override
	public Subjects findByPriKey(String subjectname){
		Subjects subjects = new Subjects();
		subjects.setSubjectname(subjectname);
		subjects = (Subjects)this.queryForObject("SUBJECTS.findByPriKey", subjects);
		return subjects;
	}
	
	@Override
	public List<Subjects> getAllList(Query<SubjectsQuery> query) {
		return this.queryForList("SUBJECTS.getAllList",query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<SubjectsQuery> pageQuery) {
		return (Integer) queryForObject("SUBJECTS.getItemCount",pageQuery);
	}
	
	@Override
	public List<Subjects> getPageList(PageQuery<SubjectsQuery> pageQuery, Integer itemCount) {
		PageQueryWrapper<SubjectsQuery> wrapper = new PageQueryWrapper<SubjectsQuery>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery(), pageQuery.getSort());
		return this.queryForList("SUBJECTS.getPagenationList",wrapper);
	}
}
