package com.uf88.admin.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uf88.admin.service.TeacherscoreService;
import com.uf88.admin.manager.TeacherscoreManager;
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
import com.uf88.uf88core.paging.Pagenation;

/**
 * 描述：</b>TeacherscoreServiceImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分10秒 星期三
 * @version:1.0
 */
@Service("teacherscoreService")
public class TeacherscoreServiceImpl implements TeacherscoreService {
	private final static Logger log = LoggerFactory.getLogger(TeacherscoreServiceImpl.class);
	@Autowired
	private TeacherscoreManager teacherscoreManager;

	@Override
	public GenericResult<String> addTeacherscore(Teacherscore teacherscore) {
		GenericResult<String> result = new GenericResult<String>();

		if (teacherscore != null) {
			// TODO:generate sequence id by CacheUtils.getSeq method Or remove this block.
			String id = "";// CacheUtils.getSeq(RedisKeyConstants.XXX, length);
			// teacherscore.setId(id);
			teacherscoreManager.insertTeacherscore(teacherscore);

			result.setValue(id);
			result.setMessage("保存成功");
			log.debug("------TeacherscoreServiceImpl.addTeacherscore 保存成功------");
		} else {
			log.error("------TeacherscoreServiceImpl.addTeacherscore - teacherscore is null!");
			result.setCode("");
			result.setMessage("teacherscore is null");
		}

		return result;
	}

	@Override
	public BasicResult modifyTeacherscore(Teacherscore teacherscore) {
		BasicResult result = new BasicResult();

		if (teacherscore != null) {
			teacherscoreManager.updateTeacherscore(teacherscore);
			result.setMessage("编辑成功");
			log.debug("------TeacherscoreServiceImpl.modifyTeacherscore 编辑成功------");
		} else {
			log.error("------TeacherscoreServiceImpl.modifyTeacherscore - teacherscore is null!");
			result.setCode("");
			result.setMessage("teacherscore is null");
		}

		return result;
	}

	@Override
	public GenericResult<Teacherscore> findByPriKey(Integer teacherid) {
		GenericResult<Teacherscore> result = new GenericResult<Teacherscore>();

		result.setValue(teacherscoreManager.findTeacherscoreByPriKey(teacherid));
		result.setMessage("查询成功");
		log.debug("------TeacherscoreServiceImpl.findByPriKey 查询成功------");

		return result;
	}

	@Override
	public BasicResult deleteByPriKey(Integer teacherid) {
		BasicResult result = new BasicResult();

		teacherscoreManager.deleteTeacherscoreByPriKey(teacherid);
		result.setMessage("删除成功");
		log.debug("------TeacherscoreServiceImpl.deleteByPriKey 删除成功------");

		return result;
	}

	@Override
	public ListResult<Teacherscore> searchTeacherscore(Query<TeacherscoreQuery> query) {
		ListResult<Teacherscore> result = new ListResult<Teacherscore>();

		result.setValues(teacherscoreManager.searchTeacherscoreList(query));
		result.setMessage("查询成功");
		log.debug("------TeacherscoreServiceImpl.searchTeacherscore 查询成功------");

		return result;
	}

	@Override
	public PageListResult<TeacherscoreVo> searchPageTeacherscore(PageQuery<TeacherscoreQuery> pageQuery) {
		PageListResult<TeacherscoreVo> result = new PageListResult<TeacherscoreVo>();

		List<TeacherscoreVo> list = teacherscoreManager.searchPageTeacherscoreList(pageQuery);
		Integer itemCount = teacherscoreManager.getItemCount(pageQuery);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);

		result.setMessage("查询成功");
		log.debug("------TeacherscoreServiceImpl.searchPageTeacherscore 查询成功------");

		return result;
	}

	@Override
	public ListResult<TeacherscoreSum> searchTeacherscoreSum(Query<TeacherscoreQuery> query) {
		ListResult<TeacherscoreSum> result = new ListResult<TeacherscoreSum>();

		result.setValues(teacherscoreManager.searchTeacherscoreListSum(query));
		result.setMessage("查询成功");
		log.debug("------TeacherscoreServiceImpl.searchTeacherscore 查询成功------");

		return result;
	}
}
