package com.java.tcp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Description:	   TCP客户端<br/>
 * Date:     0013, September 13 19:27 <br/>
 *
 * @author Aaron CHEN
 * @see
 */
public class TCPClient {

    public static void main(String[] args) {
        //创建请求的socket
        Socket socket = null;
        BufferedWriter writer = null;
        try {
            socket = new Socket("127.0.0.1", 10000);
            //获得输出流
            OutputStream outputStream = socket.getOutputStream();
            writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write("Welcome to TCP");
            writer.newLine();
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
