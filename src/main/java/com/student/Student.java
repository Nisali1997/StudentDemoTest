package com.student;

public class Student {

	private int id;
	//private String id;
	private String name;
	private String age;
	private String phone;
    private String password;

	public Student( int id, String name, String age, String phone,  String password) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.password = password;
	}

	 public int getId() {
	        return id;
	    }

	public String getName() {
		return name;
	}
	
	public String getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}
	
	public String getPassword() {
        return password;
    } 
}
