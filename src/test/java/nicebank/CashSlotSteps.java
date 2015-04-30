package nicebank;

import cucumber.api.java.en.Given;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import support.TestCashSlot;

/**
 * Created by liudi on 4/25/15.
 */
public class CashSlotSteps {

    @Autowired
    TestCashSlot cashSlot;

    @Given("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws Throwable {
        Assert.assertEquals("Incorrect amount dispensed -",
                dollars, cashSlot.getContents());
    }

    @Given("^the cash slot has developed a fault$")
    public void theCashSlotHasDevelopedAFault() throws Throwable {
        cashSlot.injectFault();
    }

    @Given("^the ATM contains \\$(\\d+)$")
    public void theATMContains$(int dollars) throws Throwable {
        cashSlot.load(dollars);
    }
}
