// TestScript.java

import org.checkerframework.checker.units.qual.A;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class TestScript {
    private WebDriver driver;

    //private final ChromeOptions opt = new ChromeOptions();

    @Before
    public void setUp() {
//        opt.addExtensions(new File("./Extentions/addblock.crx"));
        driver = new ChromeDriver();
    }

    @Test
    public void testEstimatedCosts() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();

        PricingCalculatorPage pricingCalculatorPage = new PricingCalculatorPage(driver);
        pricingCalculatorPage.fillForm();
        pricingCalculatorPage.waitOnPage();
        pricingCalculatorPage.fillSeries();
        pricingCalculatorPage.waitOnPage();
        pricingCalculatorPage.fillMachineTypeOption();
        pricingCalculatorPage.waitOnPage();
        pricingCalculatorPage.checkAddGPU();
        pricingCalculatorPage.waitOnPage();
        pricingCalculatorPage.fillGPUModel();
        pricingCalculatorPage.waitOnPage();
        pricingCalculatorPage.fillLocalSSDOption();
        pricingCalculatorPage.waitOnPage();
        pricingCalculatorPage.fillRegion();
        pricingCalculatorPage.waitOnPage();
        pricingCalculatorPage.fillCommitmentOptions();
        pricingCalculatorPage.waitOnPage();
        pricingCalculatorPage.addToEstimate();

        pricingCalculatorPage.waitOnPage();

        driver.switchTo().newWindow(WindowType.TAB);

        YopmailPage yopmailPage = new YopmailPage(driver);
        yopmailPage.openPage();

        yopmailPage.waitOnPage();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");

        yopmailPage.waitOnPage();
        yopmailPage.generateEmailPage();
        yopmailPage.generateEmailPage();
        String email;

        yopmailPage.waitOnPage();

        email = yopmailPage.getEmail();
        System.out.println(email);

        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString() );

        pricingCalculatorPage.emailEstimate();
        pricingCalculatorPage.waitOnPage();
        pricingCalculatorPage.fillEmailField(email);

        pricingCalculatorPage.waitOnPage();
        pricingCalculatorPage.sendEmail();
        pricingCalculatorPage.waitOnPage();

        String actual = pricingCalculatorPage.getTotalEstimatedCost();
        String expected = "1,081.20";

        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        yopmailPage.waitOnPage();
        yopmailPage.openEmailsReceived();

        yopmailPage.waitOnPage();
        Assert.assertEquals(expected, actual);
    }

}