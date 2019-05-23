package org.smart.plugin.cryptogram;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.plugin.cryptogram.DSACryptogram;

public class DSACryptogramTest {
	@Test
	public void test() throws Exception {
		String inputStr = "abc";
		byte[] data = inputStr.getBytes();

		// 构建密钥
		Map<String, Object> keyMap = DSACryptogram.initKey();

		// 获得密钥
		String publicKey = DSACryptogram.getPublicKey(keyMap);
		String privateKey = DSACryptogram.getPrivateKey(keyMap);

		System.err.println("公钥:\r" + publicKey);
		System.err.println("私钥:\r" + privateKey);

		// 产生签名
		String sign = DSACryptogram.sign(data, privateKey);
		System.err.println("签名:\r" + sign);

		// 验证签名
		boolean status = DSACryptogram.verify(data, publicKey, sign);
		System.err.println("状态:\r" + status);
		assertTrue(status);

	}
}
