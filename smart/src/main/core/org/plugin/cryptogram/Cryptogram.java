package org.plugin.cryptogram;

import java.security.MessageDigest;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 如基本的单向加密算法： <br>
 * BASE64 严格地说，属于编码格式，而非加密算法 <br>
 * MD5(Message Digest algorithm 5，信息摘要算法) <br>
 * SHA(Secure Hash Algorithm，安全散列算法) <br>
 * HMAC(Hash Message Authentication <br>
 * Code，散列消息鉴别码)
 * 
 * 复杂的对称加密（DES、PBE）、非对称加密算法： <br>
 * DES(Data Encryption Standard，数据加密算法) <br>
 * PBE(Password-based encryption，基于密码验证) <br>
 * RSA(算法的名字以发明者的名字命名：Ron Rivest,AdiShamir 和Leonard Adleman) <br>
 * DH(Diffie-Hellman算法，密钥一致协议) <br>
 * DSA(Digital Signature Algorithm，数字签名) <br>
 * ECC(Elliptic Curves Cryptography，椭圆曲线密码编码学)
 * 
 * @author TY
 * @Time 2017年12月24日 下午8:12:39
 * @since 1.0.0
 */
@SuppressWarnings("restriction")
public class Cryptogram {

	public static final String KEY_SHA = "SHA";
	public static final String KEY_MD5 = "MD5";

	/**
	 * MAC算法可选以下多种算法
	 * 
	 * <pre>
	 *  
	 * HmacMD5  
	 * HmacSHA1  
	 * HmacSHA256  
	 * HmacSHA384  
	 * HmacSHA512
	 * </pre>
	 */
	public static final String KEY_MAC = "HmacMD5";

	/**
	 * BASE64解密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String key) throws Exception {
		return (new BASE64Decoder()).decodeBuffer(key);
	}

	/**
	 * BASE64加密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] key) throws Exception {
		return (new BASE64Encoder()).encodeBuffer(key);
	}

	/**
	 * MD5加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptMD5(byte[] data) throws Exception {

		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		md5.update(data);

		return md5.digest();

	}

	/**
	 * SHA加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptSHA(byte[] data) throws Exception {

		MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
		sha.update(data);

		return sha.digest();

	}

	/**
	 * 初始化HMAC密钥
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String initMacKey() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);

		SecretKey secretKey = keyGenerator.generateKey();
		return encryptBASE64(secretKey.getEncoded());
	}

	/**
	 * HMAC加密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptHMAC(byte[] data, String key) throws Exception {

		SecretKey secretKey = new SecretKeySpec(decryptBASE64(key), KEY_MAC);
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);

		return mac.doFinal(data);

	}
}
