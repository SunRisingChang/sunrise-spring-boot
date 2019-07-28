SELECT
	a.*,
	b.USER_NAME,
	b.USER_SEX,
	b.USER_PHONE,
	b.USER_EMAIL,
	b.USER_BIRTHDAY
FROM
	sys_user a
LEFT JOIN sys_user_info b ON a.UUID = b.USER_UUID
WHERE
	1 = 1
	
<#if acName??>
and a.AC_NAME  like '%${acName}%'
</#if>

<#if acStat??>
and a.AC_STAT  like '%${acStat}%'
</#if>

<#if userName??>
and b.USER_NAME  like '%${userName}%'
</#if>

<#if userSex??>
and b.USER_SEX  like '%${userSex}%'
</#if>

<#if lastLogDateStart??&&lastLogDateEnd??>
and a.LAST_LOG_DATE between '${lastLogDateStart}' and '${lastLogDateEnd}'
</#if>

and a.AC_NAME <> 'admin'

order by a.UPDATED_TIME desc