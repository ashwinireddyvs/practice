package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.LongStream;

public class Practice1 {

		public static void main(String[] args) {
			IntStream.range(1, 11).mapToObj(n -> n + " ==> Ashwini \n").forEach(System.out::println);;
			
			
			List<String> list = LongStream.range(0, 16)
					  .boxed()
					  .map(Long::toHexString)
					  .collect(Collectors.toList());
			
					List<String> stringsToSearch = new ArrayList<>(list);
					stringsToSearch.addAll(list);
					
					
					
					System.out.println(list.getClass());
					
					System.out.println(list);
				Collections.sort(stringsToSearch);
				
				System.out.println(stringsToSearch);
				
				System.out.println(Collections.binarySearch(stringsToSearch, "a"));
				
				
				
				 final List<String> list1 = new ArrayList<>(Arrays.asList("one", "two", "three"));
				    final List<String> unmodifiableList = List.of(list.toArray(new String[]{})); // creates immutable list
				    unmodifiableList.add("four");
				
				
				
		}
}
