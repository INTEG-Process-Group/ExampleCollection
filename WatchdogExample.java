package watchdogexample;
 
import com.integpg.system.JANOS;
import com.integpg.system.Watchdog;
 
public class WatchdogExample {
 
    public static void main(String[] args) throws InterruptedException {
        JANOS.syslog("WatchdogExample started");
 
        // create a watchdog that will reboot the jnior if the watchdog is 
        // not fed once every 5 seconds
        Watchdog watchdog = new Watchdog("WatchdogExample");
        watchdog.setAction(Watchdog.WDT_REBOOT);
        watchdog.setDuration(5000);
        watchdog.activate();
        JANOS.syslog("WatchdogExample activated");
 
        // loop for 30 seconds.  we will feed the watchdog in this loop.  
        // when the loop stops the watchdog will timeout and reboot the jnior.
        long loopExpiration = System.currentTimeMillis() + 30000;
        while (loopExpiration > System.currentTimeMillis()) {
            System.out.print(".");
            // feed the watchdog
            watchdog.refresh();
            // sleep for a second
            Thread.sleep(1000);
        }
 
        // now that the loop is finished.  the unit will reboot soon.
        JANOS.syslog("WatchdogExample loop finished");
    }
 
}