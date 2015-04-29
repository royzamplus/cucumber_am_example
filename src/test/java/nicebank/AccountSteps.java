package nicebank;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import transforms.MoneyConverter;

/**
 * Created by liudi on 4/25/15.
 */
public class AccountSteps {
    @Autowired
    Account account;

    private Money originalBalance;

    @Given("^my account has been credited with (\\$\\d+\\.\\d+)$")
    public void myAccountHasBeenCreditedWith$(
            @Transform(MoneyConverter.class) Money amount) throws Throwable {
        account.credit(amount);
    }

    @Given("^my account is in credit$")
    public void myAccountIsInCredit$() throws Throwable {
        originalBalance = new Money(30, 00);
        account.credit(originalBalance);
    }

    @Then("^the balance of my account should be unchanged$")
    public void theBalanceOfMyAccountShouldBeUnchanged() throws Throwable{
        checkBalanceIs(originalBalance);
    }

    @Then("^the balance of my account should be (\\$\\d+\\.\\d+)$")
    public void theBalanceOfMyAccountShouldBe$(
            @Transform(MoneyConverter.class) Money amount) throws Throwable {

        checkBalanceIs(amount);
    }

    private void checkBalanceIs(Money amount) throws InterruptedException {
        int timeoutMilliSecs = 3000;
        int pollIntervalMilliSecs = 100;

        // smart sleep
        while (!account.getBalance().equals(amount)
                && timeoutMilliSecs > 0) {
            Thread.sleep(pollIntervalMilliSecs);
            timeoutMilliSecs -= pollIntervalMilliSecs;
        }

        Assert.assertEquals("Incorrect account balance -",
                amount, account.getBalance());
    }
}
