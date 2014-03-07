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
 * 消息监控线程，负责监控消息队列，当消息队列不为空时获取消息
 * @author G11
 */
public class MessageQueneListener implements Runnable {

    /**
     * 消息队列对象
     */
    private MessageQueue messageQueue;
    /**
     * 消息队列中提取出来的消息
     */
    private Message message;
    private String receiver;

    /**
     * 构造MessageExevute对象，指定消息存入的队列.
     * @param messageQueue 将获取的消息加入该消息队列
     */
    public MessageQueneListener(MessageQueue messageQueue) {  
        this.messageQueue = messageQueue;
    }

    /**
     * 重写run方法，while死循环监听消息队列
     */
    @Override
    public void run() {
    	HandlerFactory hf = new HandlerFactory();
        while (true) {
        	
            try {
                if (!messageQueue.isEmpty() ) {
                    message = messageQueue.pollMessage();
System.out.println("执行messageexcute方法！");
                    if (message.getReciever().equals("server")) {
/**8输出*/
System.out.println("++++++监控端检测到的消息是："+message);
                        Handler handler = hf.produce(message.getType());
                        handler.handle(message);
                       

                    } else if (message.getReciever().equals("0")) {
//                        MessageType.getMessType("BROADCAST").handle(message);
                    }else {
//                        MessageType.getMessType("TRANSMIT").handle(message);
                    }
                   
                }
            } catch (Exception e) {
                System.out.println("MessageExecute执行出错！");
                System.out.println(e);
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.out.println("MessageExecute出错啦！！！");
            }
        }
    }
}
