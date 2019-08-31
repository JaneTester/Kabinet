import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
     WebDriver driver;
   MainPage (WebDriver driver) {this.driver = driver;}

   private By mainHeadingText = By.xpath("//h1[text()='Мои подписи']");




    public String GetMainHeadingText() {
        return driver.findElement(mainHeadingText).getText();
    }
}

