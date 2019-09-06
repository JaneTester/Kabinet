import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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
    private By resultCompanyButton = By.xpath("(//span[@md-highlight-text='_ctrl.searchCompanyText'])[1]");
    private By enterManuallyButton = By.xpath("//button[contains(text(), 'ввести данные вручную')]");
    private By clearInputButton = By.xpath("//button[@aria-label='Clear Input']");
    private By companyDetails = By.xpath("//h3[text()='Реквизиты организации']");
    private By managerDetails = By.xpath("//h3[text()='Данные руководителя']");
    private By legalAddress = By.xpath("//h3[text()='Юридический адрес']");
    private By bankDetails = By.xpath("//h3[text()='Банковские реквизиты']");
    private By furtherButton = By.xpath("//button[contains(text(), 'Далее')]");


    public String GetHeadingLegalStepOneText() {
        return driver.findElement(headingLegalStepOne).getText();
    }

    public void InputInformationCompany() {
        driver.findElement(inputInformation).sendKeys("Sidenis");
    }

    public void GetInformationCompany() {
        WebElement result = driver.findElement(resultCompanyButton);
        Actions builder = new Actions(driver);
        Action seriesOfActions = builder
                .moveToElement(result)
                .click().build();
        seriesOfActions.perform();
    }

    public void GetEnterInformationManually() {
        driver.findElement(enterManuallyButton).click();
    }

    public void GetClearInputButton() {
        InputInformationCompany();
        driver.findElement(clearInputButton).click();
    }

    public String GetHeadingCompanyDetailsText() {
        return driver.findElement(companyDetails).getText();
    }

    public String GetHeadingManagerDetailsText() {
        return driver.findElement(managerDetails).getText();
    }

    public String GetHeadingLegalAddressText() {
        return driver.findElement(legalAddress).getText();
    }

    public String GetHeadingBankDetailsText() {
        return driver.findElement(bankDetails).getText();
    }


}
