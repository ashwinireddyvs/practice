package com.example.demo.messaing;



public enum MessageType implements MessageT{
	SMS{

		@Override
		public MessageTemplate createMsgObject() {
			// TODO Auto-generated method stub
			
			return new Sms();
		}

	},
	EMAIL{

		@Override
		public MessageTemplate createMsgObject() {
			// TODO Auto-generated method stub
			return new Email();
		}
		
	}

}
