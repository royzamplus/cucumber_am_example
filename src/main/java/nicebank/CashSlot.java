package nicebank;

/**
 * Created by liudi on 4/25/15.
 */
public class CashSlot {
    private int contents;
    private int available;

    public int getContents() {
        return contents;
    }

    public boolean canDispense(int requested) {
        return requested <= available;
    }

    public void load(int dollars) {
        available = dollars;
    }

    public void dispense(int requested) {
        if (available >= requested) {
            contents = requested;
            available -= requested;
        } else {
            throw new RuntimeException("Insufficient ATM funds");
        }
    }
}
