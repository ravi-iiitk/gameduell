package testcases;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobjects.HomePage;
import pageobjects.MyGameDuellPage;
import pageobjects.RegistrationPage;
import Driver.Driver;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class AcceptanceTestCredits {

    @BeforeClass
    public static void initalize() throws IOException
    {
        Driver drv = new Driver();
        drv.openBrowser();
        drv.openWebSite();
    }

    @Test
    public void VerifyCredits() throws BiffException,WriteException,IOException,InterruptedException
    {
        HomePage.login(Driver.driver);
        Float credtMyDuelPage = MyGameDuellPage.getTheCreditAmountPage(Driver.driver);
        Float credtMyDuelBox = MyGameDuellPage.getTheCreditAmountBox(Driver.driver);
        assertEquals(credtMyDuelPage,credtMyDuelBox);
        MyGameDuellPage.logout(Driver.driver);
    }


    @AfterClass
    public static void closeBrowser(){
      Driver drv = new Driver();
      drv.closeBrowser();
    }

}
