package support;

import hooks.ServerHooks;
import nicebank.Account;
import nicebank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by liudi on 4/25/15.
 */
@Component
@Scope("cucumber-glue")
public class AtmUserInterface implements Teller {

    private final EventFiringWebDriver webDriver;

    @Autowired
    public AtmUserInterface(MyWebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void withdrawFrom(Account account, int dollars) {
        try {
            webDriver.get("http://localhost:" + ServerHooks.PORT);
            webDriver.findElement(By.id("amount"))
                    .sendKeys(String.valueOf(dollars));
            webDriver.findElement(By.id("withdraw")).click();
        }
        finally {
            webDriver.close();
        }
    }
}
