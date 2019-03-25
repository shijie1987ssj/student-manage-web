package com.uf88.admin.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uf88.admin.manager.SubjectsManager;
import com.uf88.admin.dao.SubjectsDao;
import com.uf88.admin.pojo.Subjects;
import com.uf88.admin.pojo.SubjectsQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;


/**
 * 描述：</b>SubjectsManagerImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Component("subjectsManager")
public class SubjectsManagerImpl implements SubjectsManager {
	private final static Logger log= LoggerFactory.getLogger(SubjectsManagerImpl.class);
	@Autowired
	private SubjectsDao subjectsDao;

	@Override
	public void insertSubjects(Subjects subjects) {
		subjectsDao.insert(subjects);
	}
	
	@Override
	public void updateSubjects(Subjects subjects) {
		subjectsDao.update(subjects);
	}
	
	@Override
	public void deleteSubjectsByPriKey(String subjectname) {
		subjectsDao.deleteByPriKey(subjectname);
	}
	
	@Override
	public Subjects findSubjectsByPriKey(String subjectname) {
		return subjectsDao.findByPriKey(subjectname);
	}
	
	@Override
	public List<Subjects> searchSubjectsList(Query<SubjectsQuery> query) {
		return subjectsDao.getAllList(query);
	}
	
	@Override
	public Integer getItemCount(PageQuery<SubjectsQuery> pageQuery) {
		return subjectsDao.getItemCount(pageQuery);
	}
	
	@Override
	public List<Subjects> searchPageSubjectsList(PageQuery<SubjectsQuery> pageQuery) {
		//Integer itemCount = getItemCount(pageQuery);
		return subjectsDao.getPageList(pageQuery, 0);
	}
}
