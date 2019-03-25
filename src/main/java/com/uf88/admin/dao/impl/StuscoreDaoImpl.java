package com.uf88.admin.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.uf88.admin.dao.StuscoreDao;
import com.uf88.admin.pojo.Stuscore;
import com.uf88.admin.pojo.StuscoreQuery;
import com.uf88.admin.pojo.StuscoreSum;
import com.uf88.admin.pojo.StuscoreVo;
import com.uf88.uf88core.common.dao.BaseDao;
import com.uf88.uf88core.common.exception.Uf88Exception;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.PageQueryWrapper;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation;

/**
 * 描述：</b>StuscoreDaoImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分09秒 星期三
 * @version:1.0
 */
@Repository("stuscoreDao")
public class StuscoreDaoImpl extends BaseDao implements StuscoreDao {
	private final static Logger log = LoggerFactory.getLogger(StuscoreDaoImpl.class);

	@Override
	public void insert(Stuscore stuscore) {
		Object o = insert("STUSCORE.insert", stuscore);

	}

	@Override
	public void update(Stuscore stuscore) {
		update("STUSCORE.update", stuscore);
	}

	@Override
	public void updateAndCheck(Stuscore stuscore) {
		updateAndCheck("STUSCORE.update", stuscore);
	}

	@Override
	public void deleteByPriKey(Integer stuid) {
		Stuscore stuscore = new Stuscore();
		stuscore.setStuid(stuid);
		delete("STUSCORE.deleteByPriKey", stuscore);
	}

	@Override
	public void deleteByPriKeyAndCheck(Integer stuid) {
		Stuscore stuscore = new Stuscore();
		stuscore.setStuid(stuid);
		deleteAndCheck("STUSCORE.deleteByPriKey", stuscore);
	}

	@Override
	public StuscoreVo findByPriKey(Integer stuid) {
		StuscoreVo stuscore = new StuscoreVo();
		stuscore.setStuid(stuid);
		stuscore = (StuscoreVo) this.queryForObject("STUSCORE.findByPriKey", stuscore);
		return stuscore;
	}

	@Override
	public List<Stuscore> getAllList(Query<StuscoreQuery> query) {
		return this.queryForList("STUSCORE.getAllList", query);
	}

	@Override
	public Integer getItemCount(PageQuery<StuscoreQuery> pageQuery) {
		return (Integer) queryForObject("STUSCORE.getItemCount", pageQuery);
	}

	@Override
	public List<StuscoreVo> getPageList(PageQuery<StuscoreQuery> pageQuery, Integer itemCount) {
		PageQueryWrapper<StuscoreQuery> wrapper = new PageQueryWrapper<StuscoreQuery>(pageQuery.getPageNo(),
				pageQuery.getPageSize(), itemCount, pageQuery.getQuery(), pageQuery.getSort());
		return this.queryForList("STUSCORE.getPagenationList", wrapper);
	}

	@Override
	public List<StuscoreSum> getAllListSum(Query<StuscoreQuery> query) {
		return this.queryForList("STUSCORE.getAllListSum", query);
	}

}
