package com.uf88.admin.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.uf88.admin.utils.Auth;
import com.uf88.admin.utils.AuthTools;
import com.uf88.admin.web.AdminConst.AdminConst;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.common.exception.ResultCode;
import com.uf88.uf88core.util.PropertiesUtils;
import com.uf88.uf88core.util.StrUtil;

@Controller
@RequestMapping({ "/" })
public class IndexController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private static final String HTML_UTF8 = "text/html;charset=UTF-8";
	private static final String JSON_UTF8 = "application/json;charset=UTF-8";
	private static final String TO_LOGOUT = "/toLogout";
	private static final String INDEX = "/index";
	private static final String GETUSERINFO = "/getUserInfo";
	private static final String TO_Check_UserInfo = "/checkUserInfo";

	@RequestMapping(value = { TO_LOGOUT }, produces = { HTML_UTF8 })
	public ModelAndView toLogout(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "msgtxt", required = false) String msgtxt) {
		ModelAndView view = new ModelAndView("error/toLogin");

		// P2P登出
		AuthTools.removeLoginUser(request);

		return view;
	}

	@RequestMapping(value = { INDEX }, produces = { HTML_UTF8 })
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView view = null;
		Auth auth = AuthTools.getAuth(request);

		String user_role = "";
		String bank_code = "";
		String bank_full_name = "";
		String bank_short_name = "";

		if (auth != null) {
			// member = (Member) this.memberManager.findMemberByPriKey(auth.getId());
			// 取用户角色
			/*
			 * if (member.get.getSpare2() != null) { user_role = member.getSpare2(); }
			 */
			user_role = "ptadmin";
			String go = "admin/main";
			/*
			 * if (auth.getType().equals("admin")) { if
			 * ("regulators".equals(auth.getSpare2())) { go = "admin/main_regulator";
			 * auth.setStyleCode("regulator"); } else { go = "admin/main"; } } else { view =
			 * new ModelAndView("redirect:/toLogout.action"); view.addObject("msgtxt",
			 * "请到普通用户平台登录！"); return view; }
			 */
			view = new ModelAndView(go);
 
		} else {
			view = new ModelAndView("redirect:/toLogout.do");
			view.addObject("msgtxt", "用户不存在！");
		}

		view.addObject("user_role", user_role);
		view.addObject("bank_code", bank_code);
		view.addObject("bank_full_name", bank_full_name);
		view.addObject("bank_short_name", bank_short_name);
		return view;
	}

}
