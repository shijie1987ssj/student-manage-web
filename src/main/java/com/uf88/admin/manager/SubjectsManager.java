package com.uf88.admin.manager;

import java.util.List;
import com.uf88.admin.pojo.Subjects;
import com.uf88.admin.pojo.SubjectsQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>SubjectsManager<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface SubjectsManager {

	public void insertSubjects(Subjects subjects);
    
    public void updateSubjects(Subjects subjects);
    
    public void deleteSubjectsByPriKey(String subjectname);
	
    public Subjects findSubjectsByPriKey(String subjectname);
    
    public List<Subjects> searchSubjectsList(Query<SubjectsQuery> query);
	
	public Integer getItemCount(PageQuery<SubjectsQuery> pageQuery);
    
    public List<Subjects> searchPageSubjectsList(PageQuery<SubjectsQuery> pageQuery);
}
