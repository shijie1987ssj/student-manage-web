package com.uf88.admin.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uf88.admin.service.StuscoreService;
import com.uf88.admin.manager.StuscoreManager;
import com.uf88.admin.pojo.Stuscore;
import com.uf88.admin.pojo.StuscoreQuery;
import com.uf88.admin.pojo.StuscoreSum;
import com.uf88.admin.pojo.StuscoreVo;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation;

/**
 * 描述：</b>StuscoreServiceImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分09秒 星期三
 * @version:1.0
 */
@Service("stuscoreService")
public class StuscoreServiceImpl implements StuscoreService {
	private final static Logger log = LoggerFactory.getLogger(StuscoreServiceImpl.class);
	@Autowired
	private StuscoreManager stuscoreManager;

	@Override
	public GenericResult<String> addStuscore(Stuscore stuscore) {
		GenericResult<String> result = new GenericResult<String>();

		if (stuscore != null) {
			// TODO:generate sequence id by CacheUtils.getSeq method Or remove this block.
			String id = "";// CacheUtils.getSeq(RedisKeyConstants.XXX, length);
			// stuscore.setId(id);
			stuscoreManager.insertStuscore(stuscore);

			result.setValue(id);
			result.setMessage("保存成功");
			log.debug("------StuscoreServiceImpl.addStuscore 保存成功------");
		} else {
			log.error("------StuscoreServiceImpl.addStuscore - stuscore is null!");
			result.setCode("");
			result.setMessage("stuscore is null");
		}

		return result;
	}

	@Override
	public BasicResult modifyStuscore(Stuscore stuscore) {
		BasicResult result = new BasicResult();

		if (stuscore != null) {
			stuscoreManager.updateStuscore(stuscore);
			result.setMessage("编辑成功");
			log.debug("------StuscoreServiceImpl.modifyStuscore 编辑成功------");
		} else {
			log.error("------StuscoreServiceImpl.modifyStuscore - stuscore is null!");
			result.setCode("");
			result.setMessage("stuscore is null");
		}

		return result;
	}

	@Override
	public GenericResult<StuscoreVo> findByPriKey(Integer stuid) {
		GenericResult<StuscoreVo> result = new GenericResult<StuscoreVo>();

		result.setValue(stuscoreManager.findStuscoreByPriKey(stuid));
		result.setMessage("查询成功");
		log.debug("------StuscoreServiceImpl.findByPriKey 查询成功------");

		return result;
	}

	@Override
	public BasicResult deleteByPriKey(Integer stuid) {
		BasicResult result = new BasicResult();

		stuscoreManager.deleteStuscoreByPriKey(stuid);
		result.setMessage("删除成功");
		log.debug("------StuscoreServiceImpl.deleteByPriKey 删除成功------");

		return result;
	}

	@Override
	public ListResult<Stuscore> searchStuscore(Query<StuscoreQuery> query) {
		ListResult<Stuscore> result = new ListResult<Stuscore>();

		result.setValues(stuscoreManager.searchStuscoreList(query));
		result.setMessage("查询成功");
		log.debug("------StuscoreServiceImpl.searchStuscore 查询成功------");

		return result;
	}

	@Override
	public PageListResult<StuscoreVo> searchPageStuscore(PageQuery<StuscoreQuery> pageQuery) {
		PageListResult<StuscoreVo> result = new PageListResult<StuscoreVo>();

		List<StuscoreVo> list = stuscoreManager.searchPageStuscoreList(pageQuery);
		Integer itemCount = stuscoreManager.getItemCount(pageQuery);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);

		result.setMessage("查询成功");
		log.debug("------StuscoreServiceImpl.searchPageStuscore 查询成功------");

		return result;
	}

	@Override
	public ListResult<StuscoreSum> searchStuscoreSum(Query<StuscoreQuery> query) {
		ListResult<StuscoreSum> result = new ListResult<StuscoreSum>();

		result.setValues(stuscoreManager.searchStuscoreListSum(query));
		result.setMessage("查询成功");
		log.debug("------StuscoreServiceImpl.searchStuscore 查询成功------");

		return result;
	}
}
