import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilites.Constants;
import java.util.List;
import utilites.Log;


/**
 * Created by Ириша on 18.12.2016.
 */
public class HomePage {
    private final WebDriver driver;
    private Constants baseData = new Constants();
    private By popularNewsButtonLocator = By.xpath("//div[@class='b-articles']/ul[@class='b-articles-switch']/li[2]/a");
    private By freshNewsButtonLocator = By.xpath("//div[@class='b-articles']/ul[@class='b-articles-switch']/li[@class='current']/a");
    private By dropDownElements = By.xpath("//ul[@class='b-articles-switch']/li[2]/select/option[@value]");
    private By dropdown = By.xpath("//ul[@class='b-articles-switch']/li[2]/select");
    Log log = new Log();
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage navigateToHomePage()
    {
        driver.navigate().to(baseData.homepageUrl);
        return this;
    }

    HomePage findPopularNewsButton() {
        driver.findElement(popularNewsButtonLocator);
        return this;
    }

    HomePage findFreshNewsButton(){
        driver.findElement(freshNewsButtonLocator);
        return this;
    }

    HomePage clickOnPopularNewsButton(){
        driver.findElement(popularNewsButtonLocator).click();
        return this;
    }
    HomePage findPopularNewsDropdown()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver){
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
        for (WebElement e : elements)
        {
            log.logger("Element " + counter + " text is: " + e.getText());
            counter++;
        }
        return this;
    }


}
