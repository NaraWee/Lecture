package com.greedy.jackson;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MemberDTO {

	private int no;
	private String name;
	private int age;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss SSS", timezone = "Asia/Seoul")
	private java.sql.Date enrollDate;
	
	public MemberDTO() {}

	public MemberDTO(int no, String name, int age, Date enrollDate) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
		this.enrollDate = enrollDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public java.sql.Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(java.sql.Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "MemberDTO [no=" + no + ", name=" + name + ", age=" + age + ", enrollDate=" + enrollDate + "]";
	}
	
}
