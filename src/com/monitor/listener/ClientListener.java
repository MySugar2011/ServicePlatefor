package com.monitor.listener;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.monitor.agent.UIAgent;
import com.monitor.contents.Content;
import com.monitor.entity.Client;


/**
 * @author Sugar
 *	客户端监听类
 *
 */
//要有一个client列表,看看是不是要写在数据库里面  要不然不知道分配给谁了，或者是有人下线的时候从list里面去除
public class ClientListener implements Runnable{

	 /**
     * 服务器套接字，等待客户端的连接
     */
    private ServerSocket serverSocket;

    /**
     * 构造客户端监听线程.
     * 将线程加入到对应的messageQueue中
     */
    public ClientListener() {
        try {
            this.serverSocket = new ServerSocket(Content.CLIENT_LISTENING_PORT);
            
            UIAgent.addClientList("正在来自客户端的消息");
        } catch (IOException ex) {
            System.out.println("启动监听客户端失败");
        }
    }
	
	@Override
	public void run() {
		System.out.println("线程已经启动起来了！！！");
		 while(true) {
	            Socket socket = null;
	            try {
	                socket = serverSocket.accept();
	                UIAgent.addClientList("与客户端："+socket.getInetAddress().toString()+":"+socket.getPort()+"建立Socket连接");
	/**1输出*/
	System.out.println("ClientListening类：客户端和监控端建立了连接，开始向监控端发送消息！！！！！");
	                //input = new DataInputStream(socket.getInputStream());
	                //output = new DataOutputStream(socket.getOutputStream());
	            } catch (IOException ex) {
	                //System.out.println("出错啦");
	            }

	            //this.extendedPool = InstanceManager.getExtendedPool();
//	            extendedPool.createTask(new Client(socket));
	            //是不是要在这里添加点什么
	            new Thread(new Client(socket)).start();
	        }
	}

}
