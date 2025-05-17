package com.qa.studentmanagementsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
	
	private static List<Student> studlist;
	
	public static void main(String[] args) {
		System.out.println("****************************Student Management System******************************");
		System.out.println("****************************Welcome******************************");
		
				
		Student s1= new Student("Radha", 20, "S-1");
		s1.enrollCourse("Java");
		System.out.println(s1);	
		
		System.out.println("******************************************************");
		
		Student s2= new Student("Radha Krishna", 19, "S-2");
		s2.enrollCourse("DSA");
		System.out.println(s2);	
		
		System.out.println("*****************************************************");
		
		Student s3= new Student("Kiran", 19, "S-3");			//validation failed- it is printing default values and error message
		s3.enrollCourse("DSA");
		System.out.println(s3);	
		
		System.out.println("*****************************************************");
		
		studlist=new ArrayList<Student>();
		studlist.add(s1);
		studlist.add(s2);
		studlist.add(s3);
//		System.out.println(studlist);
		
		Student result=findStudentById("S-1");
		if(!(result==null)){
		System.out.println("Result "+ result);
		}
	
		sortByName();
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
	

