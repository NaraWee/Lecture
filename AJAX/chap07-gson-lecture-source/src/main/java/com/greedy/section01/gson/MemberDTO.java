package com.greedy.section01.gson;

import java.sql.Date;

import com.google.gson.annotations.SerializedName;

public class MemberDTO implements java.io.Serializable {
	
	@SerializedName("memberCode")
	private String code;
	private String firstName;
	private String lastName;
	private int age;
	
	private java.sql.Date enrollDate;

	public MemberDTO() {}

	public MemberDTO(String code, String firstName, String lastName, int age, Date enrollDate) {
		super();
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.enrollDate = enrollDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		return "MemberDTO [code=" + code + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", enrollDate=" + enrollDate + "]";
	}

}
