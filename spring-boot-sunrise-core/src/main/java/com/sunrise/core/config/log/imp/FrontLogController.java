package com.sunrise.core.config.log.imp;

import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunrise.core.config.log.FrontLogConfig;
import com.sunrise.core.config.log.form.FrontLogFormBean;
import com.sunrise.core.utils.CommonUtils;
import com.sunrise.core.utils.RequestUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * 账户管理
 * 
 * @author Sun_Rising
 * @date 2018.12.27 02:15:52
 *
 */
@Slf4j
@RestController
@RequestMapping("/frontlog")
public class FrontLogController {

	@Autowired
	private FrontLogConfig frontLogConfig;

	/**
	 * 放入前端错误日志
	 * 
	 * @author Sun Rising
	 * @date 2019.07.06 08:19:02
	 * @return
	 * @throws Exception
	 * @throws Exception
	 *
	 */
	@PostMapping("/anon/saveFrontLog")
	public void saveFrontLog(FrontLogFormBean frontLogFormBean, HttpServletRequest httpServletRequest) {
		try {
			if (!frontLogConfig.isEnable())
				return;
			// 文件夹是否存在
			File folder = new File(frontLogConfig.getLogFolder());
			if (!folder.exists()) {
				FileUtils.forceMkdir(folder);
			}
			// 列出该目录下的所有文件，不递归
			List<File> fileList = (List<File>) FileUtils.listFiles(folder, null, false);
			fileList = CommonUtils.sortFileByName(fileList, "desc");
			// 获取编辑文件
			File currFile = null;
			if (fileList.size() == 0) {
				String fileName = frontLogConfig.getFileName() + ".1.log";
				currFile = new File(frontLogConfig.getLogFolder() + "/" + fileName);
				currFile.createNewFile();
			} else {
				if (FileUtils.sizeOf(folder) > frontLogConfig.getFolderMaxSize()) {
					FileUtils.forceDelete(fileList.get(fileList.size() - 1));
				}
				currFile = fileList.get(0);
				if (FileUtils.sizeOf(currFile) > frontLogConfig.getFileMaxSize()) {
					String[] tmp = currFile.getName().split("\\.");
					int num = Integer.parseInt(tmp[1]) + 1;
					String fileName = frontLogConfig.getFileName() + "." + num + ".log";
					currFile = new File(frontLogConfig.getLogFolder() + "/" + fileName);
					currFile.createNewFile();
				}
			}
			// 获取客户端描述
			if (httpServletRequest != null)
				frontLogFormBean.setCliDesc(RequestUtils.getHeadersInfo(httpServletRequest).get("user-agent"));
			// 进行文件内容追加
			StringBuffer msgBuffer = new StringBuffer();
			msgBuffer.append("\n");
			msgBuffer.append(frontLogFormBean.toString());
			FileUtils.writeByteArrayToFile(currFile, msgBuffer.toString().getBytes(), true);
		} catch (Exception e) {
			log.error("[FrontLog]记录失败," + e.getMessage());
		}
	}
}
