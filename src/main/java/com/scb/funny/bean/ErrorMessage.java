package com.scb.funny.bean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ErrorMessage {
	
	private Date timeStamp;
	private String errorCode;
	private String errorDesc;
	
	public ErrorMessage(Date time, String code, String desc) {
	    super();
	    this.timeStamp = time;
	    this.errorCode = code;
	    this.errorDesc = desc;
	  }
}
