package com.uf88.admin.manager;

import java.util.List;
import com.uf88.admin.pojo.Teacherscore;
import com.uf88.admin.pojo.TeacherscoreQuery;
import com.uf88.admin.pojo.TeacherscoreSum;
import com.uf88.admin.pojo.TeacherscoreVo;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>TeacherscoreManager<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分10秒 星期三
 * @version:1.0
 */
public interface TeacherscoreManager {

	public void insertTeacherscore(Teacherscore teacherscore);

	public void updateTeacherscore(Teacherscore teacherscore);

	public void deleteTeacherscoreByPriKey(Integer teacherid);

	public Teacherscore findTeacherscoreByPriKey(Integer teacherid);

	public List<Teacherscore> searchTeacherscoreList(Query<TeacherscoreQuery> query);

	public List<TeacherscoreSum> searchTeacherscoreListSum(Query<TeacherscoreQuery> query);

	public Integer getItemCount(PageQuery<TeacherscoreQuery> pageQuery);

	public List<TeacherscoreVo> searchPageTeacherscoreList(PageQuery<TeacherscoreQuery> pageQuery);
}
