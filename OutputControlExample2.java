package outputcontrolexample2;

import com.integpg.system.IoEvent;
import com.integpg.system.Iolog;
import com.integpg.system.JANOS;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;

public class OutputControlExample2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        //gets the current time as a long.
        long now = System.currentTimeMillis();
        
        JANOS.setOutputPulsed(8, 8, 3000);
        sleep(4000);
        
        //iolog object for getting I/O events
        //refresh Iolog so getting output events from it are only output evetns
        //from when this application start AKA the outputs we just pulsed. 
        Iolog iolog = new Iolog();
        iolog.refresh(now);
        IoEvent[] events = iolog.getOutputEvents();

        //for each output event in the iolog, print the output states at that
        //time and the timestamp it occured.
        if (events.length > 0) {
            //SimpleDateFormat object that formats the timestamps of the IO events
            //into a caladender date and time.
            SimpleDateFormat date = new SimpleDateFormat("MM/dd/yy HH:mm:ss.SSS");
            for (int i = iolog.getOutputEvents().length - 1; i >= 0; i--) {
                System.out.println(String.format("States: %d @ %s\n",
                        events[i].states, date.format(events[i].timestamp)));
            }
        } else {
            System.out.println("no output events...\n");
        }
        
    }
    
}
