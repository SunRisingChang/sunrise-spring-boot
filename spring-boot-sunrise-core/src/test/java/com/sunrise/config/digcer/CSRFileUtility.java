package com.sunrise.config.digcer;

import java.io.File;
import java.io.FileReader;
import java.io.StringWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Base64;
import org.apache.commons.io.FileUtils;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMReader;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequestHolder;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CSR文件生成工具
 * 
 * @author Sun_Rising
 * @date 2019.01.04 09:36:53
 *
 */
public class CSRFileUtility {

	private static final Logger logger = LoggerFactory.getLogger(CSRFileUtility.class);
	static {
		// 添加BC支持
		Security.addProvider(new BouncyCastleProvider());
	}

	/**
	 * 处理数字证书生成流程
	 * 
	 * @author Sun_Rising
	 * @date 2019.01.04 04:22:40
	 * @param subject
	 * @throws NoSuchProviderException
	 * @throws NoSuchAlgorithmException
	 * @throws Exception
	 *
	 */
	public void genCSR(String alias, X500Name subject) throws Exception {
		// -----------------------------生成密钥 开始--------------------------
		// 获取密钥对生成器
		KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA", "BC");
		// 初始化生成器，参数为密钥的长度、随机种子
		kpGen.initialize(1024, new SecureRandom());
		// 生成密钥对
		KeyPair keyPair = kpGen.generateKeyPair();
		// 获取私钥
		PrivateKey privateKey = keyPair.getPrivate();
		// 获取公钥
		PublicKey publicKey = keyPair.getPublic();
		System.out.println(Base64.getEncoder().encodeToString(publicKey.getEncoded()));
		// -----------------------------生成密钥 结束-------------
		// ------------------------------创建CSR对象 开始-------------------------------
		// 公钥令牌
		SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(publicKey.getEncoded());
		// 创建csr生成器
		PKCS10CertificationRequestBuilder builder = new PKCS10CertificationRequestBuilder(subject, subjectPublicKeyInfo);
		// 创建签名生成器
		JcaContentSignerBuilder jcaBuilder = new JcaContentSignerBuilder("SHA256withRSA");
		// 设置签名使用BC提供的签名算法
		jcaBuilder.setProvider("BC");
		// 设置签名使用的私钥
		ContentSigner contentSigner = jcaBuilder.build(keyPair.getPrivate());
		// 装配签名器获得crs内容
		PKCS10CertificationRequestHolder csr = builder.build(contentSigner);
		// csr文件写入对象准备
		PemObject pemCsrObject = new PemObject("CERTIFICATE REQUEST", csr.getEncoded());
		PemObject pemKeyObject = new PemObject("RSA PRIVATE KEY", privateKey.getEncoded());
		// ------------------------------创建CSR对象 结束--------------------------
		// ------------------------------生成文件 开始--------------------------
		// 生成 CSR 文件
		this.createCSRFile(pemCsrObject);
		// 生成 KEY 文件
		this.createKEYFile(pemKeyObject);
		// ------------------------------生成文件 结束--------------------------
	}

	/**
	 * 创建CSR文件
	 * 
	 * @author Sun_Rising
	 * @date 2019.01.04 04:50:28
	 * @param pemObject
	 *
	 */
	public void createCSRFile(PemObject pemObject) {
		try (StringWriter strWriter = new StringWriter(); PemWriter pemWriter = new PemWriter(strWriter)) {
			pemWriter.writeObject(pemObject);
			pemWriter.flush();
			FileUtils.writeStringToFile(new File("SSL.CSR"), strWriter.toString(), "UTF-8");
		} catch (Exception e) {
			logger.error("CSR文件生成失败！" + e.getMessage());
		}
	}

	/**
	 * 创建KEY文件
	 * 
	 * @author Sun_Rising
	 * @date 2019.01.04 10:26:01
	 * @param privateKey
	 * @throws Exception
	 *
	 */
	public void createKEYFile(PemObject pemObject) {
		try (StringWriter strWriter = new StringWriter(); PemWriter pemWriter = new PemWriter(strWriter)) {
			pemWriter.writeObject(pemObject);
			pemWriter.flush();
			FileUtils.writeStringToFile(new File("RSA.KEY"), strWriter.toString(), "UTF-8");
		} catch (Exception e) {
			logger.error("KEY文件生成失败！" + e.getMessage());
		}
	}

	public void readCSRFile(String path) {
		try (FileReader fileReader = new FileReader(new File(path)); PEMReader pemReader = new PEMReader(fileReader)) {
			PemObject pemObject = pemReader.readPemObject();
			PKCS10CertificationRequestHolder pkcs10CertificationRequestHolder = new PKCS10CertificationRequestHolder(pemObject.getContent());
			System.out.println(pkcs10CertificationRequestHolder.getSubject().toString());
			AlgorithmIdentifier sigAlgId = pkcs10CertificationRequestHolder.getSignatureAlgorithm();
			System.out.println(sigAlgId.getAlgorithm());
			if (PKCSObjectIdentifiers.sha256WithRSAEncryption.equals(sigAlgId.getAlgorithm())) {
				RSASSAPSSparams param = RSASSAPSSparams.getInstance(sigAlgId.getParameters());
				ASN1ObjectIdentifier digestAlgOid = param.getHashAlgorithm().getAlgorithm();
				System.out.println(digestAlgOid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
//		X500NameBuilder x500NameBld = new X500NameBuilder(BCStyle.INSTANCE);
//		x500NameBld.addRDN(BCStyle.C, "CN");
//		x500NameBld.addRDN(BCStyle.O, "DanWeiMingCheng");
//		x500NameBld.addRDN(BCStyle.OU, "BuMen");
//		x500NameBld.addRDN(BCStyle.L, "ChengShi");
//		x500NameBld.addRDN(BCStyle.ST, "ShengFen");
//		x500NameBld.addRDN(BCStyle.CN, "YuMing");
//		x500NameBld.addRDN(BCStyle.EmailAddress, "123@123.com");
//		X500Name subject = x500NameBld.build();
//		new CSRFileUtility().genCSR("DXP2019875T", subject);
		new CSRFileUtility().readCSRFile("SSL.CSR");
	}
}
