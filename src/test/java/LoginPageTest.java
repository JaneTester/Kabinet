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

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Melkish\\IdeaProjects\\Kabinet\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://lk.thisisit.ru/login");
        loginPage = new LoginPage(driver);
        WebDriverWait wait = (new WebDriverWait(driver, 10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div [@class='uc-preloader__inner']")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//md-select[@id='select_3']")));
    }

    @Test
    public void mainPageUser() {
        MainPage mainPage = loginPage.signInAccount();
        String mail = mainPage.GetMailText();
        Assert.assertEquals("EIP.test@yandex.ru", mail);
    }

    @Test
    public void loginErrorTest() {
        loginPage.signInWithEmptyLogin();
        String error = loginPage.GetErrorLoginText();
        Assert.assertEquals("Обязательное поле", error);
    }

    @Test
    public void PasswordErrorTest() {
        loginPage.signInWithEmptyPassword();
        String error = loginPage.GetErrorPasswordText();
        Assert.assertEquals("Обязательное поле", error);
    }

    @Test
    public void PasswordForm() {
        loginPage.showPasswordForm();
        String heading = loginPage.GetHeadingFormPasswordText();
        Assert.assertEquals("Восстановление пароля", heading);
    }

    @Test
    public void BEAuthorizeErrorMessageText (){
        loginPage.showBEErrorMessage("dlkfhl@mal", "podrjgdbf");
        String message = loginPage.GetBEAuthorizeErrorMessageText();
        Assert.assertEquals("Что-то пошло не так", message);
    }
    @Test
    public void BEFormErrorMessageText () {
        loginPage.showBEFormErrorMessage("fgjdlg@m");
        String error = loginPage.GetBEAuthorizeErrorMessageText();
        Assert.assertEquals("Что-то пошло не так", error);
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}

