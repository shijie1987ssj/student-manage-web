package com.uf88.admin.manager;

import java.util.List;
import com.uf88.admin.pojo.Question;
import com.uf88.admin.pojo.QuestionQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>QuestionManager<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface QuestionManager {

	public void insertQuestion(Question question);
    
    public void updateQuestion(Question question);
    
    public void deleteQuestionByPriKey(Integer questionid);
	
    public Question findQuestionByPriKey(Integer questionid);
    
    public List<Question> searchQuestionList(Query<QuestionQuery> query);
	
	public Integer getItemCount(PageQuery<QuestionQuery> pageQuery);
    
    public List<Question> searchPageQuestionList(PageQuery<QuestionQuery> pageQuery);
}
