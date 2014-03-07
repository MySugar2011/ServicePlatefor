package com.monitor.message;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


import com.monitor.contents.Content;
import com.monitor.entity.Client;

public class MessageOperation {

	/**
     * 接收消息所用的输入流
     */
    private DataInputStream input;
    /**
     * 发送消息用到的输出流
     */
    private DataOutputStream output;
    
    private Client client;
    
   
	
	public MessageOperation(Client c) {
		this.client = c;
		 try {
			this.input = new DataInputStream(c.getSocket().getInputStream());
			this.output = new DataOutputStream(c.getSocket().getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void receiveMessage() {
		String messageStr;
		try {
			messageStr = input.readUTF();
			if (!messageStr.equals(null)) {
				//截取字符串 查看消息的类型
				Message message = new Message(messageStr,client);
				//然后把Message放到消息队列里面去
				Content.MESSAGEQUENE.addMessage(message);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
     * 消息发送操作.
     * <a href="">工作流程图</a>
     */
    public void sendMessage(String messageStr) {
    	System.out.println("正在往客户端返回消息！！！！！");
        try {

            ByteArrayOutputStream byteOut = new ByteArrayOutputStream(); //该类实现一个以字节数组形式写入数据的输出流。当数据写入缓冲区时，它自动扩大
            DataOutputStream out = new DataOutputStream(byteOut);
            out.writeUTF(messageStr); //以UTF的形式将消息写入out的写入目标：byteOut流
            out.flush(); //相当于写入输出流
            byte buf[] = byteOut.toByteArray();
            this.output.write(buf); //将这个buf数组的内容写入output流中
            this.output.flush();
            //new CNews("向"+socket.getInetAddress().toString()+"发送消息： "+messageStr);
            byteOut.close();
            out.close();
            //new CNews("向"+socket.getInetAddress().toString()+"发送消息： "+messageStr);
System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@####################################"+messageStr);
        } catch (Exception ex) { 
            System.out.println("发送失败！");
        }
    }
}
