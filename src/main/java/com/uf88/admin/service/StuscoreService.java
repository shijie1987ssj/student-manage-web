package com.uf88.admin.service;

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

/**
 * 描述：</b>StuscoreService<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分09秒 星期三
 * @version:1.0
 */
public interface StuscoreService {

	public GenericResult<String> addStuscore(Stuscore stuscore);

	public BasicResult modifyStuscore(Stuscore stuscore);

	public GenericResult<StuscoreVo> findByPriKey(Integer stuid);

	public BasicResult deleteByPriKey(Integer stuid);

	public ListResult<Stuscore> searchStuscore(Query<StuscoreQuery> query);

	public ListResult<StuscoreSum> searchStuscoreSum(Query<StuscoreQuery> query);

	public PageListResult<StuscoreVo> searchPageStuscore(PageQuery<StuscoreQuery> pageQuery);

}
