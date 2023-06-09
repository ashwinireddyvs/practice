package com.example.demo.messaing;

import java.util.List;

public interface MessageTemplate {
	String setMsg(String msg);
	void sendMsg();
	List<String> addContacts(String contact);
}
