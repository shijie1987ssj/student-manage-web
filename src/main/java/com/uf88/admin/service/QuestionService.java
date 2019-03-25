package com.uf88.admin.service;

import com.uf88.admin.pojo.Question;
import com.uf88.admin.pojo.QuestionQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>QuestionService<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface QuestionService {

	public GenericResult<String> addQuestion(Question question);
	
    public BasicResult modifyQuestion(Question question);
    
    public GenericResult<Question> findByPriKey(Integer questionid);
    
    public BasicResult deleteByPriKey(Integer questionid);
    
    public ListResult<Question> searchQuestion(Query<QuestionQuery> query);
    
    public PageListResult<Question> searchPageQuestion(PageQuery<QuestionQuery> pageQuery);
	
}
