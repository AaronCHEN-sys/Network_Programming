package com.java.tcp;

import java.io.*;
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
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            socket = new Socket("127.0.0.1", 10000);
            //获得输出流
            OutputStream outputStream = socket.getOutputStream();
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            String line = null;
            while (true) {
                line = reader.readLine();
                writer.write(line);
                writer.newLine();
                writer.flush();
                if ("exit".equals(line)) {
                    break;
                }
            }
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
