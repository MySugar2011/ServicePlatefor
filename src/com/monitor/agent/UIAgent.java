package com.monitor.agent;

import java.awt.List;


public class UIAgent {
	
	/**
     * �ͻ��˼�ʱ��Ϣ�б�
     */
    public static List clientList;
    /**
     * ����˼�ʱ��Ϣ�б�
     */
    public static List serverList;
	
 
    /**
     * ���б�����ʾ��Ϣ
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
