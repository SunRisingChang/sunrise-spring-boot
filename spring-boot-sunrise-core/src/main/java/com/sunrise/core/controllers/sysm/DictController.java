package com.sunrise.core.controllers.sysm;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunrise.core.base.BaseController;
import com.sunrise.core.config.annotations.LogOper;
import com.sunrise.core.entitys.SysDictGroup;
import com.sunrise.core.entitys.SysDictItem;
import com.sunrise.core.services.sysm.DictService;

/***
 * 字典管理
 * 
 * @author Sun Rising
 * @date 2019.06.25 11:25:32
 *
 */
@RestController
@RequestMapping("/sysm/dictMgr")
public class DictController extends BaseController {

	@Autowired
	private DictService dictService;

	/**
	 * 查询字典组
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 12:46:28
	 * @return
	 *
	 */
	@GetMapping("/querySysDictGroup")
	@LogOper(message = "查询字典组")
	public Object querySysDictGroup() {
		return dictService.querySysDictGroup();
	}

	/**
	 * 保存字典组
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 12:47:53
	 * @param sysDictGroup
	 * @throws Exception
	 *
	 */
	@PostMapping("/saveSysDictGroup")
	@LogOper(message = "保存或修改字典组")
	public void saveSysDictGroup(@RequestBody SysDictGroup sysDictGroup) throws Exception {
		dictService.saveSysDictGroup(sysDictGroup);
	}

	/**
	 * 删除字典组
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 12:50:38
	 * @param uuids
	 * @throws Exception
	 *
	 */
	@DeleteMapping("/delSysDictGroup/{uuids}")
	@LogOper(message = "删除字典组")
	public void delSysDictGroup(@PathVariable("uuids") String[] uuids) throws Exception {
		if (uuids.length > 0)
			dictService.delSysDictGroup(uuids);
	}

	/**
	 * 查询字典select值
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 12:53:39
	 * @return
	 *
	 */
	@GetMapping("/getSysDictSelectItem")
	@LogOper(message = "查询Select字典值")
	public Object getSysDictSelectItem() {
		return dictService.getSysDictSelectItem();
	}

	/**
	 * 查询字典tree值
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 12:53:39
	 * @return
	 *
	 */
	@GetMapping("/getSysDictTreeItem")
	@LogOper(message = "查询Tree字典值")
	public Object getSysDictTreeItem(String groupUuid) {
		if (StringUtils.isNotBlank(groupUuid)) {
			return dictService.getSysDictTreeItem(groupUuid);
		}
		return new ArrayList<>();
	}

	/**
	 * 查询字典tree值,通过groupKey
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 12:53:39
	 * @return
	 *
	 */
	@GetMapping("/getSysDictItemByGroupKey")
	@LogOper(message = "获取Tree字典值")
	public Object getSysDictItemByGroupKey(String groupKey) {
		if (StringUtils.isNotBlank(groupKey)) {
			return dictService.getSysDictItemByGroupKey(groupKey);
		}
		return new ArrayList<>();
	}

	/**
	 * 保存字典值
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 12:54:51
	 * @param sysDictItem
	 * @throws Exception
	 *
	 */
	@PostMapping("/saveSysDictItem")
	@LogOper(message = "保存或修改字典值")
	public void saveSysDictItem(@RequestBody List<SysDictItem> sysDictItems) throws Exception {
		dictService.saveSysDictItem(sysDictItems);
	}

	/**
	 * 删除字典值
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 08:09:28
	 * @param uuids
	 * @throws Exception
	 *
	 */
	@DeleteMapping("/delSysDictItem/{uuids}")
	@LogOper(message = "删除字典值")
	public void delSysDictItem(@PathVariable("uuids") String[] uuids) throws Exception {
		if (uuids.length > 0)
			dictService.delSysDictItem(uuids);
	}
}
