package pageobjects;


import commonlib.Utility;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;


public class MyGameDuellPage {
    final static Logger logger = Logger.getLogger(Utility.class.getName());
    public static float getTheCreditAmountBox(WebDriver driver) throws IOException,BiffException,WriteException
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement credtBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountBoxContainerPractice:accountBoxAmount")));
        Utility.captureScreenShot(driver,"MyGameDuell-Page");
        logger.info("Succesfully Logged In");
        String credtAmountStr = credtBox.getText();
        String filteredAMount = Utility.removeLast(credtAmountStr,0,credtAmountStr.length()-8);
        filteredAMount = filteredAMount.replaceAll("(\\d+),.*", "$1");
        Float credit = Float.parseFloat(filteredAMount);
        logger.info("Captured the credits Available from Box");
        return credit;
    }

    public static float getTheCreditAmountPage(WebDriver driver) throws IOException,BiffException,WriteException
    {
        driver.findElement(By.xpath("//*[@id=\"topNaviMygdLink\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement credtBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/p")));
        Utility.captureScreenShot(driver,"MyGameDuell-Page");
        String credtAmountStr = credtBox.getText();
        String filteredAMount = Utility.removeLast(credtAmountStr,credtAmountStr.length()-13,credtAmountStr.length()-8);
        filteredAMount = filteredAMount.replaceAll("(\\d+),.*", "$1");
        System.out.print(filteredAMount);
        Float credit = Float.parseFloat(filteredAMount);
        logger.info("Captured the credits Available on Page");
        return credit;
    }

    public static void logout(WebDriver driver) throws IOException
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logoutLink")));
        driver.findElement(By.id("logoutLink")).click();
        logger.info("Logged Out");
        Utility.captureScreenShot(driver,"MyGameDuell-Page");

    }
}


