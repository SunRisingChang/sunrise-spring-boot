package com.sunrise.core.config.log.form;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.sunrise.core.config.resolver.iface.PostEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FrontLogFormBean implements PostEntity {

	private String cliDesc;

	private String error;

	private String info;

	private String path;

	// 时间戳
	private Long timestamp;

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String _timestamp = dateFormat.format(new Date());
		if (this.timestamp != null) {
			_timestamp = dateFormat.format(this.timestamp);
		}
		return "[FrontLog][ERROR][" + _timestamp + "][path=" + path + "][info=" + info + "][cliDesc=" + cliDesc + "][error=" + error + "]";
	}
}
