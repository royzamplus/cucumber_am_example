package nicebank;

import cucumber.api.java.en.Then;
import junit.framework.Assert;
import support.KnowsTheDomain;

/**
 * Created by liudi on 4/25/15.
 */
public class CashSlotSteps {
    KnowsTheDomain helper;

    public CashSlotSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws Throwable {
        Assert.assertEquals("Incorrect amount dispensed -",
                dollars, helper.getCashSlot().getContents());
    }
}
