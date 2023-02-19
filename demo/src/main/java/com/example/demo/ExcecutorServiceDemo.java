package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class ExcecutorServiceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task1 task=new Task1();
		Callable<Integer> callabkeTask = ()->{
			synchronized(Task.class){
			System.out.println("2 -->"+task.count);
			TimeUnit.MILLISECONDS.sleep(3000);
			return task.count++;
			}
		};
		
		List<Callable<Integer>> callableTasks = new ArrayList<Callable<Integer>>();
		callableTasks.add(callabkeTask);
		callableTasks.add(callabkeTask);
		callableTasks.add(callabkeTask);
		callableTasks.add(callabkeTask);
		callableTasks.add(callabkeTask);
		callableTasks.add(callabkeTask);
		callableTasks.add(callabkeTask);
		callableTasks.add(callabkeTask);
		callableTasks.add(callabkeTask);
		callableTasks.add(callabkeTask);
		callableTasks.add(callabkeTask);
		callableTasks.add(callabkeTask);
		
		System.out.println("1 -->"+task.count);
		List<Future<Integer>> future = null;
		ExecutorService excService = Executors.newFixedThreadPool(10);
		try {
			
			future = excService.invokeAll(callableTasks);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("3 -- >"+task.count);
		if(future.isEmpty()) {
			System.out.println("jbdsvj "+task.count);
		}else
			System.out.println(task.count);
		
	}

}

class Task1{
	volatile int count;
}

