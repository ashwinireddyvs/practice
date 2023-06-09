package com.example.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ashwini";
		char[] ch = str.toCharArray();
		
		/*
		 * Set<Object> set = new HashSet<>(); for(char c : ch) set.add(c);
		 * System.out.println(set);
		 */
//		set=Set.of(ch);
		
		List<Character> ls = str.chars().mapToObj(c->(char)c).collect(Collectors.toList());
		
		Map<Object, Long> m = ls.stream().collect(Collectors.groupingBy(
				c->c ,Collectors.counting()));
		
		
		
		System.out.println(m);
		
		System.out.println(str.chars().distinct().mapToObj(c->(char)c+"").collect(Collectors.joining()));
	}

}
