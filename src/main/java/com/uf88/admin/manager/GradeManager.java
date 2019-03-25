package com.uf88.admin.manager;

import java.util.List;
import com.uf88.admin.pojo.Grade;
import com.uf88.admin.pojo.GradeQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>GradeManager<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface GradeManager {

	public void insertGrade(Grade grade);
    
    public void updateGrade(Grade grade);
    
    public void deleteGradeByPriKey(String gradename);
	
    public Grade findGradeByPriKey(String gradename);
    
    public List<Grade> searchGradeList(Query<GradeQuery> query);
	
	public Integer getItemCount(PageQuery<GradeQuery> pageQuery);
    
    public List<Grade> searchPageGradeList(PageQuery<GradeQuery> pageQuery);
}
