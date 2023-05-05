package immutableexample2;

import com.integpg.system.Immutable;
import java.io.IOException;

public class ImmutableExample2 {

    public static void main(String[] args) throws IOException {
        
        long[] test = Immutable.getLongArray("aaaaaaaa");
        test[1] = 40000;
        System.out.println("Immutable Array's second block was written to.");
        System.out.println("Printing out Immutable Long Array values:");
        System.out.println(String.format("Immutable spot at 0 is: %lld", test[0]));
        System.out.println(String.format("Immutable spot at 1 is: %lld", test[1]));
        Immutable.remove("aaaaaaaa");
    }
    
}
