package com.uf88.admin.manager;

import java.util.List;
import com.uf88.admin.pojo.StuPingjiaTeacher;
import com.uf88.admin.pojo.StuPingjiaTeacherQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>StuPingjiaTeacherManager<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface StuPingjiaTeacherManager {

	public void insertStuPingjiaTeacher(StuPingjiaTeacher stuPingjiaTeacher);
    
    public void updateStuPingjiaTeacher(StuPingjiaTeacher stuPingjiaTeacher);
    
    public void deleteStuPingjiaTeacherByPriKey(Integer id);
	
    public StuPingjiaTeacher findStuPingjiaTeacherByPriKey(Integer id);
    
    public List<StuPingjiaTeacher> searchStuPingjiaTeacherList(Query<StuPingjiaTeacherQuery> query);
	
	public Integer getItemCount(PageQuery<StuPingjiaTeacherQuery> pageQuery);
    
    public List<StuPingjiaTeacher> searchPageStuPingjiaTeacherList(PageQuery<StuPingjiaTeacherQuery> pageQuery);
}
