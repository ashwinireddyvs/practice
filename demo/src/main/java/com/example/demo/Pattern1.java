package com.example.demo;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Pattern1 {
	    public static void main(String args[] ) throws Exception {
	//Write code here
	Scanner scanner = new Scanner(new InputStreamReader(System.in));
	int argc=scanner.nextInt();
	    int k=1;
		for(int i=0;i<argc;i++){
	      
	           for(int l=5-i;l>1;l--){
	               System.out.print("  ");
	           }
			for(int j=65;j<65+k;j++){
	          
				System.out.print((char)j);
	            if(j<65+k-1)
	            System.out.print(" ");
			}
	         k+=2;
			System.out.println("");
		}
		

	   }
	}

