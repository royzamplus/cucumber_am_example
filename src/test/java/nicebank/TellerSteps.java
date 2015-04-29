package nicebank;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import support.AtmUserInterface;

/**
 * Created by liudi on 4/25/15.
 */
public class TellerSteps {
    @Autowired
    private Account account;

    @Autowired
    private AtmUserInterface teller;

    @When("^I withdraw \\$(\\d+)$")
    public void iWithdraw$(int dollars) throws Throwable {
       teller.withdrawFrom(account, dollars);
    }

    @Given("^I request some of my money$")
    public void iRequestSomeOfMyMoney() {
        int dollarsRequested = 10;
        teller.withdrawFrom(account, dollarsRequested);
    }

    @Then("^I should see an out-of-order message$")
    public void iShouldSeeAnOutOfOrderMessage() throws Throwable {
        Assert.assertTrue("Expected error message not displayed",
                teller.isDisplaying("Out of order"));
    }
}
