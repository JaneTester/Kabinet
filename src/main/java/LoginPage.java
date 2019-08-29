import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
private WebDriver driver;

LoginPage (WebDriver driver) {this.driver = driver;}

private By userLoginInput = By.xpath("//input[@id='input_0']");
private By userPasswordInput = By.xpath("//input[@id='input_1']");
private By loginButton = By.xpath("//button[@type='submit']");
private By loginError = By.xpath("");
private By PasswordError = By.xpath("");
private By forgotPasswordButton = By.xpath("//button[@type='button']");

public MainPage signInAccount () {
driver.findElement(userLoginInput).sendKeys("EIP.test@yandex.ru");
driver.findElement(userPasswordInput).sendKeys("R_VvPZZG");
driver.findElement(loginButton).click();
return new MainPage(driver);
}


}
