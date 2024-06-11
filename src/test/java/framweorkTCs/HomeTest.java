package framweorkTCs;
import framework.pages.HomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
public class HomeTest extends BaseTest {


    @Test
    public void testAmazonSearchFunctionality() throws InterruptedException {


        HomePage homePage = new HomePage();
        homePage.enterSearchText("Mackbook");
        homePage.clickSearchIcon();
        System.out.println(homePage.getSearchHeading());
        Thread.sleep(5000);


    }


    @Test
    public void testLogin() throws InterruptedException {


        HomePage homePage = new HomePage();
        homePage.enterSearchText("Mackbook");
        homePage.clickSearchIcon();
        System.out.println(homePage.getSearchHeading());
        Thread.sleep(5000);
        String title =homePage.clickMyAccountlink()
                .clickNewContusomer()
                .getTitle();

        Assertions.assertThat(title).isEqualTo("Register Account");


    }

}
