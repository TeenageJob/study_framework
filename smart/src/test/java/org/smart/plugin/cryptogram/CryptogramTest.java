package org.smart.plugin.cryptogram;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;
import org.plugin.cryptogram.Cryptogram;

public class CryptogramTest {

	@Test
	public void test() throws Exception {
		String inputStr = "123";
		System.err.println("原文:\n" + inputStr);

		byte[] inputData = inputStr.getBytes();
		String code = Cryptogram.encryptBASE64(inputData);

		System.err.println("BASE64加密后:\n" + code);

		byte[] output = Cryptogram.decryptBASE64(code);

		String outputStr = new String(output);

		System.err.println("BASE64解密后:\n" + outputStr);

		// 验证BASE64加密解密一致性
		assertEquals(inputStr, outputStr);

		// 验证MD5对于同一内容加密是否一致
		assertArrayEquals(Cryptogram.encryptMD5(inputData), Cryptogram.encryptMD5(inputData));

		// 验证SHA对于同一内容加密是否一致
		assertArrayEquals(Cryptogram.encryptSHA(inputData), Cryptogram.encryptSHA(inputData));

		String key = Cryptogram.initMacKey();
		System.err.println("Mac密钥:\n" + key);

		// 验证HMAC对于同一内容，同一密钥加密是否一致
		assertArrayEquals(Cryptogram.encryptHMAC(inputData, key), Cryptogram.encryptHMAC(inputData, key));

		BigInteger md5 = new BigInteger(Cryptogram.encryptMD5(inputData));
		System.err.println("MD5:\n" + md5.toString(16));

		BigInteger sha = new BigInteger(Cryptogram.encryptSHA(inputData));
		System.err.println("SHA:\n" + sha.toString(32));

		BigInteger mac = new BigInteger(Cryptogram.encryptHMAC(inputData, inputStr));
		System.err.println("HMAC:\n" + mac.toString(16));
	}
}
