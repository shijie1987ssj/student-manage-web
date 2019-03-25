package com.uf88.admin.dao;

import java.util.List;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.admin.pojo.Question;
import com.uf88.admin.pojo.QuestionQuery;

/**
 * 描述：</b>QuestionDao<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface QuestionDao {
	
	public void insert(Question question);
	
	public void update(Question question);
	
	public void updateAndCheck(Question question);
	
	public void deleteByPriKey(Integer questionid);
	public void deleteByPriKeyAndCheck(Integer questionid);
	
	public Question findByPriKey(Integer questionid);
	
	public List<Question> getAllList(Query<QuestionQuery> query);
	
	public Integer getItemCount(PageQuery<QuestionQuery> pageQuery);
	
	public List<Question> getPageList(PageQuery<QuestionQuery> pageQuery, Integer itemCount);
}
