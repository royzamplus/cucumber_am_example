package hooks;

import cucumber.api.java.Before;
import org.springframework.test.context.ContextConfiguration;
import support.AtmInterfaceFactory;

/**
 * Created by liudi on 5/1/15.
 */
@ContextConfiguration("classpath:cucumber.xml")
public class TaggedHooks {
    @Before("@bypass_teller_ui")
    public void bypassTellerUI() {
        AtmInterfaceFactory.bypassTellerUI();
    }
}
