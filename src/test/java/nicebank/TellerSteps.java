package nicebank;

import cucumber.api.java.en.When;
import support.KnowsTheDomain;

/**
 * Created by liudi on 4/25/15.
 */
public class TellerSteps {
    KnowsTheDomain helper;

    public TellerSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iWithdraw$(int dollars) throws Throwable {
        helper.getTeller().withdrawFrom(helper.getMyAccount(), dollars);
    }
}
