SELECT
	*
FROM
	LOG_OPER
WHERE
	1 = 1
	
<#if reqUrl??>
and REQ_URL  like '%${reqUrl}%'
</#if>

<#if urlDesc??>
and URL_DESC  like '%${urlDesc}%'
</#if>

<#if svrAdrr??>
and SVR_ADRR  like '%${svrAdrr}%'
</#if>

<#if svrName??>
and SVR_NAME  like '%${svrName}%'
</#if>

<#if respCode??>
and RESP_CODE  like '%${respCode}%'
</#if>

<#if startTimeStart??&&startTimeEnd??>
and START_TIME between '${startTimeStart}' and '${startTimeEnd}'
</#if>

order by START_TIME desc