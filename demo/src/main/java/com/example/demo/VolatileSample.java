package com.example.demo;

public class VolatileSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Task task=new Task();
		ThreadClass thread1 = new ThreadClass(task);
		ThreadClass thread2 = new ThreadClass(task);
		thread1.start();
		thread2.start();
		System.out.print(task.count);
	}

}

class ThreadClass extends Thread{
	Task task;
	public ThreadClass(Task task) {
		this.task=task;
	}
	
	@Override
	public void run() {
		task.count++;
	}
}

class Task{
	volatile int count;
}