package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import nicebank.AtmServer;
import nicebank.CashSlot;
import support.TestAccount;

/**
 * Created by liudi on 4/25/15.
 */
public class ServerHooks {
    public static final int PORT = 8887;

    private AtmServer server;
    private TestAccount account;
    private CashSlot cashSlot;

    public ServerHooks(TestAccount account, CashSlot cashSlot) {
        this.account = account;
        this.cashSlot = cashSlot;
    }

    @Before
    public void startServer() throws Exception {
        server = new AtmServer(
                PORT, cashSlot, account);
        server.start();
    }

    @After
    public void stopServer() throws Exception {
        server.stop();
    }
}
