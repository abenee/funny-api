package com.scb.funny.services.impl;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.scb.funny.bean.FunnyRequest;
import com.scb.funny.bean.FunnyResponse;
import com.scb.funny.exception.ServiceException;
import com.scb.funny.util.AlphabetUtil;
import com.scb.funny.util.Base64Util;
import com.scb.funny.util.ReplaceSpaceUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FunnyRestApi {
	
	@RequestMapping(
		value="/funny/",
		method=RequestMethod.POST,
		produces="application/json",
		consumes="application/json")
	@ResponseBody
	public FunnyResponse funnyPost(@RequestBody FunnyRequest req) throws ServiceException {
		log.info("Request MSG:"+new Gson().toJson(req));
		String funnyStr = req.getFunnyStr();
		FunnyResponse resp = new FunnyResponse();
		try {
			if (funnyStr!=null && funnyStr!="") {
				 funnyStr = Base64Util.decode(funnyStr); //original input
				 log.info("Original :"+ funnyStr);
				 
				 if (!AlphabetUtil.isAlphaBet(funnyStr)) { //check input is Alphabet
					 throw new ServiceException("It's not AlphaBet");
				 }
				 
				 funnyStr = funnyStr.toLowerCase();	//make as lower case
				 log.info("lower case :"+ funnyStr);
				 
				 funnyStr = ReplaceSpaceUtil.asNumber(funnyStr); //replace white space as numeric
				 
				 funnyStr = StringUtils.reverse(funnyStr); //reverse string
				 
				 funnyStr = Base64Util.encode(funnyStr); //encode response
				 				
				 resp.setFunnyStr(funnyStr);
			} else {
				throw new ServiceException("Input can not be null");
			}
		} catch (ServiceException ex){
			throw new ServiceException(ex.getMessage());
		} 
		
		log.info("Response MSG:"+new Gson().toJson(resp));
		return resp;
	} 
	
	@RequestMapping(
		value="/funny/",
		method=RequestMethod.GET)
	@ResponseBody
	public FunnyResponse funnyGet(@RequestParam String funnyStr) throws ServiceException {
		log.info("Request MSG:"+ funnyStr);
		
		FunnyResponse resp = new FunnyResponse();
		try {
			if (funnyStr!=null && funnyStr!="") {
				 funnyStr = Base64Util.decode(funnyStr); //original input
				 log.info("Original :"+ funnyStr);
				 
				 if (!AlphabetUtil.isAlphaBet(funnyStr)) { //check input is Alphabet
					 throw new ServiceException("It's not AlphaBet");
				 }
				 
				 funnyStr = funnyStr.toLowerCase();	//make as lower case
				 log.info("lower case :"+ funnyStr);
				 
				 funnyStr = ReplaceSpaceUtil.asNumber(funnyStr); //replace white space as numeric
				 
				 funnyStr = StringUtils.reverse(funnyStr); //reverse string
				 
				 funnyStr = Base64Util.encode(funnyStr); //encode response
				 				
				 resp.setFunnyStr(funnyStr);
			} else {
				throw new ServiceException("Input can not be null");
			}
		} catch (ServiceException ex){
			throw new ServiceException(ex.getMessage());
		} 
		
		log.info("Response MSG:"+new Gson().toJson(resp));
		return resp;
	} 
}