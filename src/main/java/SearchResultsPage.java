// SearchResultsPage.java
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends AbstractPage {
    @FindBy(xpath = "//a[text()='Google Cloud Pricing Calculator']")
    private WebElement calculatorLink;

    Actions actions = new Actions(driver);

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void openCalculator() {
        actions.moveToElement(calculatorLink).click().build().perform();
    }


}