package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


    public class TransferFundsPage {

        WebDriver driver;


        By amountField = By.id("amount");
        By fromAccountDropdown = By.id("fromAccountId");
        By toAccountDropdown = By.id("toAccountId");
        By transferButton = By.xpath("//input[@value='Transfer']");
        By confirmationMessage = By.xpath("//h1[text()='Transfer Complete!']");

        public TransferFundsPage(WebDriver driver) {
            this.driver = driver;
        }

        public void enterAmount(String amount) {
            driver.findElement(amountField).sendKeys(amount);
        }

        public void selectFromAccountByIndex(int index) {
            Select fromAccount = new Select(driver.findElement(fromAccountDropdown));
            List<WebElement> options = fromAccount.getOptions();
            if (options.size() > index) {
                fromAccount.selectByIndex(index);
            } else if (!options.isEmpty()) {
                fromAccount.selectByIndex(0); // fallback to first
            }
        }

        public void selectToAccountByIndex(int index) {
            Select toAccount = new Select(driver.findElement(toAccountDropdown));
            List<WebElement> options = toAccount.getOptions();
            if (options.size() > index) {
                toAccount.selectByIndex(index);
            } else if (!options.isEmpty()) {
                toAccount.selectByIndex(0); // fallback to first
            }
        }

        public void clickTransfer() {
            driver.findElement(transferButton).click();
        }

        public boolean isTransferComplete() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'Transfer Complete') or contains(text(),'was successful')]")
            ));
            return message.isDisplayed();
        }

        }

