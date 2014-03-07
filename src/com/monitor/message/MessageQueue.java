package com.monitor.message;

import java.util.LinkedList;


public class MessageQueue {
	

    /**
     * 以LinkedList实现的消息队列
     */
    private LinkedList<Message> list = new LinkedList<Message>();
    //private List sList = Collections.synchronizedList(list);
    /**
     * 需要操作的Message对象
     */
    public Message message;

    /**
     * 构造MessageQueue
     */
    public MessageQueue() {
    }

    /**
     * 清空消息队列操作
     */
    public synchronized void clearAll() {
        list.clear();
    }

    /**
     * 获取并移除此列表的头（第一个元素）
     * @return message 列表头部的message
     */
    public synchronized Message pollMessage() {
        //String message;
        //Socket socket;
        while (!list.isEmpty() ) {
            message = list.poll();
            System.out.println("消息内容");
        }
        return message;
    }

    /**
     * 将指定元素添加到此列表的结尾。
     * @param message 需要添加到结尾的Message对象
     */
    public synchronized void addMessage(Message message) {
        list.offer(message);
        //list.addElement(socket);
        //notifyAll();
    }

    /**
     * 返回列表是否为空
     * @return isEmpty 队列是否为空
     */
    public synchronized boolean isEmpty() {
        return list.isEmpty();
    }
}
