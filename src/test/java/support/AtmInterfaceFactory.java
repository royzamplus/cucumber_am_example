package support;

import org.apache.bcel.generic.IF_ACMPEQ;

/**
 * Created by liudi on 5/1/15.
 */
public class AtmInterfaceFactory {

    private static boolean bypassTellerUI = false;

    public static void reset() {
        bypassTellerUI = false;
    }

    public static void bypassTellerUI() {
        bypassTellerUI = true;
    }

    public static AtmInterface createAtmInterface() {
        if (bypassTellerUI) {
            return new AtmProgrammaticInterface();
        } else {
            return new AtmUserInterface();
        }
    }
}
