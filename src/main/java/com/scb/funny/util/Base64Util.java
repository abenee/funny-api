package com.scb.funny.util;

import org.springframework.util.Base64Utils;

public class Base64Util {
	
	public static String encode(String str) {
		return str != null ? Base64Utils.encodeToString(str.getBytes()) : null;
	}

	public static String decode(String str) {
		return str != null ? new String(Base64Utils.decodeFromString(str)) : null;
	}
}