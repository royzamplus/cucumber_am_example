package hooks;

import cucumber.api.java.Before;
import nicebank.Account;
import nicebank.TransactionQueue;
import org.javalite.activejdbc.Base;
import support.AtmInterfaceFactory;

/**
 * Created by liudi on 4/25/15.
 */
public class ResetHooks {

    @Before(order = 1)
    public void reset() {
        if (!Base.hasConnection()) {
            Base.open(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost/bank",
                    "teller", "password");
        }

        Account.deleteAll();

        TransactionQueue.clear();

        AtmInterfaceFactory.reset();
    }
}
