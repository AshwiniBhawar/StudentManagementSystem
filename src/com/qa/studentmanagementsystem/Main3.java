package com.qa.studentmanagementsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {
	
	private static List<Student> studlist;
	
	public static void main(String[] args) {
		System.out.println("****************************Student Management System******************************");
		System.out.println("****************************Welcome******************************");
		studlist=new ArrayList<Student>();
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter student name: ");
		String name=sc.next();
		System.out.println("You have entered the name: "+name);
		
		System.out.println("Enter student age:");
		int age=sc.nextInt();
		System.out.println("The student age is: "+age);
		
		System.out.println("Enter student id:");
		String studentid=sc.next();
		System.out.println("The student id is: "+studentid);
		
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
	

