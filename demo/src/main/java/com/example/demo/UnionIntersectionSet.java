package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.yaml.snakeyaml.util.ArrayUtils;

public class UnionIntersectionSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a =new int[]{1,2,3,4,5,6,7,8,9,10};
		int[] b =new int[] {11,2,31,4,15,6,17,8,19,10};
		List<Integer> aList = Arrays.asList();
		//union
		List<Integer> unionStream = 	Stream
				.concat(Arrays.stream(a).boxed(),Arrays.stream(b).boxed())
				.distinct()
				.collect(Collectors.toList());
		System.out.println("888888888888888888888888888888888888888888888888888888888888888888");
		System.out.println(unionStream);
		
		
		
		IntPredicate predicate = x -> Arrays.stream(b).anyMatch(y -> y == x);
		//intersection
		List<Integer> intersectionList = Arrays.stream(a).distinct().filter(predicate).boxed().collect(Collectors.toList());
		System.out.println(intersectionList);
		
		
		Long sameEnergy= unionStream.stream()
			    .filter(intersectionList::contains)
			    .collect(Collectors.counting());
		
		System.out.println("888888888888888888888888888888888888888888888888888888888888888888");
		IntStream.range(0,10).mapToObj(i -> i+" Ashwini").forEach(System.out::println);;
		
		System.out.println("------------------------------------------");
		//union of arrays
		Set<Integer> unionset = new LinkedHashSet<Integer>();
		for(int i: a) {
			unionset.add(i);
		}
		for(int j:b) {
			unionset.add(j);
		}
		
	System.out.println(unionset);
	System.out.println("------------------------------------------");
	Object[] union =  unionset.toArray();
	for(Object a1 : union) {
 		System.out.println(a1);
 	}
	System.out.println("------------------------------------------");
	//Intersection
	//List l =(Arrays.asList(unionset)).removeAll(Arrays.asList(a));
	 int[] interection = Arrays.stream(a)
			 					.distinct()
			 					.filter
			 						(x->Arrays.stream(b).anyMatch(y -> y == x))
			 					.toArray();
	 


	 	for(int a1 : interection) {
	 		System.out.println(a1);
	 	}
	 	
	 	
	

String s = "The acronym of the three words you entered is";
s = s.toLowerCase();
Set<Character> str = new LinkedHashSet<Character>();
for(int k=0;k<s.length();k++){
	//if(!Character.isWhitespace(s.charAt(k)))
	str.add(s.charAt(k));
	
	//System.err.println('');
}
System.out.println(str);
	
	}

}
