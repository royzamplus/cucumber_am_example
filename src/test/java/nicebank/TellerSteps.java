package nicebank;

import cucumber.api.java.en.When;
import support.AtmUserInterface;
import support.TestAccount;

/**
 * Created by liudi on 4/25/15.
 */
public class TellerSteps {
    TestAccount account;
    Teller teller;

    public TellerSteps(AtmUserInterface teller, TestAccount account) {
        this.teller = teller;
        this.account = account;
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iWithdraw$(int dollars) throws Throwable {
       teller.withdrawFrom(account, dollars);
    }
}
