package messagepumpexample;

import com.integpg.system.SystemMsg;

public interface MessagePumpListener {
    
     public void messageReceived(SystemMsg systemMsg);
    
}
