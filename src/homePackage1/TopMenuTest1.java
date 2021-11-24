package homePackage1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;

import java.util.List;

public class TopMenuTest1 extends ReusableMethods {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) throws InterruptedException {
        /*1.1 create method with name "selectMenu" it has one parameter name "menu" of  type string.
	      1.2 This method should click on the menu whatever name is passed as parameter.
	      1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.
         */
        Thread.sleep(1000);
        if (menu == "Computers") {
            clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
            String expectedMsg1 = "Computers";
            String actualMsg1 = getTextFromElement(By.xpath("//h1[text()='Computers']"));
            Assert.assertEquals("Text did not match", expectedMsg1, actualMsg1);


        } else if (menu == "Electronics") {
            clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));
            String expectedMsg1 = "Electronics";
            String actualMsg1 = getTextFromElement(By.xpath("//h1[text()='Electronics']"));
            Assert.assertEquals("Text did not match", expectedMsg1, actualMsg1);
        } else if (menu == "Apparel") {
            clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Apparel ']"));
            String expectedMsg1 = "Apparel";
            String actualMsg1 = getTextFromElement(By.xpath("//h1[text()='Apparel']"));
            Assert.assertEquals("Text did not match", expectedMsg1, actualMsg1);
        } else if (menu == "Digital downloads") {
            clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Digital downloads ']"));
            String expectedMsg1 = "Digital downloads";
            String actualMsg1 = getTextFromElement(By.xpath("//h1[text()='Digital downloads']"));
            Assert.assertEquals("Text did not match", expectedMsg1, actualMsg1);
        } else if (menu == "Books") {
            clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Books ']"));
            String expectedMsg1 = "Books";
            String actualMsg1 = getTextFromElement(By.xpath("//h1[text()='Books']"));
            Assert.assertEquals("Text did not match", expectedMsg1, actualMsg1);
        } else if (menu == "Jewelry") {
            clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Jewelry ']"));
            String expectedMsg1 = "Jewelry";
            String actualMsg1 = getTextFromElement(By.xpath("//h1[text()='Jewelry']"));
            Assert.assertEquals("Text did not match", expectedMsg1, actualMsg1);
        } else if (menu == "Gift Cards") {
            clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Gift Cards ']"));
            String expectedMsg1 = "Gift Cards";
            String actualMsg1 = getTextFromElement(By.xpath("//h1[text()='Gift Cards']"));
            Assert.assertEquals("Text did not match", expectedMsg1, actualMsg1);
        }

    }

    @Test
    public void verifyPageNavigation() throws InterruptedException {
        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']"));
        for (WebElement item : menuItems) {

            selectMenu("Computers");
            selectMenu("Electronics");
            selectMenu("Apparel");
            selectMenu("Books");
            selectMenu("Jewelry");
            selectMenu("Gift Cards");
            selectMenu("Digital downloads");

        }
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}






