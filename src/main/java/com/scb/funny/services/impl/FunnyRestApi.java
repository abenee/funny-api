package com.scb.funny.services.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.scb.funny.exception.ServiceException;
import com.scb.funny.services.FunnyServices;

@RestController
public class FunnyRestApi {
	
	@RequestMapping(
		value="/funny/",
		method=RequestMethod.POST)
	@ResponseBody
	public String funnyPost(@RequestParam String funnyStr) throws ServiceException {
		String resp = new String();
		try {
			resp = new FunnyServices().funny(funnyStr);
		} catch (ServiceException ex){
			throw new ServiceException(ex.getMessage());
		}
		return resp;
	} 
	
	@RequestMapping(
		value="/funny/",
		method=RequestMethod.GET)
	@ResponseBody
	public String funnyGet(@RequestParam String funnyStr) throws ServiceException {		
		String resp = new String();
		try {
			resp = new FunnyServices().funny(funnyStr);
		} catch (ServiceException ex){
			throw new ServiceException(ex.getMessage());
		}
		return resp;
	} 
}