package com.example.demo.messaing;

import java.util.ArrayList;
import java.util.List;

public class Sms implements MessageTemplate{
	
	List<String> contacts;
	String msg;
	
	public Sms() {
		contacts=new ArrayList<String>();
	}
	
	@Override
	public String setMsg(String msg) {
		// TODO Auto-generated method stub
		this.msg=msg;
		return msg;
	}

	@Override
	public void sendMsg() {
		// TODO Auto-generated method stub
		System.out.println("Message => "+msg);
		System.out.println(contacts);
		System.out.println("Message Sent Successfully through SMS");
	}

	@Override
	public List<String> addContacts(String contact) {
		contacts.add(contact);
		return contacts;
	}

}
