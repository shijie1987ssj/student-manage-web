package com.uf88.admin.utils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import com.uf88.tools.DesUtils;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.common.exception.ResultCode;
import com.uf88.uf88core.util.StrUtil;

public class UctClientFilter implements Filter {
	private Logger logger = Logger.getLogger(getClass().getName());

	String whiteUrl = Common.getValueByProperty("white_url");

	public void init(FilterConfig arg0) throws ServletException {

	}

	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chain)
			throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) srequest;

		HttpServletResponse response = (HttpServletResponse) sresponse;
		response.setCharacterEncoding("UTF-8");
		response.setDateHeader("expires", 0L);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("pragma", "no-cache");

		String path = request.getServletPath();

		if (StrUtil.isNotNull(this.whiteUrl)) {
			String[] wus = this.whiteUrl.split(",");
			for (int i = 0; i < wus.length; i++) {
				String wurl = wus[i];
				if ((!StrUtil.isNotNull(wurl)) || (!path.startsWith(wurl)))
					continue;
				chain.doFilter(request, response);
				return;
			}

		}
		Auth auth = AuthTools.getAuth(request);
		if (auth == null) {
			logoutResponse(request, response, ResultCode.LOG_TIMEOUT.getCode(), ResultCode.LOG_TIMEOUT.getMessage());
			return;
		}

		chain.doFilter(request, response);
	}

	private void setReferee(HttpServletRequest request, HttpServletResponse response) {
		// 获取referee推荐信息，先PARAMETER再SESSION最后COOKIE
		String referee = request.getParameter("referee");
		if (StrUtil.isNull(referee)) {
			referee = (String) request.getSession().getAttribute("referee");
			if (StrUtil.isNull(referee)) {
				Cookie cookies[] = request.getCookies();
				for (int i = 0; cookies != null && i < cookies.length; i++) {
					Cookie c = cookies[i];
					if ("referee".equals(c.getName())) {
						referee = c.getValue();
						break;
					}
				}
			}
		}
		if (StrUtil.isNotNull(referee)) {
			// 强制写入会话及COOKIE
			request.getSession().setAttribute("referee", referee);
			Cookie refereeCookie = new Cookie("referee", referee);
			refereeCookie.setMaxAge(100000);
			refereeCookie.setPath("/");
			response.addCookie(refereeCookie);
		} else {
			referee = "";
		}
	}

	private void logoutResponse(HttpServletRequest request, HttpServletResponse response, String logoutCode,
			String logoutMsg) throws IOException {
		String ajax = request.getHeader("X-Requested-With");
		if (ajax != null && ajax.equals("XMLHttpRequest")) {
			// Map<String,String> mapData = new HashMap<String,String>();
			BasicResult br = new BasicResult();
			br.setCode(ResultCode.LOG_TIMEOUT.getCode());
			br.setMessage(ResultCode.LOG_TIMEOUT.getMessage());
			// mapData.put("flag", "F22");
			// mapData.put("msg", "登录超时！");

			// mapData.put("code", "F22");
			// mapData.put("message", "登录超时！");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(com.alibaba.fastjson.JSON.toJSONString(br));
		} else {
			response.sendRedirect("/student-manage-web/login.jsp");
		}
	}

	private String getAppUrl(String path, HttpServletRequest request) {
		String path1 = request.getContextPath();
		String qString = "";
		qString = request.getQueryString();
		if (StrUtil.isNotEmpty(qString)) {
			qString = "?" + qString;
		}
		qString = StrUtil.doNull(qString, "");
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path1
				+ path;
		String appUrl = "?appUrl=" + basePath;
		request.getSession().setAttribute("lastUrl", basePath + qString);
		return appUrl;
	}

	public void destroy() {
	}

}
