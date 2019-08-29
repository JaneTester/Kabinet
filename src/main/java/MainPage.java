import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
     WebDriver driver;
   MainPage (WebDriver driver) {this.driver = driver;}

   private By mailText = By.xpath("//span[text()='EIP.test@yandex.ru']");

    public String GetMailText() {
        return driver.findElement(mailText).getText();
    }
}

