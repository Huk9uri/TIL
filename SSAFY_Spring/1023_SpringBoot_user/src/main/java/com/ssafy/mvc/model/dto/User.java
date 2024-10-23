package com.ssafy.mvc.model.dto;

public class User {
	private int userNum; // auto_increment
	private String id;
	private String password;
	private String name;
	private String grade; // grade table - 교수 / 반장 / CA // String 이면 팔요업서
	private String region; // 캠퍼스 
	private String classNum; // 반 
	// 각 캠퍼스마다 몇반까지 있는지 ? 아니면 반 별로 따로 select option 설정 가능한지 
	private int point; 
	
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getClassNum() {
		return classNum;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
