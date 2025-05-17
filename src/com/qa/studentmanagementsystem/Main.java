package com.qa.studentmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static List<Student> stu;
	
	public static void main(String[] args) {
		System.out.println("****************************Student Management System******************************");
		System.out.println("****************************Welcome******************************");
		
		Student s1= new Student("Radha", 20, "S-1");
		s1.enrollCourse("Java");
		s1.enrollCourse("Java");
		s1.enrollCourse("DevOps");
		s1.enrollCourse("C#");
		String student1=s1.toString();
		System.out.println(student1);	
		
		System.out.println("******************************************************");
		
		Student s2= new Student("Radha Krishna", 19, "S-2");
		s2.enrollCourse("DSA");
		s2.enrollCourse("QATesting");
		String student2=s2.toString();
		System.out.println(student2);	
		
		System.out.println("*****************************************************");
		
		Student s3= new Student("Kiran", 19, "S-3");			//validation failed- it is printing default values and error message
		s3.enrollCourse("DSA");
		s3.enrollCourse("JAVA");
		String student3=s3.toString();
		System.out.println(student3);	
		
		
//		stu=new ArrayList<Student>();
//		stu.add(s1);
//		stu.add(s2);
//		stu.add(s3);
//		System.out.println(stu.size());
	}
	
//	public Student findStudentById(String studentId){
//		if(stu.contains(studentId)) {
//			System.out.println(stu);
//		}
//		else {
//			throw new RuntimeException("Student is not found")
//		}
//		
//		return stu;
		
//	}
	
	
	


}
