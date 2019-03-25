package com.uf88.uct.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.uf88.admin.pojo.Admin;
import com.uf88.admin.service.AdminService;
import com.uf88.admin.service.LeaderService;
import com.uf88.admin.service.StudentService;
import com.uf88.admin.service.TeacherService;
import com.uf88.admin.utils.Auth;
import com.uf88.admin.utils.AuthTools;
import com.uf88.admin.web.AdminConst.AdminConst.LoginUserTypeEnum;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.util.ResultUtil;
import com.uf88.uf88core.util.StrUtil;
import com.uf88.uf88core.util.TcpIpUtil;

/**
 * P2P登陆系统
 * 
 * @author wenli.su
 *
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -2460596209633891006L;
	private static Logger logger = Logger.getLogger(LoginServlet.class);

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String flag = "F";
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String uflag = request.getParameter("uflag");
			String rand = request.getParameter("rand");
			logger.info("LoginServlet.doPost===用户登录：用户编号：username");
			JSONObject json = new JSONObject();
			if ((username == null) || ("".equals(username))) {
				json.put("flag", flag);
				json.put("msg", "用户名不能为空");
				outputJson(json.toString(), response);
				return;
			}
			if ((password == null) || ("".equals(password))) {
				json.put("flag", flag);
				json.put("msg", "密码不能为空");
				outputJson(json.toString(), response);
				return;
			}

			// 获取ServletContext 再获取 WebApplicationContextUtils
			ServletContext servletContext = this.getServletContext();
			WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);

			Map map = new HashMap();
			map.put("user.userEname", username);
			map.put("user.userPass", password);
			// 前台验证过了再进行UC验证
			BasicResult br = null;
			int uflagNum = Integer.parseInt(uflag);

			if (LoginUserTypeEnum.stu.getCode() == uflagNum) {
				StudentService studentService = (StudentService) context.getBean("studentService");

				br = studentService.checkLogin(username, password);
			} else if (LoginUserTypeEnum.teach.getCode() == uflagNum) {
				TeacherService teacherService = (TeacherService) context.getBean("teacherService");
				br = teacherService.checkLogin(username, password);
			} else if (LoginUserTypeEnum.leader.getCode() == uflagNum) {
				LeaderService leaderService = (LeaderService) context.getBean("leaderService");
				br = leaderService.checkLogin(username, password);
			} else {
				AdminService adminService = (AdminService) context.getBean("adminService");
				br = adminService.checkLogin(username, password);
			}
			if (ResultUtil.isSuccess(br)) {
				json.put("flag", "T");
				json.put("msg", "登陆成功");
				Auth auth = new Auth();
				auth.setUserName(username);
				auth.setUsertype(LoginUserTypeEnum.getName(uflagNum));
				AuthTools.saveAuthToSession(request, auth);
			} else {
				json.put("flag", "F");
				json.put("msg", br.getMessage());
			}
			outputJson(json.toString(), response);
			return;
		} catch (Exception ex) {
			ex.printStackTrace();
			this.logger.error(ex.getMessage());
		}
	}

	public static String getUserIp(HttpServletRequest request) {
		String ip = "";
		try {
			ip = request.getHeader("x-forwarded-for");
			if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
				ip = request.getRemoteAddr();
			}
			if ((ip != null) && (ip.length() > 32))
				ip = ip.substring(0, 32);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return ip;
	}

	private void outputJson(String json, HttpServletResponse response) throws IOException {
		logger.info("LoginServlet.outputJson===输出JSON：" + json);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

	public void init() throws ServletException {
	}
}
