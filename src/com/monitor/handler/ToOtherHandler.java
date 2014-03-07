package com.monitor.handler;

import java.util.Iterator;

import com.monitor.contents.Content;
import com.monitor.entity.Client;
import com.monitor.message.Message;
import com.monitor.message.MessageOperation;

public class ToOtherHandler implements Handler{

	@Override
	public void handle(Message message) {
		System.out.println("����ִ���������ͻ��˷�����Ϣ�ķ���������������������");
		//������Ҫ��һ���м��������߰�
		
		
		//��������map 
		Client c = Content.ClientsMap.get(message.getSender());
		for (Iterator i = Content.ClientsMap.keySet().iterator(); i.hasNext();) {
			   Object obj = i.next();
			   if (!c.equals(Content.ClientsMap.get(obj))) {
				
				   new MessageOperation(Content.ClientsMap.get(obj)).sendMessage("����"+message.getSender()+"��������Ϣ");
			   }
			   System.out.println("key=" + obj + " value=" + Content.ClientsMap.get(obj));
		}
	}

}
