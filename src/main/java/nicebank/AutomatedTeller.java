package nicebank;

/**
 * Created by liudi on 4/25/15.
 */
public class AutomatedTeller {

    public static void withdrawFrom(CashSlot cashSlot, Account account, int dollars) {
        cashSlot.dispense(dollars);
        account.debit(dollars);

    }
}
