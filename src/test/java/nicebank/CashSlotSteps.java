package nicebank;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import support.TestCashSlot;

/**
 * Created by liudi on 4/25/15.
 */
public class CashSlotSteps {

    @Autowired
    TestCashSlot cashSlot;

    @Given("^the cash slot has developed a fault$")
    public void theCashSlotHasDevelopedAFault() throws Throwable {
        cashSlot.injectFault();
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws Throwable {
        Assert.assertEquals("Incorrect amount dispensed -",
                dollars, cashSlot.getContents());
    }
}
