package com.uf88.admin.dao.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.uf88.admin.dao.ClassInfoDao;
import com.uf88.admin.pojo.ClassInfo;
import com.uf88.admin.pojo.ClassInfoQuery;
import com.uf88.uf88core.common.dao.BaseDao;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.PageQueryWrapper;
import com.uf88.uf88core.Query;

 /**
 * 描述：</b>ClassInfoDaoImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
@Repository("classInfoDao")
public class ClassInfoDaoImpl extends BaseDao implements ClassInfoDao {
	private final static Logger log= LoggerFactory.getLogger(ClassInfoDaoImpl.class);
	
	@Override
	public void insert(ClassInfo classInfo){
		Object o =insert("CLASS_INFO.insert", classInfo);
	 
	}
	
	@Override
	public void update(ClassInfo classInfo){
		update("CLASS_INFO.update", classInfo); 
	}
	
	@Override
	public void updateAndCheck(ClassInfo classInfo){
		updateAndCheck("CLASS_INFO.update", classInfo); 
	}
	
	@Override
	public void deleteByPriKey(String classname){
		ClassInfo classInfo = new ClassInfo();
		classInfo.setClassname(classname);
		delete("CLASS_INFO.deleteByPriKey", classInfo); 
	}
	
	@Override
	public void deleteByPriKeyAndCheck(String classname){
		ClassInfo classInfo = new ClassInfo();
		classInfo.setClassname(classname);
		deleteAndCheck("CLASS_INFO.deleteByPriKey", classInfo); 
	}
	
	@Override
	public ClassInfo findByPriKey(String classname){
		ClassInfo classInfo = new ClassInfo();
		classInfo.setClassname(classname);
		classInfo = (ClassInfo)this.queryForObject("CLASS_INFO.findByPriKey", classInfo);
		return classInfo;
	}
	
	@Override
	public List<ClassInfo> getAllList(Query<ClassInfoQuery> query) {
		return this.queryForList("CLASS_INFO.getAllList",query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<ClassInfoQuery> pageQuery) {
		return (Integer) queryForObject("CLASS_INFO.getItemCount",pageQuery);
	}
	
	@Override
	public List<ClassInfo> getPageList(PageQuery<ClassInfoQuery> pageQuery, Integer itemCount) {
		PageQueryWrapper<ClassInfoQuery> wrapper = new PageQueryWrapper<ClassInfoQuery>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery(), pageQuery.getSort());
		return this.queryForList("CLASS_INFO.getPagenationList",wrapper);
	}
}
