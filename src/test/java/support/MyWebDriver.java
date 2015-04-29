package support;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by liudi on 4/27/15.
 */
@Component
@Scope("cucumber-glue")
public class MyWebDriver extends EventFiringWebDriver {
    public MyWebDriver() {
        super(new FirefoxDriver());
    }
}
