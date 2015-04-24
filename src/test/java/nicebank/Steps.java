package nicebank;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.*;
import junit.framework.Assert;
import transforms.MoneyConverter;

/**
 * Created by liudi on 4/23/15.
 */
public class Steps {

    class Account {
        private Money balance = new Money();

        public void deposit(Money amount) {
            balance = balance.add(amount);
        }

        public Money getBalance() {
            return balance;
        }
    }

    class Teller {
        public void withdrawFrom(Account account, int dollars) {

        }
    }

    class KnowsMyAccount {
        private Account myAccount;

        public Account getMyAccount() {
            if (myAccount == null) {
                myAccount = new Account();
            }

            return myAccount;
        }
    }

    KnowsMyAccount helper;

    public Steps() {
        helper = new KnowsMyAccount();
    }

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        helper.getMyAccount().deposit(amount);

        Assert.assertEquals("Incorrect account balance -",
                amount, helper.getMyAccount().getBalance());
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iWithdraw$(int dollars) throws Throwable {
        Teller teller = new Teller();
        teller.withdrawFrom(helper.getMyAccount(), dollars);
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
