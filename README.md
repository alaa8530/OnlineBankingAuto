❖ Online Banking Automation Project

This is a complete automated testing project for the [ParaBank](https://parabank.parasoft.com/parabank/index.htm) online banking demo website. The project uses **Selenium WebDriver** with **TestNG** following the **Page Object Model (POM)** design pattern.


❖ Project Description

This automation project simulates user interactions on ParaBank to validate core banking functionalities like login, opening accounts, transferring funds, and bill payments.

❖ Features Tested

Test Case , Description , Status

Valid Login , Verifies valid login with correct credentials , pass

Invalid Login , Ensures login fails with invalid credentials , pass

Open New Account , Tests account opening flow  , pass

Transfer Funds , Transfers funds between two accounts , pass

Bill Payment , fill bill payment form & confirm transaction , pass


❖ Tools & Technologies

- Java 23
- Selenium WebDriver 4.20.0
- TestNG 7.10.2
- Maven
- IntelliJ IDEA 2024.3.1.1
- Git & GitHub

❖ Project Structure

OnlineBankingAuto

├── pom.xml

├── testng.xml

├── pages

│ ├── LoginPage.java

│ ├── OverviewPage.java

│ ├── TransferFundsPage.java

│ ├── BillPaymentPage.java

│ └── OpenAccountPage.java

├── tests

└── LoginTest.java


❖ How to Run

1. Clone the repository: git clone https://github.com/alaa8530/OnlineBankingAuto.git
2. Open in IntelliJ IDEA.
3. Ensure dependencies are installed via Maven.
4. Run tests using:

   ❖ `testng.xml` file

   ❖ Or directly from the `Login Test` class

• Screenshots / Results

All test cases were executed successfully. You can find the detailed report and screenshots in the attached Excel report and logs.

• Author

Alaa Ashraf
[alaa.ashraf8530@gmail.com](mail to:alaa.ashraf8530@gmail.com)

• Repository Link

[GitHub Repository](https://github.com/alaa8530/OnlineBankingAuto)