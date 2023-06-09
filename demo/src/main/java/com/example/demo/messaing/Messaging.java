package com.example.demo.messaing;

public class Messaging {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MessageType msgType;
		
		
		
		msgType=MessageType.SMS;
		msg(msgType);
		msgType=MessageType.EMAIL;
		msg(msgType);
		
	}

	public static void msg(MessageType msgType) {
		MessageTemplate msgTemplate; 
		switch (msgType) {
		case SMS: 
			msgTemplate = MessageType.SMS.createMsgObject();
			break;
		case EMAIL:
			msgTemplate = MessageType.EMAIL.createMsgObject();
			break;
		default:
			msgTemplate = MessageType.SMS.createMsgObject();
		}
		msgTemplate.addContacts("aaaaa");
		msgTemplate.addContacts("afngaaaa");
		msgTemplate.addContacts("aafbcxbzaaa");
		msgTemplate.setMsg("hi hello");
		msgTemplate.sendMsg();
	}
}
