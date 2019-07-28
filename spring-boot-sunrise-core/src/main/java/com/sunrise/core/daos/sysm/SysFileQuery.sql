SELECT
	*
FROM
	SYS_FILE
WHERE
	1 = 1

<#if fileName??>
and FILE_NAME  like '%${fileName}%'
</#if>

<#if fileUrl??>
and FILE_URL  like '%${fileUrl}%'
</#if>

<#if fileType??>
and FILE_TYPE  like '%${fileType}%'
</#if>

<#if fileStat??>
and FILE_STAT  like '%${fileStat}%'
</#if>

order by UPDATED_TIME desc