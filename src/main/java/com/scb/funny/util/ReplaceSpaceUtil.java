package com.scb.funny.util;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReplaceSpaceUtil {
	
	public static String asNumber(String st) {
		log.info("st length :"+ st.length());
		for (int i = 1; i < st.length(); i++) {
			st = StringUtils.replace(st, " ", Integer.toString(i), 1);
		}

		return st;
	}
}
