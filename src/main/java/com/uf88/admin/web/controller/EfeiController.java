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
import com.uf88.admin.pojo.Efei;
import com.uf88.admin.pojo.EfeiQuery;
import com.uf88.admin.service.EfeiService;


/**
 * 描述：</b>EfeiController<br>
 * @author：<a href="mailto:*@jd.com">系统生成</a>
 * @since：2018年09月19日 14时04分36秒 星期三 
 * @version:1.0
 */
@Controller
@RequestMapping("/efei")
public class EfeiController {
  @Autowired
  private EfeiService efeiService;
 private Logger logger = LoggerFactory.getLogger(getClass());
 
 	private static final String HTML_UTF8 = "text/html;charset=UTF-8";
	private static final String JSON_UTF8 = "application/json;charset=UTF-8";
	
	private static final String VIEW_INDEX = "efeiIndex";
	private static final String AJAX_LISTDATA = "efeiListData";
	private static final String VIEW_TOADD = "toAdd";
	private static final String AJAX_ADD = "/efeiAdd";
	private static final String VIEW_TODETAIL = "/efeiDetail";
	private static final String VIEW_TOEDIT = "toEdit";
	private static final String AJAX_EDIT = "/efeiEdit";
	private static final String AJAX_DELETE = "efeiDelete";
 /**
 * 跳转到列表页面
 * @return
 */
@RequestMapping(value = {VIEW_INDEX}, produces = { HTML_UTF8 },method ={RequestMethod.GET, RequestMethod.POST})
public ModelAndView efeiIndex(HttpServletRequest request){
    ModelAndView mv = new ModelAndView("efeiIndex");
		return mv; 
}
 /**
  * 列表页面
  * @return
  */
@RequestMapping(value= {AJAX_LISTDATA},method = {RequestMethod.GET,RequestMethod.POST}, produces = { JSON_UTF8 })
@ResponseBody
public Object efeiListData(HttpServletRequest request,
			@ModelAttribute EfeiQuery query,
			@RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize) {
		if(query==null)
			query = new EfeiQuery();
	 	PageQuery<EfeiQuery> pageQuery = new PageQuery<EfeiQuery>();
	 	pageQuery.setPageNo(pageNo);
	 	pageQuery.setPageSize(pageSize); 
		pageQuery.setQuery(query);
		
		PageListResult<Efei> info = 		efeiService.searchPageEfei(pageQuery);
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
public ModelAndView efeiDetail(@RequestParam(required = true, value = "id" ) Integer id){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("efeiDetail");
		GenericResult<Efei> result = efeiService.findByPriKey(id);
		if(result!=null)
			mav.addObject("efei",result.getValue());
		else
			mav.addObject("efei",new Efei());
		return mav;
}

/**
 * 跳转到添加页面
 * @return
 */
@RequestMapping(value = {VIEW_TOADD},method ={RequestMethod.GET, RequestMethod.POST}, produces = { HTML_UTF8 })
public String toAdd(HttpServletRequest request){
    return "efeiAdd";
}

/**
 * 保存信息
 * @return
 */
@RequestMapping(value = {AJAX_ADD},method ={RequestMethod.GET, RequestMethod.POST}, produces = { JSON_UTF8 })
@ResponseBody
public Object efeiAdd(@ModelAttribute Efei efei){
		BasicResult resultMap = new BasicResult();
		GenericResult<String> result = 	efeiService.addEfei(efei); 
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
public ModelAndView toEdit(@RequestParam(required = true, value = "id" ) Integer id){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("efeiEdit");
		GenericResult<Efei> result = efeiService.findByPriKey(id);
		mav.addObject("efei",result.getValue());
		return mav;
}

/**
 * 编辑
 * @return
 */
@RequestMapping(value = {AJAX_EDIT},method ={RequestMethod.GET, RequestMethod.POST}, produces = { JSON_UTF8 })
@ResponseBody
public Object efeiEdit(@ModelAttribute Efei efei){
		BasicResult resultMap = new BasicResult();
		BasicResult result = efeiService.modifyEfei(efei);
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
public Object efeiDelete(@RequestParam(required = true, value = "id" ) Integer id){
		BasicResult resultMap = new BasicResult();
		BasicResult result = efeiService.deleteByPriKey(id);
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
