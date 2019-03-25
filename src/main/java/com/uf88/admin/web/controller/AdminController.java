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
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.common.exception.ResultCode;
import com.uf88.uf88core.util.ResultUtil;
import com.uf88.admin.pojo.Admin;
import com.uf88.admin.pojo.AdminQuery;
import com.uf88.admin.service.AdminService;


/**
 * 描述：</b>AdminController<br>
 * @author：<a href="mailto:*@jd.com">系统生成</a>
 * @since：2018年09月19日 14时04分35秒 星期三 
 * @version:1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
  @Autowired
  private AdminService adminService;
 private Logger logger = LoggerFactory.getLogger(getClass());
 
 	private static final String HTML_UTF8 = "text/html;charset=UTF-8";
	private static final String JSON_UTF8 = "application/json;charset=UTF-8";
	
	private static final String VIEW_INDEX = "adminIndex";
	private static final String AJAX_LISTDATA = "adminListData";
	private static final String VIEW_TOADD = "toAdd";
	private static final String AJAX_ADD = "/adminAdd";
	private static final String VIEW_TODETAIL = "/adminDetail";
	private static final String VIEW_TOEDIT = "toEdit";
	private static final String AJAX_EDIT = "/adminEdit";
	private static final String AJAX_DELETE = "adminDelete";
 /**
 * 跳转到列表页面
 * @return
 */
@RequestMapping(value = {VIEW_INDEX}, produces = { HTML_UTF8 },method ={RequestMethod.GET, RequestMethod.POST})
public ModelAndView adminIndex(HttpServletRequest request){
    ModelAndView mv = new ModelAndView("adminIndex");
		return mv; 
}
 /**
  * 列表页面
  * @return
  */
@RequestMapping(value= {AJAX_LISTDATA},method = {RequestMethod.GET,RequestMethod.POST}, produces = { JSON_UTF8 })
@ResponseBody
public Object adminListData(HttpServletRequest request,
			@ModelAttribute AdminQuery query,
			@RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize) {
		if(query==null)
			query = new AdminQuery();
	 	PageQuery<AdminQuery> pageQuery = new PageQuery<AdminQuery>();
	 	pageQuery.setPageNo(pageNo);
	 	pageQuery.setPageSize(pageSize); 
		pageQuery.setQuery(query);
		
		PageListResult<Admin> info = 		adminService.searchPageAdmin(pageQuery);
		Map mapData = new HashMap();
		if(info!=null){
			mapData.put("total", info.getPagenation().getItemCount());
			mapData.put("rows", info.getValues()); 
		}else{
			mapData.put("total", 0);
			mapData.put("rows", new ArrayList()); 
		}
		return mapData;
}

 /**
  * 详情
  * @return
  */
@RequestMapping(value= {VIEW_TODETAIL},method = RequestMethod.GET, produces = { HTML_UTF8 })
public ModelAndView adminDetail(@RequestParam(required = true, value = "adminname" ) String adminname){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminDetail");
		GenericResult<Admin> result = adminService.findByPriKey(adminname);
		if(result!=null)
			mav.addObject("admin",result.getValue());
		else
			mav.addObject("admin",new Admin());
		return mav;
}

/**
 * 跳转到添加页面
 * @return
 */
@RequestMapping(value = {VIEW_TOADD},method ={RequestMethod.GET, RequestMethod.POST}, produces = { HTML_UTF8 })
public String toAdd(HttpServletRequest request){
    return "adminAdd";
}

/**
 * 保存信息
 * @return
 */
@RequestMapping(value = {AJAX_ADD},method ={RequestMethod.GET, RequestMethod.POST}, produces = { JSON_UTF8 })
@ResponseBody
public Object adminAdd(@ModelAttribute Admin admin){
		BasicResult resultMap = new BasicResult();
		GenericResult<String> result = 	adminService.addAdmin(admin); 
		if(ResultUtil.isGenericSuccess(result)){
			resultMap.setCode(ResultCode.SUCCESS.getCode());
			resultMap.setMessage("操作成功");
		}else{
			resultMap.setCode(ResultCode.FAILED.getCode());
			resultMap.setMessage(result.getMessage());
		}
		return resultMap;
}

/**
 * 跳转到编辑页面
 * @return
 */
@RequestMapping(value= {VIEW_TOEDIT},method = RequestMethod.GET, produces = { HTML_UTF8 })
public ModelAndView toEdit(@RequestParam(required = true, value = "adminname" ) String adminname){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminEdit");
		GenericResult<Admin> result = adminService.findByPriKey(adminname);
		mav.addObject("admin",result.getValue());
		return mav;
}

/**
 * 编辑
 * @return
 */
@RequestMapping(value = {AJAX_EDIT},method ={RequestMethod.GET, RequestMethod.POST}, produces = { JSON_UTF8 })
@ResponseBody
public Object adminEdit(@ModelAttribute Admin admin){
		BasicResult resultMap = new BasicResult();
		BasicResult result = adminService.modifyAdmin(admin);
		if(ResultUtil.isSuccess(result)){
			resultMap.setCode(ResultCode.SUCCESS.getCode());
			resultMap.setMessage("操作成功");
		}else{
			resultMap.setCode(ResultCode.FAILED.getCode());
			resultMap.setMessage(result.getMessage());
		}
		return resultMap;
}


/**
 * 删除
 * @return
 */
@RequestMapping(value= {AJAX_DELETE},method = RequestMethod.GET, produces = { JSON_UTF8 })
@ResponseBody
public Object adminDelete(@RequestParam(required = true, value = "adminname" ) String adminname){
		BasicResult resultMap = new BasicResult();
		BasicResult result = adminService.deleteByPriKey(adminname);
		if(ResultUtil.isSuccess(result)){
			resultMap.setCode(ResultCode.SUCCESS.getCode());
			resultMap.setMessage("操作成功");
		}else{
			resultMap.setCode(ResultCode.FAILED.getCode());
			resultMap.setMessage(result.getMessage());
		}
		return resultMap;
}
}
