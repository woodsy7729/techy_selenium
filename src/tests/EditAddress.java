package tests;

import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EditAddress {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.ebay.com.au/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEditAddress() throws Exception {
	FileInputStream fis = new FileInputStream("src\\RetailDetail");
    BufferedReader in = new BufferedReader(new InputStreamReader(fis));  
    
    String fullnameunformat = in.readLine();
    String address1unformat = in.readLine();
    String address2unformat = in.readLine();
    String cityunformat = in.readLine();
    String stateunformat = in.readLine();
    String postcodeunformat = in.readLine();
    String phonenumberunformat = in.readLine();
    
    String fullname = fullnameunformat.split("=")[1];
    String address1 = address1unformat.split("=")[1];
    String address2 = address2unformat.split("=")[1];
    String city = cityunformat.split("=")[1];
    String state = stateunformat.split("=")[1];
    String postcode = postcodeunformat.split("=")[1];
    String phonenumber = phonenumberunformat.split("=")[1];
    
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("userid")).clear();
    driver.findElement(By.id("userid")).sendKeys("stayhydratedteam2@gmail.com");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("Stacy1234");
    driver.findElement(By.id("sgnBt")).click();
    driver.findElement(By.linkText("My eBay")).click();
    driver.findElement(By.linkText("AccountPage")).click();
    driver.findElement(By.linkText("Addresses")).click();
    driver.findElement(By.linkText("Addresses")).click();
    driver.findElement(By.linkText("Change your primary delivery address")).click();
    driver.findElement(By.linkText("Edit")).click();
    driver.findElement(By.id("s0-name-field-name-field")).clear();
    driver.findElement(By.id("s0-name-field-name-field")).sendKeys(fullname);
    driver.findElement(By.id("s0-addressLine1-field-addressLine1-field")).clear();
    driver.findElement(By.id("s0-addressLine1-field-addressLine1-field")).sendKeys(address1);
    driver.findElement(By.id("s0-addressLine2-field-addressLine2-field")).clear();
    driver.findElement(By.id("s0-addressLine2-field-addressLine2-field")).sendKeys(address2);
    driver.findElement(By.id("s0-city-field-city-field")).click();
    driver.findElement(By.id("s0-city-field-city-field")).clear();
    driver.findElement(By.id("s0-city-field-city-field")).sendKeys(city);
    new Select(driver.findElement(By.id("s0-stateDD-0[0]"))).selectByVisibleText(state);
    driver.findElement(By.id("s0-zipCode-field-zipCode-field")).clear();
    driver.findElement(By.id("s0-zipCode-field-zipCode-field")).sendKeys(postcode);
    driver.findElement(By.id("s0-phone-field-phone-field")).clear();
    driver.findElement(By.id("s0-phone-field-phone-field")).sendKeys(phonenumber);
    driver.findElement(By.id("s0-savebutton")).click();
  }

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
