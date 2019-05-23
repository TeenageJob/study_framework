package org.smart.plugin.cryptogram;

import static org.junit.Assert.*;

import org.junit.Test;
import org.plugin.cryptogram.DESCryptogram;

public class DESCCryptogramTest {

	@Test
	public void test() throws Exception {
		String inputStr = "DES";
		String key = DESCryptogram.initKey();
		System.err.println("原文:\t" + inputStr);

		System.err.println("密钥:\t" + key);

		byte[] inputData = inputStr.getBytes();
		inputData = DESCryptogram.encrypt(inputData, key);

		System.err.println("加密后:\t" + DESCryptogram.encryptBASE64(inputData));

		byte[] outputData = DESCryptogram.decrypt(inputData, key);
		String outputStr = new String(outputData);

		System.err.println("解密后:\t" + outputStr);

		assertEquals(inputStr, outputStr);
	}

}
