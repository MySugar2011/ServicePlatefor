package com.monitor.handler;


public class HandlerFactory {

	public Handler produce(String type){
		
		 if ("login".equals(type)) {  
	            return new LoginHandler();  
	        } else if ("toother".equals(type)) {
				return new ToOtherHandler();
			}else {  
	            System.out.println("��������ȷ������!");  
	            return null;  
	        }  
	}
}
