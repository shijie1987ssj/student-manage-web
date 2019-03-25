package com.uf88.admin.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uf88.admin.manager.QuestionManager;
import com.uf88.admin.dao.QuestionDao;
import com.uf88.admin.pojo.Question;
import com.uf88.admin.pojo.QuestionQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;


/**
 * 描述：</b>QuestionManagerImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Component("questionManager")
public class QuestionManagerImpl implements QuestionManager {
	private final static Logger log= LoggerFactory.getLogger(QuestionManagerImpl.class);
	@Autowired
	private QuestionDao questionDao;

	@Override
	public void insertQuestion(Question question) {
		questionDao.insert(question);
	}
	
	@Override
	public void updateQuestion(Question question) {
		questionDao.update(question);
	}
	
	@Override
	public void deleteQuestionByPriKey(Integer questionid) {
		questionDao.deleteByPriKey(questionid);
	}
	
	@Override
	public Question findQuestionByPriKey(Integer questionid) {
		return questionDao.findByPriKey(questionid);
	}
	
	@Override
	public List<Question> searchQuestionList(Query<QuestionQuery> query) {
		return questionDao.getAllList(query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<QuestionQuery> pageQuery) {
		return questionDao.getItemCount(pageQuery);
	}
	
	@Override
	public List<Question> searchPageQuestionList(PageQuery<QuestionQuery> pageQuery) {
		//Integer itemCount = getItemCount(pageQuery);
		return questionDao.getPageList(pageQuery, 0);
	}
}
