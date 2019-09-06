import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LegalStepTwo {
    LegalStepTwo(WebDriver driver) {
        this.driver = driver;
    }
    WebDriver driver;

    private By headingLegalStepTwo = By.xpath("//h1[text()='Выбор подписи']");


    public String GetHeadingLegalStepTwoText() {
        return driver.findElement(headingLegalStepTwo).getText();
    }
}