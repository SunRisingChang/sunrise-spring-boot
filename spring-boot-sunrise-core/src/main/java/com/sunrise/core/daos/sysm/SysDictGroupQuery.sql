SELECT
	*
FROM
	SYS_DICT_GROUP
WHERE
	1 = 1

<#if groupName??>
and GROUP_NAME  like '%${groupName}%'
</#if>

<#if groupKey??>
and GROUP_KEY  like '%${groupKey}%'
</#if>

<#if dictType??>
and DICT_TYPE  like '%${dictType}%'
</#if>

<#if groupStat??>
and GROUP_STAT  like '%${groupStat}%'
</#if>

order by UPDATED_TIME desc