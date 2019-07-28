package com.sunrise.core.services.sysm;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sunrise.core.base.BaseService;
import com.sunrise.core.config.annotations.LocalCache;
import com.sunrise.core.config.ehcache.imp.DictCacheService;
import com.sunrise.core.config.exception.CustomRuntimeException;
import com.sunrise.core.constant.SystemConst;
import com.sunrise.core.daos.sysm.DictDao;
import com.sunrise.core.entitys.SysDictGroup;
import com.sunrise.core.entitys.SysDictItem;
import com.sunrise.core.utils.page.entitys.PageInfo;

/**
 * 字典管理
 * 
 * @author Sun Rising
 * @date 2019.06.28 12:36:13
 *
 */
@Service
public class DictService extends BaseService {

	@Autowired
	private DictDao dictDao;

	@Autowired
	private DictCacheService dictCacheService;

	/**
	 * 查询字典组
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 08:10:12
	 * @return
	 *
	 */
	@Transactional
	public PageInfo querySysDictGroup() {
		return dictDao.querySysDictGroup();
	}

	/**
	 * 保存或更新字典组
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 08:10:25
	 * @param sysDictGroup
	 * @throws Exception
	 *
	 */
	@Transactional
	public void saveSysDictGroup(SysDictGroup sysDictGroup) throws Exception {
		if (StringUtils.isNotBlank(sysDictGroup.getGroupKey())) {
			// 判重
			if (!dictDao.checkUnique(sysDictGroup, "groupKey")) {
				throw new CustomRuntimeException("字典组索引重复");
			}
		}
		if (StringUtils.isNotBlank(sysDictGroup.getUuid())) {
			dictDao.mergeAutoWriteMsg(sysDictGroup);
		} else {
			dictDao.persistAutoWriteMsg(sysDictGroup);
		}
		dictCacheService.dictRemove(sysDictGroup.getGroupKey());
	}

	/**
	 * 删除字典组
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 08:11:37
	 * @param uuids
	 * @throws Exception
	 *
	 */
	@Transactional
	public void delSysDictGroup(String[] uuids) throws Exception {
		for (String uuid : uuids) {
			SysDictGroup sysDictGroup = dictDao.getEntityManager().find(SysDictGroup.class, uuid);
			if (sysDictGroup != null) {
				dictDao.getEntityManager().remove(sysDictGroup);
				dictCacheService.dictRemove(sysDictGroup.getGroupKey());
			}
		}
	}

	/**
	 * 查询select字典值
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 08:12:00
	 * @return
	 *
	 */
	@Transactional
	public PageInfo getSysDictSelectItem() {
		return dictDao.getSysDictSelectItem();
	}

	/**
	 * 查询tree字典值
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 08:12:32
	 * @param groupUuid
	 * @return
	 *
	 */
	@Transactional
	public List<SysDictItem> getSysDictTreeItem(String groupUuid) {
		return dictDao.getSysDictTreeItem(groupUuid);
	}

	/**
	 * 查询tree字典值
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 08:12:32
	 * @param groupUuid
	 * @return
	 *
	 */
	@Transactional
	@LocalCache(key = "'" + SystemConst.DICT_CACHE_PREFIX + "'+#groupKey")
	public List<SysDictItem> getSysDictItemByGroupKey(String groupKey) {
		System.out.println("111111111111");
		return dictDao.getSysDictItemByGroupKey(groupKey);
	}

	/**
	 * 保存或更新字典值
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 08:13:08
	 * @param sysDictItems
	 * @throws Exception
	 *
	 */
	@Transactional
	public void saveSysDictItem(List<SysDictItem> sysDictItems) throws Exception {
		for (SysDictItem sysDictItem : sysDictItems) {
			if (StringUtils.isNotBlank(sysDictItem.getUuid())) {
				dictDao.mergeAutoWriteMsg(sysDictItem);
			} else {
				dictDao.persistAutoWriteMsg(sysDictItem);
			}
			SysDictGroup sysDictGroup = dictDao.getEntityManager().find(SysDictGroup.class, sysDictItem.getGroupUuid());
			dictCacheService.dictRemove(sysDictGroup.getGroupKey());
		}
	}

	/**
	 * 删除字典值
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 08:13:24
	 * @param uuids
	 * @throws Exception
	 *
	 */
	@Transactional
	public void delSysDictItem(String[] uuids) throws Exception {
		for (String uuid : uuids) {
			SysDictItem sysDictItem = dictDao.getEntityManager().find(SysDictItem.class, uuid);
			if (sysDictItem != null) {
				dictDao.getEntityManager().remove(sysDictItem);
				SysDictGroup sysDictGroup = dictDao.getEntityManager().find(SysDictGroup.class, sysDictItem.getGroupUuid());
				dictCacheService.dictRemove(sysDictGroup.getGroupKey());
			}
		}
	}
}
