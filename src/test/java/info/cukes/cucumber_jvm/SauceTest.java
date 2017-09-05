package info.cukes.cucumber_jvm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriverService;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.io.IOException;
/**
 * Created by kames on 6/24/2017.
 */
public class SauceTest {
    public static final String USERNAME = "Cognizant_Integration";
    public static final String ACCESS_KEY = "a90e4692-648f-49b8-9691-b372a9973c12";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";


    ExtentReports reports;
    ExtentTest logger;

    //paths used
    String basePath = System.getProperty("user.dir");
    String reportPath = basePath + "/src/test/resources/Reports";
    String driversPath = basePath + "/src/test/resources/webDrivers";

    //remote driver services
    WebDriver driver;
    WebDriver driver1;
    private static ChromeDriverService chromeService;

    @Test
    public void userinputs() {
//        Login_Page login = new Login_Page(driver);
//        login.create_user();
        Login_Page login1 = new Login_Page(driver1);
        login1.create_user();
        logger.log(LogStatus.INFO, "User ID entered sucessfully");
        logger.log(LogStatus.INFO, "Password entered sucessfully");
        logger.log(LogStatus.INFO, "Clicks on Submit button");
        logger.log(LogStatus.PASS, "Login Sucessfull");
    }

    @BeforeMethod
    @Parameters("browser")

    public void invoke_browser(String browser) {
        System.out.println(browser);

        reports = new ExtentReports(reportPath + "/extentreport.html");
        logger = reports.startTest("Flight Reservation Login");

        if (browser.equalsIgnoreCase("chrome")) {
            logger.log(LogStatus.INFO, "Browser started ");
            chromeService = new ChromeDriverService.Builder().usingChromeDriverExecutable(new File(driversPath + "/chromedriver.exe")).usingAnyFreePort().build();
            try {
                chromeService.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            driver = new RemoteWebDriver(chromeService.getUrl(),
                    DesiredCapabilities.chrome());
            try {
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("name", "TestNg - SauceLabs");
                caps.setCapability("platform", "Windows XP");
                caps.setCapability("version", "37.0");
                driver1 = new RemoteWebDriver(new URL(URL), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        driver1.get("http://newtours.demoaut.com/");
        System.out.println("title of page is: " + driver1.getTitle());
    }

    @AfterMethod
    public void Closebrowser(ITestResult result) {
        reports.endTest(logger);
        reports.flush();
        driver.get(reportPath + "/extentreport.html");
        driver1.quit();
    }
}

//        public static void main(String[] args) throws Exception {
//
//            DesiredCapabilities caps = DesiredCapabilities.chrome();
//            caps.setCapability("platform", "Windows XP");
//            caps.setCapability("version", "43.0");
//
//            WebDriver driver1 = new RemoteWebDriver(new URL(URL), caps);
//
//            /**
//             * Goes to Sauce Lab's guinea-pig page and prints title
//             */
//            driver1.get("http://newtours.demoaut.com/");
//            System.out.println("title of page is: " + driver1.getTitle());
//            Login_Page login = new Login_Page(driver1);
//            driver1.quit();
//        }
