import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    LoginData loginData = new LoginData();

    private By userLoginInput = By.xpath("//input[@id='input_0']");
    private By userPasswordInput = By.xpath("//input[@id='input_1']");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By loginError = By.xpath("//div[@ng-messages='loginForm.LOGIN.$error']//div[text()='Обязательное поле']");
    private By PasswordError = By.xpath("//div[@ng-messages='loginForm.PASS.$error']//div[text()='Обязательное поле']");
    private By forgotPasswordButton = By.xpath("//button[@type='button']");
    private By formForgotPassword = By.xpath("//form[@name='RestorePassForm']");
    private By headingForgotPasswordForm = By.xpath("//form[@name='RestorePassForm']//h3");
    private By BEErrorMessage = By.xpath("//div[contains(@class, 'uc-notify')]/h3[text()='Что-то пошло не так']");
    private By mailInputFormPassword = By.xpath("//form[@name='RestorePassForm']//input[@type='email']");
    private By formPasswordButton = By.xpath("//form[@name='RestorePassForm']//button[@type='submit']");


    public MainPage signInAccount() {
        driver.findElement(userLoginInput).sendKeys(loginData.login);
        driver.findElement(userPasswordInput).sendKeys(loginData.password);
        driver.findElement(loginButton).click();
        return new MainPage(driver);
    }

    public void signInWithEmptyLogin() {
        driver.findElement(userLoginInput).sendKeys(" ");
        driver.findElement(loginButton).click();

    }

    public String GetErrorLoginText() {
        return driver.findElement(loginError).getText();
    }

    public void signInWithEmptyPassword() {
        driver.findElement(userPasswordInput).click();
        driver.findElement(loginButton).click();

    }

    public String GetErrorPasswordText() {

        return driver.findElement(PasswordError).getText();
    }

    public void showPasswordForm() {
        driver.findElement(forgotPasswordButton).click();
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(formForgotPassword));

    }

    public String GetHeadingFormPasswordText() {

        return driver.findElement(headingForgotPasswordForm).getText();
    }

    public void showBEErrorMessage(String login, String password) {
        driver.findElement(userLoginInput).sendKeys(login);
        driver.findElement(userPasswordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BEErrorMessage));
    }

    public String GetBEAuthorizeErrorMessageText() {

        return driver.findElement(BEErrorMessage).getText();
    }

    public void showBEFormErrorMessage(String mail) {
        showPasswordForm();
        driver.findElement(mailInputFormPassword).sendKeys(mail);
        driver.findElement(formPasswordButton).click();
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BEErrorMessage));
    }

}
