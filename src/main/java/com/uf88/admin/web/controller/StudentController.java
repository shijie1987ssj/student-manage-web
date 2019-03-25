package com.uf88.admin.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.common.exception.ResultCode;
import com.uf88.uf88core.util.ResultUtil;
import com.uf88.admin.pojo.ClassInfo;
import com.uf88.admin.pojo.ClassInfoQuery;
import com.uf88.admin.pojo.Club;
import com.uf88.admin.pojo.ClubQuery;
import com.uf88.admin.pojo.Grade;
import com.uf88.admin.pojo.GradeQuery;
import com.uf88.admin.pojo.Student;
import com.uf88.admin.pojo.StudentQuery;
import com.uf88.admin.service.ClassInfoService;
import com.uf88.admin.service.ClubService;
import com.uf88.admin.service.GradeService;
import com.uf88.admin.service.StudentService;
import com.uf88.tools.MD5Utils;

/**
 * 描述：</b>StudentController<br>
 * @author：<a href="mailto:*@jd.com">系统生成</a>
 * 
 * @since：2018年09月19日 14时04分37秒 星期三
 * @version:1.0
 */
@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassInfoService classInfoService;
	@Autowired
	private ClubService clubService;
	@Autowired
	private GradeService gradeService;
	private Logger logger = LoggerFactory.getLogger(getClass());

	private static final String HTML_UTF8 = "text/html;charset=UTF-8";
	private static final String JSON_UTF8 = "application/json;charset=UTF-8";

	private static final String VIEW_INDEX = "studentIndex";
	private static final String AJAX_LISTDATA = "studentListData";
	private static final String VIEW_TOADD = "toAdd";
	private static final String AJAX_ADD = "/studentAdd";
	private static final String VIEW_TODETAIL = "/studentDetail";
	private static final String VIEW_TOEDIT = "toEdit";
	private static final String AJAX_EDIT = "/studentEdit";
	private static final String AJAX_DELETE = "studentDelete";

	/**
	 * 跳转到列表页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { VIEW_INDEX }, produces = { HTML_UTF8 }, method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView studentIndex(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("admin/studentIndex");
		return mv;
	}

	/**
	 * 列表页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { AJAX_LISTDATA }, method = { RequestMethod.GET, RequestMethod.POST }, produces = {
			JSON_UTF8 })
	@ResponseBody
	public Object studentListData(HttpServletRequest request, @ModelAttribute StudentQuery query,
			@RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize) {
		if (query == null)
			query = new StudentQuery();

		PageQuery<StudentQuery> pageQuery = new PageQuery<StudentQuery>();
		pageQuery.setPageNo(pageNo);
		pageQuery.setPageSize(pageSize);
		pageQuery.setQuery(query);

		PageListResult<Student> info = studentService.searchPageStudent(pageQuery);
		Map mapData = new HashMap();
		if (info != null) {
			mapData.put("total", info.getPagenation().getItemCount());
			mapData.put("rows", info.getValues());
		} else {
			mapData.put("total", 0);
			mapData.put("rows", new ArrayList());
		}
		return mapData;
	}

	/**
	 * 详情
	 * 
	 * @return
	 */
	@RequestMapping(value = { VIEW_TODETAIL }, method = RequestMethod.GET, produces = { HTML_UTF8 })
	public ModelAndView studentDetail(@RequestParam(required = true, value = "stuid") Integer stuid) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("studentDetail");
		GenericResult<Student> result = studentService.findByPriKey(stuid);
		if (ResultUtil.isGenericSuccess(result))
			mav.addObject("student", result.getValue());
		else
			mav.addObject("student", new Student());
		return mav;
	}

	/**
	 * 跳转到添加页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { VIEW_TOADD }, method = { RequestMethod.GET, RequestMethod.POST }, produces = {
			HTML_UTF8 })
	public ModelAndView toAdd(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/studentAdd");

		ClassInfoQuery cfq = new ClassInfoQuery();
		Query<ClassInfoQuery> queryClass = new Query<ClassInfoQuery>();
		queryClass.setQuery(cfq);
		ListResult<ClassInfo> lrClass = classInfoService.searchClassInfo(queryClass);
		if (ResultUtil.isSuccess(lrClass)) {
			mav.addObject("classInfoList", lrClass.getValues());
		}

		ClubQuery cq = new ClubQuery();
		Query<ClubQuery> queryClub = new Query<ClubQuery>();
		queryClub.setQuery(cq);
		ListResult<Club> lrClub = clubService.searchClub(queryClub);
		if (ResultUtil.isSuccess(lrClub)) {
			mav.addObject("clubList", lrClub.getValues());
		}

		GradeQuery gq = new GradeQuery();
		Query<GradeQuery> queryGrade = new Query<GradeQuery>();
		queryGrade.setQuery(gq);
		ListResult<Grade> lrGrade = gradeService.searchGrade(queryGrade);
		if (ResultUtil.isSuccess(lrGrade)) {
			mav.addObject("gradeList", lrGrade.getValues());
		}

		return mav;
	}

	/**
	 * 保存信息
	 * 
	 * @return
	 */
	@RequestMapping(value = { AJAX_ADD }, method = { RequestMethod.GET, RequestMethod.POST }, produces = { JSON_UTF8 })
	@ResponseBody
	public Object studentAdd(@ModelAttribute Student student) {
		BasicResult resultMap = new BasicResult();
		if (student != null && student.getStupass() != null && student.getStupass().length() > 0) {
			student.setStupass(MD5Utils.MD5(student.getStupass()));
		}
		GenericResult<String> result = studentService.addStudent(student);
		if (ResultUtil.isGenericSuccess(result)) {
			resultMap.setCode(ResultCode.SUCCESS.getCode());
			resultMap.setMessage("操作成功");
		} else {
			resultMap.setCode(ResultCode.FAILED.getCode());
			resultMap.setMessage(result.getMessage());
		}
		return resultMap;
	}

	/**
	 * 跳转到编辑页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { VIEW_TOEDIT }, method = RequestMethod.GET, produces = { HTML_UTF8 })
	public ModelAndView toEdit(@RequestParam(required = true, value = "stuid") Integer stuid) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/studentEdit");
		GenericResult<Student> result = studentService.findByPriKey(stuid);
		mav.addObject("student", result.getValue());

		ClassInfoQuery cfq = new ClassInfoQuery();
		Query<ClassInfoQuery> queryClass = new Query<ClassInfoQuery>();
		queryClass.setQuery(cfq);
		ListResult<ClassInfo> lrClass = classInfoService.searchClassInfo(queryClass);
		if (ResultUtil.isSuccess(lrClass)) {
			mav.addObject("classInfoList", lrClass.getValues());
		}

		ClubQuery cq = new ClubQuery();
		Query<ClubQuery> queryClub = new Query<ClubQuery>();
		queryClub.setQuery(cq);
		ListResult<Club> lrClub = clubService.searchClub(queryClub);
		if (ResultUtil.isSuccess(lrClub)) {
			mav.addObject("clubList", lrClub.getValues());
		}

		GradeQuery gq = new GradeQuery();
		Query<GradeQuery> queryGrade = new Query<GradeQuery>();
		queryGrade.setQuery(gq);
		ListResult<Grade> lrGrade = gradeService.searchGrade(queryGrade);
		if (ResultUtil.isSuccess(lrGrade)) {
			mav.addObject("gradeList", lrGrade.getValues());
		}

		return mav;
	}

	/**
	 * 编辑
	 * 
	 * @return
	 */
	@RequestMapping(value = { AJAX_EDIT }, method = { RequestMethod.GET, RequestMethod.POST }, produces = { JSON_UTF8 })
	@ResponseBody
	public Object studentEdit(@ModelAttribute Student student) {
		BasicResult resultMap = new BasicResult();
		if (student != null && student.getStupass() != null && student.getStupass().length() > 0) {
			student.setStupass(MD5Utils.MD5(student.getStupass()));
		}
		BasicResult result = studentService.modifyStudent(student);
		if (ResultUtil.isSuccess(result)) {
			resultMap.setCode(ResultCode.SUCCESS.getCode());
			resultMap.setMessage("操作成功");
		} else {
			resultMap.setCode(ResultCode.FAILED.getCode());
			resultMap.setMessage(result.getMessage());
		}
		return resultMap;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(value = { AJAX_DELETE }, method = RequestMethod.GET, produces = { JSON_UTF8 })
	@ResponseBody
	public Object studentDelete(@RequestParam(required = true, value = "stuid") Integer stuid) {
		BasicResult resultMap = new BasicResult();
		BasicResult result = studentService.deleteByPriKey(stuid);
		if (ResultUtil.isSuccess(result)) {
			resultMap.setCode(ResultCode.SUCCESS.getCode());
			resultMap.setMessage("操作成功");
		} else {
			resultMap.setCode(ResultCode.FAILED.getCode());
			resultMap.setMessage(result.getMessage());
		}
		return resultMap;
	}
}
