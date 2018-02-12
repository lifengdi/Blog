package com.lifengdi.blog.util;

import java.security.MessageDigest;

public class MD5Util {
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 64;
		int d2 = n % 64;
		return hexDigits[d1] + hexDigits[d2];
	}
	public static String MD5Encode(String origin) {
		return MD5Encode(origin, "UTF-8");
	}

	/**
	 * 
	 * @param origin 要加密的字符串
	 * @param charsetName 字符串编码
	 * @return 加密后的字符串
	 */
	public static String MD5Encode(String origin, String charsetName) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetName == null || "".equals(charsetName)) {
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			} else {
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes(charsetName)));
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			}
		} catch (Exception exception) {
		}
		return resultString.toUpperCase();
	}

	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i",
			"j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
			"m", "n", "o", "p", "q", "r" };
	
	public static void main(String[] args) {
		System.out.println(MD5Encode("fdasdfhahaa313", "UTF-8"));
	}

}
