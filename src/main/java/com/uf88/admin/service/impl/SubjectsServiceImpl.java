package com.uf88.admin.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uf88.admin.service.SubjectsService;
import com.uf88.admin.manager.SubjectsManager;
import com.uf88.admin.pojo.Subjects;
import com.uf88.admin.pojo.SubjectsQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation; 


/**
 * 描述：</b>SubjectsServiceImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Service("subjectsService")
public class SubjectsServiceImpl implements SubjectsService {
	private final static Logger log= LoggerFactory.getLogger(SubjectsServiceImpl.class);
	@Autowired
	private SubjectsManager subjectsManager;
	
	@Override
	public GenericResult<String> addSubjects(Subjects subjects) {
		GenericResult<String> result = new GenericResult<String>();
		  
			if (subjects != null) {
				//TODO:generate sequence id by CacheUtils.getSeq method Or remove this block.
				String id="";//CacheUtils.getSeq(RedisKeyConstants.XXX, length);
				//subjects.setId(id);
				subjectsManager.insertSubjects(subjects);
				
				result.setValue(id);
				result.setMessage("保存成功");
				log.debug("------SubjectsServiceImpl.addSubjects 保存成功------");
			} else {
				log.error("------SubjectsServiceImpl.addSubjects - subjects is null!");
				result.setCode("");
				result.setMessage("subjects is null");
			}
		  
		return result;
	}
	
	@Override
	public BasicResult modifySubjects(Subjects subjects) {
		BasicResult result = new BasicResult();
		 
			if (subjects != null) {
				subjectsManager.updateSubjects(subjects);
				result.setMessage("编辑成功");
				log.debug("------SubjectsServiceImpl.modifySubjects 编辑成功------");
			} else {
				log.error("------SubjectsServiceImpl.modifySubjects - subjects is null!");
				result.setCode("");
				result.setMessage("subjects is null");
			}
		 
		return result;
	}
	
	@Override
	public GenericResult<Subjects> findByPriKey(String subjectname) {
		GenericResult<Subjects> result = new GenericResult<Subjects>();
		 
			result.setValue(subjectsManager.findSubjectsByPriKey(subjectname));
			result.setMessage("查询成功");
			log.debug("------SubjectsServiceImpl.findByPriKey 查询成功------");
		 
		return result;
	}
	
	@Override
	public BasicResult deleteByPriKey(String subjectname) {
		BasicResult result = new BasicResult();
		 
			subjectsManager.deleteSubjectsByPriKey(subjectname);
			result.setMessage("删除成功");
			log.debug("------SubjectsServiceImpl.deleteByPriKey 删除成功------");
		 
		return result;
	}
	
	@Override
	public ListResult<Subjects> searchSubjects(Query<SubjectsQuery> query) {
		ListResult<Subjects> result = new ListResult<Subjects>();
		 
			result.setValues(subjectsManager.searchSubjectsList(query));
			result.setMessage("查询成功");
			log.debug("------SubjectsServiceImpl.searchSubjects 查询成功------");
		 
		return result;
	}
	
	@Override
	public PageListResult<Subjects> searchPageSubjects(
			PageQuery<SubjectsQuery> pageQuery) {
		PageListResult<Subjects> result = new PageListResult<Subjects>();
		 
			List<Subjects> list = subjectsManager.searchPageSubjectsList(pageQuery);
			Integer itemCount = subjectsManager.getItemCount(pageQuery);
			Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
			result.setPagenation(pagenation);
			result.setValues(list);
			
			result.setMessage("查询成功");
			log.debug("------SubjectsServiceImpl.searchPageSubjects 查询成功------");
		 
		return result;
	}
}
