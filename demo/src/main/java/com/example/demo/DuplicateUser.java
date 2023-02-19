package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> le = new ArrayList<>();	
		le.add(new Employee("aaaaa",1));
		le.add(new Employee("aaaaa1",10));
		le.add(new Employee("aaaaa2",2));
		le.add(new Employee("aaaaa",12));
		
		
		for(int j=0;j<le.size();j++) {
			int count=1;
			
			for(int i=j+1;i<le.size();i++) {
				if(le.get(j).Name.equals(le.get(i).Name)) {
					count++;
					le.remove(i);
				}
			}
			System.out.println("name= "+le.get(j).Name+" count="+count);
		}
		
		le.add(new Employee("aaaaa",12));
		Map<Object, Long> m = le.stream()
		.collect(Collectors.groupingBy(k -> k.Name, Collectors.counting()));
		
		System.out.println(m);
		
		
	}
	

}

class Employee{
	String Name;
	int id;
	
	public Employee(String n,int i) {
		Name=n;
		id=i;
	}
}
