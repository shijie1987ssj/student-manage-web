package com.uf88.admin.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uf88.admin.service.GradeService;
import com.uf88.admin.manager.GradeManager;
import com.uf88.admin.pojo.Grade;
import com.uf88.admin.pojo.GradeQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation; 


/**
 * 描述：</b>GradeServiceImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Service("gradeService")
public class GradeServiceImpl implements GradeService {
	private final static Logger log= LoggerFactory.getLogger(GradeServiceImpl.class);
	@Autowired
	private GradeManager gradeManager;
	
	@Override
	public GenericResult<String> addGrade(Grade grade) {
		GenericResult<String> result = new GenericResult<String>();
		  
			if (grade != null) {
				//TODO:generate sequence id by CacheUtils.getSeq method Or remove this block.
				String id="";//CacheUtils.getSeq(RedisKeyConstants.XXX, length);
				//grade.setId(id);
				gradeManager.insertGrade(grade);
				
				result.setValue(id);
				result.setMessage("保存成功");
				log.debug("------GradeServiceImpl.addGrade 保存成功------");
			} else {
				log.error("------GradeServiceImpl.addGrade - grade is null!");
				result.setCode("");
				result.setMessage("grade is null");
			}
		  
		return result;
	}
	
	@Override
	public BasicResult modifyGrade(Grade grade) {
		BasicResult result = new BasicResult();
		 
			if (grade != null) {
				gradeManager.updateGrade(grade);
				result.setMessage("编辑成功");
				log.debug("------GradeServiceImpl.modifyGrade 编辑成功------");
			} else {
				log.error("------GradeServiceImpl.modifyGrade - grade is null!");
				result.setCode("");
				result.setMessage("grade is null");
			}
		 
		return result;
	}
	
	@Override
	public GenericResult<Grade> findByPriKey(String gradename) {
		GenericResult<Grade> result = new GenericResult<Grade>();
		 
			result.setValue(gradeManager.findGradeByPriKey(gradename));
			result.setMessage("查询成功");
			log.debug("------GradeServiceImpl.findByPriKey 查询成功------");
		 
		return result;
	}
	
	@Override
	public BasicResult deleteByPriKey(String gradename) {
		BasicResult result = new BasicResult();
		 
			gradeManager.deleteGradeByPriKey(gradename);
			result.setMessage("删除成功");
			log.debug("------GradeServiceImpl.deleteByPriKey 删除成功------");
		 
		return result;
	}
	
	@Override
	public ListResult<Grade> searchGrade(Query<GradeQuery> query) {
		ListResult<Grade> result = new ListResult<Grade>();
		 
			result.setValues(gradeManager.searchGradeList(query));
			result.setMessage("查询成功");
			log.debug("------GradeServiceImpl.searchGrade 查询成功------");
		 
		return result;
	}
	
	@Override
	public PageListResult<Grade> searchPageGrade(
			PageQuery<GradeQuery> pageQuery) {
		PageListResult<Grade> result = new PageListResult<Grade>();
		 
			List<Grade> list = gradeManager.searchPageGradeList(pageQuery);
			Integer itemCount = gradeManager.getItemCount(pageQuery);
			Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
			result.setPagenation(pagenation);
			result.setValues(list);
			
			result.setMessage("查询成功");
			log.debug("------GradeServiceImpl.searchPageGrade 查询成功------");
		 
		return result;
	}
}
