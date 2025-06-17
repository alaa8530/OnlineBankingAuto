package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class BillPaymentPage {

    WebDriver driver;

    By payeeName = By.name("payee.name");
    By address = By.name("payee.address.street");
    By city = By.name("payee.address.city");
    By state = By.name("payee.address.state");
    By zipCode = By.name("payee.address.zipCode");
    By phone = By.name("payee.phoneNumber");
    By accountNumber = By.name("payee.accountNumber");
    By verifyAccount = By.name("verifyAccount");
    By amount = By.name("amount");
    By sendPaymentButton = By.xpath("//input[@value='Send Payment']");
    By confirmationMessage = By.xpath("//h1[contains(text(), 'Bill Payment Complete')]");

    public BillPaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillPaymentForm(String name, String addressText, String cityText, String stateText,
                                String zip, String phoneText, String acc, String verify, String amt) {
        driver.findElement(payeeName).sendKeys(name);
        driver.findElement(address).sendKeys(addressText);
        driver.findElement(city).sendKeys(cityText);
        driver.findElement(state).sendKeys(stateText);
        driver.findElement(zipCode).sendKeys(zip);
        driver.findElement(phone).sendKeys(phoneText);
        driver.findElement(accountNumber).sendKeys(acc);
        driver.findElement(verifyAccount).sendKeys(verify);
        driver.findElement(amount).sendKeys(amt);
    }

    public void clickSendPayment() {
        driver.findElement(sendPaymentButton).click();
    }

    public boolean isPaymentSuccessful() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
            return message.isDisplayed();
        } catch (Exception e) {
            System.out.println(" Confirmation not found: " + e.getMessage());
            return false;
        }
    }


}
