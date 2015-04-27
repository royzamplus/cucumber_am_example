package support;

import nicebank.Account;
import nicebank.CashSlot;
import nicebank.Teller;
import org.javalite.activejdbc.Base;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by liudi on 4/25/15.
 */
public class KnowsTheDomain {
    private Account myAccount;
    private Teller teller;
    private CashSlot cashSlot;
    private EventFiringWebDriver webDriver;

    public KnowsTheDomain() {
        if (!Base.hasConnection()) {
            Base.open(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost/bank",
                    "teller", "password"
            );

            Account.deleteAll();
        }
    }

    public Account getMyAccount() {
        if (myAccount == null) {
            myAccount = new Account(1234);
            myAccount.saveIt();
        }

        return myAccount;
    }

    public Teller getTeller() {
        if (teller == null) {
            teller = new AtmUserInterface(getWebDriver());
        }

        return teller;
    }

    public CashSlot getCashSlot() {
        if (cashSlot == null) {
            cashSlot = new CashSlot();
        }

        return cashSlot;
    }

    public EventFiringWebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = new EventFiringWebDriver(new FirefoxDriver());
        }

        return webDriver;
    }
}
