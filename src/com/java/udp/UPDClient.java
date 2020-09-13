package com.java.udp;

import java.io.IOException;
import java.net.*;

/**
 * Description:	   UDP客户端<br/>
 * Date:     0013, September 13 19:16 <br/>
 *
 * @author Aaron CHEN
 * @see
 */
public class UPDClient {
    public static void main(String[] args) {
        //创建客户端Socket对象
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            String string = "Welcome to Network Programming！";
            //创建数据包
            DatagramPacket packet = new DatagramPacket(string.getBytes("UTF-8"), string.length(), InetAddress.getByName("127.0.0.1"), 10000);
            //发送数据
            socket.send(packet);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
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
