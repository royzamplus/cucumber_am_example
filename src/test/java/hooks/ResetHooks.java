package hooks;

import cucumber.api.java.Before;
import nicebank.TransactionQueue;

/**
 * Created by liudi on 4/25/15.
 */
public class ResetHooks {

    @Before
    public void reset() {
        TransactionQueue.clear();
    }
}
