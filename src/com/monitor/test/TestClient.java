package com.monitor.test;

import com.monitor.contents.Content;


public class TestClient {

	 public static void main(String[] args) {
	        System.out.println("333");
	            SocketConn s = new SocketConn(Content.MONITOR_IP, Content.CLIENT_LISTENING_PORT);
//	            s.sendMessage("MCDService,zhao,2010-10-7 15:36:24,CREATE_GROUP,asd,none#3#FREE#123");
//	            s.sendMessage("server,1111,1394021022109,toother,0,a1#5#aa");
//	            s.sendMessage("server,2222,1394021022109,login,0,a1#5#aa");
	            s.sendMessage("server,333,1394021022109,toother,0,a1#5#aa");
	            while (true) {
					
					System.out.println(s.getAckMess());
				}
	    }
}
