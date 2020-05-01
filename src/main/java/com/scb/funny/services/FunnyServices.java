package com.scb.funny.services;

import org.apache.commons.lang3.StringUtils;

import com.scb.funny.exception.ServiceException;
import com.scb.funny.util.AlphabetUtil;
import com.scb.funny.util.Base64Util;
import com.scb.funny.util.ReplaceSpaceUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FunnyServices {
	
	public String funny(String funnyStr) {
		
		log.info("Request MSG:"+ funnyStr);
		
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
			} else {
				throw new ServiceException("Input can not be null");
			}
		} catch (ServiceException ex){
			throw new ServiceException(ex.getMessage());
		} 
		
		log.info("Response MSG:"+ funnyStr);
		
		return funnyStr;
	}
}
