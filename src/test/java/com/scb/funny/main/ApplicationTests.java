package com.scb.funny.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void restApi() {
		String req = "TVkgIE5BTUUgICBJUyAgICBCRU4=";
		ResponseEntity<String> resp = this.restTemplate.getForEntity("/funny/?funnyStr="+req, String.class);
		assertEquals("bmViNHNpM2VtYW4yeW0=", resp.getBody());
		assertEquals(HttpStatus.OK, resp.getStatusCode());
	}
}