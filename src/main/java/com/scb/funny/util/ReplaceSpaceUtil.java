package com.scb.funny.util;

import org.apache.commons.lang3.RegExUtils;

public class ReplaceSpaceUtil {
	
	public static String asNumber(String st) {
		for (int i = 1; i < st.length(); i++) {
			int count =0;
			for (int j = 0; j < st.length(); j++) {
				if(Character.isWhitespace(st.charAt(j))) {
					count++;
				} 
				if (count!=0 && !Character.isWhitespace(st.charAt(j+1))) {
					break;
				}
			}
			st = RegExUtils.replaceFirst(st.trim()," +", Integer.toString(count));
		}
		return st;
	}
}
