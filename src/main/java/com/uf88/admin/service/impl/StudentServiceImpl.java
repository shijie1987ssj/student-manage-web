package com.uf88.admin.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uf88.admin.service.StudentService;
import com.uf88.admin.manager.StudentManager;
import com.uf88.admin.pojo.Leader;
import com.uf88.admin.pojo.Student;
import com.uf88.admin.pojo.StudentQuery;
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
 * 描述：</b>StudentServiceImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分09秒 星期三
 * @version:1.0
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
	private final static Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
	@Autowired
	private StudentManager studentManager;

	@Override
	public GenericResult<String> addStudent(Student student) {
		GenericResult<String> result = new GenericResult<String>();

		if (student != null) {
			// TODO:generate sequence id by CacheUtils.getSeq method Or remove this block.
			String id = "";// CacheUtils.getSeq(RedisKeyConstants.XXX, length);
			// student.setId(id);
			studentManager.insertStudent(student);

			result.setValue(id);
			result.setMessage("保存成功");
			log.debug("------StudentServiceImpl.addStudent 保存成功------");
		} else {
			log.error("------StudentServiceImpl.addStudent - student is null!");
			result.setCode("");
			result.setMessage("student is null");
		}

		return result;
	}

	@Override
	public BasicResult modifyStudent(Student student) {
		BasicResult result = new BasicResult();

		if (student != null) {
			if (student.getStupass() != null && student.getStupass().length() == 0) {
				student.setStupass(null);
			}
			studentManager.updateStudent(student);
			result.setMessage("编辑成功");
			log.debug("------StudentServiceImpl.modifyStudent 编辑成功------");
		} else {
			log.error("------StudentServiceImpl.modifyStudent - student is null!");
			result.setCode("");
			result.setMessage("student is null");
		}

		return result;
	}

	@Override
	public GenericResult<Student> findByPriKey(Integer stuid) {
		GenericResult<Student> result = new GenericResult<Student>();

		result.setValue(studentManager.findStudentByPriKey(stuid));
		result.setMessage("查询成功");
		log.debug("------StudentServiceImpl.findByPriKey 查询成功------");

		return result;
	}

	@Override
	public BasicResult checkLogin(String name, String passwd) {
		BasicResult br = new BasicResult();
		Integer nameNum = 0;
		try {
			nameNum = Integer.parseInt(name);
			GenericResult<Student> gr = findByPriKey(nameNum);
			if (ResultUtil.isGenericSuccess(gr)) {
				if (gr.getValue().getStupass().equals(passwd)) {
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
			log.error("------StudentServiceImpl.findByPriKey 异常------", e);
			br.setCode(ResultCode.FAILED.getCode());
			br.setMessage("用户名错误！");
		}

		return br;
	}

	@Override
	public BasicResult deleteByPriKey(Integer stuid) {
		BasicResult result = new BasicResult();

		studentManager.deleteStudentByPriKey(stuid);
		result.setMessage("删除成功");
		log.debug("------StudentServiceImpl.deleteByPriKey 删除成功------");

		return result;
	}

	@Override
	public ListResult<Student> searchStudent(Query<StudentQuery> query) {
		ListResult<Student> result = new ListResult<Student>();

		result.setValues(studentManager.searchStudentList(query));
		result.setMessage("查询成功");
		log.debug("------StudentServiceImpl.searchStudent 查询成功------");

		return result;
	}

	@Override
	public PageListResult<Student> searchPageStudent(PageQuery<StudentQuery> pageQuery) {
		PageListResult<Student> result = new PageListResult<Student>();

		List<Student> list = studentManager.searchPageStudentList(pageQuery);
		Integer itemCount = studentManager.getItemCount(pageQuery);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);

		result.setMessage("查询成功");
		log.debug("------StudentServiceImpl.searchPageStudent 查询成功------");

		return result;
	}
}
