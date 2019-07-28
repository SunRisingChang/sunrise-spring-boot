package com.sunrise.core.controllers.sysm;

import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.sunrise.core.base.BaseController;
import com.sunrise.core.config.annotations.LogOper;
import com.sunrise.core.services.sysm.FileService;

/**
 * 系统文件
 * 
 * @author Sun Rising
 * @date 2019.07.09 08:36:09
 *
 */
@RestController
@RequestMapping("/sysm/fileMgr")
public class FileController extends BaseController {

	@Autowired
	private FileService fileService;

	/**
	 * 查询文件
	 * 
	 * @author Sun Rising
	 * @date 2019.07.09 08:51:04
	 * @return
	 *
	 */
	@GetMapping("/querySysFile")
	@LogOper(message = "查询附件列表")
	public Object querySysFile() {
		return fileService.querySysFile();
	}

	/**
	 * 保存文件
	 * 
	 * @author Sun Rising
	 * @date 2019.07.09 08:51:20
	 *
	 */
	@PostMapping("/saveSysFile")
	@LogOper(message = "保存附件")
	public void saveSysFile(@RequestParam("file") MultipartFile file) {
		fileService.saveSysFile(file);
	}

	/**
	 * 改变文件状态
	 * 
	 * @author Sun Rising
	 * @date 2019.07.09 08:51:29
	 * @param uuids
	 * @throws Exception
	 *
	 */
	@PutMapping("/changeSysFileStat/{uuids}/{stat}")
	@LogOper(message = "改变附件状态")
	public void changeSysFileStat(@PathVariable("uuids") String[] uuids, @PathVariable("stat") String stat)
			throws Exception {
		if (uuids.length > 0 && StringUtils.isNotBlank(stat))
			fileService.changeSysFileStat(uuids, stat);
	}

	/**
	 * 下载文件
	 * 
	 * @author Sun Rising
	 * @date 2019.07.09 08:51:41
	 * @param uuid
	 *
	 */
	@GetMapping("/anon/downFile/{md5}")
	@LogOper(message = "下载附件")
	public void downFile(HttpServletResponse response, @PathVariable("md5") String md5) {
		fileService.downFile(response, md5);
	}

	/**
	 * 删除文件
	 * 
	 * @author Sun Rising
	 * @date 2019.07.09 08:51:49
	 * @param uuids
	 *
	 */
	@DeleteMapping("/delSysFile/{uuids}")
	@LogOper(message = "删除附件")
	public void delSysFile(@PathVariable("uuids") String[] uuids) {
		if (uuids.length > 0)
			fileService.delSysFile(uuids);
	}
}
