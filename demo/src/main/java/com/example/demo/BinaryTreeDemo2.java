package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BinaryTreeDemo2 {

	public static void main(String[] args) {
		List<User> ls=new ArrayList<User>();
		ls.add(new User("aaaa",1));
		ls.add(new User("aaaa12",12));
		ls.add(new User("aaaa10",10));
		ls.add(new User("aaaa5",5));
		
		
		Predicate<? super User> userPre=u->u.age<=10;
		ls.stream()
			.filter(userPre)
			.sorted(Comparator.comparingInt(User::getAge).reversed())
			.forEach(System.out::println);
		
		
		String n="ashwini";
		Set<Character> s = new LinkedHashSet<Character>();
		for (int i=0;i<n.length();i++) {
			s.add(n.charAt(i));
		}
		
		String st = s.stream().map(u->u.toString()).collect(Collectors.joining(" "));
		System.out.println(st);
		
		
	}
	
	
}

class User {
	String name;
	int age;
	public User() {
		
	}
	
	public User(String name,int age) {
		this.name=name;
		this.age=age;
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

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	
}

