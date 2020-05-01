package com.scb.funny.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.scb.funny.util.AlphabetUtil;
import com.scb.funny.util.Base64Util;
import com.scb.funny.util.ReplaceSpaceUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void base64() {
		String funnyStr = "TXkgbmFtZSBpcyBCZW4=";
		String resp = Base64Util.decode(funnyStr);
		assertEquals("My name is Ben", resp);
		resp = Base64Util.encode(resp);
		assertEquals("TXkgbmFtZSBpcyBCZW4=", resp);
	}
	
	@Test
	public void alphabet() {
		String funnyStr = "My name is Ben";
		String funnyErr = "26/08/1992";
		boolean resp = AlphabetUtil.isAlphaBet(funnyStr);
		assertTrue(resp);
		boolean respErr = AlphabetUtil.isAlphaBet(funnyErr);
		assertFalse(respErr);
	}
	
	@Test
	public void replaceNumber() {
		String funnyStr = "My name is Ben";
		String resp = ReplaceSpaceUtil.asNumber(funnyStr);
		assertEquals("My1name2is3Ben", resp);
	}
	
	@Test
	public void restApi() {
		String req = "TXkgbmFtZSBpcyBCZW4=";
		ResponseEntity<String> resp = this.restTemplate.getForEntity("/funny/?funnyStr="+req, String.class);
		assertEquals("bmViM3NpMmVtYW4xeW0=", resp.getBody());
		assertEquals(HttpStatus.OK, resp.getStatusCode());
	}
}