package com.uf88.admin.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uf88.admin.service.ClassInfoService;
import com.uf88.admin.manager.ClassInfoManager;
import com.uf88.admin.pojo.ClassInfo;
import com.uf88.admin.pojo.ClassInfoQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation; 


/**
 * 描述：</b>ClassInfoServiceImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
@Service("classInfoService")
public class ClassInfoServiceImpl implements ClassInfoService {
	private final static Logger log= LoggerFactory.getLogger(ClassInfoServiceImpl.class);
	@Autowired
	private ClassInfoManager classInfoManager;
	
	@Override
	public GenericResult<String> addClassInfo(ClassInfo classInfo) {
		GenericResult<String> result = new GenericResult<String>();
		  
			if (classInfo != null) {
				//TODO:generate sequence id by CacheUtils.getSeq method Or remove this block.
				String id="";//CacheUtils.getSeq(RedisKeyConstants.XXX, length);
				//classInfo.setId(id);
				classInfoManager.insertClassInfo(classInfo);
				
				result.setValue(id);
				result.setMessage("保存成功");
				log.debug("------ClassInfoServiceImpl.addClassInfo 保存成功------");
			} else {
				log.error("------ClassInfoServiceImpl.addClassInfo - classInfo is null!");
				result.setCode("");
				result.setMessage("classInfo is null");
			}
		  
		return result;
	}
	
	@Override
	public BasicResult modifyClassInfo(ClassInfo classInfo) {
		BasicResult result = new BasicResult();
		 
			if (classInfo != null) {
				classInfoManager.updateClassInfo(classInfo);
				result.setMessage("编辑成功");
				log.debug("------ClassInfoServiceImpl.modifyClassInfo 编辑成功------");
			} else {
				log.error("------ClassInfoServiceImpl.modifyClassInfo - classInfo is null!");
				result.setCode("");
				result.setMessage("classInfo is null");
			}
		 
		return result;
	}
	
	@Override
	public GenericResult<ClassInfo> findByPriKey(String classname) {
		GenericResult<ClassInfo> result = new GenericResult<ClassInfo>();
		 
			result.setValue(classInfoManager.findClassInfoByPriKey(classname));
			result.setMessage("查询成功");
			log.debug("------ClassInfoServiceImpl.findByPriKey 查询成功------");
		 
		return result;
	}
	
	@Override
	public BasicResult deleteByPriKey(String classname) {
		BasicResult result = new BasicResult();
		 
			classInfoManager.deleteClassInfoByPriKey(classname);
			result.setMessage("删除成功");
			log.debug("------ClassInfoServiceImpl.deleteByPriKey 删除成功------");
		 
		return result;
	}
	
	@Override
	public ListResult<ClassInfo> searchClassInfo(Query<ClassInfoQuery> query) {
		ListResult<ClassInfo> result = new ListResult<ClassInfo>();
		 
			result.setValues(classInfoManager.searchClassInfoList(query));
			result.setMessage("查询成功");
			log.debug("------ClassInfoServiceImpl.searchClassInfo 查询成功------");
		 
		return result;
	}
	
	@Override
	public PageListResult<ClassInfo> searchPageClassInfo(
			PageQuery<ClassInfoQuery> pageQuery) {
		PageListResult<ClassInfo> result = new PageListResult<ClassInfo>();
		 
			List<ClassInfo> list = classInfoManager.searchPageClassInfoList(pageQuery);
			Integer itemCount = classInfoManager.getItemCount(pageQuery);
			Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
			result.setPagenation(pagenation);
			result.setValues(list);
			
			result.setMessage("查询成功");
			log.debug("------ClassInfoServiceImpl.searchPageClassInfo 查询成功------");
		 
		return result;
	}
}
