package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/Features/SearchTable.feature",
        glue = "steps",
        dryRun = false,
        monochrome = true,
        tags = "@SearchOnHomePage",
        plugin = {"pretty","html:target/cucumber.html"}
)
public class HomePageRunner {
}
