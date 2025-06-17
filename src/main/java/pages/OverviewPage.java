package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class OverviewPage {

    WebDriver driver;
    By title = By.xpath("//h1[contains(text(),'Accounts Overview')]");

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOverviewDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return element.isDisplayed();
    }
}
