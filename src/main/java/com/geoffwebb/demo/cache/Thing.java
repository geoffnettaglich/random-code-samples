package com.geoffwebb.demo.cache;

import java.io.Serializable;

public class Thing implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public Thing(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
