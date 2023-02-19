package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.yaml.snakeyaml.reader.StreamReader;

public class SerializationDemo {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		List<UserSer> userList = new ArrayList<UserSer>();
		userList.add(new UserSer(10,"hdgsjh"));
		userList.add(new UserSer(1,"hdgsjh1"));
		userList.add(new UserSer(12,"hdgsjh2"));
		userList.add(new UserSer(5,"hdgsjh3"));
		userList.add(new UserSer(15,"hdgsjh4"));
		userList.add(new UserSer(1,"hdgsjh5"));
		
		
		UserSer s = new UserSer(10,"hdgsjh");
		
		
		try {
			File file =new File("serialize.txt");
			System.out.println(file.getAbsolutePath());
			FileOutputStream fo = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fo);
			oos.writeObject(userList);
			oos.close();
			fo.close();
			
			
			
			FileInputStream fi = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fi);
		    
			System.out.println(ois.readObject().toString());
			ois.close();
			fi.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

class UserSer implements Serializable{
	int age;
	String name;
	public UserSer(int age,String name) {
		this.age=age;
		this.name=name;
		
	}
	
	@Override
	public String toString() {
		return "{name:"+name+",age:"+age+"}";
		
	}
}