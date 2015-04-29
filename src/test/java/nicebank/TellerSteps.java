package nicebank;

import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import support.AtmUserInterface;
import support.TestAccount;

/**
 * Created by liudi on 4/25/15.
 */
public class TellerSteps {
    @Autowired
    private TestAccount account;

    @Autowired
    private Teller teller;

    @When("^I withdraw \\$(\\d+)$")
    public void iWithdraw$(int dollars) throws Throwable {
       teller.withdrawFrom(account, dollars);
    }
}
