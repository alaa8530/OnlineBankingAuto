package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import pages.*;

import static org.testng.Assert.assertTrue;


/**
 * This class contains automated test cases for the ParaBank web application.
 * It covers login, bill payment, funds transfer, and account opening scenarios.
 * Tests are implemented using Selenium WebDriver and TestNG.
 * Author: Alaa Ashraf
 */

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;
    OverviewPage overviewPage;
    TransferFundsPage transferFundsPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/ALAA ASHRAF/Downloads/chromedriver-win32/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        overviewPage = new OverviewPage(driver);
        transferFundsPage = new TransferFundsPage(driver);
        driver.manage().window().maximize();

    }



/**
     * Test valid login functionality using correct credentials.
     * Verifies that the user is redirected to the account overview page.
     */

   @Test
    public void testValidLogin() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage.loginAs("john", "demo");
        assertTrue(overviewPage.isOverviewDisplayed());
    }



    /**
     * Test invalid login functionality using wrong credentials.
     * Verifies that the error message is displayed.
     */

 @Test
   public void testInvalidLogin() {
       driver.get("https://parabank.parasoft.com/parabank/index.htm");
       loginPage.loginAs("invalidUser", "wrongPassword");


       WebElement errorMsg = driver.findElement(By.xpath("//p[@class='error' and contains(text(),'could not be verified')]"));
       assertTrue(errorMsg.isDisplayed());
   }



    /**
     * Test account opening functionality.
     * Logs in, opens new savings account, and verifies the confirmation.
     */

   @Test
    public void testOpenNewAccount() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage.loginAs("john", "demo");


        driver.findElement(By.linkText("Open New Account")).click();

        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.selectAccountType("SAVINGS");
        openAccountPage.selectFromExistingAccountFirstOption();
        openAccountPage.clickOpenAccount();

        assertTrue(openAccountPage.isAccountOpened(), "Account was not opened - message not found");

    }


    /**
     * Test transferring funds between accounts.
     * Enters amount and performs transfer, then asserts success message.
     */

   @Test
   public void testTransferFunds() {
       // Go to login page and login
       driver.get("https://parabank.parasoft.com/parabank/index.htm");
       LoginPage loginPage = new LoginPage(driver);
       loginPage.loginAs("john", "demo");

       //  Navigate to "Transfer Funds"
       driver.findElement(By.linkText("Transfer Funds")).click();

       //  Fill transfer form
       TransferFundsPage tfPage = new TransferFundsPage(driver);
       tfPage.enterAmount("100");
       tfPage.selectFromAccountByIndex(0);
       tfPage.selectToAccountByIndex(1);
       tfPage.clickTransfer();

       //  Debug output
       System.out.println("Title: " + driver.getTitle());
       System.out.println("Page contains: " + driver.getPageSource().contains("Transfer Complete"));


       //  Assert transfer was successful
       Assert.assertTrue(tfPage.isTransferComplete(), "Transfer confirmation not found.");
   }


    /**
     * Test bill payment functionality.
     * Fills the bill payment form and confirms success.
     */

    @Test
    public void testBillPayment() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage.loginAs("john", "demo");

        driver.findElement(By.linkText("Bill Pay")).click();

        BillPaymentPage billPage = new BillPaymentPage(driver);
        billPage.fillPaymentForm(
                "Ali Mostafa", "123 Street", "Cairo", "Giza", "12345", "0111111111",
                "123456", "123456", "150"
        );
        billPage.clickSendPayment();

        Assert.assertTrue(billPage.isPaymentSuccessful(), "Bill Payment confirmation not found.");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}