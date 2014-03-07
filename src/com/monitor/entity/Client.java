package com.monitor.entity;

import java.net.Socket;

import com.monitor.message.MessageOperation;



public class Client implements Runnable{

	/**
     * 与客户端建立连接用的socket
     */
    private String clientID, ip;
    int timeoutCount = 0, port;
    private Socket socket;
//    private MessageQueue messageQueue;
    boolean closed = false;
	
	public Client(Socket socket) {
		this.socket = socket;
	}


	public Socket getSocket() {
		return socket;
	}


	public void setSocket(Socket socket) {
		this.socket = socket;
	}


	@Override
	public void run() {

		while(true){
			
			new MessageOperation(this).receiveMessage();
		}
	}

}
