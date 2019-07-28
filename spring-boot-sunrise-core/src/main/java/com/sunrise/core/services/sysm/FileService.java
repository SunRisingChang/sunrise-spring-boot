package com.sunrise.core.services.sysm;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.sunrise.core.base.BaseService;
import com.sunrise.core.daos.sysm.FileDao;
import com.sunrise.core.entitys.SysFile;
import com.sunrise.core.utils.FileTypeUtils;
import com.sunrise.core.utils.page.entitys.PageInfo;
import lombok.extern.slf4j.Slf4j;

/**
 * 系统文件
 * 
 * @author Sun Rising
 * @date 2019.07.09 08:38:07
 *
 */
@Slf4j
@Service
public class FileService extends BaseService {

	@Autowired
	private FileDao fileDao;

	@Value("${file.custom.fileUploadPath}")
	private String fileUploadPath;

	private static final String FILE_STAT_PUBLIC = "1";

	private static final String FILE_STAT_PRIVATE = "2";

	private static final String FILE_DOWN_URL_PREFIX = "/sysm/fileMgr/anon/downFile/";

	/**
	 * 查询文件
	 * 
	 * @author Sun Rising
	 * @date 2019.07.09 09:06:43
	 * @return
	 *
	 */
	@Transactional
	public PageInfo querySysFile() {
		return fileDao.querySysFile();
	}

	/**
	 * 改变文件状态
	 * 
	 * @author Sun Rising
	 * @date 2019.07.09 09:15:47
	 * @param uuids
	 * @param stat
	 * @throws Exception
	 *
	 */
	@Transactional
	public void changeSysFileStat(String[] uuids, String stat) throws Exception {
		for (String uuid : uuids) {
			SysFile sysFile = fileDao.getEntityManager().find(SysFile.class, uuid);
			if (sysFile != null) {
				if (stat.equals(FILE_STAT_PUBLIC) && FILE_STAT_PRIVATE.equals(sysFile.getFileStat())) {
					sysFile.setFileStat(FILE_STAT_PUBLIC);
				}
				if (stat.equals(FILE_STAT_PRIVATE) && FILE_STAT_PUBLIC.equals(sysFile.getFileStat())) {
					sysFile.setFileStat(FILE_STAT_PRIVATE);
				}
				fileDao.mergeAutoWriteMsg(sysFile);
			}
		}
	}

	/**
	 * 删除文件
	 * 
	 * @author Sun Rising
	 * @date 2019.07.09 09:16:15
	 * @param uuids
	 *
	 */
	@Transactional
	public void delSysFile(String[] uuids) {
		for (String uuid : uuids) {
			SysFile sysFile = fileDao.getEntityManager().find(SysFile.class, uuid);
			if (sysFile != null) {
				Path targetPath = Paths.get(sysFile.getFilePath());
				File file = targetPath.toFile();
				if (file.exists())
					file.delete();
				fileDao.getEntityManager().remove(sysFile);
			}
		}
	}

	/**
	 * 保存文件
	 * 
	 * @author Sun Rising
	 * @throws Exception
	 * @date 2019.07.09 09:18:04
	 *
	 */
	@Transactional
	public void saveSysFile(MultipartFile file) {
		if (file == null) {
			return;
		}
		try (InputStream is = file.getInputStream()) {
			//
			final String fileName = file.getOriginalFilename();
			if (StringUtils.isBlank(fileName)) {
				return;
			}
			final String ranDomStr = UUID.randomUUID().toString().replaceAll("-", "");
			final int extIndex = fileName.lastIndexOf(".");
			final String ext = fileName.substring(extIndex, fileName.length());
			final String filePathYMD = DateFormatUtils.format(System.currentTimeMillis(), "YYYY/MM/dd");
			final Path filePathFull = Paths.get(fileUploadPath, filePathYMD, fileName.replace(ext, "." + ranDomStr + ext));
			final Path fileFolder = filePathFull.getParent();
			File fileFinal = filePathFull.toFile();
			//
			if (fileFinal == null) {
				return;
			}
			if (Files.notExists(fileFolder)) {
				Files.createDirectories(fileFolder);
			}
			if (fileFinal.createNewFile()) {
				FileUtils.copyInputStreamToFile(file.getInputStream(), fileFinal);
				SysFile sysFile = new SysFile();
				sysFile.setFileName(fileName);
				sysFile.setFileStat(FILE_STAT_PRIVATE);
				sysFile.setFileMd5(com.sunrise.core.utils.FileUtils.fileMD5(fileFinal));
				sysFile.setFilePath(filePathFull.toString());
				sysFile.setFileSize(fileFinal.length());
				String fileType = FileTypeUtils.getFileType(fileFinal.getAbsolutePath());
				fileType = StringUtils.isNotBlank(fileType) ? fileType : "unknow";
				sysFile.setFileType(fileType);
				sysFile.setFileUrl(FILE_DOWN_URL_PREFIX + sysFile.getFileMd5());
				fileDao.persistAutoWriteMsg(sysFile);
			}
		} catch (Exception e) {
			log.error("文件保存失败");
		}
	}

	/**
	 * 下载文件
	 * 
	 * @author Sun Rising
	 * @date 2019.07.09 09:18:16
	 * @param uuid
	 *
	 */
	@Transactional
	public void downFile(HttpServletResponse response, String md5) {
		try (OutputStream outputStream = response.getOutputStream()) {
			SysFile sysFile = fileDao.getSysFileByMd5(md5);
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			if (sysFile == null) {
				outputStream.write("未知的文件".getBytes("UTF-8"));
				return;
			}
			if (StringUtils.isBlank(sysFile.getFilePath())) {
				outputStream.write("文件丢失".getBytes("UTF-8"));
				return;
			}
			File file = Paths.get(sysFile.getFilePath()).toFile();
			if (!file.exists()) {
				outputStream.write("文件丢失".getBytes("UTF-8"));
				return;
			}
			if (FILE_STAT_PRIVATE.equals(sysFile.getFileStat())) {
				Subject subject = SecurityUtils.getSubject();
				if (!subject.isAuthenticated()) {
					outputStream.write("该文件为私有文件".getBytes("UTF-8"));
					return;
				}
			}
			String fileName = URLEncoder.encode(sysFile.getFileName(), "UTF-8");
			response.setHeader("content-type", "application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
			response.addHeader("Content-Length", "" + sysFile.getFileSize());
			response.setContentType("application/octet-stream");
			InputStream is = new FileInputStream(file);
			IOUtils.copy(is, response.getOutputStream());
			is.close();
		} catch (Exception e) {
			log.error("文件下载失败");
		}
	}
}
