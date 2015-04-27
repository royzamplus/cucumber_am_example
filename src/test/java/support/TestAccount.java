package support;

import nicebank.Account;

/**
 * Created by liudi on 4/27/15.
 */
public class TestAccount extends Account {

    public TestAccount() {
        super(1234);
        saveIt();
    }
}
