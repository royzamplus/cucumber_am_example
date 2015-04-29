package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import nicebank.Account;
import nicebank.AtmServer;
import nicebank.CashSlot;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liudi on 4/25/15.
 */
public class ServerHooks {
    public static final int PORT = 8887;

    private AtmServer server;

    @Autowired
    private Account account;

    @Autowired
    private CashSlot cashSlot;

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
