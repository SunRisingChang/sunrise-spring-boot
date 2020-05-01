package com.sunrise.core.digcer.form;

import java.util.Date;

/**
 * x509证书实体
 * 
 * @author Sun_Rising
 * @date 2019.01.08 02:28:40
 *
 */
public class X509CertBean {

	// 证书版本
	private String version;

	// 序列号
	private String serialNumber;

	// 证书生效日期
	private Date notBefore;

	// 证书失效日期
	private Date notAfter;

	// 证书拥有者名称
	private String subjectCN;

	// 证书拥有者实体
	private String subjectDN;

	// 颁发者名称
	private String issuerCN;

	// 颁发者实体
	private String issuerDN;

	// 签名算法名称
	private String sigAlgName;

	// 公钥BASE64
	private String publicKeyBase64;

	// 公钥信息
	private String publicKey;

	// 简称：CN 字段，对于 SSL 证书，一般为网站域名；而对于代码签名证书则为申请单位名称；而对于客户端证书则为证书申请者的姓名；
	private String commonName;

	// 简称：O 字段，对于 SSL 证书，一般为网站域名；而对于代码签名证书则为申请单位名称；而对于客户端单位证书则为证书申请者所在单位名称；
	private String organizationName;

	// OU 部门
	private String organizationalUnit;

	// 简称：L 字段 城市
	private String locality;

	// 简称：S 字段 省份
	private String state;

	// 简称：C 字段，只能是国家字母缩写，如中国：CN
	private String country;

	// 简称：E 字段
	private String email;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getNotBefore() {
		return notBefore;
	}

	public void setNotBefore(Date notBefore) {
		this.notBefore = notBefore;
	}

	public Date getNotAfter() {
		return notAfter;
	}

	public void setNotAfter(Date notAfter) {
		this.notAfter = notAfter;
	}

	public String getSubjectCN() {
		return subjectCN;
	}

	public void setSubjectCN(String subjectCN) {
		this.subjectCN = subjectCN;
	}

	public String getSubjectDN() {
		return subjectDN;
	}

	public void setSubjectDN(String subjectDN) {
		this.subjectDN = subjectDN;
	}

	public String getIssuerCN() {
		return issuerCN;
	}

	public void setIssuerCN(String issuerCN) {
		this.issuerCN = issuerCN;
	}

	public String getIssuerDN() {
		return issuerDN;
	}

	public void setIssuerDN(String issuerDN) {
		this.issuerDN = issuerDN;
	}

	public String getSigAlgName() {
		return sigAlgName;
	}

	public void setSigAlgName(String sigAlgName) {
		this.sigAlgName = sigAlgName;
	}

	public String getPublicKeyBase64() {
		return publicKeyBase64;
	}

	public void setPublicKeyBase64(String publicKeyBase64) {
		this.publicKeyBase64 = publicKeyBase64;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationalUnit() {
		return organizationalUnit;
	}

	public void setOrganizationalUnit(String organizationalUnit) {
		this.organizationalUnit = organizationalUnit;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
