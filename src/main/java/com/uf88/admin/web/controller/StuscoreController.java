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
import com.uf88.admin.pojo.Stuscore;
import com.uf88.admin.pojo.StuscoreQuery;
import com.uf88.admin.pojo.StuscoreSum;
import com.uf88.admin.pojo.StuscoreVo;
import com.uf88.admin.pojo.TeacherscoreQuery;
import com.uf88.admin.pojo.TeacherscoreSum;
import com.uf88.admin.service.StuscoreService;
import com.uf88.admin.utils.Auth;
import com.uf88.admin.utils.AuthTools;

/**
 * 描述：</b>StuscoreController<br>
 * @author：<a href="mailto:*@jd.com">系统生成</a>
 * 
 * @since：2018年09月19日 14时04分37秒 星期三
 * @version:1.0
 */
@Controller
@RequestMapping("/stuscore")
public class StuscoreController {
	@Autowired
	private StuscoreService stuscoreService;
	private Logger logger = LoggerFactory.getLogger(getClass());

	private static final String HTML_UTF8 = "text/html;charset=UTF-8";
	private static final String JSON_UTF8 = "application/json;charset=UTF-8";

	private static final String VIEW_INDEX = "stuscoreIndex";
	private static final String AJAX_LISTDATA = "stuscoreListData";
	private static final String VIEW_TOADD = "toAdd";
	private static final String AJAX_ADD = "/stuscoreAdd";
	private static final String VIEW_TODETAIL = "/stuscoreDetail";
	private static final String VIEW_TOEDIT = "toEdit";
	private static final String AJAX_EDIT = "/stuscoreEdit";
	private static final String AJAX_DELETE = "stuscoreDelete";

	/**
	 * 跳转到列表页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { VIEW_INDEX }, produces = { HTML_UTF8 }, method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView stuscoreIndex(HttpServletRequest request,
			@RequestParam(required = false, value = "uflag") String uflag) {
		ModelAndView mv = null;
		if (uflag != null && "99".equals(uflag)) {
			mv = new ModelAndView("admin/stuscoreIndexShow");
		} else {
			mv = new ModelAndView("admin/stuscoreIndex");
		}
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
	public Object stuscoreListData(HttpServletRequest request, @ModelAttribute StuscoreQuery query,
			@RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize) {
		if (query == null)
			query = new StuscoreQuery();
		PageQuery<StuscoreQuery> pageQuery = new PageQuery<StuscoreQuery>();
		pageQuery.setPageNo(pageNo);
		pageQuery.setPageSize(pageSize);
		pageQuery.setQuery(query);

		PageListResult<StuscoreVo> info = stuscoreService.searchPageStuscore(pageQuery);
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
	public ModelAndView stuscoreDetail(@RequestParam(required = true, value = "stuid") Integer stuid) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/stuscoreDetail");
		GenericResult<StuscoreVo> result = stuscoreService.findByPriKey(stuid);
		if (result != null)
			mav.addObject("stuscore", result.getValue());
		else
			mav.addObject("stuscore", new Stuscore());
		return mav;
	}

	/**
	 * 详情
	 * 
	 * @return
	 */
	@RequestMapping(value = { "stuscoreDetailOwner" }, method = RequestMethod.GET, produces = { HTML_UTF8 })
	public ModelAndView stuscoreDetailOwner(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/stuscoreDetailOwner");
		Auth auth = AuthTools.getAuth(request);
		if (auth != null) {
			GenericResult<StuscoreVo> result = stuscoreService.findByPriKey(Integer.parseInt(auth.getUserName()));
			if (result != null)
				mav.addObject("stuscore", result.getValue());
			else
				mav.addObject("stuscore", new Stuscore());
		} else {
			mav.addObject("stuscore", new Stuscore());
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
	public String toAdd(HttpServletRequest request) {
		return "admin/stuscoreAdd";
	}

	/**
	 * 保存信息
	 * 
	 * @return
	 */
	@RequestMapping(value = { AJAX_ADD }, method = { RequestMethod.GET, RequestMethod.POST }, produces = { JSON_UTF8 })
	@ResponseBody
	public Object stuscoreAdd(@ModelAttribute Stuscore stuscore) {
		BasicResult resultMap = new BasicResult();
		GenericResult<String> result = stuscoreService.addStuscore(stuscore);
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
		mav.setViewName("admin/stuscoreEdit");
		GenericResult<StuscoreVo> result = stuscoreService.findByPriKey(stuid);
		StuscoreVo sv = null;
		if (ResultUtil.isGenericSuccess(result)) {
			sv = result.getValue();
		} else {
			sv = new StuscoreVo();
			sv.setStuid(stuid);
		}
		mav.addObject("stuscore", sv);
		return mav;
	}

	/**
	 * 编辑
	 * 
	 * @return
	 */
	@RequestMapping(value = { AJAX_EDIT }, method = { RequestMethod.GET, RequestMethod.POST }, produces = { JSON_UTF8 })
	@ResponseBody
	public Object stuscoreEdit(@ModelAttribute Stuscore stuscore) {
		BasicResult resultMap = new BasicResult();
		BasicResult result = stuscoreService.modifyStuscore(stuscore);
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
	public Object stuscoreDelete(@RequestParam(required = true, value = "stuid") Integer stuid) {
		BasicResult resultMap = new BasicResult();
		BasicResult result = stuscoreService.deleteByPriKey(stuid);
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
	@RequestMapping(value = { "stuscoreSum" }, produces = { HTML_UTF8 }, method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView stuscoreSum(HttpServletRequest request) {
		ModelAndView mv = null;
		mv = new ModelAndView("admin/stuscoreIndexSum");
		return mv;
	}

	/**
	 * 列表页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { "stuscoreListDataSum" }, method = { RequestMethod.GET, RequestMethod.POST }, produces = {
			JSON_UTF8 })
	@ResponseBody
	public Object stuscoreListDataSum(HttpServletRequest request, @ModelAttribute StuscoreQuery query,
			@RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize) {
		if (query == null)
			query = new StuscoreQuery();
		PageQuery<StuscoreQuery> pageQuery = new PageQuery<StuscoreQuery>();
		pageQuery.setPageNo(pageNo);
		pageQuery.setPageSize(pageSize);
		pageQuery.setQuery(query);

		ListResult<StuscoreSum> info = stuscoreService.searchStuscoreSum(pageQuery);
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
