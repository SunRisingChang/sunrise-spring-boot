package com.sunrise.core.services.usrm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sunrise.core.base.BaseService;
import com.sunrise.core.config.exception.CustomRuntimeException;
import com.sunrise.core.controllers.usrm.dto.OrgTree;
import com.sunrise.core.daos.usrm.OrgDao;
import com.sunrise.core.entitys.SysOrg;
import com.sunrise.core.utils.TreeUtils;

/**
 * 组织管理
 * 
 * @author Sun Rising
 * @date 2019.06.25 11:26:49
 *
 */
@Service
public class OrgService extends BaseService {

	@Autowired
	private OrgDao orgDao;

	/**
	 * 保存或更新组织
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:30:07
	 * @param list
	 * @throws Exception
	 *
	 */
	@Transactional
	public void saveSysOrg(List<SysOrg> list) throws Exception {
		for (SysOrg sysOrg : list) {
			// 判重
			if (StringUtils.isNotBlank(sysOrg.getOrgCode())) {
				if (!orgDao.checkUnique(sysOrg, "orgCode")) {
					throw new CustomRuntimeException("组织唯一编码重复");
				}
			}
			if (StringUtils.isNotBlank(sysOrg.getUuid())) {
				orgDao.mergeAutoWriteMsg(sysOrg);
			} else {
				orgDao.persistAutoWriteMsg(sysOrg);
			}
		}
	}

	/**
	 * 获取组织列表
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:30:36
	 * @return
	 *
	 */
	@Transactional
	public List<SysOrg> getSysOrg() {
		return orgDao.getSysOrg();
	}

	/**
	 * 删除组织
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:29:24
	 * @param uuids uuid数组
	 *
	 */
	@Transactional
	public void delSysOrg(String[] uuids) {
		for (String uuid : uuids) {
			SysOrg sysOrg = orgDao.getEntityManager().find(SysOrg.class, uuid);
			if (sysOrg != null) {
				List<SysOrg> list = orgDao.getSysOrgChildren(sysOrg.getOrgCode());
				List<String> _uuids = new ArrayList<String>();
				for (SysOrg sysOrg2 : list) {
					_uuids.add(sysOrg2.getUuid());
				}
				delSysOrg(_uuids.toArray(new String[_uuids.size()]));
				orgDao.getEntityManager().remove(sysOrg);
			}
		}
	}

	/**
	 * 获取可用的组织树集合
	 * 
	 * @author Sun Rising
	 * @date 2019.06.26 08:58:46
	 * @return
	 * @throws Exception
	 *
	 */
	@Transactional
	public Collection<OrgTree> getOrgTree() throws Exception {
		List<SysOrg> list = orgDao.getOrgTreeList();
		List<OrgTree> treeList = new ArrayList<>();
		for (SysOrg sysOrg : list) {
			OrgTree orgTree = new OrgTree();
			BeanUtils.copyProperties(orgTree, sysOrg);
			treeList.add(orgTree);
		}
		return TreeUtils.toTree(treeList, "ROOT", "orgCode", "orgPare", "children", OrgTree.class);
	}
}
