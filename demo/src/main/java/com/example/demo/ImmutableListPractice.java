package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class ImmutableListPractice {

	public static void main(String[] args) {
	
		
		final List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
			
		//using factory method of java 9
			    List<String> unmodifiableList = List.of(list.toArray(new String[]{})); // creates immutable list
			 //   unmodifiableList.add("four");
			
		
		//using Guava
			    List<String> unmodifiableListGuava =  ImmutableList.copyOf(list);
			   // unmodifiableListGuava.add("four");
			
	//With the Apache Collections Commons
			 //   ListUtils.unmodifiableList(list);
			    
			    
			    List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
			    List<List<Integer>> subSets = Lists.partition(intList, 3);

			    List<Integer> lastPartition = subSets.get(2);
System.out.println(subSets);			//[[1, 2, 3], [4, 5, 6], [7, 8]]   
	}	

}
