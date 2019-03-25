package com.uf88.uct.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.uf88.admin.utils.AuthTools;
import com.uf88.uf88core.util.PropertiesUtils;
import com.uf88.uf88core.util.StrUtil;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = -2460596209633891007L;
	private Logger logger = Logger.getLogger(getClass().getName());

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			AuthTools.removeLoginUser(request);
			AuthTools.removeAuth(request);
			JSONObject json = new JSONObject();
			json.put("flag", "T");
			json.put("msg", "已退出");

			outputJson(json.toString(), response);
		} catch (Exception ex) {
			ex.printStackTrace();
			this.logger.error(ex.getMessage());
		}
	}

	public void init() throws ServletException {
	}

	private void outputJson(String json, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}
}
