package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.WebDriverFactory;

@CucumberOptions(
        features = "src/test/resources/features", // Path to feature files
        glue = "StepDefinition",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
        private static WebDriver driver;

        @BeforeClass
        @Parameters("browser")
        public void setUp(String browser) {
                driver = WebDriverFactory.getDriver(browser);

        }

        @AfterClass
        public void tearDown() {
                if (driver != null) {
                        driver.quit();
                }
        }

        public static WebDriver getDriver() {
                return driver;
        }
}
