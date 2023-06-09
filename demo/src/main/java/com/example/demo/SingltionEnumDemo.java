package com.example.demo;

public class SingltionEnumDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonEnum seIntsnce = SingletonEnum.INSTANCE;
		System.out.println(seIntsnce);
		System.out.println(seIntsnce.getI());
		seIntsnce.i=10;
		System.out.println(seIntsnce.getI());
	}

}
enum SingletonEnum{
	INSTANCE;
	int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
}