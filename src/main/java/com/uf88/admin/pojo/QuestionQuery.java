package com.uf88.admin.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
/**
 * 描述：</b>QuestionQuery:<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public class QuestionQuery implements Serializable {
	private static final long serialVersionUID = 1L;
		/**	 *	 */	private Integer questionid;	/**	 *	 */	private Integer questionscore;	/**	 *	 */	private String question;	public Integer getQuestionid() {	    return this.questionid;	}	public void setQuestionid(Integer questionid) {	    this.questionid=questionid;	}	public Integer getQuestionscore() {	    return this.questionscore;	}	public void setQuestionscore(Integer questionscore) {	    this.questionscore=questionscore;	}	public String getQuestion() {	    return this.question;	}	public void setQuestion(String question) {	    this.question=question;	}
}

