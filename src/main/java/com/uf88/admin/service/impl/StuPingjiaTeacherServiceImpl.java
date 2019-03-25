package com.uf88.admin.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uf88.admin.service.StuPingjiaTeacherService;
import com.uf88.admin.manager.StuPingjiaTeacherManager;
import com.uf88.admin.pojo.StuPingjiaTeacher;
import com.uf88.admin.pojo.StuPingjiaTeacherQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation; 


/**
 * 描述：</b>StuPingjiaTeacherServiceImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Service("stuPingjiaTeacherService")
public class StuPingjiaTeacherServiceImpl implements StuPingjiaTeacherService {
	private final static Logger log= LoggerFactory.getLogger(StuPingjiaTeacherServiceImpl.class);
	@Autowired
	private StuPingjiaTeacherManager stuPingjiaTeacherManager;
	
	@Override
	public GenericResult<String> addStuPingjiaTeacher(StuPingjiaTeacher stuPingjiaTeacher) {
		GenericResult<String> result = new GenericResult<String>();
		  
			if (stuPingjiaTeacher != null) {
				//TODO:generate sequence id by CacheUtils.getSeq method Or remove this block.
				String id="";//CacheUtils.getSeq(RedisKeyConstants.XXX, length);
				//stuPingjiaTeacher.setId(id);
				stuPingjiaTeacherManager.insertStuPingjiaTeacher(stuPingjiaTeacher);
				
				result.setValue(id);
				result.setMessage("保存成功");
				log.debug("------StuPingjiaTeacherServiceImpl.addStuPingjiaTeacher 保存成功------");
			} else {
				log.error("------StuPingjiaTeacherServiceImpl.addStuPingjiaTeacher - stuPingjiaTeacher is null!");
				result.setCode("");
				result.setMessage("stuPingjiaTeacher is null");
			}
		  
		return result;
	}
	
	@Override
	public BasicResult modifyStuPingjiaTeacher(StuPingjiaTeacher stuPingjiaTeacher) {
		BasicResult result = new BasicResult();
		 
			if (stuPingjiaTeacher != null) {
				stuPingjiaTeacherManager.updateStuPingjiaTeacher(stuPingjiaTeacher);
				result.setMessage("编辑成功");
				log.debug("------StuPingjiaTeacherServiceImpl.modifyStuPingjiaTeacher 编辑成功------");
			} else {
				log.error("------StuPingjiaTeacherServiceImpl.modifyStuPingjiaTeacher - stuPingjiaTeacher is null!");
				result.setCode("");
				result.setMessage("stuPingjiaTeacher is null");
			}
		 
		return result;
	}
	
	@Override
	public GenericResult<StuPingjiaTeacher> findByPriKey(Integer id) {
		GenericResult<StuPingjiaTeacher> result = new GenericResult<StuPingjiaTeacher>();
		 
			result.setValue(stuPingjiaTeacherManager.findStuPingjiaTeacherByPriKey(id));
			result.setMessage("查询成功");
			log.debug("------StuPingjiaTeacherServiceImpl.findByPriKey 查询成功------");
		 
		return result;
	}
	
	@Override
	public BasicResult deleteByPriKey(Integer id) {
		BasicResult result = new BasicResult();
		 
			stuPingjiaTeacherManager.deleteStuPingjiaTeacherByPriKey(id);
			result.setMessage("删除成功");
			log.debug("------StuPingjiaTeacherServiceImpl.deleteByPriKey 删除成功------");
		 
		return result;
	}
	
	@Override
	public ListResult<StuPingjiaTeacher> searchStuPingjiaTeacher(Query<StuPingjiaTeacherQuery> query) {
		ListResult<StuPingjiaTeacher> result = new ListResult<StuPingjiaTeacher>();
		 
			result.setValues(stuPingjiaTeacherManager.searchStuPingjiaTeacherList(query));
			result.setMessage("查询成功");
			log.debug("------StuPingjiaTeacherServiceImpl.searchStuPingjiaTeacher 查询成功------");
		 
		return result;
	}
	
	@Override
	public PageListResult<StuPingjiaTeacher> searchPageStuPingjiaTeacher(
			PageQuery<StuPingjiaTeacherQuery> pageQuery) {
		PageListResult<StuPingjiaTeacher> result = new PageListResult<StuPingjiaTeacher>();
		 
			List<StuPingjiaTeacher> list = stuPingjiaTeacherManager.searchPageStuPingjiaTeacherList(pageQuery);
			Integer itemCount = stuPingjiaTeacherManager.getItemCount(pageQuery);
			Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
			result.setPagenation(pagenation);
			result.setValues(list);
			
			result.setMessage("查询成功");
			log.debug("------StuPingjiaTeacherServiceImpl.searchPageStuPingjiaTeacher 查询成功------");
		 
		return result;
	}
}
