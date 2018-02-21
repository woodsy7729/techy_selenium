package tests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class AmazonLogin {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String path = "src\\ebayCredentials";

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.woolworths.com.au/shop/securelogin";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testLogin() throws Exception {
        driver.get(baseUrl);
        FileInputStream fis = new FileInputStream(path);
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
        String usernameunformat = in.readLine();
        String passwordunformat = in.readLine();
        String password = passwordunformat.split("=")[1];
        String username = usernameunformat.split("=")[1];
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("userid")).clear();
        driver.findElement(By.id("userid")).sendKeys(username);
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("sgnBt")).click();
        testLogout();

    }
    public void testLogout() throws Exception{
        driver.findElement(By.id("gh-ug")).click();
        driver.findElement(By.linkText("Sign out")).click();
    }
    public void isSignedIn() throws Exception{
        boolean signedin = isElementPresent(By.linkText("Sign in"));
        if (signedin == true)
            testLogout();
        else
            driver.quit();
    }
    /*
    @Test
    public void testLogout() throws Exception{
        driver.get(baseUrl);
        try {
            assertTrue(isElementPresent(By.linkText("Sign in")));
            System.out.println("Sign in is present, so we are not logged in");
            driver.quit();
        } catch (Exception e) {
            System.err.println("Logged in: " + e.getMessage());
            System.out.println("Sign in is not present, so we are logged in");
            driver.findElement(By.id("gh-ug")).click();
            driver.findElement(By.linkText("Sign out")).click();
        }
    }
  */
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
