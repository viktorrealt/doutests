import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilites.Constants;
import java.util.List;
import utilites.Log;

public class HomePage {
    private final WebDriver driver;
    private Constants baseData = new Constants();
    private By popularNewsButtonLocator = By.xpath("//div[@class='b-articles']/ul[@class='b-articles-switch']/li[2]/a");
    private By freshNewsButtonLocator = By.xpath("//div[@class='b-articles']/ul[@class='b-articles-switch']/li[@class='current']/a");
    private By dropDownElements = By.xpath("//ul[@class='b-articles-switch']/li[2]/select/option[@value]");
    private By dropdown = By.xpath("//ul[@class='b-articles-switch']/li[2]/select");
    private By logo = By.xpath("//header/ul/li[@class='logo']");
    private By miniHeader = By.xpath("//header/ul/li[@class='mini-header']");
    private By headerLinks = By.xpath("//header/ul/li/a");
    private By subHeaderLinks = By.xpath("//div[@class='col70 m-cola']/ul/li/a");
    private By descriptionsInSlider = By.xpath(".//*[@id='slideArticles']/ul/li/div");
    private By titlesInSlider = By.xpath(".//*[@id='slideArticles']/ul/li/a[@class='link']");
    private Log log = new Log();

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    HomePage navigateToHomePage() {
        driver.navigate().to(baseData.homepageUrl);
        return this;
    }

    HomePage findPopularNewsButton() {
        driver.findElement(popularNewsButtonLocator);
        return this;
    }

    HomePage findFreshNewsButton() {
        driver.findElement(freshNewsButtonLocator);
        return this;
    }

    HomePage clickOnPopularNewsButton() {
        driver.findElement(popularNewsButtonLocator).click();
        return this;
    }

    HomePage findPopularNewsDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return webDriver.findElement(dropdown).isDisplayed();
            }
        });
        driver.findElement(dropdown);
        return this;
    }

    HomePage findPopularNewsDropdownElements() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return webDriver.findElement(dropdown).isDisplayed();
            }
        });
        List<WebElement> elements = driver.findElements(dropDownElements);
        log.logger("Found " + elements.size() + " elements in dropdown list");
        int counter = 0;
        for (WebElement e : elements) {
            log.logger("Element " + counter + " text is: " + e.getText());
            counter++;
        }
        return this;
    }

    HomePage findLogo() {
        driver.findElement(logo);
        return this;
    }

    HomePage findMiniHeader() {
        driver.findElement(miniHeader);
        return this;
    }

    HomePage findHeaderLinks() {
        List<WebElement> elements = driver.findElements(headerLinks);
        log.logger("Found " + elements.size() + " elements in header links");
        int counter = 0;
        for (WebElement e : elements.subList(1, elements.size())) { //Skip logo and depricated mini-header
            log.logger("Element " + counter + " text is: " + e.getText());
            counter++;
        }

        return this;
    }

    HomePage findSubHeaderLinks() {
        List<WebElement> elements = driver.findElements(subHeaderLinks);
        log.logger("Found " + elements.size() + " elements in Sub-header links");
        int counter = 0;
        for (WebElement e : elements) {
            log.logger("Element " + counter + " text is: " + e.getText());
            counter++;
        }

        return this;
    }

    HomePage findTitlesInSlider(){
        List<WebElement> elements = driver.findElements(titlesInSlider);
        log.logger("Found " + elements.size() + " Titles in slider");
        int counter = 0;
        for (WebElement e : elements) {
            log.logger("Title " + counter + " text is: " + e.getText());
            counter++;
        }
        return this;
    }

    HomePage findDescriptionsInSlider(){
        List<WebElement> elements = driver.findElements(descriptionsInSlider);
        log.logger("Found " + elements.size() + " descriptions in slider");
        int counter = 0;
        for (WebElement e : elements) {
            log.logger("Element " + counter + " text is: " + e.getText());
            counter++;
        }

        return this;
    }


}
