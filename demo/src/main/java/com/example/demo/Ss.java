package com.example.demo;


import java.io.*;
import java.util.*;
public class Ss {
   public static void main(String args[] ) throws Exception {

       Something impl= new SomeImpl();
       impl.setColor("Red");
       impl.test();
        
       System.out.println("********************************");
       Something s = new Something();
       Something.Inner in = s.new Inner();
       in.func(10);
       System.out.println("********************************");

   }
}
class Something{
	
	String color;
	int x=5;
	
	void setColor(String color) {};
	
	
	
	 void test() {
		System.out.println("test "+color);
	}
	 
	 class Inner{
		 int x=7;
		 void func(int x) {
			 System.out.println(x);
			 System.out.println(this.x);
			 System.out.println(Something.this.x);
		 }
	 }
}

class SomeImpl extends Something{
	void setColor(String color) {
		super.color=color;
	}
	
}


