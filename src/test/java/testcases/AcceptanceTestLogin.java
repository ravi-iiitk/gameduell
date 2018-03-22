package testcases;

import Driver.Driver;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobjects.HomePage;
import pageobjects.MyGameDuellPage;
import pageobjects.RegistrationPage;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AcceptanceTestLogin {

    @BeforeClass
    public static void initalize() throws IOException
    {
        Driver drv = new Driver();
        drv.openBrowser();
        drv.openWebSite();
    }

    @Test
    public void verifyLinkOnLoginAgain() throws IOException,BiffException,InterruptedException
    {
        HomePage.login(Driver.driver);
        MyGameDuellPage.logout(Driver.driver);
        HomePage.login(Driver.driver);
        HomePage.verifyURLOnReLogin(Driver.driver);
        MyGameDuellPage.logout(Driver.driver);
    }

    @AfterClass
    public static void closeBrowser(){
      Driver drv = new Driver();
      drv.closeBrowser();
    }

}
