package com.monitor.contents;

import java.util.HashMap;
import java.util.Map;

import com.monitor.entity.Client;
import com.monitor.message.MessageQueue;

public class Content {

	public static final int CLIENT_LISTENING_PORT = 8083;
	
	public static final int SERVER_LISTENING_PORT = 8082;
	
	public static final String MONITOR_IP = "172.18.40.181";
	
	public static  MessageQueue MESSAGEQUENE = new MessageQueue();
	
	/**key �ǿͻ��˵�����  Value ��һ���ͻ��˶��� ������Ա���������Socket*/
	public static Map<String, Client> ClientsMap = new HashMap<String, Client>();
}
