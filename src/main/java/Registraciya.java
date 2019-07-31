import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Registraciya {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Melkish\\IdeaProjects\\Kabinet\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://lk.thisisit.ru/login");
        WebDriverWait wait = (new WebDriverWait(driver, 3));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div [@class='uc-preloader__inner']")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//md-select[@id='select_3']")));
        driver.findElement(By.xpath("//md-select[@id='select_3']")).click();
        driver.findElement(By.xpath("//md-option[@id='select_option_6']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='uc-preloader__inner']")));
        driver.findElement(By.xpath("//span[text()='pol-sasha@yandex.ru']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("md-backdrop[@class='md-menu-backdrop md-click-catcher ng-scope']")));
        driver.findElement(By.xpath("//button[@role='menuitem']")).click();
    }
}