package com.scb.funny.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Base64UtilTest {

	@Test
	public void base64() {
		String funnyStr = "TXkgbmFtZSBpcyBCZW4=";
		String resp = Base64Util.decode(funnyStr);
		assertEquals("My name is Ben", resp);
		resp = Base64Util.encode(resp);
		assertEquals("TXkgbmFtZSBpcyBCZW4=", resp);
	}
}
