package ethernetexample;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class EthernetExample {

    //declare output stream and socket objects for an ethernet connection
    public static OutputStream outputStream = null;
    public static Socket socket = null;
    
    public static void main(String[] args) throws IOException {

        //set IP and port number
        int portOut = 9223;
        String IP = "10.0.0.17";

        try {
            //set socket and then create outputstream with socket
            socket = new Socket(IP, portOut);
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (NullPointerException e) {
        }
        
        try {
            //send message out the outputstream
            outputStream.write("This was sent from an ethernet connection.".getBytes());
            outputStream.flush();
        } catch (NullPointerException e) {}
        
    }

}
