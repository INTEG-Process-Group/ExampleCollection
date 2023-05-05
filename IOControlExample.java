package iocontrolexample;

import com.integpg.system.JANOS;
import java.io.IOException;
import static java.lang.Thread.sleep;

public class IOControlExample {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        //Pulse output 1 for 3 seconds
        JANOS.setOutputPulsed(1, 1, 3000);
        sleep(4000);
        //Pulse output 2 and 3 for 3 seconds
        JANOS.setOutputPulsed(6, 6, 3000);
        sleep(4000);
        //Check if output 1 is on
        System.out.println(String.format("Is output 1 on: %s\n", String.valueOf(JANOS.isOutputSet(0))));
        //Check and manipulate input 1 counter
        System.out.println(String.format("Current counter value for input 1: %d\n", JANOS.getInputCounter(0)));
        JANOS.incInputCounter(0);
        System.out.println(String.format("Current counter value for input 1 after being incremented: %d\n", JANOS.getInputCounter(0)));
        JANOS.setInputCounter(0, 100);
        System.out.println(String.format("Current counter value for input 1 after being set to 100: %d\n", JANOS.getInputCounter(0)));
        //print out usage meter value for input 1 and output 1, values may change for different model JNIOR:
        //for JNIOR 412 0 and 4
        //for JNIOR 414 0 and 12
        System.out.println(String.format("Current usage meter value for input 1: %d\n", JANOS.getUsageMeter(0)));
        System.out.println(String.format("Current usage meter value for output 1: %d\n", JANOS.getUsageMeter(8)));
        //print out the current mask of inputs and outputs that are on.
        System.out.println(String.format("current input states are %d\n", JANOS.getInputStates()));
        System.out.println(String.format("current output states are %d\n", JANOS.getOutputStates()));
        
    }

}
