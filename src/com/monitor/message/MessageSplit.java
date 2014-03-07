package com.monitor.message;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 */

import java.util.StringTokenizer;

/**
 * 消息拆分类.
 * 负责消息的拆分
 * @author Sugar
 */
public class MessageSplit {

    /* 拆分后请求的详细操作内容的数组 */
    String[] infoArray;
    /* 消息处理信息 */
    String messageStr, type, sender_ID, receiver_ID, info;
    /* 参数中表示详细参数个数的值（新规划中已省去，由   代替） */
    int num;
    /* 端口信息 */
    String port;
    /* ip地址 */
    String ip;
    /* 消息格式内容是否合法（默认为非法） */
    Boolean isValid = false;
    /* 消息内容是否为空（默认是不为空） */
    Boolean isEmpty = false;
    String[] messageArray;
    //DataInputStream input;

    /**
     * 构造SplitMessage对象，拆分message
     * @param messageStr 待拆分的消息
     */
    public MessageSplit(String messageStr) {
        this.messageStr = messageStr;
        if (messageStr.equals(null)) {
            this.isEmpty = true;
        } else if (!messageStr.equals("-1")) {
            //判断收到消息是否合法
            StringTokenizer st = new StringTokenizer(messageStr, ",");
            int count = 0;
            while (st.hasMoreTokens()) {
                st.nextToken();
                count++;
            }
            //System.out.println(count);

            //消息格式合法

            this.isValid = true;
            this.messageArray = messageStr.split(",");
/**5输出*/
System.out.println("SplitMessage类中将要拆分的消息："+messageStr);
            try {
                info = messageArray[5];
                this.infoArray = this.SplitInfo(info, "#");
            } catch (Exception e) {
                this.infoArray = null;
            }
            
        } else if (messageStr.equals("-1")) {
            System.out.println("消息为空");
        }
    }

    /**
     * 拆分消息（通用方法）
     * @param str 需要拆分的字符串
     * @param delimiter 分隔符
     * @param num 元素个数
     * @return
     */
    protected String[] SplitInfo(String str, String delimiter) {

        //判断收到消息是否合法
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
     * 判断消息是否为空，即是否收到消息
     * @return isEmpty 消息是否为空的标记
     */
    protected boolean isEmpty() {
        return this.isEmpty;
    }

    /**
     * 判断消息是否合法（）
     * @return isValid 消息是否合法的标记
     */
    protected boolean isValid() {
        return this.isValid;
    }

    //获取完整信息
    /**
     * 获取完整信息
     * @return request 消息的完整字符串形式
     */
    protected String getMessage() {
        return this.messageStr;
    }

    /**
     * 获取详细参数
     * @return infoArray 详细参数
     */
    protected String[] getInfoArray() {
        return this.infoArray;
    }

    /**
     * 获取详细参数
     * @return infoArray 详细参数
     */
    protected String[] getMessageArray() {
        return this.messageArray;
    }
}
