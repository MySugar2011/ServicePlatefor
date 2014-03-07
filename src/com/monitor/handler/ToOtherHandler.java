package com.monitor.handler;

import java.util.Iterator;

import com.monitor.contents.Content;
import com.monitor.entity.Client;
import com.monitor.message.Message;
import com.monitor.message.MessageOperation;

public class ToOtherHandler implements Handler{

	@Override
	public void handle(Message message) {
		System.out.println("正在执行向其他客户端发送消息的方法！！！！！！！！！");
		//首先是要看一共有几个人在线吧
		
		
		//遍历整个map 
		Client c = Content.ClientsMap.get(message.getSender());
		for (Iterator i = Content.ClientsMap.keySet().iterator(); i.hasNext();) {
			   Object obj = i.next();
			   if (!c.equals(Content.ClientsMap.get(obj))) {
				
				   new MessageOperation(Content.ClientsMap.get(obj)).sendMessage("这是"+message.getSender()+"发来的消息");
			   }
			   System.out.println("key=" + obj + " value=" + Content.ClientsMap.get(obj));
		}
	}

}
