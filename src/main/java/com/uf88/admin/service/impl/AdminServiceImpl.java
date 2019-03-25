package com.uf88.admin.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uf88.admin.service.AdminService;
import com.uf88.admin.manager.AdminManager;
import com.uf88.admin.pojo.Admin;
import com.uf88.admin.pojo.AdminQuery;
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
 * 描述：</b>AdminServiceImpl<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分08秒 星期三
 * @version:1.0
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
	private final static Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);
	@Autowired
	private AdminManager adminManager;

	@Override
	public GenericResult<String> addAdmin(Admin admin) {
		GenericResult<String> result = new GenericResult<String>();

		if (admin != null) {
			// TODO:generate sequence id by CacheUtils.getSeq method Or remove this block.
			String id = "";// CacheUtils.getSeq(RedisKeyConstants.XXX, length);
			// admin.setId(id);
			adminManager.insertAdmin(admin);

			result.setValue(id);
			result.setMessage("保存成功");
			log.debug("------AdminServiceImpl.addAdmin 保存成功------");
		} else {
			log.error("------AdminServiceImpl.addAdmin - admin is null!");
			result.setCode("");
			result.setMessage("admin is null");
		}

		return result;
	}

	@Override
	public BasicResult modifyAdmin(Admin admin) {
		BasicResult result = new BasicResult();

		if (admin != null) {
			adminManager.updateAdmin(admin);
			result.setMessage("编辑成功");
			log.debug("------AdminServiceImpl.modifyAdmin 编辑成功------");
		} else {
			log.error("------AdminServiceImpl.modifyAdmin - admin is null!");
			result.setCode("");
			result.setMessage("admin is null");
		}

		return result;
	}

	@Override
	public GenericResult<Admin> findByPriKey(String adminname) {
		GenericResult<Admin> result = new GenericResult<Admin>();

		result.setValue(adminManager.findAdminByPriKey(adminname));
		result.setMessage("查询成功");
		log.debug("------AdminServiceImpl.findByPriKey 查询成功------");

		return result;
	}

	@Override
	public BasicResult checkLogin(String name, String passwd) {
		BasicResult br = new BasicResult();
		GenericResult<Admin> gr = findByPriKey(name);
		if (ResultUtil.isGenericSuccess(gr)) {
			if (gr.getValue().getAdminpassword().equals(passwd)) {
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
	public BasicResult deleteByPriKey(String adminname) {
		BasicResult result = new BasicResult();

		adminManager.deleteAdminByPriKey(adminname);
		result.setMessage("删除成功");
		log.debug("------AdminServiceImpl.deleteByPriKey 删除成功------");

		return result;
	}

	@Override
	public ListResult<Admin> searchAdmin(Query<AdminQuery> query) {
		ListResult<Admin> result = new ListResult<Admin>();

		result.setValues(adminManager.searchAdminList(query));
		result.setMessage("查询成功");
		log.debug("------AdminServiceImpl.searchAdmin 查询成功------");

		return result;
	}

	@Override
	public PageListResult<Admin> searchPageAdmin(PageQuery<AdminQuery> pageQuery) {
		PageListResult<Admin> result = new PageListResult<Admin>();

		List<Admin> list = adminManager.searchPageAdminList(pageQuery);
		Integer itemCount = adminManager.getItemCount(pageQuery);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);

		result.setMessage("查询成功");
		log.debug("------AdminServiceImpl.searchPageAdmin 查询成功------");

		return result;
	}

}
