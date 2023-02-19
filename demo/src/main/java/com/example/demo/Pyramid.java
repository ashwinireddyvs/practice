package com.example.demo;

public class Pyramid {
	
	public static void main(String[] args) {
		for(int i=5;i>0;i--) {
			
			for(int j=5;j>0;j--) {
				if(j>i) {
					System.out.print("  ");
				}else
				System.out.print(i+" ");
			}
			System.out.println("\n");
		}
	}
}
