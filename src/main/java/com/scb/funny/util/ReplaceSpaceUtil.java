package com.scb.funny.util;

import org.apache.commons.lang3.StringUtils;

public class ReplaceSpaceUtil {
	
	public static String asNumber(String st) {
		for (int i = 1; i < st.length(); i++) {
			st = StringUtils.replace(st, " ", Integer.toString(i), 1);
		}
		return st;
	}
}
