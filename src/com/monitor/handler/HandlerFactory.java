package com.monitor.handler;


public class HandlerFactory {

	public Handler produce(String type){
		
		 if ("login".equals(type)) {  
	            return new LoginHandler();  
	        } else if ("toother".equals(type)) {
				return new ToOtherHandler();
			}else {  
	            System.out.println("请输入正确的类型!");  
	            return null;  
	        }  
	}
}
