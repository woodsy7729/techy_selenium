package tests;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class MainTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String credentialspath = "src\\config\\ebayCredentials";
    private String addresspath = "src\\config\\RetailDetail.txt";
    private String urlpath = "src\\config\\";


    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.ebay.com.au/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //testEditAddress();
    }

    public void screenshotTest(String status) throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String basepath= "C:\\Users\\woods\\IdeaProjects\\hello_world\\src\\Logs\\";
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String name= dateFormat.format(date);
        String img = ".png";
        String fullpath = basepath+ status+"_"+name+img;
        System.out.println(fullpath);
// Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File(fullpath));
        driver.quit();
    }


    public void testEditAddressRealtime() throws Exception {
        FileInputStream fis = new FileInputStream(addresspath);
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
        testLogin("config/User1");
        driver.findElement(By.linkText("My eBay")).click();
        driver.findElement(By.linkText("AccountPage")).click();
        driver.findElement(By.linkText("Addresses")).click();
        //driver.findElement(By.linkText("Addresses")).click();
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
        TimeUnit.SECONDS.sleep(2);
        screenshotTest("EditDetails");
        driver.findElement(By.id("s0-savebutton")).click();

    }

    public void testEditAddressSlowed() throws Exception {
        FileInputStream fis = new FileInputStream(addresspath);
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
        testLogin("config/User1");
        driver.findElement(By.linkText("My eBay")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.linkText("AccountPage")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.linkText("Addresses")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.linkText("Change your primary delivery address")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.linkText("Edit")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("s0-name-field-name-field")).clear();
        driver.findElement(By.id("s0-name-field-name-field")).sendKeys(fullname);
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("s0-addressLine1-field-addressLine1-field")).clear();
        driver.findElement(By.id("s0-addressLine1-field-addressLine1-field")).sendKeys(address1);
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("s0-addressLine2-field-addressLine2-field")).clear();
        driver.findElement(By.id("s0-addressLine2-field-addressLine2-field")).sendKeys(address2);
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("s0-city-field-city-field")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("s0-city-field-city-field")).clear();
        driver.findElement(By.id("s0-city-field-city-field")).sendKeys(city);
        TimeUnit.SECONDS.sleep(2);
        new Select(driver.findElement(By.id("s0-stateDD-0[0]"))).selectByVisibleText(state);
        driver.findElement(By.id("s0-zipCode-field-zipCode-field")).clear();
        driver.findElement(By.id("s0-zipCode-field-zipCode-field")).sendKeys(postcode);
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("s0-phone-field-phone-field")).clear();
        driver.findElement(By.id("s0-phone-field-phone-field")).sendKeys(phonenumber);
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("s0-savebutton")).click();
        TimeUnit.SECONDS.sleep(2);
    }

    public void testGetFirstURL(String path) throws Exception{
        String fullpath = urlpath+path;
        System.out.println(fullpath);
        FileInputStream fis = new FileInputStream(fullpath);
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
        String line = in.readLine();
        //baseUrl = line;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(line);
    }

    public void testGetAllURL(String path) throws Exception{
        String fullpath = urlpath+path;
        FileInputStream fis = new FileInputStream(fullpath);
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));

        String line;
        while ((line = in.readLine()) != null) {
            // process the line.
            driver.get(line);
            TimeUnit.SECONDS.sleep(4);
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void get(String url){
        driver.get(url);
    }

    public void quit(){ driver.quit();
    }

    public void LogOut (){
        driver.findElement(By.id("gh-ug")).click();
        driver.findElement(By.linkText("Sign out")).click();
    }

    public void testLogin(String path) throws Exception {
        driver.get(baseUrl);
        String fullpath = "src//" + path;
        FileInputStream fis = new FileInputStream(fullpath); //change to full path
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
    }

    public void testEbayAddtocart() throws Exception {
        driver.get("https://www.ebay.com.au/");
        testLogin("config/User1");
        //Add config file
        String path = "src\\config\\Items";
        String item;
        FileInputStream fis = new FileInputStream(path);
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
        while ((item = in.readLine()) != null) {
            driver.findElement(By.id("gh-ac")).click();
            driver.findElement(By.id("gh-ac")).clear();
            driver.findElement(By.id("gh-ac")).sendKeys(item);
            driver.findElement(By.id("gh-btn")).click();
            driver.findElement(By.xpath("//li/h3/a")).click(); //change?
            //driver.findElement(By.linkText("Buy It Now")).click();
            //driver.findElement(By.cssSelector("#binBtn_btn")).click();
            //driver.findElement(By.id("binBtn_btn")).click();
            screenshotTest("Purchase");
            //driver.findElement(By.id("")).click();
            driver.get("https://www.ebay.com.au/");
        }
    }

    public void SearchGeneric(String distopath, String itemspath) throws Exception {
        String fullpathdisto = urlpath+distopath;
        FileInputStream fis = new FileInputStream(fullpathdisto);
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));

        String distline;
        while ((distline = in.readLine()) != null) {
            // process the line.
            String fullpathitems = urlpath + itemspath;
            FileInputStream fis1 = new FileInputStream(fullpathitems);
            BufferedReader in1 = new BufferedReader(new InputStreamReader(fis1));
            String itemline;
            //driver.get(distline);
            while ((itemline = in1.readLine())!= null){

                driver.get(distline);
                WebElement iframe = driver.findElement(By.xpath("//input[@type='text' or @type='search']"));
                driver.findElement(By.xpath("//input[@type='text' or @type='search']")).clear();
                driver.findElement(By.xpath("//input[@type='text' or @type='search']")).sendKeys(itemline);
                driver.findElement(By.xpath("//input[@type='text' or @type='search']")).sendKeys(Keys.RETURN);
                TimeUnit.SECONDS.sleep(3);
                //add click on first link if time
                //if (distline == "https://www.ebay.com.au/"){

                //}
            }

        }
    }

    public void testLogout() throws Exception{
        driver.findElement(By.id("gh-ug")).click();
        driver.findElement(By.linkText("Sign out")).click();
    }
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
