package support;

import nicebank.Account;

/**
 * Created by liudi on 4/27/15.
 */
public class AccountFactory {

    public static Account createTestAccount() {
        Account account = new Account(1234);
        account.saveIt();
        return account;
    }
}
