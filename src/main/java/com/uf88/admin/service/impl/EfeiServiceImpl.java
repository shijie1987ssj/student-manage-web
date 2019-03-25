package com.uf88.admin.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uf88.admin.service.EfeiService;
import com.uf88.admin.manager.EfeiManager;
import com.uf88.admin.pojo.Efei;
import com.uf88.admin.pojo.EfeiQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation; 


/**
 * 描述：</b>EfeiServiceImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
@Service("efeiService")
public class EfeiServiceImpl implements EfeiService {
	private final static Logger log= LoggerFactory.getLogger(EfeiServiceImpl.class);
	@Autowired
	private EfeiManager efeiManager;
	
	@Override
	public GenericResult<String> addEfei(Efei efei) {
		GenericResult<String> result = new GenericResult<String>();
		  
			if (efei != null) {
				//TODO:generate sequence id by CacheUtils.getSeq method Or remove this block.
				String id="";//CacheUtils.getSeq(RedisKeyConstants.XXX, length);
				//efei.setId(id);
				efeiManager.insertEfei(efei);
				
				result.setValue(id);
				result.setMessage("保存成功");
				log.debug("------EfeiServiceImpl.addEfei 保存成功------");
			} else {
				log.error("------EfeiServiceImpl.addEfei - efei is null!");
				result.setCode("");
				result.setMessage("efei is null");
			}
		  
		return result;
	}
	
	@Override
	public BasicResult modifyEfei(Efei efei) {
		BasicResult result = new BasicResult();
		 
			if (efei != null) {
				efeiManager.updateEfei(efei);
				result.setMessage("编辑成功");
				log.debug("------EfeiServiceImpl.modifyEfei 编辑成功------");
			} else {
				log.error("------EfeiServiceImpl.modifyEfei - efei is null!");
				result.setCode("");
				result.setMessage("efei is null");
			}
		 
		return result;
	}
	
	@Override
	public GenericResult<Efei> findByPriKey(Integer id) {
		GenericResult<Efei> result = new GenericResult<Efei>();
		 
			result.setValue(efeiManager.findEfeiByPriKey(id));
			result.setMessage("查询成功");
			log.debug("------EfeiServiceImpl.findByPriKey 查询成功------");
		 
		return result;
	}
	
	@Override
	public BasicResult deleteByPriKey(Integer id) {
		BasicResult result = new BasicResult();
		 
			efeiManager.deleteEfeiByPriKey(id);
			result.setMessage("删除成功");
			log.debug("------EfeiServiceImpl.deleteByPriKey 删除成功------");
		 
		return result;
	}
	
	@Override
	public ListResult<Efei> searchEfei(Query<EfeiQuery> query) {
		ListResult<Efei> result = new ListResult<Efei>();
		 
			result.setValues(efeiManager.searchEfeiList(query));
			result.setMessage("查询成功");
			log.debug("------EfeiServiceImpl.searchEfei 查询成功------");
		 
		return result;
	}
	
	@Override
	public PageListResult<Efei> searchPageEfei(
			PageQuery<EfeiQuery> pageQuery) {
		PageListResult<Efei> result = new PageListResult<Efei>();
		 
			List<Efei> list = efeiManager.searchPageEfeiList(pageQuery);
			Integer itemCount = efeiManager.getItemCount(pageQuery);
			Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
			result.setPagenation(pagenation);
			result.setValues(list);
			
			result.setMessage("查询成功");
			log.debug("------EfeiServiceImpl.searchPageEfei 查询成功------");
		 
		return result;
	}
}
