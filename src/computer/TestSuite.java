package computer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;

public class TestSuite extends ReusableMethods {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeAlphaBaticOrder() throws InterruptedException {
        /*1.1 Click on Computer Menu.
	      1.2 Click on Desktop
	      1.3 Select Sort By position "Name: Z to A"
       	  1.4 Verify the Product will arrange in Descending order.
         */

        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));   //click on desktop
        Thread.sleep(1000);
        selectByValueFromDropdown(By.xpath("//select[@id='products-orderby']"), "6");      //descending order Z-A
        String expectedText = "Name: Z to A";
        String actualText = getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        Assert.assertEquals("Text did not matched", expectedText, actualText);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));   //2.1 click on computer
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));   //2.2 click on desktop
        Thread.sleep(1000);
        selectByValueFromDropdown(By.xpath("//select[@id='products-orderby']"), "5");      //2.3 select A to Z
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@class='item-box'][1]//button[text()='Add to cart']"));   //2.4 click on add to cart

        String expextedtext = "Build your own computer";                                      //2.5 Build your own computer text verified
        String actualtext = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("Build your own computer page not found", expextedtext, actualtext);
        Thread.sleep(1000);
        selectByValueFromDropdown(By.xpath("//select[@id='product_attribute_1']"), "1");  //2.6  (select 2.2 GHz)
        Thread.sleep(1000);
        selectByValueFromDropdown(By.xpath("//select[@id='product_attribute_2']"), "5");  //2.7  (select 8GB)
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@value='7']"));  //2.8   selecd 400GB
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@value='9']"));  //2.9   VISTA PRIMIUM
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@value='12']")); //2.10  Total commander
        Thread.sleep(1000);
        String expectedmsg = "$1,475.00";                   //2.11    price verified
        Thread.sleep(1000);
        String actualmsg = getTextFromElement(By.xpath("//span[contains(text(),'$1,475.00')]"));
        Assert.assertEquals("Price not verified", expectedmsg, actualmsg);
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Add to cart')]"));     //2.12 Add to cart
        Thread.sleep(1000);

        String expectedmsg1 = "The product has been added to your shopping cart";   //2.13 message varified
        String actualmsg1 = getTextFromElement(By.xpath("//p[@class='content']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[@title='Close']"));        // close the msg

        mouseHoverAction(By.xpath("//span[@class='cart-label']"));   //2.14 mouse hover on shopping cart
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']")); //click

        String expectedmsg2 = "Shopping cart";                 //verify msg
        String actualmsg2 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Shopping cart page not found", expectedmsg2, actualmsg2);
        Thread.sleep(1000);

        clearValue(By.xpath("//input[@class='qty-input']"));     //clear value "1"
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");   //2.16 change to quantity 2
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Update shopping cart')]"));     //2.16 click to update cart
        Thread.sleep(1000);

        String expectedmsg3 = "$2,950.00";                 //2.17 verify amount $2950.00
        String actualmsg3 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        Assert.assertEquals("Amount is not verified", expectedmsg2, actualmsg2);
        Thread.sleep(1000);

        clickOnElement(By.xpath("//input[@id='termsofservice']")); //2.18 click on checkbox "I agree"
        clickOnElement(By.xpath("//button[@id='checkout']"));      //2.19 click on checkout
        Thread.sleep(1000);

        String expecedmsg4 = "Welcome, Please Sign In!";     //2.20 verify welcome msg
        String actualmsg4 = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        Assert.assertEquals("Welcome page not found", expecedmsg4, actualmsg4);

        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));  //2.21 clcik on as a guest

        //filling mandatory fields
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Kishan");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Patel");
        sendTextToElement(By.id("BillingNewAddress_Email"), "prime123@gmail.com");
        Thread.sleep(1000);
        selectByValueFromDropdown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "1");
        Thread.sleep(1000);
        selectByValueFromDropdown(By.id("BillingNewAddress_StateProvinceId"), "47");
        Thread.sleep(1000);
        sendTextToElement(By.id("BillingNewAddress_City"), "Shrewsbury");
        Thread.sleep(1000);
        sendTextToElement(By.id("BillingNewAddress_Address1"), "01 Near CVS");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "01550");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "4342858811");
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        Thread.sleep(1000);

        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));  //2.24 radio button next day air
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));  //2.25 click on continue
        Thread.sleep(2000);

        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));   //2.26
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        Thread.sleep(2000);

        selectByValueFromDropdown(By.xpath("//select[@id='CreditCardType']"), "MasterCard");   //2.27  select mastercard

        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "KSPATEL");      //2.28 fill all the details
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5105105105105100");
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireMonth']"), "12");
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireYear']"), "2023");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "555");

        clickOnElement(By.xpath("//button[@onclick='PaymentInfo.save()']"));      //2.29 click on continue
        Thread.sleep(1000);

        String expectedcard = "Credit Card";           //2.30 verify
        String actualcard = getTextFromElement(By.xpath("//span[contains(text(),'  Credit Card')]"));
        Assert.assertEquals("Card is not credit card", expectedcard, actualcard);
        Thread.sleep(1000);
        String expectedshipping = "Next Day Air";    //2.31  verify
        String actualshipping = getTextFromElement(By.xpath("//span[contains(text(),'  Next Day Air')]"));
        Assert.assertEquals("Shipping is not by Air", expectedshipping, actualshipping);
        Thread.sleep(1000);                  //2.33 Verify total
        String expectedTotal1 = "$2,950.00";
        String actualTotal1 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        Assert.assertEquals("Final Total is wrong", expectedTotal1, actualTotal1);
        Thread.sleep(1000);

        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));  //2.34 click on confirm

        String expectedThankYou = "Thank you";      //2.35 Thank you text verified
        String actualThankYou = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Thank you page not found !!!!", expectedThankYou, actualThankYou);

        String expectedOrderStatus = "Your order has been successfully processed!";   //2.36  verify text
        String actualOrderStatus = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Order status message not found!!!", expectedOrderStatus, actualOrderStatus);

        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));    //2.37 click on continue

        String expectedWelcome = "Welcome to our store";                         //2.38 welcome to our store text verified
        String actualWelcome = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Welcome to our store page not found !!", expectedWelcome, actualWelcome);


    }


}
