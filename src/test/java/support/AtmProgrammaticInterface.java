package support;

import nicebank.Account;
import nicebank.AutomatedTeller;
import nicebank.CashSlot;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liudi on 5/1/15.
 */
public class AtmProgrammaticInterface implements AtmInterface {
    @Autowired
    private CashSlot cashSlot;

    RuntimeException runtimeException;

    public void type(int amount) {

    }

    public boolean isDisplaying(String message) {
        return true;
    }

    public void withdrawFrom(Account account, int amount) {
        try {
            AutomatedTeller.withdrawFrom(cashSlot, account, amount);
        } catch (RuntimeException e) {
            runtimeException = e;
        }
    }
}
