package com.uf88.admin.manager;

import java.util.List;
import com.uf88.admin.pojo.StuPiechart;
import com.uf88.admin.pojo.StuPiechartQuery;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;

/**
 * 描述：</b>StuPiechartManager<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public interface StuPiechartManager {

	public void insertStuPiechart(StuPiechart stuPiechart);
    
    public void updateStuPiechart(StuPiechart stuPiechart);
    
    public void deleteStuPiechartByPriKey(Integer id);
	
    public StuPiechart findStuPiechartByPriKey(Integer id);
    
    public List<StuPiechart> searchStuPiechartList(Query<StuPiechartQuery> query);
	
	public Integer getItemCount(PageQuery<StuPiechartQuery> pageQuery);
    
    public List<StuPiechart> searchPageStuPiechartList(PageQuery<StuPiechartQuery> pageQuery);
}
