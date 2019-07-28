package com.sunrise.core.services.sysm;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sunrise.core.base.BaseService;
import com.sunrise.core.daos.sysm.MenuDao;
import com.sunrise.core.entitys.SysMenu;

/**
 * 菜单管理
 * 
 * @author Sun Rising
 * @date 2019.06.25 05:28:10
 *
 */
@Service
public class MenuService extends BaseService {

	@Autowired
	private MenuDao menuDao;

	/**
	 * 保存或更新菜单
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:30:07
	 * @param list
	 * @throws Exception
	 *
	 */
	@Transactional
	public void saveSysMenu(List<SysMenu> list) throws Exception {
		for (SysMenu sysMenu : list) {
			if (StringUtils.isNotBlank(sysMenu.getUuid())) {
				menuDao.mergeAutoWriteMsg(sysMenu);
			} else {
				menuDao.persistAutoWriteMsg(sysMenu);
			}
		}
	}

	/**
	 * 获取菜单列表
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:30:36
	 * @return
	 *
	 */
	@Transactional
	public List<SysMenu> getSysMenu() {
		return menuDao.getSysMenu();
	}

	/**
	 * 删除菜单
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:29:24
	 * @param uuids uuid数组
	 *
	 */
	@Transactional
	public void delSysMenu(String[] uuids) {
		for (String uuid : uuids) {
			SysMenu sysMenu = menuDao.getEntityManager().find(SysMenu.class, uuid);
			if (sysMenu != null) {
				List<SysMenu> list = menuDao.getSysMenuChildren(sysMenu.getMenuUrl());
				List<String> _uuids = new ArrayList<String>();
				for (SysMenu sysMenuObj : list) {
					_uuids.add(sysMenuObj.getUuid());
				}
				delSysMenu(_uuids.toArray(new String[_uuids.size()]));
				menuDao.getEntityManager().remove(sysMenu);
			}
		}
	}
}
