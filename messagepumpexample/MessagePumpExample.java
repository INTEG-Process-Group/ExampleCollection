package messagepumpexample;

import com.integpg.system.MessagePump;
import com.integpg.system.SystemMsg;
import static java.lang.Thread.sleep;
import java.util.Vector;

public class MessagePumpExample {

    private static final MessagePump MESSAGE_PUMP = new MessagePump();
    private static final Vector LISTENERS = new Vector<>();
    
    public static void addListener(MessagePumpListener listener) {
        
        synchronized (LISTENERS) {
            LISTENERS.addElement(listener);
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        MESSAGE_PUMP.open();
        while (true) {
            System.out.println("looping");
            // read all messages from the message pump
            SystemMsg systemMsg = MESSAGE_PUMP.getMessage();
            // we must repost as fast as we can
            MESSAGE_PUMP.postMessage(systemMsg);
            String message = new String(systemMsg.msg); 
            if (systemMsg.type == 1600) {

                System.out.println("Recieved command 1600.\n");
                System.out.println(String.format("The message was: %s\n", message));

            }
            sleep(10);
        }
    }
    
}
