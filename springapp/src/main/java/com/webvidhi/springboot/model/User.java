package com.webvidhi.springboot.model;

import java.io.Serializable;



public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long id;
	
	String username;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User(long l, String username) {
		super();
		this.id = l;
		this.username = username;
	}
	

}
