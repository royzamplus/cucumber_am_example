package nicebank;

/**
 * Created by liudi on 4/25/15.
 */
public class AutomatedTeller implements Teller {
    private CashSlot cashSlot;

    public AutomatedTeller(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public void withdrawFrom(Account account, int dollars) {
        cashSlot.dispense(dollars);
        account.debit(dollars);

    }
}
