package com.example.demo;


public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VarInterface fi = (var firstName, var lastName)-> firstName + lastName ;
		System.out.println(fi.fullName(1,2));
		
		SampleAbstract abstractName = new Person("Ashwini");
		abstractName.printName();
		
		
	}
	
	public int print() {
		return 10;
	}

}

interface VarInterface{
	int fullName(int firstName,int secondName);
}

abstract class SampleAbstract{
	String name;
	SampleAbstract(String name){
		this.name=name;
	}
	
	abstract void printName();
}

class Person extends SampleAbstract implements SampleInterface{
	Person(String name){
		super(name);
		
	}

	@Override
	void printName() {
		// TODO Auto-generated method stub
		System.out.println(name);
	}

	@Override
	public void printNm() {
		// TODO Auto-generated method stub
		System.out.println(name);
	}
	
	
}

interface SampleInterface{
	String nm = "";//only constants
	void printNm();
}