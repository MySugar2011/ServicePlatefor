package com.monitor.message;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 */

import java.util.StringTokenizer;

/**
 * ��Ϣ�����.
 * ������Ϣ�Ĳ��
 * @author Sugar
 */
public class MessageSplit {

    /* ��ֺ��������ϸ�������ݵ����� */
    String[] infoArray;
    /* ��Ϣ������Ϣ */
    String messageStr, type, sender_ID, receiver_ID, info;
    /* �����б�ʾ��ϸ����������ֵ���¹滮����ʡȥ����   ���棩 */
    int num;
    /* �˿���Ϣ */
    String port;
    /* ip��ַ */
    String ip;
    /* ��Ϣ��ʽ�����Ƿ�Ϸ���Ĭ��Ϊ�Ƿ��� */
    Boolean isValid = false;
    /* ��Ϣ�����Ƿ�Ϊ�գ�Ĭ���ǲ�Ϊ�գ� */
    Boolean isEmpty = false;
    String[] messageArray;
    //DataInputStream input;

    /**
     * ����SplitMessage���󣬲��message
     * @param messageStr ����ֵ���Ϣ
     */
    public MessageSplit(String messageStr) {
        this.messageStr = messageStr;
        if (messageStr.equals(null)) {
            this.isEmpty = true;
        } else if (!messageStr.equals("-1")) {
            //�ж��յ���Ϣ�Ƿ�Ϸ�
            StringTokenizer st = new StringTokenizer(messageStr, ",");
            int count = 0;
            while (st.hasMoreTokens()) {
                st.nextToken();
                count++;
            }
            //System.out.println(count);

            //��Ϣ��ʽ�Ϸ�

            this.isValid = true;
            this.messageArray = messageStr.split(",");
/**5���*/
System.out.println("SplitMessage���н�Ҫ��ֵ���Ϣ��"+messageStr);
            try {
                info = messageArray[5];
                this.infoArray = this.SplitInfo(info, "#");
            } catch (Exception e) {
                this.infoArray = null;
            }
            
        } else if (messageStr.equals("-1")) {
            System.out.println("��ϢΪ��");
        }
    }

    /**
     * �����Ϣ��ͨ�÷�����
     * @param str ��Ҫ��ֵ��ַ���
     * @param delimiter �ָ���
     * @param num Ԫ�ظ���
     * @return
     */
    protected String[] SplitInfo(String str, String delimiter) {

        //�ж��յ���Ϣ�Ƿ�Ϸ�
        StringTokenizer st = new StringTokenizer(str, delimiter);
        int count = 0;
        while (st.hasMoreTokens()) {
            st.nextToken();
            count++;
        }

        this.infoArray = str.split(delimiter);

        return this.infoArray;
    }

    /**
     * �ж���Ϣ�Ƿ�Ϊ�գ����Ƿ��յ���Ϣ
     * @return isEmpty ��Ϣ�Ƿ�Ϊ�յı��
     */
    protected boolean isEmpty() {
        return this.isEmpty;
    }

    /**
     * �ж���Ϣ�Ƿ�Ϸ�����
     * @return isValid ��Ϣ�Ƿ�Ϸ��ı��
     */
    protected boolean isValid() {
        return this.isValid;
    }

    //��ȡ������Ϣ
    /**
     * ��ȡ������Ϣ
     * @return request ��Ϣ�������ַ�����ʽ
     */
    protected String getMessage() {
        return this.messageStr;
    }

    /**
     * ��ȡ��ϸ����
     * @return infoArray ��ϸ����
     */
    protected String[] getInfoArray() {
        return this.infoArray;
    }

    /**
     * ��ȡ��ϸ����
     * @return infoArray ��ϸ����
     */
    protected String[] getMessageArray() {
        return this.messageArray;
    }
}
