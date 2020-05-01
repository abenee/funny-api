package com.scb.funny.util;


import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

public class AlphabetUtil {
		
	public static boolean isAlphaBet(String st) {
		st = StringUtils.deleteWhitespace(st);
		return StringUtils.isAlpha(st);
	}
}
