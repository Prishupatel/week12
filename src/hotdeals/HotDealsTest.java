package hotdeals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;

public class HotDealsTest extends ReusableMethods {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() {
        /*1 - verifySaleProductsArrangeAlphabetically()
		1.1 Mouse hover on the “Hot deals” link
		1.2 Mouse hover on the “Sale”  link and click
		1.3 Verify the text “Sale”
		1.4 Mouse hover on “Sort By” and select “Name A-Z”
		1.5 Verify that the product arrange alphabetically */

        mouseHoverAction(By.xpath("(//span[@class='primary-title'][normalize-space()='Hot deals'])[2]"));
        mouseHoverAction(By.xpath("(//span[contains(text(),'Sale')])[2]")).click();

        String expectedMsg = "Sale";
        String actualMsg = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("USER IS UNABLE TO REACH AT SALE PAGE ", expectedMsg, actualMsg);

        mouseHoverAction(By.xpath("//span[@class='sort-by-value']"));
        clickOnElement(By.partialLinkText("Name A -"));

        expectedMsg = "Name A - Z";
        actualMsg = getTextFromElement(By.xpath("//span[contains(text(),'Name A - Z')]"));
        Assert.assertEquals("Not sorted by expected", expectedMsg, actualMsg);

    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() {
        /*
        2.1 Mouse hover on the “Hot deals” link
		2.2 Mouse hover on the “Sale”  link and click
		2.3 Verify the text “Sale”
		2.4 Mouse hover on “Sort By” and select “Price Low-High”
		2.5 Verify that the product’s price arrange Low to High
         */

        mouseHoverAction(By.xpath("(//span[@class='primary-title'][normalize-space()='Hot deals'])[2]"));
        mouseHoverAndClickOnElement(By.xpath("(//span[contains(text(),'Sale')])[2]"));


        String expectedMsg = "Sale";
        String actualMsg = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("USER IS UNABLE TO REACH ", expectedMsg, actualMsg);

        mouseHoverAction(By.xpath("//span[@class='sort-by-value']"));
        clickOnElement(By.partialLinkText("Price Low - Hi"));

        expectedMsg = "Price Low - High";
        actualMsg = getTextFromElement(By.xpath("//span[contains(text(),'Price Low - High')"));
        Assert.assertEquals("Not sorted by expected", expectedMsg, actualMsg);

    }

    @Test
    public void verifySalesProductsArrangedByRates() {
       /* 		 3.1 Mouse hover on the “Hot deals” link
		         3.2 Mouse hover on the “Sale”  link and click
		         3.3 Verify the text “Sale”
                 3.4 Mouse hover on “Sort By” and select “Rates”
                 3.5 Verify that the product’s arrange Rates

        */

        mouseHoverAction(By.xpath("(//span[@class='primary-title'][normalize-space()='Hot deals'])[2]"));
        mouseHoverAndClickOnElement(By.xpath("(//span[contains(text(),'Sale')])[2]"));


        String expectedMsg = "Sale";
        String actualMsg = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("USER IS UNABLE TO REACH ", expectedMsg, actualMsg);

        mouseHoverAction(By.xpath("//span[@class='sort-by-value']"));
        clickOnElement(By.partialLinkText("Rates"));

        expectedMsg = "Rates";
        actualMsg = getTextFromElement(By.xpath("//span[contains(text(),'Rates')]"));
        Assert.assertEquals("Not sorted by expected", expectedMsg, actualMsg);

    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() {
        /*
         *      1.1 Mouse hover on the “Hot deals” link
         * 		1.2 Mouse hover on the “Bestsellers”  link and click
         * 		1.3 Verify the text “Bestsellers”
         * 		1.4 Mouse hover on “Sort By” and select “Name Z-A”
         * 		1.5 Verify that the product arrange by Z to A
         */
        mouseHoverAction(By.xpath("(//span[@class='primary-title'][normalize-space()='Hot deals'])[2]"));
        mouseHoverAndClickOnElement(By.xpath("(//span[contains(text(),'Sale')])[2]"));


        String expectedMsg = "Sale";
        String actualMsg = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("USER IS UNABLE TO REACH ", expectedMsg, actualMsg);

        mouseHoverAction(By.xpath("//span[@class='sort-by-value']"));
        clickOnElement(By.partialLinkText("Name Z -"));

        expectedMsg = "Name Z - A";
        actualMsg = getTextFromElement(By.xpath("//span[contains(text(),'Name Z - A')]"));
        Assert.assertEquals("Not sorted by expected", expectedMsg, actualMsg);

    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() {
        /*
        2.1 Mouse hover on the “Hot deals” link
		2.2 Mouse hover on the “Bestsellers” link and click
		2.3 Verify the text “Bestsellers”
		2.4 Mouse hover on “Sort By” and select “Price High-Low”
		2.5 Verify that the product’s price arrange High to Low

         */

        mouseHoverAction(By.xpath("(//span[@class='primary-title'][normalize-space()='Hot deals'])[2]"));
        mouseHoverAndClickOnElement(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        String expectedMsg = "Sale";
        String actualMsg = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("USER IS UNABLE TO REACH ", expectedMsg, actualMsg);

        mouseHoverAction(By.xpath("//span[@class='sort-by-value']"));
        clickOnElement(By.partialLinkText("Price High - L"));

        expectedMsg = "Price High - Low";
        actualMsg = getTextFromElement(By.xpath("//span[contains(text(),'Price High - Low')"));
        Assert.assertEquals("Not sorted by expected", expectedMsg, actualMsg);
    }


}
