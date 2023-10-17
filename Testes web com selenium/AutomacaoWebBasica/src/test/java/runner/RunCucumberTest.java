package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/reports/cucumberReports.json", "html:target/reports/"},
        features = "src/test/resources/features",
        tags = {"@gerarcupom"},
        glue = {"steps"}
)

public class RunCucumberTest {

    public static WebDriver driver;

    @BeforeClass
    public static void start() {
        driver = new ChromeDriver();

    }

    @AfterClass
    public static void stop() {
        driver.quit();

    }
}
