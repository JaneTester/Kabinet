import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainPage {
    WebDriver driver;

    MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By mainHeadingText = By.xpath("//h1[text()='Мои подписи']");
    private By logotip = By.xpath("//img[@class='uc-header__logo']");
    private By phone = By.xpath("//a[text()='8 800 500 31 65']");
    private By signatureButton = By.xpath("//button[@aria-label='Получить новую подпись']");
    private By legalProfile = By.xpath("//a[contains(text(),'для Юридического лица')]");
    private By individualProfile = By.xpath("//a[contains(text(),'для Индивидуального предпринимателя')]");
    private By personProfile = By.xpath("для Физического лица");

    public String GetMainHeadingText() {
        return driver.findElement(mainHeadingText).getText();
    }

    public String GetPhoneText() {
        return driver.findElement(phone).getText();
    }





}

