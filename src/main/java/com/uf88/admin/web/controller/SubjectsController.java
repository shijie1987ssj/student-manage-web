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
import com.uf88.admin.pojo.Subjects;
import com.uf88.admin.pojo.SubjectsQuery;
import com.uf88.admin.service.ClubService;
import com.uf88.admin.service.SubjectsService;

/**
 * 描述：</b>SubjectsController<br>
 * @author：<a href="mailto:*@jd.com">系统生成</a>
 * 
 * @since：2018年09月19日 14时04分37秒 星期三
 * @version:1.0
 */
@Controller
@RequestMapping("/subjects")
public class SubjectsController {
	@Autowired
	private SubjectsService subjectsService;
	@Autowired
	private ClubService clubService;
	private Logger logger = LoggerFactory.getLogger(getClass());

	private static final String HTML_UTF8 = "text/html;charset=UTF-8";
	private static final String JSON_UTF8 = "application/json;charset=UTF-8";

	private static final String VIEW_INDEX = "subjectsIndex";
	private static final String AJAX_LISTDATA = "subjectsListData";
	private static final String VIEW_TOADD = "toAdd";
	private static final String AJAX_ADD = "/subjectsAdd";
	private static final String VIEW_TODETAIL = "/subjectsDetail";
	private static final String VIEW_TOEDIT = "toEdit";
	private static final String AJAX_EDIT = "/subjectsEdit";
	private static final String AJAX_DELETE = "subjectsDelete";

	/**
	 * 跳转到列表页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { VIEW_INDEX }, produces = { HTML_UTF8 }, method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView subjectsIndex(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("admin/subjectsIndex");
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
	public Object subjectsListData(HttpServletRequest request, @ModelAttribute SubjectsQuery query,
			@RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize) {
		if (query == null)
			query = new SubjectsQuery();
		PageQuery<SubjectsQuery> pageQuery = new PageQuery<SubjectsQuery>();
		pageQuery.setPageNo(pageNo);
		pageQuery.setPageSize(pageSize);
		pageQuery.setQuery(query);

		PageListResult<Subjects> info = subjectsService.searchPageSubjects(pageQuery);
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
	public ModelAndView subjectsDetail(@RequestParam(required = true, value = "subjectname") String subjectname) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/subjectsDetail");
		GenericResult<Subjects> result = subjectsService.findByPriKey(subjectname);
		if (result != null)
			mav.addObject("subjects", result.getValue());
		else
			mav.addObject("subjects", new Subjects());
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
		mav.setViewName("admin/subjectsAdd");

		ClubQuery cq = new ClubQuery();
		Query<ClubQuery> queryClub = new Query<ClubQuery>();
		queryClub.setQuery(cq);
		ListResult<Club> lrClub = clubService.searchClub(queryClub);
		if (ResultUtil.isSuccess(lrClub)) {
			mav.addObject("clubList", lrClub.getValues());
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
	public Object subjectsAdd(@ModelAttribute Subjects subjects) {
		BasicResult resultMap = new BasicResult();
		GenericResult<String> result = subjectsService.addSubjects(subjects);
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
	public ModelAndView toEdit(@RequestParam(required = true, value = "subjectname") String subjectname) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/subjectsEdit");
		GenericResult<Subjects> result = subjectsService.findByPriKey(subjectname);
		mav.addObject("subjects", result.getValue());
		return mav;
	}

	/**
	 * 编辑
	 * 
	 * @return
	 */
	@RequestMapping(value = { AJAX_EDIT }, method = { RequestMethod.GET, RequestMethod.POST }, produces = { JSON_UTF8 })
	@ResponseBody
	public Object subjectsEdit(@ModelAttribute Subjects subjects) {
		BasicResult resultMap = new BasicResult();
		BasicResult result = subjectsService.modifySubjects(subjects);
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
	public Object subjectsDelete(@RequestParam(required = true, value = "subjectname") String subjectname) {
		BasicResult resultMap = new BasicResult();
		BasicResult result = subjectsService.deleteByPriKey(subjectname);
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
