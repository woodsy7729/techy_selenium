package tests;

import java.io.*;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LogoutTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String path = "src\\ebayCredentials";

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://ebay.com.au/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void checkLoggedIn (){
        //see if there is the logged in/ register button
        try {
            assertFalse(isElementPresent(By.linkText("Sign in")));
        } catch (Exception e) {
            System.err.println("Not there: " + e.getMessage());
        }

    }

    @Test
    public void testLogout() throws Exception {
        //check if logged in
        //if logged in log out
        driver.get(baseUrl );
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("userid")).clear();
        driver.findElement(By.id("userid")).sendKeys("stayhydratedteam2@gmail.com");
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("Stacy1234");
        driver.findElement(By.id("sgnBt")).click();

        driver.findElement(By.linkText("Sign out")).click();
    }

  /*
  https://signin.ebay.com.au/ws/eBayISAPI.dll?SignOutConfirm&ru=&i=.83990007900015

   */

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
