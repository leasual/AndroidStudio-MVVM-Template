package com.mvvm.javademo.util.Aes256cbc;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encode {

	// Latest CBC method due to 212 server only support this as php 7.1

	public static String getEncode(String src, String time){
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			int ivsize=cipher.getBlockSize();

			String randomIV = GenerateRandomIV(ivsize);

			cipher.init(Cipher.ENCRYPT_MODE, makeKey(time), makeIv(randomIV));
			return Base64.encodeBytes(randomIV.getBytes()) + Base64.encodeBytes(cipher.doFinal(src.getBytes()));

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static String GenerateRandomIV(int n){
		char[] chars1 = "ABCDEF012GHIJKL345MNOPQR678STUVWXYZ9".toCharArray();
		StringBuilder sb1 = new StringBuilder();
		Random random1 = new Random();
		for (int i = 0; i < n; i++)
		{
			char c1 = chars1[random1.nextInt(chars1.length)];
			sb1.append(c1);
		}
		String random_string = sb1.toString();
		return random_string;
	}

	private static AlgorithmParameterSpec makeIv(String iv) {
		try {
			return new IvParameterSpec(iv.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static SecretKeySpec makeKey(String time) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			String keys = "REMOTEBLE_CLOUD_166_";
			String md5Time = MD5.getMD5(time);
			keys += md5Time;
			byte[]  key  =  keys.getBytes("UTF-8");
			return new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
