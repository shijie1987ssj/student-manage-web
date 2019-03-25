package com.uf88.admin.service;

import com.uf88.admin.pojo.Teacherscore;
import com.uf88.admin.pojo.TeacherscoreQuery;
import com.uf88.admin.pojo.TeacherscoreSum;
import com.uf88.admin.pojo.TeacherscoreVo;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>TeacherscoreService<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分10秒 星期三
 * @version:1.0
 */
public interface TeacherscoreService {

	public GenericResult<String> addTeacherscore(Teacherscore teacherscore);

	public BasicResult modifyTeacherscore(Teacherscore teacherscore);

	public GenericResult<Teacherscore> findByPriKey(Integer teacherid);

	public BasicResult deleteByPriKey(Integer teacherid);

	public ListResult<Teacherscore> searchTeacherscore(Query<TeacherscoreQuery> query);

	public PageListResult<TeacherscoreVo> searchPageTeacherscore(PageQuery<TeacherscoreQuery> pageQuery);

	public ListResult<TeacherscoreSum> searchTeacherscoreSum(Query<TeacherscoreQuery> query);

}
