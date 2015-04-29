package support;

import nicebank.Account;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by liudi on 4/27/15.
 */
@Component
@Scope("cucumber-glue")
public class TestAccount extends Account {

    public TestAccount() {
        super(1234);
        saveIt();
    }
}
