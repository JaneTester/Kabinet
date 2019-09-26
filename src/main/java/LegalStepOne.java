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
    private By fullNameInput = By.xpath("//input[@name='fullName']");
    private By shortNameInput = By.xpath("//input[@name='shortName']");
    private By innInput = By.xpath("//input[@name='inn']");
    private By kppInput = By.xpath("//input[@name='kpp']");
    private By ogrnInput = By.xpath("//input[@name='ogrn']");
    private By managementPostInput = By.xpath("//input[@name='managementPost']");
    private By managementNameInput = By.xpath("//input[@name='managementName']");
    private By managementBasisInput = By.xpath("//input[@name='managementBasis']");
    private By postalCodeInput = By.xpath("//input[@name='postalCode']");
    private By ucRegionInput = By.xpath("//input[@name='ucRegion']");
    private By ucCityInput = By.xpath("//input[@name='ucCity']");
    private By streetInput = By.xpath("//input[@name='street']");
    private By houseInput = By.xpath("//input[@name='house']");
    private By jumpByRegion = By.xpath("(//div[@class='md-virtual-repeat-scroller'])[2]");
    private By jumpByCity = By.xpath("//span[text()='Город ']");

    public String GetHeadingLegalStepOneText() {
        return driver.findElement(headingLegalStepOne).getText();
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

    public void dropDownLists(By element) {
        WebElement result = driver.findElement(element);
        Actions builder = new Actions(driver);
        Action seriesOfActions = builder
                .moveToElement(result).sendKeys(Keys.ENTER)
                .click().build();
        seriesOfActions.perform();
    }

    public LegalStepTwo GetEnterInformationManually() {
        driver.findElement(enterManuallyButton).click();
        driver.findElement(fullNameInput).sendKeys("ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"СИДЕНИС\"");
        driver.findElement(shortNameInput).sendKeys("ООО \"СИДЕНИС\"");
        driver.findElement(innInput).sendKeys("7801406823");
        driver.findElement(kppInput).sendKeys("780101001");
        driver.findElement(ogrnInput).sendKeys("5067847002867");
        driver.findElement(managementPostInput).sendKeys("ГЕНЕРАЛЬНЫЙ ДИРЕКТОР");
        driver.findElement(managementNameInput).sendKeys("Цаголти Алан Ахсарбекович");
        driver.findElement(managementBasisInput).sendKeys("Устава");
        driver.findElement(postalCodeInput).sendKeys("197136");
        driver.findElement(ucRegionInput).sendKeys("78");
        dropDownLists(jumpByRegion);
//        driver.findElement(ucCityInput).sendKeys("Санкт-Петербург");
//        dropDownLists(jumpByCity);
//        driver.findElement(streetInput).sendKeys("Большой пр В.О.");
//        driver.findElement(houseInput).sendKeys("д. 84 литер. А");
        driver.findElement(furtherButton).click();
        return new LegalStepTwo(driver);
    }

    public void GetClearInputButton() {
        InputInformationCompany();
        driver.findElement(clearInputButton).click();
    }


    public LegalStepTwo StepTwo() {
        InputInformationCompany();
        GetInformationCompany();
        driver.findElement(furtherButton).click();
        return new LegalStepTwo(driver);
    }


}
