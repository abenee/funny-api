package com.scb.funny.util;

import org.springframework.util.Base64Utils;

public class Base64Util {
	
	public static String encode(String string) {
		return string != null ? Base64Utils.encodeToString(string.getBytes()) : null;
	}

	public static String decode(String string) {
		return string != null ? new String(Base64Utils.decodeFromString(string)) : null;
	}
}
