package com.uf88.admin.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uf88.admin.service.QuestionService;
import com.uf88.admin.manager.QuestionManager;
import com.uf88.admin.pojo.Question;
import com.uf88.admin.pojo.QuestionQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation; 


/**
 * 描述：</b>QuestionServiceImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
	private final static Logger log= LoggerFactory.getLogger(QuestionServiceImpl.class);
	@Autowired
	private QuestionManager questionManager;
	
	@Override
	public GenericResult<String> addQuestion(Question question) {
		GenericResult<String> result = new GenericResult<String>();
		  
			if (question != null) {
				//TODO:generate sequence id by CacheUtils.getSeq method Or remove this block.
				String id="";//CacheUtils.getSeq(RedisKeyConstants.XXX, length);
				//question.setId(id);
				questionManager.insertQuestion(question);
				
				result.setValue(id);
				result.setMessage("保存成功");
				log.debug("------QuestionServiceImpl.addQuestion 保存成功------");
			} else {
				log.error("------QuestionServiceImpl.addQuestion - question is null!");
				result.setCode("");
				result.setMessage("question is null");
			}
		  
		return result;
	}
	
	@Override
	public BasicResult modifyQuestion(Question question) {
		BasicResult result = new BasicResult();
		 
			if (question != null) {
				questionManager.updateQuestion(question);
				result.setMessage("编辑成功");
				log.debug("------QuestionServiceImpl.modifyQuestion 编辑成功------");
			} else {
				log.error("------QuestionServiceImpl.modifyQuestion - question is null!");
				result.setCode("");
				result.setMessage("question is null");
			}
		 
		return result;
	}
	
	@Override
	public GenericResult<Question> findByPriKey(Integer questionid) {
		GenericResult<Question> result = new GenericResult<Question>();
		 
			result.setValue(questionManager.findQuestionByPriKey(questionid));
			result.setMessage("查询成功");
			log.debug("------QuestionServiceImpl.findByPriKey 查询成功------");
		 
		return result;
	}
	
	@Override
	public BasicResult deleteByPriKey(Integer questionid) {
		BasicResult result = new BasicResult();
		 
			questionManager.deleteQuestionByPriKey(questionid);
			result.setMessage("删除成功");
			log.debug("------QuestionServiceImpl.deleteByPriKey 删除成功------");
		 
		return result;
	}
	
	@Override
	public ListResult<Question> searchQuestion(Query<QuestionQuery> query) {
		ListResult<Question> result = new ListResult<Question>();
		 
			result.setValues(questionManager.searchQuestionList(query));
			result.setMessage("查询成功");
			log.debug("------QuestionServiceImpl.searchQuestion 查询成功------");
		 
		return result;
	}
	
	@Override
	public PageListResult<Question> searchPageQuestion(
			PageQuery<QuestionQuery> pageQuery) {
		PageListResult<Question> result = new PageListResult<Question>();
		 
			List<Question> list = questionManager.searchPageQuestionList(pageQuery);
			Integer itemCount = questionManager.getItemCount(pageQuery);
			Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
			result.setPagenation(pagenation);
			result.setValues(list);
			
			result.setMessage("查询成功");
			log.debug("------QuestionServiceImpl.searchPageQuestion 查询成功------");
		 
		return result;
	}
}
