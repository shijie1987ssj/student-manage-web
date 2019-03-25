package com.uf88.admin.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.uf88.admin.dao.QuestionDao;
import com.uf88.admin.pojo.Question;
import com.uf88.admin.pojo.QuestionQuery;
import com.uf88.uf88core.common.dao.BaseDao;
import com.uf88.uf88core.common.exception.Uf88Exception;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.PageQueryWrapper;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation;

 /**
 * 描述：</b>QuestionDaoImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Repository("questionDao")
public class QuestionDaoImpl extends BaseDao implements QuestionDao {
	private final static Logger log= LoggerFactory.getLogger(QuestionDaoImpl.class);
	
	@Override
	public void insert(Question question){
		Object o =insert("QUESTION.insert", question);
		 
	}
	
	@Override
	public void update(Question question){
		update("QUESTION.update", question); 
	}
	
	@Override
	public void updateAndCheck(Question question){
		updateAndCheck("QUESTION.update", question); 
	}
	
	@Override
	public void deleteByPriKey(Integer questionid){
		Question question = new Question();
		question.setQuestionid(questionid);
		delete("QUESTION.deleteByPriKey", question); 
	}
	
	@Override
	public void deleteByPriKeyAndCheck(Integer questionid){
		Question question = new Question();
		question.setQuestionid(questionid);
		deleteAndCheck("QUESTION.deleteByPriKey", question);  
	}
	
	@Override
	public Question findByPriKey(Integer questionid){
		Question question = new Question();
		question.setQuestionid(questionid);
		question = (Question)this.queryForObject("QUESTION.findByPriKey", question);
		return question;
	}
	
	@Override
	public List<Question> getAllList(Query<QuestionQuery> query) {
		return this.queryForList("QUESTION.getAllList",query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<QuestionQuery> pageQuery) {
		return (Integer) queryForObject("QUESTION.getItemCount",pageQuery);
	}
	
	@Override
	public List<Question> getPageList(PageQuery<QuestionQuery> pageQuery, Integer itemCount) {
		PageQueryWrapper<QuestionQuery> wrapper = new PageQueryWrapper<QuestionQuery>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery(), pageQuery.getSort());
		return this.queryForList("QUESTION.getPagenationList",wrapper);
	}
}
