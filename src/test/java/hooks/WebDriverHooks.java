package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liudi on 4/25/15.
 */
public class WebDriverHooks {

    @Autowired
    private EventFiringWebDriver webDriver;

    @After
    public void finish(Scenario scenario) {
        try {
            byte[] screenshot = webDriver.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        finally {
            webDriver.close();
        }
    }
}
