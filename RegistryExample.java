package registryexample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.integpg.system.JANOS;
import java.io.IOException;

public class RegistryExample {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String stringRegistry = JANOS.getRegistryString("AppData/RegistryTest", "Registry not created yet.");
        System.out.println(String.format("Current registry value was: %s", stringRegistry));
        System.out.print("Enter new string value for registry: ");
        String registryValue = br.readLine();
        JANOS.setRegistryString("AppData/RegistryTest", registryValue);
        System.out.println("\nExiting");
    }

}
