package org.smart.plugin.cryptogram;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.plugin.cryptogram.ECCCryptogram;

public class ECCCryptogramTest {

	@Test
	public void test() throws Exception {
		String inputStr = "abc";
		byte[] data = inputStr.getBytes();

		Map<String, Object> keyMap = ECCCryptogram.initKey();

		String publicKey = ECCCryptogram.getPublicKey(keyMap);
		String privateKey = ECCCryptogram.getPrivateKey(keyMap);
		System.err.println("公钥: \n" + publicKey);
		System.err.println("私钥： \n" + privateKey);

		byte[] encodedData = ECCCryptogram.encrypt(data, publicKey);

		byte[] decodedData = ECCCryptogram.decrypt(encodedData, privateKey);

		String outputStr = new String(decodedData);
		System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
		assertEquals(inputStr, outputStr);
	}
}
