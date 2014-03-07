/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.monitor.test;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class SocketConn {
     private String ip;
     int port;
    private Socket socket;
    private boolean error = false;
    private DataOutputStream dos;
    private DataInputStream dis;

    public boolean isError() {
        return error;
    }

    //构造函数，建立与服务器的连接
    public SocketConn(String ip, int port) {
        this.ip = ip;
        this.port = port;
//        try {
//            socket = new Socket(InetAddress.getByName(ip), port);
//            this.dos = new DataOutputStream(socket.getOutputStream());
//            this.dis = new DataInputStream(socket.getInputStream());
//        } catch (IOException ex) {
//            System.out.println("Socket连接失败");
//            ex.printStackTrace();
//            this.error = true;
//        }
    }

    public Socket getSocket() {
        return socket;
    }

    //发送消息
    public void sendMessage(String messageStr) {
        try {
            socket = new Socket(ip, port);
            this.dos = new DataOutputStream(socket.getOutputStream());
            this.dis = new DataInputStream(socket.getInputStream());
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream(); //该类实现一个以字节数组形式写入数据的输出流。当数据写入缓冲区时，它自动扩大
            DataOutputStream out = new DataOutputStream(byteOut);
            out.writeUTF(messageStr); //以UTF的形式将消息写入out的写入目标：byteOut流
            out.flush(); //相当于写入输出流
            byte buf[] = byteOut.toByteArray();
            this.dos.write(buf); //将这个buf数组的内容写入output流中
            this.dos.flush();
            byteOut.close();
            out.close();
        } catch (IOException ex) {
            System.out.println("发送消息失败！");
        }
    }

    public String getAckMess() { //得到反馈
        try {
           return this.dis.readUTF();
        } catch (IOException ex) {
            return null;
        }
    }

    public DataOutputStream getServDOS() {
        try {
            dos = new DataOutputStream(this.socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(SocketConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dos;
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException ex) {
            System.out.println("连接未能正常关闭！");
        }
    }
}
