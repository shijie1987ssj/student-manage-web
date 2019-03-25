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
import com.uf88.uf88core.common.exception.ResultCode;
import com.uf88.uf88core.util.ResultUtil;
import com.uf88.admin.pojo.Teacherscore;
import com.uf88.admin.pojo.TeacherscoreQuery;
import com.uf88.admin.pojo.TeacherscoreSum;
import com.uf88.admin.pojo.TeacherscoreVo;
import com.uf88.admin.service.TeacherscoreService;

/**
 * 描述：</b>TeacherscoreController<br>
 * @author：<a href="mailto:*@jd.com">系统生成</a>
 * 
 * @since：2018年09月19日 14时04分37秒 星期三
 * @version:1.0
 */
@Controller
@RequestMapping("/teacherscore")
public class TeacherscoreController {
	@Autowired
	private TeacherscoreService teacherscoreService;
	private Logger logger = LoggerFactory.getLogger(getClass());

	private static final String HTML_UTF8 = "text/html;charset=UTF-8";
	private static final String JSON_UTF8 = "application/json;charset=UTF-8";

	private static final String VIEW_INDEX = "teacherscoreIndex";
	private static final String AJAX_LISTDATA = "teacherscoreListData";
	private static final String VIEW_TOADD = "toAdd";
	private static final String AJAX_ADD = "/teacherscoreAdd";
	private static final String VIEW_TODETAIL = "/teacherscoreDetail";
	private static final String VIEW_TOEDIT = "toEdit";
	private static final String AJAX_EDIT = "/teacherscoreEdit";
	private static final String AJAX_DELETE = "teacherscoreDelete";

	/**
	 * 跳转到列表页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { VIEW_INDEX }, produces = { HTML_UTF8 }, method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView teacherscoreIndex(HttpServletRequest request,
			@RequestParam(required = false, value = "uflag", defaultValue = "0") String uflag) {
		ModelAndView mv = null;
		if (uflag != null && "99".equals(uflag)) {
			mv = new ModelAndView("admin/teacherscoreIndexShow");
		} else {
			mv = new ModelAndView("admin/teacherscoreIndex");
		}
		mv.addObject("uflag", uflag);
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
	public Object teacherscoreListData(HttpServletRequest request, @ModelAttribute TeacherscoreQuery query,
			@RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize,
			@RequestParam(required = false, value = "uflag", defaultValue = "0") String uflag) {
		if (query == null)
			query = new TeacherscoreQuery();
		if (!uflag.equals("99") && (query.getShowNoScore() == null || query.getShowNoScore().trim().length() == 0)) {
			query.setShowScore("1");
		}
		PageQuery<TeacherscoreQuery> pageQuery = new PageQuery<TeacherscoreQuery>();
		pageQuery.setPageNo(pageNo);
		pageQuery.setPageSize(pageSize);
		pageQuery.setQuery(query);

		PageListResult<TeacherscoreVo> info = teacherscoreService.searchPageTeacherscore(pageQuery);
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
	public ModelAndView teacherscoreDetail(@RequestParam(required = true, value = "teacherid") Integer teacherid) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/teacherscoreDetail");
		GenericResult<Teacherscore> result = teacherscoreService.findByPriKey(teacherid);
		if (result != null)
			mav.addObject("teacherscore", result.getValue());
		else
			mav.addObject("teacherscore", new Teacherscore());
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
		return "admin/teacherscoreAdd";
	}

	/**
	 * 保存信息
	 * 
	 * @return
	 */
	@RequestMapping(value = { AJAX_ADD }, method = { RequestMethod.GET, RequestMethod.POST }, produces = { JSON_UTF8 })
	@ResponseBody
	public Object teacherscoreAdd(@ModelAttribute Teacherscore teacherscore) {
		BasicResult resultMap = new BasicResult();
		GenericResult<String> result = teacherscoreService.addTeacherscore(teacherscore);
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
		mav.setViewName("admin/teacherscoreEdit");
		GenericResult<Teacherscore> result = teacherscoreService.findByPriKey(teacherid);
		Teacherscore t = null;
		if (ResultUtil.isGenericSuccess(result)) {
			t = result.getValue();
		} else {
			t = new Teacherscore();
			t.setTeacherid(teacherid);
		}
		mav.addObject("teacherscore", t);
		return mav;
	}

	/**
	 * 编辑
	 * 
	 * @return
	 */
	@RequestMapping(value = { AJAX_EDIT }, method = { RequestMethod.GET, RequestMethod.POST }, produces = { JSON_UTF8 })
	@ResponseBody
	public Object teacherscoreEdit(@ModelAttribute Teacherscore teacherscore) {
		BasicResult resultMap = new BasicResult();
		BasicResult result = teacherscoreService.modifyTeacherscore(teacherscore);
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
	public Object teacherscoreDelete(@RequestParam(required = true, value = "teacherid") Integer teacherid) {
		BasicResult resultMap = new BasicResult();
		BasicResult result = teacherscoreService.deleteByPriKey(teacherid);
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
	 * 跳转到列表页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { "teacherscoreSum" }, produces = { HTML_UTF8 }, method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView teacherscoreSum(HttpServletRequest request) {
		ModelAndView mv = null;
		mv = new ModelAndView("admin/teacherscoreIndexSum");
		return mv;
	}

	/**
	 * 列表页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { "teacherscoreListDataSum" }, method = { RequestMethod.GET,
			RequestMethod.POST }, produces = { JSON_UTF8 })
	@ResponseBody
	public Object teacherscoreListDataSum(HttpServletRequest request, @ModelAttribute TeacherscoreQuery query,
			@RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize) {
		if (query == null)
			query = new TeacherscoreQuery();

		PageQuery<TeacherscoreQuery> pageQuery = new PageQuery<TeacherscoreQuery>();
		pageQuery.setPageNo(pageNo);
		pageQuery.setPageSize(pageSize);
		pageQuery.setQuery(query);

		ListResult<TeacherscoreSum> info = teacherscoreService.searchTeacherscoreSum(pageQuery);
		Map mapData = new HashMap();
		if (info != null) {
			mapData.put("total", info.getValues().size());
			mapData.put("rows", info.getValues());
		} else {
			mapData.put("total", 0);
			mapData.put("rows", new ArrayList());
		}
		return mapData;
	}
}
