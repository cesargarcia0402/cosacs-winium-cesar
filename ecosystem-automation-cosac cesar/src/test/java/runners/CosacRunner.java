package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/payments.feature",
        tags = "@Payments",
        glue = "stepDefinitions")
public class CosacRunner {
}
