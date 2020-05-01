package com.scb.funny.util;


import org.apache.commons.lang3.StringUtils;

public class AlphabetUtil {
		
	public static boolean isAlphaBet(String st) {
		st = StringUtils.deleteWhitespace(st);
		return StringUtils.isAlpha(st);
	}
}