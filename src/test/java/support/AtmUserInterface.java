package support;

import hooks.ServerHooks;
import nicebank.Account;
import nicebank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.List;

/**
 * Created by liudi on 4/25/15.
 */
public class AtmUserInterface implements Teller {

    @Autowired
    private EventFiringWebDriver webDriver;

    public void withdrawFrom(Account account, int dollars) {
        webDriver.get("http://localhost:" + ServerHooks.PORT);
        webDriver.findElement(By.id("amount"))
                .sendKeys(String.valueOf(dollars));
        webDriver.findElement(By.id("withdraw")).click();
    }

    public void type(int amount) {
        webDriver.get("http://localhost:" + ServerHooks.PORT);
        WebElement input = webDriver.findElement(By.id("amount"));
        String amountString = String.valueOf(amount);
        for (int i = 0; i<amountString.length(); i++) {
            input.sendKeys(convertToKey(amountString.charAt(i)));
        }

        // ask("Ready to continue");
    }

    public void ask(String question) {
        JOptionPane.showMessageDialog(
                null,
                question,
                "Ask for response",
                JOptionPane.PLAIN_MESSAGE);
    }

    public boolean isDisplaying(String message) {
        By locator = By.xpath("//*[contains(text(),'" + message + "')]");

        WebDriverWait wait = new WebDriverWait(webDriver, 2, 30);
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator));

        List<WebElement> list = webDriver.findElements(locator);
        return (list.size() > 0);
    }

    private Keys convertToKey(char digit) {
        switch (digit){
            case '0': return Keys.NUMPAD0;
            case '1': return Keys.NUMPAD1;
            case '2': return Keys.NUMPAD2;
            case '3': return Keys.NUMPAD3;
            case '4': return Keys.NUMPAD4;
            case '5': return Keys.NUMPAD5;
            case '6': return Keys.NUMPAD6;
            case '7': return Keys.NUMPAD7;
            case '8': return Keys.NUMPAD8;
            case '9': return Keys.NUMPAD9;
            default: throw new RuntimeException("Invalid keypress in test");
        }
    }
}
