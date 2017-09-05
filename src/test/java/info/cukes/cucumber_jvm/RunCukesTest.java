package info.cukes.cucumber_jvm;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import org.openqa.selenium.WebDriver;
import com.cucumber.listener.Reporter;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import cucumber.api.testng.CucumberFeatureWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.io.File;
import java.io.IOException;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\test\\resources\\info\\cukes\\cucumber_jvm"}
//        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:src/test/resources/Reports/report.html"}
//        format = {"pretty", "html:src\\test\\resources\\Reports"}
)

//@CucumberOptions(plugin = "json:target/cucumber-report-composite.json")
public class RunCukesTest {
    private TestNGCucumberRunner testNGCucumberRunner;
    ExtentReports reports;
    ExtentTest logger;
    WebDriver driver;
    private static ChromeDriverService chromeService;
    String basePath = System.getProperty("user.dir");
    String reportPath = basePath + "/src/test/resources/Reports";
    String driversPath = basePath + "/src/test/resources/webDrivers";

    @BeforeMethod
    @Parameters("browser")

    public void invoke_browser(String browser) {
        System.out.println(browser);
        String basePath = System.getProperty("user.dir");
        String reportPath = basePath + "/src/test/resources/Reports";
        reports = new ExtentReports(reportPath + "/ExtentReportForCucumberRun.html");
        logger = reports.startTest("Flight Reservation Login");
    }

    @BeforeClass
    public void setup() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

//    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features/login2.feature")
//    public void feature1(CucumberFeatureWrapper cucumberFeature) {
//        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
//    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }


//    @DataProvider(name = "dp1", parallel = true)
//    public Object[][] features() {
//        return testNGCucumberRunner.provideFeatures();
//    }

    @AfterMethod
    public void Closebrowser(ITestResult result) {
        reports.endTest(logger);
        reports.flush();
//        chromeService = new ChromeDriverService.Builder().usingChromeDriverExecutable(new File(driversPath + "/chromedriver.exe")).usingAnyFreePort().build();
//        try {
//            chromeService.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        driver = new RemoteWebDriver(chromeService.getUrl(),
//                DesiredCapabilities.chrome());
//        driver.get(reportPath + "/ExtentReportForCucumberRun.html");
    }
}

