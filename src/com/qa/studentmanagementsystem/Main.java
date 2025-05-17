package com.qa.studentmanagementsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static List<Student> studlist;
	private static Scanner sc;
	public static void main(String[] args) {
		System.out.println("****************************Student Management System******************************");
		
		studlist=new ArrayList<Student>();
		sc= new Scanner(System.in);
		while(true) {
		System.out.println("****************************Welcome******************************");
		
		System.out.println("Select an option....");
		System.out.println("1. Register a student");
		System.out.println("2. Find student with studentId");
		System.out.println("3. List all student information");
		System.out.println("4. List student information in sorted order");
		System.out.println("5. Exit");
		
		int option=sc.nextInt();
		
		switch(option) {
		case 1:
			enrollStudent(sc); 
			break;
		case 2:
			findStudentById(sc);
			break;
		case 3:
			printAllStudentData();
			break;
		case 4: 
			sortByName();
			break;
		case 5:
			exit();
			break;
		default: 
			System.out.println("Invalid option selected!....Enter between 1 to 5");
		}
	}
	}
	
	private static void exit() {
		System.out.println("Good bye!!");
		System.exit(0);		
	}

	private static void printAllStudentData() {
		System.out.println("************************Print All Student Data************************");

		if (studlist.size() > 0) {
			for (Student list : studlist) {
				list.printStudentInfo();
			}
		} else {
			System.out.println("Student list is empty!! No student record found..");
		}
	}

	private static void findStudentById(Scanner sc2) {
		Student studentfound = null;
		System.out.println("Enter the student id: ");
		String studentid=sc2.next();
		try {
			studentfound= studlist.stream().filter(student->student.getStudentId().equalsIgnoreCase(studentid))
				.findFirst()
				.orElseThrow(()->new RuntimeException("No data found"));
		}
		catch(RuntimeException e) {
			System.err.println("Student with ID "+studentid+" not found.");
		}
		try {
		studentfound.printStudentInfo();
		}
		catch(Exception e){
			System.err.println("Enter the valid details");
			findStudentById(sc2);
		}
	}

	private static void enrollStudent(Scanner sc2) {
		System.out.println("Enter the student name: ");
		String name=sc2.next();
		System.out.println("You have entered the name: "+name);
		
		System.out.println("Enter the student age between 19-35:");
		int age=sc2.nextInt();
		System.out.println("The student age is: "+age);
		
		System.out.println("Enter the student id:");
		String studentid=sc2.next();
		
		System.out.println("The student id is: "+studentid);
		Student newstudent= new Student(name, age, studentid); 
		studlist.add(newstudent);
		while(true) {
		System.out.println("Enter the course to be enrolled..Type done to exit");
		String coursename=sc.next();
		if(coursename.equalsIgnoreCase("done")) {
			break;
		}
		newstudent.enrollCourse(coursename);
	}
		newstudent.printStudentInfo();
	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator=(o1,o2)->o1.getName().compareTo(o2.getName());
		
		/*Comparator<Student> studentNameComparator= new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};*/
				
		Collections.sort(studlist,studentNameComparator);
		System.out.println(studlist); 
		printAllStudentData();
	}

	public static Student findStudentById(String studentId){
		Student result = null;
		try {
		result= studlist.stream().filter(x->x.getStudentId().equalsIgnoreCase(studentId))
				.findFirst()
				.orElseThrow(()->new RuntimeException("No data found"));
		}
		catch(RuntimeException e) {
			System.err.println("Student with ID "+studentId+" not found.");
		}
		
		return result;
		
		/*try {
		for(Student list:studlist) {
			if(list.getStudentId().contains(studentId)) {
				result=list;
				break;
			}
			}
		if(result==null) {
			throw new RuntimeException();
		}
		}
		catch(Exception e){
		 		System.err.println("Student with ID "+studentId+" not found.");
		}
		return result;*/
		 
	}
}
	

