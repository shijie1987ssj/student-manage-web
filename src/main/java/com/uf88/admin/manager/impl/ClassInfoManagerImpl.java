package com.uf88.admin.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uf88.admin.manager.ClassInfoManager;
import com.uf88.admin.dao.ClassInfoDao;
import com.uf88.admin.pojo.ClassInfo;
import com.uf88.admin.pojo.ClassInfoQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;


/**
 * 描述：</b>ClassInfoManagerImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
@Component("classInfoManager")
public class ClassInfoManagerImpl implements ClassInfoManager {
	private final static Logger log= LoggerFactory.getLogger(ClassInfoManagerImpl.class);
	@Autowired
	private ClassInfoDao classInfoDao;

	@Override
	public void insertClassInfo(ClassInfo classInfo) {
		classInfoDao.insert(classInfo);
	}
	
	@Override
	public void updateClassInfo(ClassInfo classInfo) {
		classInfoDao.update(classInfo);
	}
	
	@Override
	public void deleteClassInfoByPriKey(String classname) {
		classInfoDao.deleteByPriKey(classname);
	}
	
	@Override
	public ClassInfo findClassInfoByPriKey(String classname) {
		return classInfoDao.findByPriKey(classname);
	}
	
	@Override
	public List<ClassInfo> searchClassInfoList(Query<ClassInfoQuery> query) {
		return classInfoDao.getAllList(query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<ClassInfoQuery> pageQuery) {
		return classInfoDao.getItemCount(pageQuery);
	}
	
	@Override
	public List<ClassInfo> searchPageClassInfoList(PageQuery<ClassInfoQuery> pageQuery) {
		//Integer itemCount = getItemCount(pageQuery);
		return classInfoDao.getPageList(pageQuery, 0);
	}
}
