// PricingCalculatorPage.java

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PricingCalculatorPage extends AbstractPage {

    @FindBy(id = "input_100")
    private WebElement numberOfInstances;

    @FindBy(id = "select_125")
    private WebElement series;

    @FindBy(id="select_option_224")
    private WebElement seriesOption;

    @FindBy(id = "select_value_label_96")
    private WebElement machineType;

    @FindBy(id = "select_option_474")
    private WebElement machineTypeOption;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGPUFlag;

    @FindBy(id = "select_510")
    private WebElement gpuType;

    @FindBy(id = "select_option_517")
    private WebElement gpuTypeOption;

    @FindBy(id = "select_512")
    private WebElement numberOfGPUs;

    @FindBy(id = "select_option_530")
    private WebElement numberOfGPUsOption;

    @FindBy(id="select_value_label_468")
    private WebElement LocalSSD;

    @FindBy(id = "select_option_495")
    private WebElement LocalSSDOption;

    @FindBy(id = "select_value_label_98")
    private WebElement datacenterLocation;

    @FindBy(id = "select_option_268")
    private WebElement datacenterLocationOption;

    @FindBy(id = "select_value_label_99")
    private WebElement commitedUsage;
    @FindBy(id = "select_option_138")
    private WebElement commitedUsageOption;

    @FindBy(xpath = "//button[text()='\n" +
            "            Add to Estimate\n" +
            "        ']")
    private WebElement addToEstimateButton;

    @FindBy(id = "Email Estimate")
    private WebElement emailEstimateButton;

    @FindBy(id = "input_620")
    private WebElement emailInputField;

    @FindBy(xpath = "//button[text()='\n" +
            "        Send Email\n" +
            "      ']")
    private WebElement sendEmailButton;

    @FindBy (xpath = "//div[@class='cpc-cart-total']")
    private WebElement totalEstimatedCost;
    private Actions actions;
    private WebDriverWait wait;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    public String getTotalEstimatedCost() {
        return totalEstimatedCost.getText().split(" ")[4];
    }

    public void fillForm() {
        System.out.println("Filling form");
        actions.moveToElement(numberOfInstances).click().sendKeys("4").build().perform();
    }

    public void fillSeries() {
        System.out.println("Filling series");
        actions.moveToElement(series).click().build().perform();
        this.waitOnPage();
        actions.moveToElement(seriesOption).click().build().perform();
    }

    public void fillMachineTypeOption() {
        System.out.println("Filling machine type");
        actions.moveToElement(machineType).click().build().perform();
        this.waitOnPage();
        actions.moveToElement(machineTypeOption).click().build().perform();
    }



    public void checkAddGPU() {
        System.out.println("Checking add GPU");
        actions.moveToElement(addGPUFlag).click().build().perform();
    }

    public void fillNumberOfGPUs() {
        System.out.println("Filling number of GPUs");
        actions.moveToElement(numberOfGPUs).click().build().perform();
        this.waitOnPage();
        actions.moveToElement(numberOfGPUsOption).click().build().perform();
    }

    public void fillGPUModel() {
        System.out.println("Filling GPU model");
        actions.moveToElement(gpuType).click().build().perform();
        this.waitOnPage();
        actions.moveToElement(gpuTypeOption).click().build().perform();
    }

    public void fillLocalSSDOption() {
        System.out.println("Filling local SSD option");
        actions.moveToElement(LocalSSD).click().build().perform();
        this.waitOnPage();
        actions.moveToElement(LocalSSDOption).click().build().perform();
    }

    public void fillRegion() {
        System.out.println("Filling region");
        actions.moveToElement(datacenterLocation).click().build().perform();
        this.waitOnPage();
        actions.moveToElement(datacenterLocationOption).click().build().perform();
    }

    public void fillCommitmentOptions() {
        System.out.println("Filling commitment options");
        actions.moveToElement(commitedUsage).click().build().perform();
        this.waitOnPage();
        actions.moveToElement(commitedUsageOption).click().build().perform();
    }

    public void addToEstimate() {
        System.out.println("Clicking add to estimate");
        actions.moveToElement(addToEstimateButton).click().build().perform();
    }

    public void emailEstimate() {
        System.out.println("Clicking email estimate");
        actions.moveToElement(emailEstimateButton).click().build().perform();
    }

    public void fillEmailField(String email) {
        System.out.println("Filling email field");
        actions.moveToElement(emailInputField).click().sendKeys(email).build().perform();
    }

    public void sendEmail() {
        System.out.println("Sending email");
        actions.moveToElement(sendEmailButton).click().build().perform();
    }


    public void waitOnPage() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}