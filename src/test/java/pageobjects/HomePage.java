package pageobjects;

import commonlib.ReadExcelFile;
import commonlib.Utility;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;


public class HomePage {
    final static Logger logger = Logger.getLogger(Utility.class.getName());
    public static void clickOnNewUserLink(WebDriver driver) throws IOException
    {
        String xpathNewUSerLink = "/html/body/div[1]/div[1]/div/div/span[3]/a[1]";
        if(Utility.existsElement(xpathNewUSerLink,driver))
        {
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/span[3]/a[1]")).click();
            logger.info("On Home Page");
            Utility.captureScreenShot(driver,"HomePage");
            WebElement newUserLink = driver.findElement(By.xpath("//*[@id=\"newHereLink\"]"));
            newUserLink.click();
            logger.info("New User LInk clicked");
            Utility.captureScreenShot(driver,"NewUser_Link_Clicked");
        }

    }
    public static void login(WebDriver driver) throws IOException,BiffException,InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div/span[3]/a[1]")));
        if(Utility.existsElement("/html/body/div[1]/div[1]/div/div/span[3]/a[1]",driver))
        {
            WebElement popup = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/span[3]/a[1]"));
            popup.click();
        }
        String userId ="";
        String pwd = "";
        Utility.captureScreenShot(driver,"Login_DataEntry");
        logger.info("Entering Data for Login");
        WebElement userName = driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/div[3]/form/input[1]"));
        WebElement password = driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/div[3]/form/input[2]"));
        ReadExcelFile rdExl = new ReadExcelFile();
        String signupRow = rdExl.readExcel("DataRow",1,0);
        int signUpRow = Integer.parseInt(signupRow);
        try
        {
            pwd=rdExl.readExcel("signup",signUpRow,2);
            userId=rdExl.readExcel("signup",signUpRow,0);
        }
        catch (IOException ioe)
        {
            System.out.print(ioe.getMessage());
        }
        catch (BiffException bfe)
        {
            System.out.print(bfe.getMessage());
        }

        userName.sendKeys(userId);
        password.sendKeys(pwd);
        Utility.captureScreenShot(driver,"Login_DataEntred");
        logger.info("Data entered for Login and going to click Login button");
        WebElement loginBtn = driver.findElement(By.id("loginLink"));
        loginBtn.click();
        logger.info("Clicked on Login button");
        Utility.captureScreenShot(driver,"Login_ButtonClicked");
    }

    public static void verifyURLOnReLogin(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        By addItem = By.id("mailInput");
        wait.until(ExpectedConditions.presenceOfElementLocated(addItem));
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://my.gameduell.com/gd/emailManagement/emailValidation.xhtml" );
    }

    public static void verifyLogin(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        By addItem = By.id("mailInput");
        wait.until(ExpectedConditions.presenceOfElementLocated(addItem));
        Assert.assertEquals(Utility.isElementVisible(driver,addItem,Utility.ElementStatus.VISIBLE),Utility.ElementStatus.VISIBLE);
    }
}
