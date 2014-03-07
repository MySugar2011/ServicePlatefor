package com.monitor.test;

import com.monitor.contents.Content;
import com.monitor.listener.ClientListener;
import com.monitor.listener.MessageQueneListener;

public class TestClitenListener {
	public static void main(String args[]){
		
		ClientListener cl = new ClientListener();
		MessageQueneListener me = new MessageQueneListener(Content.MESSAGEQUENE);
		Thread t = new Thread(cl);
		Thread t2 = new Thread(me);
		t.start();
		t2.start();
	}
}
