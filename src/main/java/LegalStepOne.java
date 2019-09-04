import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LegalStepOne {
    WebDriver driver;



    LegalStepOne(WebDriver driver) {
        this.driver = driver;
    }

    private By headingLegalStepOne = By.xpath("//h1[text()='Общая информация']");
    private By inputInformation = By.xpath("//label[text()='Введите ИНН или название компании']/following-sibling::input[@aria-label='Введите ИНН или название компании']");
    private By findInformationButton = By.xpath("//button[@class= 'md-accent md-raised uc-dadata-btn md-button md-ink-ripple']");
    private By resultCompanyButton = By.xpath("//ul[@class='md-autocomplete-suggestions uc-dadata-search']");
    private By companyDetails = By.xpath("//h3[text()='Реквизиты организации']");
    private By managerDetails= By.xpath("//h3[text()='Данные руководителя']");
    private By legalAddress= By.xpath("//h3[text()='Юридический адрес']");
    private By bankDetails= By.xpath("//h3[text()='Банковские реквизиты']");
    private By furtherButton= By.xpath("//button[contains(text(), 'Далее')]");
    private By clearInputButton = By.xpath("//button[@aria-label='Clear Input']");

    public String GetHeadingLegalStepOneText() {
        return driver.findElement(headingLegalStepOne).getText();
    }
    public void InputInformationCompany(){
        driver.findElement(inputInformation).sendKeys("Sidenis");

    }
    public void GetInformationCompany(){
     WebElement result = driver.findElement(resultCompanyButton);
     result.sendKeys(Keys.DOWN, Keys.RETURN);

    }
    public String GetHeadingCompanyDetailsText () {
        return driver.findElement(companyDetails).getText();
    }
    public String GetHeadingManagerDetailsText () {
        return driver.findElement(managerDetails).getText();
    }
    public String GetHeadingLegalAddressText () {
        return driver.findElement(legalAddress).getText();
    }
    public String GetHeadingBankDetailsText () {
        return driver.findElement(bankDetails).getText();
    }


}
