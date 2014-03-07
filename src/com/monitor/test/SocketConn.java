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

    //���캯���������������������
    public SocketConn(String ip, int port) {
        this.ip = ip;
        this.port = port;
//        try {
//            socket = new Socket(InetAddress.getByName(ip), port);
//            this.dos = new DataOutputStream(socket.getOutputStream());
//            this.dis = new DataInputStream(socket.getInputStream());
//        } catch (IOException ex) {
//            System.out.println("Socket����ʧ��");
//            ex.printStackTrace();
//            this.error = true;
//        }
    }

    public Socket getSocket() {
        return socket;
    }

    //������Ϣ
    public void sendMessage(String messageStr) {
        try {
            socket = new Socket(ip, port);
            this.dos = new DataOutputStream(socket.getOutputStream());
            this.dis = new DataInputStream(socket.getInputStream());
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream(); //����ʵ��һ�����ֽ�������ʽд�����ݵ��������������д�뻺����ʱ�����Զ�����
            DataOutputStream out = new DataOutputStream(byteOut);
            out.writeUTF(messageStr); //��UTF����ʽ����Ϣд��out��д��Ŀ�꣺byteOut��
            out.flush(); //�൱��д�������
            byte buf[] = byteOut.toByteArray();
            this.dos.write(buf); //�����buf���������д��output����
            this.dos.flush();
            byteOut.close();
            out.close();
        } catch (IOException ex) {
            System.out.println("������Ϣʧ�ܣ�");
        }
    }

    public String getAckMess() { //�õ�����
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
            System.out.println("����δ�������رգ�");
        }
    }
}
