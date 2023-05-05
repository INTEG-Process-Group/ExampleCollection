package immutableexample;

import com.integpg.system.Immutable;
import java.util.Date;

public class ImmutableExample {

    public static void main(String[] args) {
// get an array of long values that represent the last 5 boot times 
        long[] lastFiveBootTimes = Immutable.getLongArray("BootTimes");
// if the array does not already exist then create an array of 5 long values 
        if (lastFiveBootTimes == null) {
            lastFiveBootTimes = Immutable.createLongArray("BootTimes", 5);
        }
// shift the previous 4 boot times 
        for (int i = 4; i > 0; i--) {
            lastFiveBootTimes[i] = lastFiveBootTimes[i - 1];
        }
// assign the most recent boot time 
        lastFiveBootTimes[0] = System.currentTimeMillis();
// loop through our last five boot times and print them in a readable format 
        for (int i = 0; i < 5; i++) {
            long bootTime = lastFiveBootTimes[i];
            if (bootTime > 0) {
                System.out.println(new Date(bootTime));
            }
        }
    }
}
