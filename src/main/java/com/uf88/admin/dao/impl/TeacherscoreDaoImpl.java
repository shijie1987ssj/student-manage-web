package com.uf88.admin.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.uf88.admin.dao.TeacherscoreDao;
import com.uf88.admin.pojo.Teacherscore;
import com.uf88.admin.pojo.TeacherscoreQuery;
import com.uf88.admin.pojo.TeacherscoreSum;
import com.uf88.admin.pojo.TeacherscoreVo;
import com.uf88.uf88core.common.dao.BaseDao;
import com.uf88.uf88core.common.exception.Uf88Exception;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.PageQueryWrapper;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation;

/**
 * 描述：</b>TeacherscoreDaoImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分10秒 星期三
 * @version:1.0
 */
@Repository("teacherscoreDao")
public class TeacherscoreDaoImpl extends BaseDao implements TeacherscoreDao {
	private final static Logger log = LoggerFactory.getLogger(TeacherscoreDaoImpl.class);

	@Override
	public void insert(Teacherscore teacherscore) {
		Object o = insert("TEACHERSCORE.insert", teacherscore);

	}

	@Override
	public void update(Teacherscore teacherscore) {
		update("TEACHERSCORE.update", teacherscore);
	}

	@Override
	public void updateAndCheck(Teacherscore teacherscore) {
		updateAndCheck("TEACHERSCORE.update", teacherscore);
	}

	@Override
	public void deleteByPriKey(Integer teacherid) {
		Teacherscore teacherscore = new Teacherscore();
		teacherscore.setTeacherid(teacherid);
		delete("TEACHERSCORE.deleteByPriKey", teacherscore);
	}

	@Override
	public void deleteByPriKeyAndCheck(Integer teacherid) {
		Teacherscore teacherscore = new Teacherscore();
		teacherscore.setTeacherid(teacherid);
		deleteAndCheck("TEACHERSCORE.deleteByPriKey", teacherscore);
	}

	@Override
	public Teacherscore findByPriKey(Integer teacherid) {
		Teacherscore teacherscore = new Teacherscore();
		teacherscore.setTeacherid(teacherid);
		teacherscore = (Teacherscore) this.queryForObject("TEACHERSCORE.findByPriKey", teacherscore);
		return teacherscore;
	}

	@Override
	public List<Teacherscore> getAllList(Query<TeacherscoreQuery> query) {
		return this.queryForList("TEACHERSCORE.getAllList", query);
	}

	@Override
	public List<TeacherscoreSum> getAllListSum(Query<TeacherscoreQuery> query) {
		return this.queryForList("TEACHERSCORE.getAllListSum", query);
	}

	@Override
	public Integer getItemCount(PageQuery<TeacherscoreQuery> pageQuery) {
		return (Integer) queryForObject("TEACHERSCORE.getItemCount", pageQuery);
	}

	@Override
	public List<TeacherscoreVo> getPageList(PageQuery<TeacherscoreQuery> pageQuery, Integer itemCount) {
		PageQueryWrapper<TeacherscoreQuery> wrapper = new PageQueryWrapper<TeacherscoreQuery>(pageQuery.getPageNo(),
				pageQuery.getPageSize(), itemCount, pageQuery.getQuery(), pageQuery.getSort());
		return this.queryForList("TEACHERSCORE.getPagenationList", wrapper);
	}
}
