SELECT
	*
FROM
	SYS_QUARTZ
WHERE
	1 = 1
	
<#if quartzName??>
and QUARTZ_NAME  like '%${quartzName}%'
</#if>

<#if quartzGroup??>
and QUARTZ_GROUP  like '%${quartzGroup}%'
</#if>

<#if quartzStat??>
and QUARTZ_STAT  like '%${quartzStat}%'
</#if>

order by UPDATED_TIME desc