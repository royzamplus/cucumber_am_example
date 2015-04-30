package support;

import hooks.ServerHooks;
import nicebank.Account;
import nicebank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by liudi on 4/25/15.
 */
public class AtmUserInterface implements Teller {

    @Autowired
    private EventFiringWebDriver webDriver;

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

    public void type(int amount) {
        webDriver.get("http://localhost:" + ServerHooks.PORT);
        WebElement input = webDriver.findElement(By.id("amount"));
        String amountString = String.valueOf(amount);
        input.sendKeys(amountString);
    }

    public boolean isDisplaying(String message) {
        List<WebElement> list = webDriver.findElements(
                By.xpath("//*[contains(text(), '" + message + "')]"));
        return (list.size() > 0);
    }
}
