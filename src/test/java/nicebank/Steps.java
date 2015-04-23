package nicebank;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import junit.framework.Assert;

/**
 * Created by liudi on 4/23/15.
 */
public class Steps {

    class Account {
        public void deposit(int amount) {
        }

        public int getBalance() {
            return 0;
        }
    }

    @Given("^I have deposited \\$(\\d+) in my account$")
    public void iHaveDeposited$InMyAccount(int amount) throws Throwable {
        Account myAccount = new Account();
        myAccount.deposit(amount);

        Assert.assertEquals("Incorrect account balance -",
                amount, myAccount.getBalance());
    }

    @When("^I request \\$(\\d+)$")
    public void iRequest$(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
