package messagepumpexamplesender;

import com.integpg.system.MessagePump;
import com.integpg.system.SystemMsg;
import static java.lang.Thread.sleep;

public class MessagePumpExampleSender {

    private static final MessagePump MESSAGE_PUMP = new MessagePump();

    public static void main(String[] args) throws InterruptedException {
        MESSAGE_PUMP.open();
        SystemMsg systemMsg = new SystemMsg();
        systemMsg.type = 1600;
        systemMsg.msg = "This message is from the MessagePumpExampleSender".getBytes();
        MESSAGE_PUMP.postMessage(systemMsg);
        sleep(5000);
        MESSAGE_PUMP.close();
    }
    
}
