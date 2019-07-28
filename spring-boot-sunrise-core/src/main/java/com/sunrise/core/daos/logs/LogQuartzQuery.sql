SELECT
	*
FROM
	LOG_QUARTZ
WHERE
	1 = 1
	
<#if qtzName??>
and QTZ_NAME  like '%${qtzName}%'
</#if>

<#if qtzGroup??>
and QTZ_GROUP  like '%${qtzGroup}%'
</#if>

<#if logLeve??>
and LOG_LEVE  like '%${logLeve}%'
</#if>

<#if svrName??>
and SVR_NAME  like '%${svrName}%'
</#if>

<#if svrAddr??>
and SVR_ADDR  like '%${svrAddr}%'
</#if>

<#if startTimeStart??&&startTimeEnd??>
and START_TIME between '${startTimeStart}' and '${startTimeEnd}'
</#if>

order by START_TIME desc