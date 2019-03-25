package com.uf88.admin.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uf88.admin.service.ClubService;
import com.uf88.admin.manager.ClubManager;
import com.uf88.admin.pojo.Club;
import com.uf88.admin.pojo.ClubQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.paging.Pagenation; 


/**
 * 描述：</b>ClubServiceImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
@Service("clubService")
public class ClubServiceImpl implements ClubService {
	private final static Logger log= LoggerFactory.getLogger(ClubServiceImpl.class);
	@Autowired
	private ClubManager clubManager;
	
	@Override
	public GenericResult<String> addClub(Club club) {
		GenericResult<String> result = new GenericResult<String>();
		  
			if (club != null) {
				//TODO:generate sequence id by CacheUtils.getSeq method Or remove this block.
				String id="";//CacheUtils.getSeq(RedisKeyConstants.XXX, length);
				//club.setId(id);
				clubManager.insertClub(club);
				
				result.setValue(id);
				result.setMessage("保存成功");
				log.debug("------ClubServiceImpl.addClub 保存成功------");
			} else {
				log.error("------ClubServiceImpl.addClub - club is null!");
				result.setCode("");
				result.setMessage("club is null");
			}
		  
		return result;
	}
	
	@Override
	public BasicResult modifyClub(Club club) {
		BasicResult result = new BasicResult();
		 
			if (club != null) {
				clubManager.updateClub(club);
				result.setMessage("编辑成功");
				log.debug("------ClubServiceImpl.modifyClub 编辑成功------");
			} else {
				log.error("------ClubServiceImpl.modifyClub - club is null!");
				result.setCode("");
				result.setMessage("club is null");
			}
		 
		return result;
	}
	
	@Override
	public GenericResult<Club> findByPriKey(String clubname) {
		GenericResult<Club> result = new GenericResult<Club>();
		 
			result.setValue(clubManager.findClubByPriKey(clubname));
			result.setMessage("查询成功");
			log.debug("------ClubServiceImpl.findByPriKey 查询成功------");
		 
		return result;
	}
	
	@Override
	public BasicResult deleteByPriKey(String clubname) {
		BasicResult result = new BasicResult();
		 
			clubManager.deleteClubByPriKey(clubname);
			result.setMessage("删除成功");
			log.debug("------ClubServiceImpl.deleteByPriKey 删除成功------");
		 
		return result;
	}
	
	@Override
	public ListResult<Club> searchClub(Query<ClubQuery> query) {
		ListResult<Club> result = new ListResult<Club>();
		 
			result.setValues(clubManager.searchClubList(query));
			result.setMessage("查询成功");
			log.debug("------ClubServiceImpl.searchClub 查询成功------");
		 
		return result;
	}
	
	@Override
	public PageListResult<Club> searchPageClub(
			PageQuery<ClubQuery> pageQuery) {
		PageListResult<Club> result = new PageListResult<Club>();
		 
			List<Club> list = clubManager.searchPageClubList(pageQuery);
			Integer itemCount = clubManager.getItemCount(pageQuery);
			Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
			result.setPagenation(pagenation);
			result.setValues(list);
			
			result.setMessage("查询成功");
			log.debug("------ClubServiceImpl.searchPageClub 查询成功------");
		 
		return result;
	}
}
