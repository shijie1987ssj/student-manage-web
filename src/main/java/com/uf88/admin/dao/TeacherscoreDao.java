package com.uf88.admin.dao;

import java.util.List;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.admin.pojo.Teacherscore;
import com.uf88.admin.pojo.TeacherscoreQuery;
import com.uf88.admin.pojo.TeacherscoreSum;
import com.uf88.admin.pojo.TeacherscoreVo;

/**
 * 描述：</b>TeacherscoreDao<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分10秒 星期三
 * @version:1.0
 */
public interface TeacherscoreDao {

	public void insert(Teacherscore teacherscore);

	public void update(Teacherscore teacherscore);

	public void updateAndCheck(Teacherscore teacherscore);

	public void deleteByPriKey(Integer teacherid);

	public void deleteByPriKeyAndCheck(Integer teacherid);

	public Teacherscore findByPriKey(Integer teacherid);

	public List<Teacherscore> getAllList(Query<TeacherscoreQuery> query);

	public List<TeacherscoreSum> getAllListSum(Query<TeacherscoreQuery> query);

	public Integer getItemCount(PageQuery<TeacherscoreQuery> pageQuery);

	public List<TeacherscoreVo> getPageList(PageQuery<TeacherscoreQuery> pageQuery, Integer itemCount);
}
