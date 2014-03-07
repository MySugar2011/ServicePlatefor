/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitor.listener;

import com.monitor.handler.Handler;
import com.monitor.handler.HandlerFactory;
import com.monitor.message.Message;
import com.monitor.message.MessageQueue;



/**
 * ��Ϣ����̣߳���������Ϣ���У�����Ϣ���в�Ϊ��ʱ��ȡ��Ϣ
 * @author G11
 */
public class MessageQueneListener implements Runnable {

    /**
     * ��Ϣ���ж���
     */
    private MessageQueue messageQueue;
    /**
     * ��Ϣ��������ȡ��������Ϣ
     */
    private Message message;
    private String receiver;

    /**
     * ����MessageExevute����ָ����Ϣ����Ķ���.
     * @param messageQueue ����ȡ����Ϣ�������Ϣ����
     */
    public MessageQueneListener(MessageQueue messageQueue) {  
        this.messageQueue = messageQueue;
    }

    /**
     * ��дrun������while��ѭ��������Ϣ����
     */
    @Override
    public void run() {
    	HandlerFactory hf = new HandlerFactory();
        while (true) {
        	
            try {
                if (!messageQueue.isEmpty() ) {
                    message = messageQueue.pollMessage();
System.out.println("ִ��messageexcute������");
                    if (message.getReciever().equals("server")) {
/**8���*/
System.out.println("++++++��ض˼�⵽����Ϣ�ǣ�"+message);
                        Handler handler = hf.produce(message.getType());
                        handler.handle(message);
                       

                    } else if (message.getReciever().equals("0")) {
//                        MessageType.getMessType("BROADCAST").handle(message);
                    }else {
//                        MessageType.getMessType("TRANSMIT").handle(message);
                    }
                   
                }
            } catch (Exception e) {
                System.out.println("MessageExecuteִ�г���");
                System.out.println(e);
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.out.println("MessageExecute������������");
            }
        }
    }
}
