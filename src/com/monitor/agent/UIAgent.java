package com.monitor.agent;

import java.awt.List;


public class UIAgent {
	
	/**
     * 客户端即时消息列表
     */
    public static List clientList;
    /**
     * 服务端即时消息列表
     */
    public static List serverList;
	
 
    /**
     * 在列表中显示消息
     */
    public static void addClientList(String message) {
    	System.out.println(message);
//        clientList.add(message, 0);
    }
    public static void addServerList(String message) {
    	System.out.println(message);
//        serverList.add(message, 0);
    }
}
