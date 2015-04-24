import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by liudi on 4/23/15.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", snippets = SnippetType.CAMELCASE, dryRun = false)
public class RunCukesTest {
}
