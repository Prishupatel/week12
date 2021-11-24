package homepage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;

public class TopMenuTest extends ReusableMethods {
    String baseUrl="https://mobile.x-cart.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

     //user should navigate to shipping page and verify
    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully(){

        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//li[@class='leaf']//a[@href='shipping.html']"));

        String expectedMsg="Shipping.";
        String actualMsg=getTextFromElement(By.id("page-title"));
        Assert.assertEquals("User is not able to navigate to shipping page",expectedMsg,actualMsg);

    }

    //user should navigate to new page successfully
    @Test
    public void verifyUserShouldNavigateToNewArrivalPageSuccessfully(){
        clickOnElement(By.xpath("(//span[contains(text(),'New!')])[2]"));

        String expectedMsg="New arrivals";
        String actualMsg=getTextFromElement(By.id("page-title"));
        Assert.assertEquals("USER IS UNABLE TO REACH AT NEW ARRIVALS ",actualMsg,expectedMsg);
    }

    @Test
    public void verifyUserShouldNavigateToComingSoonPageSuccessfully(){
        clickOnElement(By.xpath("(//span[contains(text(),'Coming soon')])[2]"));
        String expectedMsg="Coming soon";
        String actualMsg=getTextFromElement(By.id("page-title"));
        Assert.assertEquals("USER IS UNABLE TO REACH AT COMING SOON  ",actualMsg,expectedMsg);

    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
        clickOnElement(By.xpath("(//span[contains(text(),'Contact us')])[2]"));
        String expectedMsg="Contact us";
        String actualMsg=getTextFromElement(By.id("page-title"));
        Assert.assertEquals("USER IS UNABLE TO REACH AT CONTACT US  ",actualMsg,expectedMsg);


    }



}
