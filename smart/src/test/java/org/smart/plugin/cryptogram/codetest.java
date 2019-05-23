package org.smart.plugin.cryptogram;

import java.math.BigInteger;

import org.plugin.cryptogram.Cryptogram;
import org.plugin.security.SecurityHelper;

public class codetest {

	public static void main(String[] args) throws Exception {
		System.out.println(SecurityHelper.encrypt("123"));
		String inputStr = "123";
		System.err.println("原文:\n" + inputStr);

		byte[] inputData = inputStr.getBytes();
		BigInteger md5 = new BigInteger(Cryptogram.encryptMD5(inputData));
		System.err.println("MD5:\n" + md5.toString(16));
	}
}
