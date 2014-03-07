package com.monitor.listener;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.monitor.agent.UIAgent;
import com.monitor.contents.Content;
import com.monitor.entity.Client;


/**
 * @author Sugar
 *	�ͻ��˼�����
 *
 */
//Ҫ��һ��client�б�,�����ǲ���Ҫд�����ݿ�����  Ҫ��Ȼ��֪�������˭�ˣ��������������ߵ�ʱ���list����ȥ��
public class ClientListener implements Runnable{

	 /**
     * �������׽��֣��ȴ��ͻ��˵�����
     */
    private ServerSocket serverSocket;

    /**
     * ����ͻ��˼����߳�.
     * ���̼߳��뵽��Ӧ��messageQueue��
     */
    public ClientListener() {
        try {
            this.serverSocket = new ServerSocket(Content.CLIENT_LISTENING_PORT);
            
            UIAgent.addClientList("�������Կͻ��˵���Ϣ");
        } catch (IOException ex) {
            System.out.println("���������ͻ���ʧ��");
        }
    }
	
	@Override
	public void run() {
		System.out.println("�߳��Ѿ����������ˣ�����");
		 while(true) {
	            Socket socket = null;
	            try {
	                socket = serverSocket.accept();
	                UIAgent.addClientList("��ͻ��ˣ�"+socket.getInetAddress().toString()+":"+socket.getPort()+"����Socket����");
	/**1���*/
	System.out.println("ClientListening�ࣺ�ͻ��˺ͼ�ض˽��������ӣ���ʼ���ض˷�����Ϣ����������");
	                //input = new DataInputStream(socket.getInputStream());
	                //output = new DataOutputStream(socket.getOutputStream());
	            } catch (IOException ex) {
	                //System.out.println("������");
	            }

	            //this.extendedPool = InstanceManager.getExtendedPool();
//	            extendedPool.createTask(new Client(socket));
	            //�ǲ���Ҫ��������ӵ�ʲô
	            new Thread(new Client(socket)).start();
	        }
	}

}
