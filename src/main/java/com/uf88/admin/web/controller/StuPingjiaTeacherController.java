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
import com.uf88.admin.pojo.Question;
import com.uf88.admin.pojo.QuestionQuery;
import com.uf88.admin.pojo.StuPingjiaTeacher;
import com.uf88.admin.pojo.StuPingjiaTeacherQuery;
import com.uf88.admin.pojo.Teacher;
import com.uf88.admin.pojo.TeacherQuery;
import com.uf88.admin.pojo.Teacherscore;
import com.uf88.admin.service.QuestionService;
import com.uf88.admin.service.StuPingjiaTeacherService;
import com.uf88.admin.service.TeacherService;
import com.uf88.admin.service.TeacherscoreService;
import com.uf88.admin.utils.Auth;
import com.uf88.admin.utils.AuthTools;

/**
 * 描述：</b>StuPingjiaTeacherController<br>
 * @author：<a href="mailto:*@jd.com">系统生成</a>
 * 
 * @since：2018年09月19日 14时04分37秒 星期三
 * @version:1.0
 */
@Controller
@RequestMapping("/stuPingjiaTeacher")
public class StuPingjiaTeacherController {
	@Autowired
	private StuPingjiaTeacherService stuPingjiaTeacherService;
	@Autowired
	private TeacherscoreService teacherscoreService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private TeacherService teacherService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	private static final String HTML_UTF8 = "text/html;charset=UTF-8";
	private static final String JSON_UTF8 = "application/json;charset=UTF-8";

	private static final String VIEW_INDEX = "stuPingjiaTeacherIndex";
	private static final String AJAX_LISTDATA = "stuPingjiaTeacherListData";
	private static final String VIEW_TOADD = "toAdd";
	private static final String AJAX_ADD = "/stuPingjiaTeacherAdd";
	private static final String VIEW_TODETAIL = "/stuPingjiaTeacherDetail";
	private static final String VIEW_TOEDIT = "toEdit";
	private static final String AJAX_EDIT = "/stuPingjiaTeacherEdit";
	private static final String AJAX_DELETE = "stuPingjiaTeacherDelete";

