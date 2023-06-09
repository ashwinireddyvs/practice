package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import lombok.Data;

public class LambdaPractice {
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5,6,7,8,9,11,20};
		//checking whether the
		//return true if all matches
		System.out.println(Arrays.stream(arr)
			.allMatch(i->i<12)
			);
			
		System.out.println(Arrays.stream(arr)
				.anyMatch(i->i<12)
				);
				
		System.out.println(Arrays.stream(arr)
				.noneMatch(i->i>20)
				);	
		
		List<Student> st = new ArrayList<Student>();
		st.add(new Student("Saanvi",12,"Bangalore"));
		st.add(new Student("Smaran",5,"Bangalore"));
		st.add(new Student("Srihan",3,"Arnhem"));
		
		//minimum, maximum, average and total age of all the students object
		DoubleSummaryStatistics statistics = st.stream()
		.mapToDouble(Student::getAge)
		.summaryStatistics();
		
		System.out.println("SummeryStatistics : "+statistics);
		System.out.println("SummeryStatistics avg : "+statistics.getAverage());
		System.out.println("SummeryStatistics count: "+statistics.getCount());
		System.out.println("SummeryStatistics max: "+statistics.getMax());
		System.out.println("SummeryStatistics main: "+statistics.getMin());
		System.out.println("SummeryStatistics sum: "+statistics.getSum());
		
		DoubleSummaryStatistics statistics1 = st.stream()
				.filter(s->s.getAge()<10)
				.mapToDouble(Student::getAge)
				.summaryStatistics();
		
		System.out.println("SummeryStatistics : "+statistics1);
	
		
	Predicate<Student> predicate = s->s.getCity().equals("Bangalore");
	Map<Boolean,List<Student>> students = 	st.stream()
			.collect(Collectors.partitioningBy(
					predicate 
				));
	
		System.out.println("students livingin Bangalore -> "+students.get(true));
		System.out.println("students livingin Bangalore -> "+students.get(false));
		
	
		Map<String,List<Student>> grp = st.stream()
			.collect(Collectors.groupingBy(Student::getCity));
		
		System.out.println(grp);
		
		Map<String, Set<String>> grp_name = st.stream()
					.collect(Collectors.groupingBy(Student::getCity,Collectors.mapping(Student::getName,Collectors.toSet())));
		System.out.println(grp_name);	
		
		System.out.println(st.stream()
				.map(Student::getName)
				.collect(Collectors.joining(","))
				);
			

	}
}

@Data
class Student{
	private String name;
	private int age;
	private String city;
	
	public Student(String n,int a,String c) {
		name=n;
		age=a;
		city=c;
	}
}
