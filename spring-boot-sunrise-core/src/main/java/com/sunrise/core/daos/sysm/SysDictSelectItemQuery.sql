SELECT
	*
FROM
	SYS_DICT_ITEM
WHERE
	1 = 1

<#if dictName??>
and DICT_NAME  like '%${dictName}%'
</#if>

<#if dictKey??>
and DICT_KEY  like '%${dictKey}%'
</#if>

<#if dictValue??>
and DICT_VALUE  like '%${dictValue}%'
</#if>

<#if dictStat??>
and DICT_STAT  like '%${dictStat}%'
</#if>

<#if groupUuid??>
and GROUP_UUID  like '%${groupUuid}%'
</#if>

order by UPDATED_TIME desc