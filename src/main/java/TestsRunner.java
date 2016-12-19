import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilites.Log;
import utilites.SystemProperties;
import utilites.VerifyMobileView;
import utilites.Constants;

public class TestsRunner {
    private String browser = System.getProperty("browser");
    private String huburl = System.getProperty("huburl");
    private String outputdir = System.getProperty("outputdir");
    private String platform = System.getProperty("platform");
    private SystemProperties sysprop = new SystemProperties();
    private WebDriver driver = sysprop.driverInitialization(browser, huburl, outputdir, platform);
    private VerifyMobileView checkMobile = new VerifyMobileView();
    private Constants baseData = new Constants();
    private Log log = new Log();
    @BeforeTest
    public void setUp() throws Exception {

    }

    @Test
    public void checkButtonsOnHomePage()
    {
        driver.manage().window().maximize();
        log.logger("Maximize window");
        HomePage hp = new HomePage(driver);
        log.logger("Navogate to Home Page");
        hp.navigateToHomePage();
        hp.findFreshNewsButton();
        log.logger("Find fresh news button");
        hp.findPopularNewsButton();
        log.logger("Find Popular news button");
        hp.clickOnPopularNewsButton();
        log.logger("Click on popular news button.");
        hp.findPopularNewsDropdown();
        log.logger("Find popular news dropdown.");
        hp.findPopularNewsDropdownElements();
        hp.findLogo();
        log.logger("Find logo");
        //hp.findMiniHeader(); //Changes on site
        //log.logger("Find mini header");
        hp.findHeaderLinks();
    }

    @AfterSuite
    public void closeAll()
    {
        driver.quit();
    }
}
