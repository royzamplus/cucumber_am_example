package nicebank;

/**
 * Created by liudi on 4/25/15.
 */
public class CashSlot {
    private int contents;

    public int getContents() {
        return contents;
    }

    public void dispense(int dollars) {
        contents = dollars;
    }
}
