package com.example.demo.messaing;

import java.util.ArrayList;
import java.util.List;

public class Email implements MessageTemplate{
	List<String> contacts;
	String msg;
	
	Email(){
		contacts = new ArrayList<String>();
	}
	
	@Override
	public String setMsg(String msg) {
		this.msg=msg;
		return msg;
	}

	@Override
	public void sendMsg() {
		// TODO Auto-generated method stub
		System.out.println("Message => "+msg);
		System.out.println(contacts);
		System.out.println("Message sent through email");
	}

	@Override
	public List<String> addContacts(String contact) {
		contacts.add(contact);
		return contacts;
	}

}
