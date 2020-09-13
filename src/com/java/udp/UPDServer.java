package com.java.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Description:	   UDP服务器端<br/>
 * Date:     0013, September 13 19:09 <br/>
 *
 * @author Aaron CHEN
 * @see
 */
public class UPDServer {
    public static void main(String[] args) {
        //创建服务器端Socket对象
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(10000);
            //创建字节数组
            byte[] bytes = new byte[1024];
            //创建数据包
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            System.out.println("UDP服务器端已启动！");
            //接收数据
            socket.receive(packet);
            //获取客户端的IP地址
            InetAddress address = packet.getAddress();//获得数据
            byte[] data = packet.getData();
            //获得接受数据的长度
            int length = packet.getLength();
            //接受数据的字符串
            String string = new String(data, 0, length);
            System.out.println(address.getHostAddress() + "发送的数据是:" + string);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
