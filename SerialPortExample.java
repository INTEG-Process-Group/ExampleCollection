package serialportexample;

import com.integpg.comm.AUXSerialPort;
import com.integpg.comm.PortInUseException;
import com.integpg.comm.SerialPort;
import java.io.IOException;
import java.io.OutputStream;

public class SerialPortExample {

    public static SerialPort AUX = null;
    public static OutputStream outputStream = null;
    
    public static void main(String[] args) throws PortInUseException, IOException {

        //create aux port object and open an aux port connection.
        AUX = new AUXSerialPort();
        AUX.open();

        //create object for aux outputstream and send message out aux port.
        outputStream = AUX.getOutputStream();
        outputStream.write("This was sent from the AUX port.".getBytes());
        
    }

}
