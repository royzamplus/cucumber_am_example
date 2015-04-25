package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import nicebank.AtmServer;
import org.eclipse.jetty.server.Server;
import sun.nio.cs.KOI8_R;
import support.KnowsTheDomain;

/**
 * Created by liudi on 4/25/15.
 */
public class ServerHooks {
    public static final int PORT = 8887;

    private AtmServer server;
    private KnowsTheDomain helper;

    public ServerHooks(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Before
    public void startServer() throws Exception {
        server = new AtmServer(
                PORT, helper.getCashSlot(), helper.getMyAccount());
        server.start();
    }

    @After
    public void stopServer() throws Exception {
        server.stop();
    }
}
