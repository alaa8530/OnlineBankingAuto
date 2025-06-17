package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenAccountPage {

    WebDriver driver;
    WebDriverWait wait;

    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void selectAccountType(String accountType) {
        WebElement accountTypeDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("type"))
        );
        Select select = new Select(accountTypeDropdown);
        select.selectByVisibleText(accountType);
    }


    public void selectFromExistingAccountFirstOption() {
        WebElement accountDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("fromAccountId"))
        );
        Select select = new Select(accountDropdown);
        select.selectByIndex(0);
    }


    public void clickOpenAccount() {
        WebElement openAccountBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Open New Account']"))
        );
        openAccountBtn.click();
    }


    public boolean isAccountOpened() {
        try {
            WebElement message = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//*[contains(text(),'Account Opened')]")
                    )
            );
            return message.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }


    public String getNewAccountId() {
        try {
            WebElement accountIdLink = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("newAccountId"))
            );
            return accountIdLink.getText();
        } catch (TimeoutException | NoSuchElementException e) {
            return null;
        }
    }
}
