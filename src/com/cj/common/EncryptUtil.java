package com.cj.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class EncryptUtil {

	public static String encrypt(String str) {

		try {
			MessageDigest md = MessageDigest.getInstance("md5"); // 获取md5加密算法
			byte[] bytes = md.digest(str.getBytes());
			return new String(Base64.getEncoder().encode(bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} 
		return null;
	}
}
