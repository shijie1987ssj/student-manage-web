package com.uf88.admin.utils;

import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.alibaba.fastjson.JSONObject;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.common.exception.ResultCode;
import com.uf88.uf88core.common.exception.Uf88Exception;
import com.uf88.uf88core.util.SpringContextUtil;

public class Uf88SimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        
        logger.error(ex.getMessage(),ex);
        boolean blnJSON = false;
        if ((handler instanceof HandlerMethod)) {
            Method method = ((HandlerMethod) handler).getMethod();
            ResponseBody annotation = (ResponseBody) method.getAnnotation(ResponseBody.class);
            if (annotation != null) {
                blnJSON = true;
            }
        }
        String uuid = UUID.randomUUID().toString();
        if(blnJSON){
        	if ((handler instanceof HandlerMethod)) {
        		Method method = ((HandlerMethod) handler).getMethod();
    			Token annotation = (Token) method.getAnnotation(Token.class);
    			if (annotation != null) {
    				boolean needRemoveSession = annotation.remove();
    				if (needRemoveSession) {
    					HttpSession session = request.getSession(true);
    					if (session != null)
    						session.setAttribute("formToken", uuid);
    				}
    			}
        	}
        }
        if (blnJSON) {
            GenericResult<String> result = new GenericResult<String>();
            result.setFormToken(uuid);
            result.setCode(ResultCode.FAILED.getCode());
            result.setDesc("未知异常");
            result.setMessage("未知异常");
            
            if (ex instanceof BindException)
            {
                BindException  be=(BindException)ex;
                List<ObjectError> list= be.getAllErrors();
                StringBuffer sb=new StringBuffer();
                for(ObjectError err:list)
                {
                   String errinfo=err.getDefaultMessage();
                   try
                   {
                       errinfo=  SpringContextUtil.getMessage(err.getDefaultMessage());
                   }
                   catch(Exception e)
                   {
                       
                   }
                   sb.append(errinfo).append(";");
                }
                result.setMessage(sb.toString());
            }
            
            if (ex instanceof Uf88Exception)
            {
                Uf88Exception uf88Exception=(Uf88Exception) ex;
                result.setCode(uf88Exception.getCode());
                
                result.setDesc(uf88Exception.getMessage());
                result.setMessage(uf88Exception.getMessage());
            }
            if (ex instanceof MaxUploadSizeExceededException)
            {
                result.setCode(ResultCode.FAILED.getCode());
                String errinfo="";
                try
                {
                    errinfo= SpringContextUtil.getMessage(WebErrorCode.FILE_TO_BIG);
                }
                catch(Exception e)
                {
                    
                }
                result.setMessage(errinfo);
            }
            
            ModelAndView mv = new ModelAndView();
            // 设置状态码
            response.setStatus(HttpStatus.OK.value());
            // 设置ContentType
            response.setContentType(MediaType.TEXT_HTML_VALUE);
            // 避免乱码
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Cache-Control", "no-cache, must-revalidate");
          //  ObjectMapper mapper = new ObjectMapper();
            try {
                response.getWriter().write(JSONObject.toJSONString(result));
            } catch (Exception e) {
                logger.error(e.getMessage(),e);
            }
             return mv;
        } else {
            Uf88Exception uf88Ex=new Uf88Exception(WebErrorCode.FILE_TO_BIG,"未知异常");
            
            if (ex instanceof MaxUploadSizeExceededException)
            {

                String errinfo="";
                try
                {
                    errinfo= SpringContextUtil.getMessage(WebErrorCode.FILE_TO_BIG);
                }
                catch(Exception e)
                {
                    logger.error(e.getMessage(),e);
                }
                uf88Ex=new Uf88Exception(WebErrorCode.FILE_TO_BIG,errinfo);
                
            }
            return super.doResolveException(request, response, handler, uf88Ex);
        }

    }
}
