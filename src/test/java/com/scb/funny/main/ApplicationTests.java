package com.scb.funny.main;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
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
		assertThat(resp).isEqualTo("My name is Ben");
		resp = Base64Util.encode(resp);
		assertThat(resp).isEqualTo("TXkgbmFtZSBpcyBCZW4=");
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
		assertThat(resp).isEqualTo("My1name2is3Ben");
	}
	
	@Test
	public void restApi() {
		String req = "TXkgbmFtZSBpcyBCZW4=";
		ResponseEntity<String> resp = this.restTemplate.getForEntity("/funny/?funnyStr="+req, String.class);
		assertThat(resp.getBody()).isEqualTo("bmViM3NpMmVtYW4xeW0=");
		assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}