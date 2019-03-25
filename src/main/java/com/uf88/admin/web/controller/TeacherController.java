package com.uf88.admin.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;
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
import com.uf88.admin.pojo.Subjects;
import com.uf88.admin.pojo.SubjectsQuery;
import com.uf88.admin.pojo.Teacher;
import com.uf88.admin.pojo.TeacherQuery;
import com.uf88.admin.pojo.Teacherscore;
import com.uf88.admin.service.ClassInfoService;
import com.uf88.admin.service.ClubService;
import com.uf88.admin.service.GradeService;
import com.uf88.admin.service.SubjectsService;
import com.uf88.admin.service.TeacherService;
import com.uf88.admin.service.TeacherscoreService;
import com.uf88.admin.service.impl.TeacherscoreServiceImpl;
import com.uf88.admin.utils.Auth;
import com.uf88.admin.utils.AuthTools;
import com.uf88.tools.MD5Utils;

/**
 * 描述：</b>TeacherController<br>
 * @author：<a href="mailto:*@jd.com">系统生成</a>
 * 
 * @since：2018年09月19日 14时04分37秒 星期三
 * @version:1.0
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private ClassInfoService classInfoService;
	@Autowired
	private ClubService clubService;
	@Autowired
	private GradeService gradeService;
	@Autowired
	private SubjectsService subjectsService;
	@Autowired
	private TeacherscoreService teacherscoreService;
	private Logger logger = LoggerFactory.getLogger(getClass());

	private static final String HTML_UTF8 = "text/html;charset=UTF-8";
	private static final String JSON_UTF8 = "application/json;charset=UTF-8";

	private static final String VIEW_INDEX = "teacherIndex";
	private static final String AJAX_LISTDATA = "teacherListData";
	private static final String VIEW_TOADD = "toAdd";
	private static final String AJAX_ADD = "/teacherAdd";
	private static final String VIEW_TODETAIL = "/teacherDetail";
	private static final String VIEW_TOEDIT = "toEdit";
	private static final String AJAX_EDIT = "/teacherEdit";
	private static final String AJAX_DELETE = "teacherDelete";

	/**
	 * 跳转到列表页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { VIEW_INDEX }, produces = { HTML_UTF8 }, method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView teacherIndex(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("admin/teacherIndex");
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
	public Object teacherListData(HttpServletRequest request, @ModelAttribute TeacherQuery query,
			@RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize) {
		if (query == null)
			query = new TeacherQuery();
		PageQuery<TeacherQuery> pageQuery = new PageQuery<TeacherQuery>();
		pageQuery.setPageNo(pageNo);
		pageQuery.setPageSize(pageSize);
		pageQuery.setQuery(query);

		PageListResult<Teacher> info = teacherService.searchPageTeacher(pageQuery);
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
	public ModelAndView teacherDetail(@RequestParam(required = true, value = "teacherid") Integer teacherid) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("teacherDetail");
		GenericResult<Teacher> result = teacherService.findByPriKey(teacherid);
		if (result != null)
			mav.addObject("teacher", result.getValue());
		else
			mav.addObject("teacher", new Teacher());
		return mav;
	}

	/**
	 * 详情
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/teacherDetailOwner" }, method = RequestMethod.GET, produces = { HTML_UTF8 })
	public ModelAndView teacherDetailOwner(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/teacherDetailOwner");

		Auth auth = AuthTools.getAuth(request);
		if (auth != null) {
			Integer teacherId = Integer.parseInt(auth.getUserName());
			GenericResult<Teacher> result = teacherService.findByPriKey(teacherId);
			if (result != null) {
				mav.addObject("teacher", result.getValue());
				GenericResult<Teacherscore> gr = teacherscoreService.findByPriKey(teacherId);
				if (ResultUtil.isGenericSuccess(gr)) {
					mav.addObject("teacherscore", gr.getValue());
				}
			} else {
				mav.addObject("teacher", new Teacher());
			}
		} else {
			mav.addObject("teacher", new Teacher());
		}
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
		mav.setViewName("admin/teacherAdd");

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

		SubjectsQuery sq = new SubjectsQuery();
		Query<SubjectsQuery> querySubjects = new Query<SubjectsQuery>();
		querySubjects.setQuery(sq);
		ListResult<Subjects> lrSubjects = subjectsService.searchSubjects(querySubjects);
		if (ResultUtil.isSuccess(lrSubjects)) {
			mav.addObject("subjectsList", lrSubjects.getValues());
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
	public Object teacherAdd(@ModelAttribute Teacher teacher) {
		BasicResult resultMap = new BasicResult();
		if (teacher != null && teacher.getTeacherpass() != null && teacher.getTeacherpass().length() > 0) {
			teacher.setTeacherpass(MD5Utils.MD5(teacher.getTeacherpass()));
		}
		GenericResult<String> result = teacherService.addTeacher(teacher);
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
	public ModelAndView toEdit(@RequestParam(required = true, value = "teacherid") Integer teacherid) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/teacherEdit");
		GenericResult<Teacher> result = teacherService.findByPriKey(teacherid);
		mav.addObject("teacher", result.getValue());

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

		SubjectsQuery sq = new SubjectsQuery();
		Query<SubjectsQuery> querySubjects = new Query<SubjectsQuery>();
		querySubjects.setQuery(sq);
		ListResult<Subjects> lrSubjects = subjectsService.searchSubjects(querySubjects);
		if (ResultUtil.isSuccess(lrSubjects)) {
			mav.addObject("subjectsList", lrSubjects.getValues());
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
	public Object teacherEdit(@ModelAttribute Teacher teacher) {
		BasicResult resultMap = new BasicResult();
		if (teacher != null && teacher.getTeacherpass() != null && teacher.getTeacherpass().length() > 0) {
			teacher.setTeacherpass(MD5Utils.MD5(teacher.getTeacherpass()));
		}
		BasicResult result = teacherService.modifyTeacher(teacher);
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
	public Object teacherDelete(@RequestParam(required = true, value = "teacherid") Integer teacherid) {
		BasicResult resultMap = new BasicResult();
		BasicResult result = teacherService.deleteByPriKey(teacherid);
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
