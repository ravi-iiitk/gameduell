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


public class RegistrationPage {
    final static Logger logger = Logger.getLogger(Utility.class.getName());
    public static void doRegistration(WebDriver driver) throws IOException,BiffException,WriteException
    {
        String userId ="";
        String pwd = "";
        String emal ="";
        Utility.captureScreenShot(driver,"SingUp_DataEntry");
        logger.info("Entering Data for sign up");
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"tf1\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"tf2\"]"));
        WebElement email  = driver.findElement(By.xpath("//*[@id=\"tf3\"]"));
        ReadExcelFile rdExl = new ReadExcelFile();
        String signupRow = rdExl.readExcel("DataRow",1,0);
        int signUpRow = Integer.parseInt(signupRow);
        try
        {
            userId=Utility.randomString(10);
            emal = Utility.randomString(5);
            String emailtoEnter = emal+"@gmail.com";
            String celToWrtId = "A"+(signUpRow+1);
            String celToWrtEmailId = "B"+(signUpRow+1);
            rdExl.writeToExcel("signup",celToWrtId,userId);
            rdExl.writeToExcel("signup",celToWrtEmailId,emailtoEnter);
            pwd=rdExl.readExcel("signup",signUpRow,2);
            emal=rdExl.readExcel("signup",signUpRow,1);
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
        email.sendKeys(emal);
        Utility.captureScreenShot(driver,"SingUp_DataEntred");
        logger.info("Data entered for signup and going to click sign up button");
        WebElement registerBtn = driver.findElement(By.id("registrationButton"));
        registerBtn.click();
        logger.info("Clicked on Signup button");
        Utility.captureScreenShot(driver,"SingUp_ButtonClicked");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mailInput")));
        Utility.isElementVisible(driver,By.id("mailInput"), Utility.ElementStatus.VISIBLE);
        Assert.assertEquals(Utility.isElementVisible(driver,By.id("mailInput"), Utility.ElementStatus.VISIBLE),Utility.ElementStatus.VISIBLE);
    }
}
