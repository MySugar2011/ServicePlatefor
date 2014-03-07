package com.monitor.message;

import java.util.LinkedList;


public class MessageQueue {
	

    /**
     * ��LinkedListʵ�ֵ���Ϣ����
     */
    private LinkedList<Message> list = new LinkedList<Message>();
    //private List sList = Collections.synchronizedList(list);
    /**
     * ��Ҫ������Message����
     */
    public Message message;

    /**
     * ����MessageQueue
     */
    public MessageQueue() {
    }

    /**
     * �����Ϣ���в���
     */
    public synchronized void clearAll() {
        list.clear();
    }

    /**
     * ��ȡ���Ƴ����б��ͷ����һ��Ԫ�أ�
     * @return message �б�ͷ����message
     */
    public synchronized Message pollMessage() {
        //String message;
        //Socket socket;
        while (!list.isEmpty() ) {
            message = list.poll();
            System.out.println("��Ϣ����");
        }
        return message;
    }

    /**
     * ��ָ��Ԫ����ӵ����б�Ľ�β��
     * @param message ��Ҫ��ӵ���β��Message����
     */
    public synchronized void addMessage(Message message) {
        list.offer(message);
        //list.addElement(socket);
        //notifyAll();
    }

    /**
     * �����б��Ƿ�Ϊ��
     * @return isEmpty �����Ƿ�Ϊ��
     */
    public synchronized boolean isEmpty() {
        return list.isEmpty();
    }
}
