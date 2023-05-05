package expansionmoduleexample;

import com.integpg.sensor.SensorPort;
import com.integpg.system.JANOS;
import java.io.IOException;

public class ExpansionModuleExample {

    public static void main(String[] args) throws IOException {

        int maModule = 0;
        int voltModule = 0;
        int tempProbe = 0;
        int fourRout = 0;

        long[] devices;
        devices = SensorPort.externalDeviceList();
        for (int i = 0; i < devices.length; i++) {
            if (Long.toHexString(devices[i]).endsWith("fe")) {
                maModule++;
            }
            if (Long.toHexString(devices[i]).endsWith("fd")) {
                voltModule++;
            }
            if (Long.toHexString(devices[i]).endsWith("fb")) {
                tempProbe++;
            }
            if (Long.toHexString(devices[i]).endsWith("28")) {
                fourRout++;
            }
        }

        System.out.println(String.format("%d 4-20ma modules connected", maModule));
        System.out.println(String.format("%d 10-volt modules connected", voltModule));
        System.out.println(String.format("%d Temperature probes connected", tempProbe));
        System.out.println(String.format("%d 4-rout modules connected\n", fourRout));

        if (maModule != 0) {
            int y = 0;
            int z = 0;
            try {
                for (int i = 0; i < maModule; i++) {
                    System.out.println(String.format("4-20ma module %d", i + 1));
                    Double maInput1 = SensorPort.get420In(y);
                    System.out.println(String.format("Input %d: %.3f", y + 1, maInput1));
                    y++;
                    Double maInput2 = SensorPort.get420In(y);
                    System.out.println(String.format("Input %d: %.3f", y + 1, maInput2));
                    y++;
                    Double maInput3 = SensorPort.get420In(y);
                    System.out.println(String.format("Input %d: %.3f", y + 1, maInput3));
                    y++;
                    Double maInput4 = SensorPort.get420In(y);
                    System.out.println(String.format("Input %d: %.3f", y + 1, maInput4));
                    y++;
                    Double maOutput1 = SensorPort.get420Out(z);
                    System.out.println(String.format("Output %d: %.3f", z + 1, maOutput1));
                    z++;
                    Double maOutput2 = SensorPort.get420Out(z);
                    System.out.println(String.format("Output %d: %.3f\n", z + 1, maOutput2));
                    z++;
                }
            } catch (IOException e) {
                JANOS.logfile("/expansionmoduleexample.log", "Expansion module was removed."
                        + " Remove connected expansion modules from JNIOR. Then perform"
                        + " extern -r command to reset saved expansion modules registry keys."
                        + " Reconnect expansion modules and run application again.");
            }
        }
        if (voltModule != 0) {
            int y = 0;
            int z = 0;
            try {
                for (int i = 0; i < voltModule; i++) {
                    System.out.println(String.format("10volt module %d", i + 1));
                    Double voltInput1 = SensorPort.get10vIn(y);
                    System.out.println(String.format("Input %d: %.3f", y + 1, voltInput1));
                    y++;
                    Double voltInput2 = SensorPort.get10vIn(y);
                    System.out.println(String.format("Input %d: %.3f", y + 1, voltInput2));
                    y++;
                    Double voltInput3 = SensorPort.get10vIn(y);
                    System.out.println(String.format("Input %d: %.3f", y + 1, voltInput3));
                    y++;
                    Double voltInput4 = SensorPort.get10vIn(y);
                    System.out.println(String.format("Input %d: %.3f", y + 1, voltInput4));
                    y++;
                    Double voltOutput1 = SensorPort.get10vOut(z);
                    System.out.println(String.format("Output %d: %.3f", z + 1, voltOutput1));
                    z++;
                    Double voltOutput2 = SensorPort.get10vOut(z);
                    System.out.println(String.format("Output %d: %.3f\n", z + 1, voltOutput2));
                    z++;
                }
            } catch (IOException e) {
                JANOS.logfile("/expansionmoduleexample.log", "Expansion module was removed."
                        + " Remove connected expansion modules from JNIOR. Then perform"
                        + " extern -r command to reset saved expansion modules registry keys."
                        + " Reconnect expansion modules and run application again.");
            }
        }
        if (tempProbe != 0) {
            try {
                for (int i = 0; i < tempProbe; i++) {
                    System.out.println(String.format("temp probe %d temperature", i + 1));
                    Double temp = SensorPort.getTemp(i);
                    System.out.println(String.format("%.3f\n", temp));
                }
            } catch (IOException e) {
                JANOS.logfile("/expansionmoduleexample.log", "Expansion module was removed."
                        + " Remove connected expansion modules from JNIOR. Then perform"
                        + " extern -r command to reset saved expansion modules registry keys."
                        + " Reconnect expansion modules and run application again.");
            }
        }
        if (fourRout != 0) {
            try {
                String getAllOutputs = Integer.toString(SensorPort.getOutputStates());
                System.out.println(String.format("%s is the relay state mask for JNIOR and 4-rout module", getAllOutputs));
                System.out.println("Now setting outputs");
                SensorPort.setOutputStates(15, 15);
                
            } catch (IOException e) {
                JANOS.logfile("/expansionmoduleexample.log", "Expansion module was removed."
                    + " Remove connected expansion modules from JNIOR. Then perform"
                    + " extern -r command to reset saved expansion modules registry keys."
                    + " Reconnect expansion modules and run application again.");
            }
        }
    }
}
