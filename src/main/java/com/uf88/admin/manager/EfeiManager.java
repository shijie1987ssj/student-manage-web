package com.uf88.admin.manager;

import java.util.List;
import com.uf88.admin.pojo.Efei;
import com.uf88.admin.pojo.EfeiQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>EfeiManager<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
public interface EfeiManager {

	public void insertEfei(Efei efei);
    
    public void updateEfei(Efei efei);
    
    public void deleteEfeiByPriKey(Integer id);
	
    public Efei findEfeiByPriKey(Integer id);
    
    public List<Efei> searchEfeiList(Query<EfeiQuery> query);
	
	public Integer getItemCount(PageQuery<EfeiQuery> pageQuery);
    
    public List<Efei> searchPageEfeiList(PageQuery<EfeiQuery> pageQuery);
}
