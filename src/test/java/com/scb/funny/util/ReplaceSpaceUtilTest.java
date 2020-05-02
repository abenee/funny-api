package com.scb.funny.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReplaceSpaceUtilTest {

	@Test
	public void replaceNumber() {
		String funnyStr = "My name is Ben";
		String resp = ReplaceSpaceUtil.asNumber(funnyStr);
		assertEquals("My1name2is3Ben", resp);
	}
}
