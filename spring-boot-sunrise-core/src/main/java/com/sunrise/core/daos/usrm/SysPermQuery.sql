SELECT
	*
FROM
	sys_perm
WHERE
	1 = 1

<#if permType??>
and PERM_TYPE  like '%${permType}%'
</#if>

<#if permTable??>
and PERM_TABLE  like '%${permTable}%'
</#if>

<#if permStat??>
and PERM_STAT  like '%${permStat}%'
</#if>

order by UPDATED_TIME desc