package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class SlidingWindow {
	public static void main(String[] args) {
		int[] array = new int[] {1,5,3,4,7,8,9};
		int g=3;
		List<Integer> result=new ArrayList<Integer>();
		List<Integer> result1=new ArrayList<Integer>();
		for(int i=0;i<=array.length-g;i++) {
			result.add(max(i,i+(g-1),array));
			
			result1.add(max(Arrays.copyOfRange(array,i,i+(g-1)+1)).getAsInt());
			
			/*
			 * result1.add( Arrays.stream( Arrays.copyOfRange(array,i,i+(g-1)+1) ) .max()
			 * .getAsInt() );
			 */
		}
		System.out.println(result);
		System.out.println(result1);
		
	}
	
	public static int max(int i,int j,int[] array) {
		int max=0;
		for(int k=i;k<=j;k++) {
			if(max<array[k])
				max=array[k];
		}
		return max;
	}
	
	public static OptionalInt max(int[] array) {
				
				return Arrays.stream(array).max();
	}
}
