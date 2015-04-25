package support;

import nicebank.Account;
import nicebank.CashSlot;
import nicebank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by liudi on 4/25/15.
 */
public class KnowsTheDomain {
    private Account myAccount;
    private Teller teller;
    private CashSlot cashSlot;

    public Account getMyAccount() {
        if (myAccount == null) {
            myAccount = new Account();
        }

        return myAccount;
    }

    class AtmUserInterface implements Teller {

        private final EventFiringWebDriver webDriver;

        public AtmUserInterface() {
            this.webDriver = new EventFiringWebDriver(new FirefoxDriver());
        }

        public void withdrawFrom(Account account, int dollars) {
            try {
                webDriver.get("http://localhost:9988");
                webDriver.findElement(By.id("Amount"))
                        .sendKeys(String.valueOf(dollars));
                webDriver.findElement(By.id("Withdraw")).click();
            }
            finally {
                webDriver.close();
            }
        }
    }

    public Teller getTeller() {
        if (teller == null) {
            teller = new AtmUserInterface();
        }

        return teller;
    }

    public CashSlot getCashSlot() {
        if (cashSlot == null) {
            cashSlot = new CashSlot();
        }

        return cashSlot;
    }
}
