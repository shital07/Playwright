package framweorkTCs;

import framework.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {


    @BeforeMethod
    public void setBrowser() {


        Driver.initBrowser("chrome");
        Driver.getBrowserContext();
        Driver.getPage();
        Driver.loadUrl();
    }

    @AfterMethod
    public void tearDown() {


        Driver.closeBrowserContext();

    }
}
