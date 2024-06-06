import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    protected WebDriver driver;
    private final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage openPage() {
        return null;
    }

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void closePage() {
        driver.quit();
    }
}
