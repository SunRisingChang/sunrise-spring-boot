SELECT
	*
FROM
	SYS_ROLE
WHERE
	1 = 1

<#if orgUuid??>
and ORG_UUID  like '%${orgUuid}%'
</#if>

<#if roleCode??>
and ROLE_CODE  like '%${roleCode}%'
</#if>

<#if roleName??>
and ROLE_NAME  like '%${roleName}%'
</#if>

order by UPDATED_TIME desc