package com.java.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:	   TCP服务器端<br/>
 * Date:     0013, September 13 19:26 <br/>
 *
 * @author Aaron CHEN
 * @see
 */
public class TCPServer {
    public static void main(String[] args) {
        //创建服务器端的套接字
        ServerSocket serverSocket = null;
        BufferedReader reader = null;
        Socket accept = null;
        try {
            serverSocket = new ServerSocket(10000);
            System.out.println("服务器段已启动！");
            //接收客户端的请求
            accept = serverSocket.accept();
            //获取流对象
            InputStream inputStream = accept.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                //读取数据
                String s = reader.readLine();
                InetAddress inetAddress = accept.getInetAddress();
                if ("exit".equals(s)) {
                    break;
                }
                //获取客户端的IP地址
                String hostAddress = inetAddress.getHostAddress();
                System.out.println(hostAddress + "发送的数据是：" + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (accept != null) {
                    accept.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
