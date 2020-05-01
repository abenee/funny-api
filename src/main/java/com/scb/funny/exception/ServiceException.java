package com.scb.funny.exception;

public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1973409118711923931L;

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(Throwable ex) {
		super(ex);
	}
}
