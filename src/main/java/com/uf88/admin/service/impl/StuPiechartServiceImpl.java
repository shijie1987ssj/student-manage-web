package com.uf88.admin.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uf88.admin.service.StuPiechartService;
import com.uf88.admin.manager.StuPiechartManager;
import com.uf88.admin.pojo.StuPiechart;
import com.uf88.admin.pojo.StuPiechartQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation; 


/**
 * 描述：</b>StuPiechartServiceImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
@Service("stuPiechartService")
public class StuPiechartServiceImpl implements StuPiechartService {
	private final static Logger log= LoggerFactory.getLogger(StuPiechartServiceImpl.class);
	@Autowired
	private StuPiechartManager stuPiechartManager;
	
	@Override
	public GenericResult<String> addStuPiechart(StuPiechart stuPiechart) {
		GenericResult<String> result = new GenericResult<String>();
		  
			if (stuPiechart != null) {
				//TODO:generate sequence id by CacheUtils.getSeq method Or remove this block.
				String id="";//CacheUtils.getSeq(RedisKeyConstants.XXX, length);
				//stuPiechart.setId(id);
				stuPiechartManager.insertStuPiechart(stuPiechart);
				
				result.setValue(id);
				result.setMessage("保存成功");
				log.debug("------StuPiechartServiceImpl.addStuPiechart 保存成功------");
			} else {
				log.error("------StuPiechartServiceImpl.addStuPiechart - stuPiechart is null!");
				result.setCode("");
				result.setMessage("stuPiechart is null");
			}
		  
		return result;
	}
	
	@Override
	public BasicResult modifyStuPiechart(StuPiechart stuPiechart) {
		BasicResult result = new BasicResult();
		 
			if (stuPiechart != null) {
				stuPiechartManager.updateStuPiechart(stuPiechart);
				result.setMessage("编辑成功");
				log.debug("------StuPiechartServiceImpl.modifyStuPiechart 编辑成功------");
			} else {
				log.error("------StuPiechartServiceImpl.modifyStuPiechart - stuPiechart is null!");
				result.setCode("");
				result.setMessage("stuPiechart is null");
			}
		 
		return result;
	}
	
	@Override
	public GenericResult<StuPiechart> findByPriKey(Integer id) {
		GenericResult<StuPiechart> result = new GenericResult<StuPiechart>();
		 
			result.setValue(stuPiechartManager.findStuPiechartByPriKey(id));
			result.setMessage("查询成功");
			log.debug("------StuPiechartServiceImpl.findByPriKey 查询成功------");
		 
		return result;
	}
	
	@Override
	public BasicResult deleteByPriKey(Integer id) {
		BasicResult result = new BasicResult();
		 
			stuPiechartManager.deleteStuPiechartByPriKey(id);
			result.setMessage("删除成功");
			log.debug("------StuPiechartServiceImpl.deleteByPriKey 删除成功------");
		 
		return result;
	}
	
	@Override
	public ListResult<StuPiechart> searchStuPiechart(Query<StuPiechartQuery> query) {
		ListResult<StuPiechart> result = new ListResult<StuPiechart>();
		 
			result.setValues(stuPiechartManager.searchStuPiechartList(query));
			result.setMessage("查询成功");
			log.debug("------StuPiechartServiceImpl.searchStuPiechart 查询成功------");
		 
		return result;
	}
	
	@Override
	public PageListResult<StuPiechart> searchPageStuPiechart(
			PageQuery<StuPiechartQuery> pageQuery) {
		PageListResult<StuPiechart> result = new PageListResult<StuPiechart>();
		 
			List<StuPiechart> list = stuPiechartManager.searchPageStuPiechartList(pageQuery);
			Integer itemCount = stuPiechartManager.getItemCount(pageQuery);
			Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
			result.setPagenation(pagenation);
			result.setValues(list);
			
			result.setMessage("查询成功");
			log.debug("------StuPiechartServiceImpl.searchPageStuPiechart 查询成功------");
		 
		return result;
	}
}
