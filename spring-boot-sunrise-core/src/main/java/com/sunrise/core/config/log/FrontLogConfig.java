package com.sunrise.core.config.log;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.Getter;

/**
 * 前端错误日志
 * 
 * @author Sun Rising
 * @date 2019.07.06 08:06:44
 *
 */
@Component
@Getter
public class FrontLogConfig {

	@Value("${frontlog.custom.enable}")
	private boolean enable;

	// 日志文件名
	@Value("${frontlog.custom.fileName}")
	private String fileName;

	// 日志文件夹
	@Value("${frontlog.custom.logFolder}")
	private String logFolder;

	// 单文件大小(kb)
	@Value("${frontlog.custom.fileMaxSize}")
	private Long fileMaxSize;

	// 单文件夹大小（kb）
	@Value("${frontlog.custom.folderMaxSize}")
	private Long folderMaxSize;
}
