package nicebank;

import cucumber.api.java.en.Then;
import junit.framework.Assert;

/**
 * Created by liudi on 4/25/15.
 */
public class CashSlotSteps {

    CashSlot cashSlot;

    public CashSlotSteps(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws Throwable {
        Assert.assertEquals("Incorrect amount dispensed -",
                dollars, cashSlot.getContents());
    }
}
