package com.demo.springboot.helloworld;

public class Image {
	private int id;
	private String name;
	private String url;
	private int year;
	private String color;
	private String pantonevalue;
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPantonevalue() {
		return pantonevalue;
	}

	public void setPantonevalue(String pantonevalue) {
		this.pantonevalue = pantonevalue;
	}

	public Image(int id, String name, String url) {
		this.id = id;
		this.name = name;
		this.url = url;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}