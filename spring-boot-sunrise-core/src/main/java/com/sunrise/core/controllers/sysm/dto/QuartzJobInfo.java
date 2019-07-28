package com.sunrise.core.controllers.sysm.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * QuartaJob信息
 * 
 * @author Sun Rising
 * @date 2019.07.02 06:09:05
 *
 */
@Getter
@Setter
@ToString
public class QuartzJobInfo {

	private String jobName;

	private String jobGroup;

	private String description;

	private String jobClassName;

	private String triggerName;

	private String triggerGroup;

	private String nextFireTime;

	private String prevFireTime;

	private String triggerState;

	private String startTime;

	private String endTime;

	private String cronExpression;

	private String timeZoneId;
}
