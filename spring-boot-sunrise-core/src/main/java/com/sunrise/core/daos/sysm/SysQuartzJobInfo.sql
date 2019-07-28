SELECT
	job.JOB_NAME,
	job.JOB_GROUP,
	job.DESCRIPTION,
	job.JOB_CLASS_NAME,
	tri.TRIGGER_NAME,
	tri.TRIGGER_GROUP,
	tri.NEXT_FIRE_TIME,
	tri.PREV_FIRE_TIME,
	tri.TRIGGER_STATE,
	tri.START_TIME,
	tri.END_TIME,
	cron.CRON_EXPRESSION,
	cron.TIME_ZONE_ID
FROM
	qtz_job_details job
LEFT JOIN qtz_triggers tri ON job.JOB_NAME = tri.JOB_NAME
LEFT JOIN qtz_cron_triggers cron ON cron.TRIGGER_NAME = tri.TRIGGER_NAME
WHERE
	tri.TRIGGER_TYPE = 'CRON'
	
<#if jobName??>
and job.JOB_NAME  like '%${jobName}%'
</#if>

<#if jobGroup??>
and job.JOB_GROUP  like '%${jobGroup}%'
</#if>
	