package com.uf88.admin.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uf88.admin.service.LeaderService;
import com.uf88.admin.manager.LeaderManager;
import com.uf88.admin.pojo.Admin;
import com.uf88.admin.pojo.Leader;
import com.uf88.admin.pojo.LeaderQuery;
import com.uf88.uf88core.BasicResult;
import com.uf88.uf88core.GenericResult;
import com.uf88.uf88core.ListResult;
import com.uf88.uf88core.PageListResult;
import com.uf88.uf88core.PageQuery;
import com.uf88.uf88core.Query;
import com.uf88.uf88core.common.exception.ResultCode;
import com.uf88.uf88core.paging.Pagenation;
import com.uf88.uf88core.util.ResultUtil;

/**
 * 描述：</b>LeaderServiceImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分09秒 星期三
 * @version:1.0
 */
@Service("leaderService")
public class LeaderServiceImpl implements LeaderService {
	private final static Logger log = LoggerFactory.getLogger(LeaderServiceImpl.class);
	@Autowired
	private LeaderManager leaderManager;

	@Override
	public GenericResult<String> addLeader(Leader leader) {
		GenericResult<String> result = new GenericResult<String>();

		if (leader != null) {
			// TODO:generate sequence id by CacheUtils.getSeq method Or remove this block.
			String id = "";// CacheUtils.getSeq(RedisKeyConstants.XXX, length);
			// leader.setId(id);
			leaderManager.insertLeader(leader);

			result.setValue(id);
			result.setMessage("保存成功");
			log.debug("------LeaderServiceImpl.addLeader 保存成功------");
		} else {
			log.error("------LeaderServiceImpl.addLeader - leader is null!");
			result.setCode("");
			result.setMessage("leader is null");
		}

		return result;
	}

	@Override
	public BasicResult modifyLeader(Leader leader) {
		BasicResult result = new BasicResult();

		if (leader != null) {
			leaderManager.updateLeader(leader);
			result.setMessage("编辑成功");
			log.debug("------LeaderServiceImpl.modifyLeader 编辑成功------");
		} else {
			log.error("------LeaderServiceImpl.modifyLeader - leader is null!");
			result.setCode("");
			result.setMessage("leader is null");
		}

		return result;
	}

	@Override
	public GenericResult<Leader> findByPriKey(String leadername) {
		GenericResult<Leader> result = new GenericResult<Leader>();

		result.setValue(leaderManager.findLeaderByPriKey(leadername));
		result.setMessage("查询成功");
		log.debug("------LeaderServiceImpl.findByPriKey 查询成功------");

		return result;
	}

	@Override
	public BasicResult checkLogin(String name, String passwd) {
		BasicResult br = new BasicResult();
		GenericResult<Leader> gr = findByPriKey(name);
		if (ResultUtil.isGenericSuccess(gr)) {
			if (gr.getValue().getLeaderpass().equals(passwd)) {
				br.setCode(ResultCode.SUCCESS.getCode());
				br.setMessage("登陆成功");
			} else {
				br.setCode(ResultCode.FAILED.getCode());
				br.setMessage("用户名/密码错误");
			}
		} else {
			br.setCode(ResultCode.FAILED.getCode());
			br.setMessage("用户名/密码错误");
		}
		return br;
	}

	@Override
	public BasicResult deleteByPriKey(String leadername) {
		BasicResult result = new BasicResult();

		leaderManager.deleteLeaderByPriKey(leadername);
		result.setMessage("删除成功");
		log.debug("------LeaderServiceImpl.deleteByPriKey 删除成功------");

		return result;
	}

	@Override
	public ListResult<Leader> searchLeader(Query<LeaderQuery> query) {
		ListResult<Leader> result = new ListResult<Leader>();

		result.setValues(leaderManager.searchLeaderList(query));
		result.setMessage("查询成功");
		log.debug("------LeaderServiceImpl.searchLeader 查询成功------");

		return result;
	}

	@Override
	public PageListResult<Leader> searchPageLeader(PageQuery<LeaderQuery> pageQuery) {
		PageListResult<Leader> result = new PageListResult<Leader>();

		List<Leader> list = leaderManager.searchPageLeaderList(pageQuery);
		Integer itemCount = leaderManager.getItemCount(pageQuery);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);

		result.setMessage("查询成功");
		log.debug("------LeaderServiceImpl.searchPageLeader 查询成功------");

		return result;
	}
}
