package com.scb.funny.services.impl;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.scb.funny.bean.funnyRequest;
import com.scb.funny.bean.funnyResponse;

@RestController
public class funnyRestApi {
	

	@RequestMapping(
		value="/", 
		method=RequestMethod.POST,
		produces="application/json",
		consumes="application/json")
	@ResponseBody
	public funnyResponse funnyApi(@RequestBody funnyRequest funnyStr) throws Exception {
		funnyResponse resp = new funnyResponse();
		try {
			if (funnyStr!=null) {
				resp.setFunnyStr(funnyStr.getFunnyStr()+" very funny");
			} else {
				resp.setFunnyStr("it's not funny");
			}
		} catch (Exception ex){
			
		}
		
		return resp;
	} 
}