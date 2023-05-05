package immutableexample3;

import com.integpg.system.Immutable;
import java.io.IOException;

public class ImmutableExample3 {

    public static void main(String[] args) throws IOException {
        long[] test = Immutable.createLongArray("aaaaaaaa", 2);
        test[0] = 20000;
        System.out.println("Immutable Array's first block was written to.");

    }

}
