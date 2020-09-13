package com.java.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Description:	   <br/>
 * Date:     0013, September 13 18:01 <br/>
 *
 * @author Aaron CHEN
 * @see
 */
public class NetworkDeno {

    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String hostAddress = localHost.getHostAddress();
            String hostName = localHost.getHostName();

            System.out.println("localHost=" + localHost);
            System.out.println("hostAddress=" + hostAddress);
            System.out.println("hostName=" + hostName);

            //获得一个远程的IP
            InetAddress name = InetAddress.getByName("14.215.177.39");
            System.out.println(name.getHostAddress());
            System.out.println(name.getHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