	/**
	 * 跳转到列表页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { VIEW_INDEX }, produces = { HTML_UTF8 }, method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView stuPingjiaTeacherIndex(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("admin/stuPingjiaTeacherListIndex");
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
	public Object stuPingjiaTeacherListData(HttpServletRequest request, @ModelAttribute StuPingjiaTeacherQuery query,
			@RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize) {
		if (query == null)
			query = new StuPingjiaTeacherQuery();
		TeacherQuery tq = new TeacherQuery();
		if (query.getTeacheridStr() != null && query.getTeacheridStr().trim().length() > 0) {
			tq.setTeacheridStr(query.getTeacheridStr().trim());
		}
		PageQuery<TeacherQuery> pageQuery = new PageQuery<TeacherQuery>();
		pageQuery.setPageNo(pageNo);
		pageQuery.setPageSize(pageSize);
		pageQuery.setQuery(tq);

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
	public ModelAndView stuPingjiaTeacherDetail(@RequestParam(required = true, value = "id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("stuPingjiaTeacherDetail");
		GenericResult<StuPingjiaTeacher> result = stuPingjiaTeacherService.findByPriKey(id);
		if (result != null)
			mav.addObject("stuPingjiaTeacher", result.getValue());
		else
			mav.addObject("stuPingjiaTeacher", new StuPingjiaTeacher());
		return mav;
	}

	/**
	 * 跳转到添加页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { VIEW_TOADD }, method = { RequestMethod.GET, RequestMethod.POST }, produces = {
			HTML_UTF8 })
	public String toAdd(HttpServletRequest request) {
		return "stuPingjiaTeacherAdd";
	}

	/**
	 * 保存信息
	 * 
	 * @return
	 */
	@RequestMapping(value = { AJAX_ADD }, method = { RequestMethod.GET, RequestMethod.POST }, produces = { JSON_UTF8 })
	@ResponseBody
	public Object stuPingjiaTeacherAdd(@ModelAttribute StuPingjiaTeacher stuPingjiaTeacher) {
		BasicResult resultMap = new BasicResult();
		GenericResult<String> result = stuPingjiaTeacherService.addStuPingjiaTeacher(stuPingjiaTeacher);
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
	public ModelAndView toEdit(@RequestParam(required = true, value = "id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("stuPingjiaTeacherEdit");
		GenericResult<StuPingjiaTeacher> result = stuPingjiaTeacherService.findByPriKey(id);
		mav.addObject("stuPingjiaTeacher", result.getValue());
		return mav;
	}

	/**
	 * 编辑
	 * 
	 * @return
	 */
	@RequestMapping(value = { AJAX_EDIT }, method = { RequestMethod.GET, RequestMethod.POST }, produces = { JSON_UTF8 })
	@ResponseBody
	public Object stuPingjiaTeacherEdit(@ModelAttribute StuPingjiaTeacher stuPingjiaTeacher) {
		BasicResult resultMap = new BasicResult();
		BasicResult result = stuPingjiaTeacherService.modifyStuPingjiaTeacher(stuPingjiaTeacher);
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
	public Object stuPingjiaTeacherDelete(@RequestParam(required = true, value = "id") Integer id) {
		BasicResult resultMap = new BasicResult();
		BasicResult result = stuPingjiaTeacherService.deleteByPriKey(id);
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
	 * 跳转到编辑页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { "toStuPingjiaTeacherUpsert" }, method = RequestMethod.GET, produces = { HTML_UTF8 })
	public ModelAndView toStuPingjiaTeacherUpsert(
			@RequestParam(required = true, value = "teacherid") Integer teacherid) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/stuPingjiaTeacherUpsert");
		QuestionQuery qq = new QuestionQuery();
		Query<QuestionQuery> query = new Query<QuestionQuery>();
		query.setQuery(qq);
		ListResult<Question> result = questionService.searchQuestion(query);
		if (ResultUtil.isSuccess(result)) {
			mav.addObject("questionList", result.getValues());
		}
		mav.addObject("teacherid", teacherid);
		return mav;
	}

	/**
	 * 编辑
	 * 
	 * @return
	 */
	@RequestMapping(value = { "stuPingjiaTeacherUpsert" }, method = { RequestMethod.GET,
			RequestMethod.POST }, produces = { JSON_UTF8 })
	@ResponseBody
	public Object stuPingjiaTeacherUpsert(HttpServletRequest request,
			@ModelAttribute StuPingjiaTeacher stuPingjiaTeacher) {
		BasicResult resultMap = new BasicResult();
		int score = 0;
		int pingjiascore = 0;
		for (int i = 0; i < 10; i++) {
			String scoreStr = request.getParameter("score" + i);
			score = Integer.parseInt(scoreStr); // 获得学生每一题评价的打分的分数
			pingjiascore += score; // 统计分数
		}
		Auth auth = AuthTools.getAuth(request);
		if (auth != null) {
			// 保存打分信息
			stuPingjiaTeacher.setPingjiascore(pingjiascore);
			stuPingjiaTeacher.setStuid(Integer.parseInt(auth.getUserName()));
			BasicResult result = stuPingjiaTeacherService.modifyStuPingjiaTeacher(stuPingjiaTeacher);
			if (ResultUtil.isSuccess(result)) {
				resultMap.setCode(ResultCode.SUCCESS.getCode());
				resultMap.setMessage("操作成功");

				// 更新教师平均分
				StuPingjiaTeacherQuery sptq = new StuPingjiaTeacherQuery();
				sptq.setTeacherid(stuPingjiaTeacher.getTeacherid());
				Query<StuPingjiaTeacherQuery> query = new Query<StuPingjiaTeacherQuery>();
				query.setQuery(sptq);
				ListResult<StuPingjiaTeacher> lrStuPingj = stuPingjiaTeacherService.searchStuPingjiaTeacher(query);
				if (ResultUtil.isSuccess(lrStuPingj)) {
					int sumscore = 0;
					for (StuPingjiaTeacher spt : lrStuPingj.getValues()) {
						sumscore += spt.getPingjiascore();
					}
					Teacherscore teacherscore = new Teacherscore();
					teacherscore.setTeacherid(stuPingjiaTeacher.getTeacherid());
					teacherscore.setTeacherscore(sumscore / lrStuPingj.getValues().size());
					BasicResult br = teacherscoreService.modifyTeacherscore(teacherscore);
					if (ResultUtil.isSuccess(br)) {
						// 更新教师评价状态
						Teacher teacher = new Teacher();
						teacher.setTeacherid(stuPingjiaTeacher.getTeacherid());
						teacher.setPingjia("已评价");
						BasicResult br1 = teacherService.modifyTeacher(teacher);
					}
				}
			} else {
				resultMap.setCode(ResultCode.FAILED.getCode());
				resultMap.setMessage(result.getMessage());
			}
		} else {
			resultMap.setCode(ResultCode.FAILED.getCode());
			resultMap.setMessage("请先登录");
		}

		return resultMap;
	}
}
