package com.classwork.pattern.dto.model.entity;

import java.io.Serializable;

public class Ship implements Serializable {

	private String title;
	private User owner;

	public Ship(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public String toString(){
		return String.format("{title: %s}", getTitle());
	}
}