package com.uf88.admin.aspect;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.uf88.admin.utils.Auth;
import com.uf88.admin.utils.AuthTools;
import com.uf88.uf88core.BaseDomain;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.common.exception.ResultCode;
import com.uf88.uf88core.common.exception.Uf88Exception;
import com.uf88.uf88core.util.ResultUtil;

@Aspect
@Configuration
public class AuditAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Pointcut("execution(* com.uf88.*.dao.impl.*.insert*(..))")
	private void pointCutMethodInsert() {

	}

	@Pointcut("execution(* com.uf88.*.dao.impl.*.update*(..))")
	private void pointCutMethodUpdate() {

	}

	@Pointcut("execution(* com.uf88.*.dao.impl.*.upsert*(..))")
	private void pointCutMethodUpsert() {

	}

	// 声明前置通知
	@Before("pointCutMethodInsert()")
	public void doInsertBefore(JoinPoint joinPoint) {
		for (Object obj : joinPoint.getArgs()) {
			if (obj != null && obj instanceof BaseDomain) {
				BaseDomain baseDomain = (BaseDomain) obj;
				Date date = new Date();
				baseDomain.setCreateDate(date);
				baseDomain.setCreatedDate(date);
				baseDomain.setLastModifiedDate(date);
				// 获取用户的信息
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
						.getRequest();
				Auth auth = AuthTools.getAuth(request);
				if (auth != null) {
					baseDomain.setCreatedBy(auth.getUserName());
					baseDomain.setCreatedByName(auth.getRealName());
					baseDomain.setLastModifiedBy(auth.getUserName());
					baseDomain.setLastModifiedByName(auth.getRealName());
				}
			}
		}
	}

	// 声明前置通知
	@Before("pointCutMethodUpdate()")
	public void doUpdateBefore(JoinPoint joinPoint) {
		for (Object obj : joinPoint.getArgs()) {
			if (obj != null && obj instanceof BaseDomain) {
				BaseDomain baseDomain = (BaseDomain) obj;
				Date date = new Date();
				baseDomain.setLastModifiedDate(date);
				// 获取用户的信息
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
						.getRequest();
				Auth auth = AuthTools.getAuth(request);
				if (auth != null) {
					baseDomain.setLastModifiedBy(auth.getUserName());
					baseDomain.setLastModifiedByName(auth.getRealName());
				}
			}
		}
	}

	@Before("pointCutMethodUpsert()")
	public void doUpsertBefore(JoinPoint joinPoint) {
		for (Object obj : joinPoint.getArgs()) {
			if (obj != null && obj instanceof BaseDomain) {
				BaseDomain baseDomain = (BaseDomain) obj;
				Date date = new Date();
				baseDomain.setCreateDate(date);
				baseDomain.setLastModifiedDate(date);
				// 获取用户的信息
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
						.getRequest();
				Auth auth = AuthTools.getAuth(request);
				if (auth != null) {
					baseDomain.setLastModifiedBy(auth.getUserName());
					baseDomain.setLastModifiedByName(auth.getRealName());
				}
			}
		}
	}
}
