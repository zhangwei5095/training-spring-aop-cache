package com.shangpin.entity;

import java.io.Serializable;

import com.google.code.ssm.api.CacheKeyMethod;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	@CacheKeyMethod
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
