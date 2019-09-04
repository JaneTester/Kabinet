import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
    public void GetURLLegalStepOne() {
        mainPage.GetLegalStepOne();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Общая информация']")));
        Assert.assertEquals("https://lk.thisisit.ru/personal/eds/legal/", driver.getCurrentUrl());
    }

    @Test
    public void GetHeadingLegalStepOne() {
        mainPage.GetLegalStepOne();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Общая информация']")));
        String heading = legalStepOne.GetHeadingLegalStepOneText();
        Assert.assertEquals("Общая информация", heading);
    }

    @Test
    public void GetInformationCompany() {
        mainPage.GetLegalStepOne();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Общая информация']")));
        legalStepOne.InputInformationCompany();
       //legalStepOne.GetInformationCompany();
//        wait = (new WebDriverWait(driver, 5));
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='ng-scope']")));
//        Assert.assertEquals("Реквизиты организации", legalStepOne.GetHeadingCompanyDetailsText());
//        Assert.assertEquals("Данные руководителя", legalStepOne.GetHeadingManagerDetailsText());
//        Assert.assertEquals("Юридический адрес", legalStepOne.GetHeadingLegalAddressText());
//        Assert.assertEquals("Банковские реквизиты", legalStepOne.GetHeadingBankDetailsText());
    }
}


//    @After
//    public void tearDown() {
//        driver.quit();
//    }
//}