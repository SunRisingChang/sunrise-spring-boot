SELECT
	*
FROM
	SYS_QUARTZ
WHERE
	1 = 1
	
<#if jobName??>
and JOB_NAME  like '%${jobName}%'
</#if>

<#if triggerState??>
and TRIGGER_STATE  like '%${triggerState}%'
</#if>

order by UPDATED_TIME desc