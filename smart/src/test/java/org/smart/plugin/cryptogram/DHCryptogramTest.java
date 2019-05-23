package org.smart.plugin.cryptogram;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.plugin.cryptogram.DHCryptogram;

public class DHCryptogramTest {
	@Test
	public void test() throws Exception {
		// 生成甲方密钥对儿
		Map<String, Object> aKeyMap = DHCryptogram.initKey();
		String aPublicKey = DHCryptogram.getPublicKey(aKeyMap);
		String aPrivateKey = DHCryptogram.getPrivateKey(aKeyMap);

		System.err.println("甲方公钥:\r" + aPublicKey);
		System.err.println("甲方私钥:\r" + aPrivateKey);

		// 由甲方公钥产生本地密钥对儿
		Map<String, Object> bKeyMap = DHCryptogram.initKey(aPublicKey);
		String bPublicKey = DHCryptogram.getPublicKey(bKeyMap);
		String bPrivateKey = DHCryptogram.getPrivateKey(bKeyMap);

		System.err.println("乙方公钥:\r" + bPublicKey);
		System.err.println("乙方私钥:\r" + bPrivateKey);

		String aInput = "abc ";
		System.err.println("原文: " + aInput);

		// 由甲方公钥，乙方私钥构建密文
		byte[] aCode = DHCryptogram.encrypt(aInput.getBytes(), aPublicKey, bPrivateKey);

		// 由乙方公钥，甲方私钥解密
		byte[] aDecode = DHCryptogram.decrypt(aCode, bPublicKey, aPrivateKey);
		String aOutput = (new String(aDecode));

		System.err.println("解密: " + aOutput);

		assertEquals(aInput, aOutput);

		System.err.println(" ===============反过来加密解密================== ");
		String bInput = "def ";
		System.err.println("原文: " + bInput);

		// 由乙方公钥，甲方私钥构建密文
		byte[] bCode = DHCryptogram.encrypt(bInput.getBytes(), bPublicKey, aPrivateKey);

		// 由甲方公钥，乙方私钥解密
		byte[] bDecode = DHCryptogram.decrypt(bCode, aPublicKey, bPrivateKey);
		String bOutput = (new String(bDecode));

		System.err.println("解密: " + bOutput);

		assertEquals(bInput, bOutput);
	}
}
