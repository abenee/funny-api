package com.scb.funny.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlphabetUtilTest {

	@Test
	public void alphabet() {
		String funnyStr = "My name is Ben";
		String funnyErr = "26/08/1992";
		boolean resp = AlphabetUtil.isAlphaBet(funnyStr);
		assertTrue(resp);
		boolean respErr = AlphabetUtil.isAlphaBet(funnyErr);
		assertFalse(respErr);
	}
}
