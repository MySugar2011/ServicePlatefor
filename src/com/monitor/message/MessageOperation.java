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
     * ������Ϣ���õ�������
     */
    private DataInputStream input;
    /**
     * ������Ϣ�õ��������
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
				//��ȡ�ַ��� �鿴��Ϣ������
				Message message = new Message(messageStr,client);
				//Ȼ���Message�ŵ���Ϣ��������ȥ
				Content.MESSAGEQUENE.addMessage(message);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
     * ��Ϣ���Ͳ���.
     * <a href="">��������ͼ</a>
     */
    public void sendMessage(String messageStr) {
    	System.out.println("�������ͻ��˷�����Ϣ����������");
        try {

            ByteArrayOutputStream byteOut = new ByteArrayOutputStream(); //����ʵ��һ�����ֽ�������ʽд�����ݵ��������������д�뻺����ʱ�����Զ�����
            DataOutputStream out = new DataOutputStream(byteOut);
            out.writeUTF(messageStr); //��UTF����ʽ����Ϣд��out��д��Ŀ�꣺byteOut��
            out.flush(); //�൱��д�������
            byte buf[] = byteOut.toByteArray();
            this.output.write(buf); //�����buf���������д��output����
            this.output.flush();
            //new CNews("��"+socket.getInetAddress().toString()+"������Ϣ�� "+messageStr);
            byteOut.close();
            out.close();
            //new CNews("��"+socket.getInetAddress().toString()+"������Ϣ�� "+messageStr);
System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@####################################"+messageStr);
        } catch (Exception ex) { 
            System.out.println("����ʧ�ܣ�");
        }
    }
}
