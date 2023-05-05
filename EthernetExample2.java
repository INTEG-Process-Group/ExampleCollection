package ethernetexample2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class EthernetExample2 {

    public static DatagramSocket udpsocket;
    public static InetAddress address;
    public static byte[] buf;
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        
    udpsocket = new DatagramSocket();
    address = InetAddress.getByName("10.0.0.17");

       try {
        buf = "This was sent from a UDP connection.".getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 9222);
        udpsocket.send(packet);
        } catch (NullPointerException e) {
        }
    }
    
}
