// HomePage.java
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(className = "YSM5S")
    private WebElement searchButton;

    @FindBy(id="i4")
    private WebElement searchField;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage() {
        driver.get("https://cloudpricingcalculator.appspot.com");
        return this;
    }

    public void searchFor(String text) {
        searchButton.click();
        searchField.sendKeys(text, Keys.RETURN);
    }
}