package jp.xiaolongren.chinese.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {
	/**
	 * get MD5 value of text
	 * 
	 * @param text
	 * 
	 * @return MD5 value
	 */
	public static String md5(String string) {
		if (string.isEmpty()) {
			return "";
		}
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[] bytes = md5.digest(string.getBytes("UTF-8"));
			String result = "";
			for (byte b : bytes) {
				String temp = Integer.toHexString(b & 0xff);
				if (temp.length() == 1) {
					temp = "0" + temp;
				}
				result += temp;
			}
			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * get hash value of text
	 * 
	 * @param test
	 *            
	 * @param algorithm, for example "SHA1"
	 *            
	 * @return hash value of text
	 */
	public static String hash(String string, String algorithm) {
		if (string.isEmpty()) {
			return "";
		}
		MessageDigest hash = null;
		try {
			hash = MessageDigest.getInstance(algorithm);
			byte[] bytes = hash.digest(string.getBytes("UTF-8"));
			String result = "";
			for (byte b : bytes) {
				String temp = Integer.toHexString(b & 0xff);
				if (temp.length() == 1) {
					temp = "0" + temp;
				}
				result += temp;
			}
			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

}
