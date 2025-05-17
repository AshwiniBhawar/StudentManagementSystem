package com.qa.studentmanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	private String name;
	private int age;
	private String studentId;
	private List<String> courses;

	public Student(String name, int age, String studentId) {

		if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>(); // Initialization of courses
		}
	}

	private boolean validateStudentId(String studentId) {
		String studentIdRegex = "^S-[0-9]+$";
		// String studentIdRegex="S-\\d+$";
		Pattern studentIdPattern = Pattern.compile(studentIdRegex);
		Matcher studentIdMatcher = studentIdPattern.matcher(studentId);
		if (studentIdMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid studentId!! Use the format e.g.....S-123");
			return false;
		}

	}

	public void enrollCourse(String course) {
		if(validateCoursename(course)) {
		if (!courses.contains(course)) {
			courses.add(course);
			System.out.println("Student is enrolled to " + course + " successfully!!");
		}	
		else{
			System.err.println("Student is already enrolled to the Course " + course);
		}
		}
	}
	
	public boolean validateCoursename(String course) {
		if (course.equalsIgnoreCase("Java")|| course.equalsIgnoreCase("DSA")||course.equalsIgnoreCase("DevOps")||course.equalsIgnoreCase("QATesting")) {
			return true;
		}	
		else{
			System.err.println("Invalid course name!! Please select Courses from the list!![Java, DSA, DevOps, QATesting]");
			return false;
		}
	}

	public void printStudentInfo() {
		System.out.println("***********************Student Information***********************");
		System.out.println("Student name: " + name);
		System.out.println("Student age: " + age);
		System.out.println("Student studentId: " + studentId);
		System.out.println("Student courses: " + courses);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	// validation methods
	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) { // both condition need to be true
			return true;
		} else {
			System.err.println("Invalid age!! Students age needs to be between 19 and 35");
			return false;
		}
	}

	public boolean validateName(String name) {
		String nameRegex = "^[a-zA-z\\s]+";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid name!! Please enter alphabets only");
			return false;
		}

	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

}
