package outputcontrolexample;

import com.integpg.system.JANOS;
import java.io.IOException;
import static java.lang.Thread.sleep;

public class OutputControlExample {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        //Pulse output 1 for 3 seconds
        JANOS.setOutputPulsed(1, 1, 3000);
        sleep(4000);
        //Pulse output 2 and 3 for 3 seconds
        JANOS.setOutputPulsed(6, 6, 3000);
        //print out the current mask of outputs that are on.
        System.out.println(String.format("current output states are %d\n", JANOS.getOutputStates()));
        sleep(4000);
        //Check if output 1 is on
        System.out.println(String.format("Is output 1 on: %s\n", String.valueOf(JANOS.isOutputSet(0))));
        //print out usage meter value for output 1, values may change for different model JNIOR:
        System.out.println(String.format("Current usage meter value for output 1: %d\n", JANOS.getUsageMeter(8)));
        
    }

}
