package com.sunrise.core.controllers.sysm;

import java.util.List;
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
import com.sunrise.core.entitys.SysMenu;
import com.sunrise.core.services.sysm.MenuService;

/**
 * 菜单管理
 * 
 * @author Sun Rising
 * @date 2019.06.25 05:27:51
 *
 */
@RestController
@RequestMapping("/sysm/menuMgr")
public class MenuController extends BaseController {

	@Autowired
	private MenuService menuService;

	/**
	 * 保存或更新菜单
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:28:34
	 * @param list
	 * @throws Exception
	 *
	 */
	@PostMapping("/saveSysMenu")
	@LogOper(message = "保存或修改菜单")
	public void saveSysMenu(@RequestBody List<SysMenu> list) throws Exception {
		menuService.saveSysMenu(list);
	}

	/**
	 * 获取菜单列表
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:29:04
	 * @return
	 *
	 */
	@GetMapping("/getSysMenu")
	@LogOper(message = "获取菜单列表")
	public Object getSysMenu() {
		return menuService.getSysMenu();
	}

	/**
	 * 删除菜单
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:29:24
	 * @param uuids uuid数组
	 *
	 */
	@DeleteMapping("/delSysMenu/{uuid}")
	@LogOper(message = "删除菜单")
	public void delSysMenu(@PathVariable("uuid") String[] uuids) {
		menuService.delSysMenu(uuids);
	}
}
