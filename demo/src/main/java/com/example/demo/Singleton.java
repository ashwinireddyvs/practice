package com.example.demo;

import java.lang.reflect.Constructor;

public class Singleton {
	public static void main(String[] args) {
		Class cls = Single.class;
		try {//break singleton
			Constructor cons = cls.getDeclaredConstructor();
			Single s = (Single) cons.newInstance();
			System.out.println(s);
			Single s2 = (Single) cons.newInstance();
			System.out.println(s2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Single.getInstance());
	}
}

class Single{
	private static final Single instance = new Single();
	private void Single() {
		
	}
	public static  Single getInstance() {
		return instance;
	}
}
