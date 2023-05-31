package com.softra.model;

import java.io.Serializable;

public class Student implements Serializable {
	private int sid;
	private String name;
	private Integer age;
	private Integer mobile;
	private String address;
	
	public Student() {}

	public Student(String name, Integer age, Integer mobile, String address) {
		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
	}
	
	public Student(int id, String name, Integer age, Integer mobile, String address) {
		super();
		this.sid = id;
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int id) {
		this.sid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", age=" + age + ", mobile=" + mobile + ", address=" + address + "]";
	}
}
