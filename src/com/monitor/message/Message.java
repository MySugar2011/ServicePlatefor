package com.monitor.message;

import java.net.Socket;

import com.monitor.contents.Content;
import com.monitor.entity.Client;


public class Message {
	
	public String reciever;
	public String sender;
	public String time;
	public String type;//任务类型
	private Client client;
	
	


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public String getReciever() {
		return reciever;
	}


	public void setReciever(String reciever) {
		this.reciever = reciever;
	}


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getType() {
		System.out.println("消息的类型是："+type);
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Message(String message,Client client){
		
		MessageSplit Messagesplit = new MessageSplit(message);
		String[]  messageArray = Messagesplit.getMessageArray();
		this.setReciever(messageArray[0]);
        this.setSender(messageArray[1]);
        this.setTime(messageArray[2]);
        this.setType(messageArray[3]);
        this.setClient(client);
        Content.ClientsMap.put(this.sender, client);
        System.out.println("往客户端列表里面添加了信息");
	}
}
