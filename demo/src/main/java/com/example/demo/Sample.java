package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.boot.origin.SystemEnvironmentOrigin;

public class Sample {

	public static void main(String[] args) {
		List<User> ls=new ArrayList<User>();
		ls.add(new User("aaaa",1));
		ls.add(new User("aaaa12",12));
		ls.add(new User("aaaa10",10));
		ls.add(new User("aaaa5",5));
		
		
		Predicate<? super User> userPre=u->u.age<=10;
		List<User> l = ls.stream()
			.filter(userPre)
			.sorted(Comparator.comparing(User::getAge).reversed())
			.collect(Collectors.toList());//for printing in reverse order use list
			//.forEach(System.out::println);
		
		System.out.println(l);
		
		
		String n="ashwini";
		Set<Character> s = new LinkedHashSet<Character>();
		for (int i=0;i<n.length();i++) {
			s.add(n.charAt(i));
		}
		
		String st = s.stream().map(u->u.toString()).collect(Collectors.joining(" "));
		System.out.println(st);
		
		
		Map<User,String> m = new HashMap<User,String>(3);
		m.put(new User("aaaa",13),"aaa");
		m.put(new User("aaaa",12),"bbb");
		m.put(new User("aaa24a",11),"ccc");
		m.put(new User("aa1aa",10),"ddd");
		
		System.out.println(m);
		
		
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

	@Override
	public int hashCode() {
		return 	age;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	
	
}

