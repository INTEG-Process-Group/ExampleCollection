package loggingexample;

import com.integpg.system.JANOS;

public class LoggingExample {

    public static void main(String[] args) {
        
        //log message to log file
        JANOS.logfile("/temp/loggingExample.log", "This will create a log in"
                + " the temp folder of the JNIOR called loggingExample");
        
    }
    
}
