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

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
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
        wait = (new WebDriverWait(driver, 10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div [@class='uc-preloader__inner']")));
        loginPage.signInAccount();


    }

    @Test
    public void phoneTextTest() {
        String phoneText = mainPage.GetPhoneText();
        Assert.assertEquals("8 800 500 31 65", phoneText);
    }

    @Test
    public void URLMainPage() {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Мои подписи']")));
        Assert.assertEquals("https://lk.thisisit.ru/personal/main", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}

