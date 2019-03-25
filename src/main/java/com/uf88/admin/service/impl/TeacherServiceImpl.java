package com.uf88.admin.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uf88.admin.service.TeacherService;
import com.uf88.admin.manager.TeacherManager;
import com.uf88.admin.pojo.Student;
import com.uf88.admin.pojo.Teacher;
import com.uf88.admin.pojo.TeacherQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.common.exception.ResultCode;
import com.uf88.uf88core.paging.Pagenation;
import com.uf88.uf88core.util.ResultUtil;

/**
 * 描述：</b>TeacherServiceImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分09秒 星期三
 * @version:1.0
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
	private final static Logger log = LoggerFactory.getLogger(TeacherServiceImpl.class);
	@Autowired
	private TeacherManager teacherManager;

	@Override
	public GenericResult<String> addTeacher(Teacher teacher) {
		GenericResult<String> result = new GenericResult<String>();

		if (teacher != null) {
			// TODO:generate sequence id by CacheUtils.getSeq method Or remove this block.
			String id = "";// CacheUtils.getSeq(RedisKeyConstants.XXX, length);
			// teacher.setId(id);
			teacherManager.insertTeacher(teacher);

			result.setValue(id);
			result.setMessage("保存成功");
			log.debug("------TeacherServiceImpl.addTeacher 保存成功------");
		} else {
			log.error("------TeacherServiceImpl.addTeacher - teacher is null!");
			result.setCode("");
			result.setMessage("teacher is null");
		}

		return result;
	}

	@Override
	public BasicResult modifyTeacher(Teacher teacher) {
		BasicResult result = new BasicResult();

		if (teacher != null) {
			teacherManager.updateTeacher(teacher);
			result.setMessage("编辑成功");
			log.debug("------TeacherServiceImpl.modifyTeacher 编辑成功------");
		} else {
			log.error("------TeacherServiceImpl.modifyTeacher - teacher is null!");
			result.setCode("");
			result.setMessage("teacher is null");
		}

		return result;
	}

	@Override
	public GenericResult<Teacher> findByPriKey(Integer teacherid) {
		GenericResult<Teacher> result = new GenericResult<Teacher>();

		result.setValue(teacherManager.findTeacherByPriKey(teacherid));
		result.setMessage("查询成功");
		log.debug("------TeacherServiceImpl.findByPriKey 查询成功------");

		return result;
	}

	@Override
	public BasicResult checkLogin(String name, String passwd) {
		BasicResult br = new BasicResult();
		Integer nameNum = 0;
		try {
			nameNum = Integer.parseInt(name);
			GenericResult<Teacher> gr = findByPriKey(nameNum);
			if (ResultUtil.isGenericSuccess(gr)) {
				if (gr.getValue().getTeacherpass().equals(passwd)) {
					br.setCode(ResultCode.SUCCESS.getCode());
					br.setMessage("登陆成功");
				} else {
					br.setCode(ResultCode.FAILED.getCode());
					br.setMessage("用户名/密码错误");
				}
			} else {
				br.setCode(ResultCode.FAILED.getCode());
				br.setMessage("用户名/密码错误");
			}
		} catch (Exception e) {
			br.setCode(ResultCode.FAILED.getCode());
			br.setMessage("用户名错误！");
		}

		return br;
	}

	@Override
	public BasicResult deleteByPriKey(Integer teacherid) {
		BasicResult result = new BasicResult();

		teacherManager.deleteTeacherByPriKey(teacherid);
		result.setMessage("删除成功");
		log.debug("------TeacherServiceImpl.deleteByPriKey 删除成功------");

		return result;
	}

	@Override
	public ListResult<Teacher> searchTeacher(Query<TeacherQuery> query) {
		ListResult<Teacher> result = new ListResult<Teacher>();

		result.setValues(teacherManager.searchTeacherList(query));
		result.setMessage("查询成功");
		log.debug("------TeacherServiceImpl.searchTeacher 查询成功------");

		return result;
	}

	@Override
	public PageListResult<Teacher> searchPageTeacher(PageQuery<TeacherQuery> pageQuery) {
		PageListResult<Teacher> result = new PageListResult<Teacher>();

		List<Teacher> list = teacherManager.searchPageTeacherList(pageQuery);
		Integer itemCount = teacherManager.getItemCount(pageQuery);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);

		result.setMessage("查询成功");
		log.debug("------TeacherServiceImpl.searchPageTeacher 查询成功------");

		return result;
	}
}
