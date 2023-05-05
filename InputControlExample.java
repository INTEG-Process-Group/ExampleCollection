package inputcontrolexample;

import com.integpg.system.JANOS;
import java.io.IOException;
import static java.lang.Thread.sleep;

public class InputControlExample {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        //Use input conditioning to invert input 1's status
        JANOS.setInputConditioning(0, JANOS.INPUT_COND_INVERT);
        //print out the current mask of inputs that are on.
        System.out.println(String.format("current input states are %d\n", JANOS.getInputStates()));
        sleep(3000);
        //Turn off input 1's inversion
        JANOS.setInputConditioning(0, JANOS.INPUT_COND_NONE);
        sleep(1000);
        //Check and manipulate input 1 counter
        System.out.println(String.format("Current counter value for input 1: %d\n", JANOS.getInputCounter(0)));
        JANOS.incInputCounter(0);
        System.out.println(String.format("Current counter value for input 1 after being incremented: %d\n", JANOS.getInputCounter(0)));
        JANOS.setInputCounter(0, 100);
        System.out.println(String.format("Current counter value for input 1 after being set to 100: %d\n", JANOS.getInputCounter(0)));
        //print out usage meter value for input 1, values may change for different model JNIOR:
        System.out.println(String.format("Current usage meter value for input 1: %d\n", JANOS.getUsageMeter(0)));
        
    }

}
