package com.sunrise.config.digcer;
//package com.sunrising.exc.digcer;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.math.BigInteger;
//import java.security.InvalidKeyException;
//import java.security.Key;
//import java.security.KeyPair;
//import java.security.KeyPairGenerator;
//import java.security.KeyStore;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//import java.security.NoSuchProviderException;
//import java.security.SecureRandom;
//import java.security.Security;
//import java.security.SignatureException;
//import java.security.cert.CertificateEncodingException;
//import java.security.cert.CertificateException;
//import java.security.cert.CertificateFactory;
//import java.security.cert.X509Certificate;
//import java.util.Date;
//import java.util.Enumeration;
//
//import org.bouncycastle.asn1.x509.X509Name;
//import org.bouncycastle.jce.X509V3CertificateGenerator;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//
//import sun.misc.BASE64Encoder;
//
//public class DataCertCreate {
//    private String path = "D:/";
//
//    /**
//     * 公钥方法
//     */
//    static {
//        Security.addProvider(new BouncyCastleProvider());
//    }
//
//    /**
//     * 产生数字公钥证书 String[]
//     * info长度为9，分别是{cn,ou,o,c,l,st,starttime,endtime,serialnumber}
//     * 
//     * @throws SignatureException
//     * @throws SecurityException
//     * @throws NoSuchProviderException
//     * @throws InvalidKeyException
//     */
//    public X509Certificate generateCert(String[] info, KeyPair keyPair_root, KeyPair keyPair_user)
//            throws InvalidKeyException, NoSuchProviderException, SecurityException, SignatureException {
//        X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();
//        X509Certificate cert = null;
//        certGen.setSerialNumber(new BigInteger(info[8]));
//        certGen.setIssuerDN(new X509Name("CN=huahua, OU=hnu, O=university , C=china"));
//        certGen.setNotBefore(new Date(Long.parseLong(info[6])));
//        certGen.setNotAfter(new Date(Long.parseLong(info[7])));
//        certGen.setSubjectDN(new X509Name("C=" + info[0] + ",OU=" + info[1] + ",O=" + info[2] + ",C=" + info[3] + ",L="
//                + info[4] + ",ST=" + info[3]));
//        certGen.setPublicKey(keyPair_user.getPublic());
//        certGen.setSignatureAlgorithm("SHA1WithRSA");
//        cert = certGen.generateX509Certificate(keyPair_root.getPrivate(), "BC");
//        return cert;
//    }
//
//    /**
//     * 私钥方法
//     */
//
//    private String KEYSTORE_PASSWORD = "2078888";
//
//    /**
//     * 创建空的jks文件 String[]
//     * info长度为9，分别是{cn,ou,o,c,l,st,starttime,endtime,serialnumber}
//     */
//    public void generateJKS(String[] info) {
//        try {
//            KeyStore keyStore = KeyStore.getInstance("jks");
//            keyStore.load(null, null);
//            keyStore.store(new FileOutputStream("D:/" + info[0] + ".jks"), KEYSTORE_PASSWORD.toCharArray());
//        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 使用空的jks创建自己的jks String[]
//     * info长度为9，分别是{cn,ou,o,c,l,st,starttime,endtime,serialnumber}
//     */
//    public void storeJKS(String[] info, KeyPair keyPair_root, KeyPair keyPair_user) {
//        KeyStore keyStore;
//        try {
//            // use exited jks file
//            keyStore = KeyStore.getInstance("JKS");
//            keyStore.load(new FileInputStream("D:/" + info[0] + ".jks"), KEYSTORE_PASSWORD.toCharArray());
//            // generate user's keystore by info[8] -----keypair
//            X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();
//            certGen.setSerialNumber(new BigInteger(info[8]));
//            certGen.setIssuerDN(new X509Name("CN=huahua, OU=hnu, O=university , C=china"));
//            certGen.setNotBefore(new Date(Long.parseLong(info[6])));
//            certGen.setNotAfter(new Date(Long.parseLong(info[7])));
//            certGen.setSubjectDN(new X509Name("C=" + info[0] + ",OU=" + info[1] + ",O=" + info[2] + ",C=" + info[3]
//                    + ",L=" + info[4] + ",ST=" + info[3]));
//            certGen.setPublicKey(keyPair_user.getPublic());
//            certGen.setSignatureAlgorithm("SHA1WithRSA");
//            X509Certificate cert = null;
//            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
//            cert = certGen.generateX509Certificate(keyPair_root.getPrivate(), "BC");
//            X509Certificate[] chain = new X509Certificate[1];
//            chain[0] = cert;
//            keyStore.setKeyEntry("mykey", keyPair_user.getPrivate(), KEYSTORE_PASSWORD.toCharArray(), chain);
//            keyStore.setCertificateEntry("single_cert", cert);
//            keyStore.store(new FileOutputStream("D:/" + info[0] + ".jks"), KEYSTORE_PASSWORD.toCharArray());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 公私钥公共方法
//     */
//    /**
//     * 根据seed产生密钥对
//     * 
//     * @param seed
//     * @return
//     * @throws NoSuchAlgorithmException
//     */
//    public KeyPair generateKeyPair(int seed) throws NoSuchAlgorithmException {
//        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
//        kpg.initialize(1024, new SecureRandom(new byte[seed]));
//        KeyPair keyPair = kpg.generateKeyPair();
//        return keyPair;
//    }
//
//    public static final String PKCS12 = "PKCS12";
//
//    /**
//     * 转换成pfx格式
//     * 
//     * @param info
//     */
//    public Boolean toPFX(String[] info) {
//        try {
//            String pfx_keystore_file = "D:/" + info[0] + ".pfx";
//            String jkx_keystore_file = "D:/" + info[0] + ".jks";
//            KeyStore inputKeyStore = KeyStore.getInstance("JKS");
//            FileInputStream fis = new FileInputStream(jkx_keystore_file);
//            char[] nPassword = null;
//            if ((KEYSTORE_PASSWORD == null) || KEYSTORE_PASSWORD.trim().equals("")) {
//                nPassword = null;
//            } else {
//                nPassword = KEYSTORE_PASSWORD.toCharArray();
//            }
//            inputKeyStore.load(fis, nPassword);
//            fis.close();
//            KeyStore outputKeyStore = KeyStore.getInstance("PKCS12");
//            outputKeyStore.load(null, KEYSTORE_PASSWORD.toCharArray());
//            Enumeration enums = inputKeyStore.aliases();
//            while (enums.hasMoreElements()) {
//                String keyAlias = (String) enums.nextElement();
//                System.out.println("alias=[" + keyAlias + "]");
//                if (inputKeyStore.isKeyEntry(keyAlias)) {
//                    Key key = inputKeyStore.getKey(keyAlias, nPassword);
//                    java.security.cert.Certificate[] certChain = inputKeyStore.getCertificateChain(keyAlias);
//                    outputKeyStore.setKeyEntry(keyAlias, key, KEYSTORE_PASSWORD.toCharArray(), certChain);
//                }
//            }
//            FileOutputStream out = new FileOutputStream(pfx_keystore_file);
//            outputKeyStore.store(out, nPassword);
//            out.close();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("toPFX :" + e.getMessage());
//            return false;
//        }
//    }
//
//    public boolean createPublicKey(String[] info) {
//        try {
//            KeyPair keyPair_root = generateKeyPair(10);
//            KeyPair keyPair_user = generateKeyPair(100);
//            X509Certificate cert = generateCert(info, keyPair_root, keyPair_user);
//            String certPath = path + info[0] + ".cer";
//            FileOutputStream fos = new FileOutputStream(certPath);
//            BASE64Encoder encoder = new BASE64Encoder();
//            String string = encoder.encode(cert.getEncoded());
//            System.out.println(string);
//            fos.write(cert.getEncoded());
//            fos.close();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("public key :" + e.getMessage());
//            return false;
//        }
//    }
//
//    public boolean createPublicKeyBYDecode(String[] info) {
//        try {
//            KeyPair keyPair_root = generateKeyPair(10);
//            KeyPair keyPair_user = generateKeyPair(100);
//            X509Certificate cert = generateCert(info, keyPair_root, keyPair_user);
//            String certPath = path + info[0] + "_base.cer";
//
//            FileWriter wr = new java.io.FileWriter(new File(certPath));
//            String encode = new BASE64Encoder().encode(cert.getEncoded());
//            String strCertificate = "-----BEGIN CERTIFICATE-----\r\n" + encode + "\r\n-----END CERTIFICATE-----\r\n";
//
//            wr.write(strCertificate); // 给证书编码
//            wr.flush();
//            wr.close();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("public key :" + e.getMessage());
//            return false;
//        }
//    }
//
//    public X509Certificate fromString(String cert) {
//        try {
//            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
//            String strCertificate = "-----BEGIN CERTIFICATE-----\n" + cert + "\n-----END CERTIFICATE-----\n";
//            java.io.ByteArrayInputStream streamCertificate = new java.io.ByteArrayInputStream(
//                    strCertificate.getBytes("UTF-8"));
//            return (X509Certificate) certificateFactory.generateCertificate(streamCertificate);
//        } catch (Exception ex) {
//
//            System.out.println(ex.getMessage());
//        }
//        return null;
//    }
//
//    public boolean createPrivateKey(String[] info) {
//        try {
//            KeyPair keyPair_root = generateKeyPair(10);
//            KeyPair keyPair_user = generateKeyPair(100);
//            generateJKS(info);
//            storeJKS(info, keyPair_root, keyPair_user);
//            return true;
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//            System.out.println("private key :" + e.getMessage());
//            return false;
//        }
//    }
//
//    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException,
//            NoSuchProviderException, SecurityException, SignatureException, CertificateEncodingException, IOException {
//        DataCertCreate dataCertCreate = new DataCertCreate();
//        String[] info = { "huahua_user", "hnu", "university", "china", "hunan", "changsha", "111111", "11111111", "1" };
//        // 生成公钥
//        boolean createPublicKey = dataCertCreate.createPublicKey(info);
//        System.out.println("PUBLIC KEY CREATE OK, result==" + createPublicKey);
//
//        boolean createPublicKeyBYDecode = dataCertCreate.createPublicKeyBYDecode(info);
//        System.out.println("PUBLIC KEY BY BASE64Encoder CREATE OK, result==" + createPublicKeyBYDecode);
//
//        boolean createPrivateKey = dataCertCreate.createPrivateKey(info);
//        System.out.println("PRIVATE KEY CREATE OK, result==" + createPrivateKey);
//
//        Boolean pfx = dataCertCreate.toPFX(info);
//        System.out.println("transToPFX OK, result==" + pfx);
//    }
//}