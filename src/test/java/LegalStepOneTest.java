import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNull;

public class LegalStepOneTest {
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private LegalStepOne legalStepOne;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Melkish\\IdeaProjects\\Kabinet\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://lk.thisisit.ru/login");
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        legalStepOne = new LegalStepOne(driver);
        wait = (new WebDriverWait(driver, 3));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div [@class='uc-preloader__inner']")));
        loginPage.signInAccount();
        wait = (new WebDriverWait(driver, 3));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div [@class='uc-preloader__inner']")));

    }

    @Test
    public void GetURLLegalStepOneTest() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//md-backdrop[@class=\"md-menu-backdrop md-click-catcher ng-scope\"]")));
        mainPage.GetLegalStepOne();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Общая информация']")));
        Assert.assertEquals("https://lk.thisisit.ru/personal/eds/legal/", driver.getCurrentUrl());
    }

    @Test
    public void GetHeadingLegalStepOneTest() {
        mainPage.GetLegalStepOne();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Общая информация']")));
        String heading = legalStepOne.GetHeadingLegalStepOneText();
        Assert.assertEquals("Общая информация", heading);
    }

    @Test
    public void GetInformationCompanyTest() {
        mainPage.GetLegalStepOne();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Общая информация']")));
        legalStepOne.InputInformationCompany();
        legalStepOne.GetInformationCompany();
        wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h3[text()='Реквизиты организации']")));
        Assert.assertEquals("Реквизиты организации", legalStepOne.GetHeadingCompanyDetailsText());
        Assert.assertEquals("Данные руководителя", legalStepOne.GetHeadingManagerDetailsText());
        Assert.assertEquals("Юридический адрес", legalStepOne.GetHeadingLegalAddressText());
        Assert.assertEquals("Банковские реквизиты", legalStepOne.GetHeadingBankDetailsText());
    }

    @Test
    public void GetEnterInformationManuallyTest() {
        mainPage.GetLegalStepOne();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Общая информация']")));
        legalStepOne.GetEnterInformationManually();
        wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h3[text()='Реквизиты организации']")));
        Assert.assertEquals("Реквизиты организации", legalStepOne.GetHeadingCompanyDetailsText());
        Assert.assertEquals("Данные руководителя", legalStepOne.GetHeadingManagerDetailsText());
        Assert.assertEquals("Юридический адрес", legalStepOne.GetHeadingLegalAddressText());
        Assert.assertEquals("Банковские реквизиты", legalStepOne.GetHeadingBankDetailsText());
    }

    @Test
    public void GetCheckFieldValueCompanyDetailsTest() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div [@class='uc-preloader__inner']")));
        mainPage.GetLegalStepOne();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Общая информация']")));
        legalStepOne.InputInformationCompany();
        legalStepOne.GetInformationCompany();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h3[text()='Реквизиты организации']")));
        WebElement fullNameInput = driver.findElement(By.xpath("//input[@name='fullName']"));
        WebElement shortNameInput = driver.findElement(By.xpath("//input[@name='shortName']"));
        WebElement innInput = driver.findElement(By.xpath("//input[@name='inn']"));
        WebElement kppInput = driver.findElement(By.xpath("//input[@name='kpp']"));
        WebElement ogrnInput = driver.findElement(By.xpath("//input[@name='ogrn']"));
        String value = fullNameInput.getAttribute("value");
        String value2 = shortNameInput.getAttribute("value");
        String value3 = innInput.getAttribute("value");
        String value4 = kppInput.getAttribute("value");
        String value5 = ogrnInput.getAttribute("value");
        System.out.println(value);
        Assert.assertNotNull(value);
        System.out.println(value2);
        Assert.assertNotNull(value2);
        System.out.println(value3);
        Assert.assertNotNull(value3);
        System.out.println(value4);
        Assert.assertNotNull(value4);
        System.out.println(value5);
        Assert.assertNotNull(value5);
    }

    @Test
    public void GetCheckFieldValueManagerDetailsTest() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div [@class='uc-preloader__inner']")));
        mainPage.GetLegalStepOne();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Общая информация']")));
        legalStepOne.InputInformationCompany();
        legalStepOne.GetInformationCompany();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h3[text()='Реквизиты организации']")));
        WebElement managementPostInput = driver.findElement(By.xpath("//input[@name='managementPost']"));
        WebElement managementNameInput = driver.findElement(By.xpath("//input[@name='managementName']"));
        WebElement managementBasisInput = driver.findElement(By.xpath("//input[@name='managementBasis']"));

        String value = managementPostInput.getAttribute("value");
        String value2 = managementNameInput.getAttribute("value");
        String value3 = managementBasisInput.getAttribute("value");

        System.out.println(value);
        Assert.assertNotNull(value);
        System.out.println(value2);
        Assert.assertNotNull(value2);
        System.out.println(value3);
        Assert.assertNotNull(value3);
    }

    @Test
    public void GetCheckFieldValueLegalAddressTest() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div [@class='uc-preloader__inner']")));
        mainPage.GetLegalStepOne();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Общая информация']")));
        legalStepOne.InputInformationCompany();
        legalStepOne.GetInformationCompany();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h3[text()='Реквизиты организации']")));
        WebElement postalCodeInput = driver.findElement(By.xpath("//input[@name='postalCode']"));
        WebElement ucRegionInput = driver.findElement(By.xpath("//input[@name='ucRegion']"));
        WebElement ucCityInput = driver.findElement(By.xpath("//input[@name='ucCity']"));
        WebElement streetInput = driver.findElement(By.xpath("//input[@name='street']"));
        WebElement houseInput = driver.findElement(By.xpath("//input[@name='house']"));

        String value = postalCodeInput.getAttribute("value");
        String value2 = ucRegionInput.getAttribute("value");
        String value3 = ucCityInput.getAttribute("value");
        String value4 = streetInput.getAttribute("value");
        String value5 = houseInput.getAttribute("value");

        System.out.println(value);
        Assert.assertNotNull(value);
        System.out.println(value2);
        Assert.assertNotNull(value2);
        System.out.println(value3);
        Assert.assertNotNull(value3);
        System.out.println(value4);
        Assert.assertNotNull(value4);
        System.out.println(value5);
        Assert.assertNotNull(value5);
    }

    @Test

    public void GetClearInputButtonTest() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div [@class='uc-preloader__inner']")));
        mainPage.GetLegalStepOne();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Общая информация']")));
        legalStepOne.GetClearInputButton();
        WebElement inputInformation = driver.findElement(By.xpath("//input[@name='autocompleteCompanyField']"));
        String value = inputInformation.getAttribute("value");
        System.out.println("Поле пустое" + value);
        Assert.assertEquals("", value);


    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}