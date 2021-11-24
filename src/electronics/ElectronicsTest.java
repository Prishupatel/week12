package electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;

import java.util.Random;

public class ElectronicsTest extends ReusableMethods {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        mouseHoverAction(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        mouseHoverAndClickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        String expectedCellptext = "Cell phones";
        String actualCellptext = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Cell phones page not found !!!", expectedCellptext, actualCellptext);

    }

    @Test
    public void verifyTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        mouseHoverAction(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));  //2.1
        Thread.sleep(1000);
        mouseHoverAndClickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']")); //2.2

        String expectedCellptext = "Cell phones";         //2.3
        String actualCellptext = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Cell phone page not found !!!", expectedCellptext, actualCellptext);

        clickOnElement(By.xpath("//a[contains(text(),'List')]"));   //2.4  clcik on list view tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));    //2.5 click on product name nokia lumia

        String expectedCellname = "Nokia Lumia 1020";         //2.6
        String actualCellname = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("Nokia Lumia page not found !!!", expectedCellname, actualCellname);

        String expectedCellprice = "$349.00";         //2.7
        String actualCellprice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals("Nokia Lumia page not found !!!", expectedCellprice, actualCellprice);
        Thread.sleep(1000);

        clearValue(By.xpath("//input[@id='product_enteredQuantity_20']"));   //2.8 change quantity
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));  //2.9 click on ADD TO CART
        Thread.sleep(1000);

        String expectedmsg = "The product has been added to your shopping cart";   //2.10 message varified
        String actualmsg = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals("Wrong Page !!!", expectedmsg, actualmsg);
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[@title='Close']"));        // close the msg
        Thread.sleep(1000);

        mouseHoverAndClickOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));  //2.11

        String expectedshopping = "Shopping cart";    //2.12
        String actualshopping = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Shopping cart page not found !!!", expectedshopping, actualshopping);

        Thread.sleep(1000);

//        String expectedQT="2";    //2.13
//        String actualQT= getTextFromElement(By.xpath("//input[@id='itemquantity11216']"));
//        Assert.assertEquals("Shopping cart page not found !!!",expectedQT,actualQT);
        String expectedPrice = "$698.00";    //2.14 verify price
        String actualPrice = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
        Assert.assertEquals("Price not matched", expectedPrice, actualPrice);
        Thread.sleep(1000);

        clickOnElement(By.xpath("//input[@id='termsofservice']"));   //2.15 i agree button checkbox
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='checkout']"));     //2.16 click on checkout

        String expecedmsg2 = "Welcome, Please Sign In!";     //2.17 verify welcome msg
        String actualmsg2 = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        Assert.assertEquals("Welcome page not found", expecedmsg2, actualmsg2);

        Thread.sleep(10000);
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));    //2.18 click on register tab

        String expectedRegister = "Register";     // 2.19 verify text
        String actualRegister = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Register page not found !!", expectedRegister, actualRegister);
        Thread.sleep(1000);

        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Prime");    //2.20  fill req field
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Tester");

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);

        sendTextToElement(By.xpath("//input[@id='Email']"), "QAnalyst" + randomInt + "@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "kishan123#");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "kishan123#");
        Thread.sleep(1000);

        clickOnElement(By.xpath("//button[@id='register-button']"));   //2.21 click on register

        String expextedLoginmsg = "Your registration completed";        //2.22 regestration completed verified
        String actualLoginmsg = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Your register completed page not found", expextedLoginmsg, actualLoginmsg);
        Thread.sleep(1100);

        clickOnElement(By.xpath("//a[contains(text(),'Continue')]")); //2.23
        Thread.sleep(1000);

        String expectedshoppingcart = "Shopping cart";    //2.24
        String actualshoppingcart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Shopping cart page not found !!!", expectedshoppingcart, actualshoppingcart);
        Thread.sleep(1000);

        clickOnElement(By.xpath("//input[@id='termsofservice']"));  //2.25 i agree
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='checkout']"));    //2.26 checkout
        Thread.sleep(1000);

        //sendTextToElement(By.id("BillingNewAddress_FirstName"), "Kishan");
        //sendTextToElement(By.id("BillingNewAddress_LastName"), "Patel");
        // Thread.sleep(1000);
        selectByValueFromDropdown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "1"); //2.27 mandatory fields
        Thread.sleep(1000);
        selectByValueFromDropdown(By.id("BillingNewAddress_StateProvinceId"), "47");
        Thread.sleep(1000);
        sendTextToElement(By.id("BillingNewAddress_City"), "Shrewsbury");
        Thread.sleep(1000);
        sendTextToElement(By.id("BillingNewAddress_Address1"), "01 Near CVS");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "01550");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "4342858811");
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));          //2.28 click on continue
        Thread.sleep(1000);

        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));  //2.29 radio button next day air
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));  //2.30 click on continue
        Thread.sleep(2000);

        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));   //2.30
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        Thread.sleep(2000);

        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "KSPATEL");      //2.33 fill all the details
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "4012888888881881");
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireMonth']"), "12");
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireYear']"), "2023");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "555");

        clickOnElement(By.xpath("//button[@onclick='PaymentInfo.save()']"));      //2.34 click on continue
        Thread.sleep(1000);

        String expectedcard = "Credit Card";           //2.35 verify
        String actualcard = getTextFromElement(By.xpath("//span[contains(text(),'  Credit Card')]"));
        Assert.assertEquals("Card is not credit card", expectedcard, actualcard);
        Thread.sleep(1000);
        String expectedshipping = "Next Day Air";    //2.36  verify
        String actualshipping = getTextFromElement(By.xpath("//span[contains(text(),'  Next Day Air')]"));
        Assert.assertEquals("Shipping is not by Air", expectedshipping, actualshipping);
        Thread.sleep(1000);
        String expectedTotal1 = "$698.00";       //2.37
        String actualTotal1 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
        Assert.assertEquals("Final Total is wrong", expectedTotal1, actualTotal1);
        Thread.sleep(1000);

        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));  //2.38 click on confirm

        String expectedThankYou = "Thank you";      //2.39 Thank you text verified
        String actualThankYou = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Thank you page not found !!!!", expectedThankYou, actualThankYou);

        String expectedOrderStatus = "Your order has been successfully processed!";   //2.40  verify text
        String actualOrderStatus = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Order status message not found!!!", expectedOrderStatus, actualOrderStatus);

        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));    //2.41click on continue

        String expectedWelcome = "Welcome to our store";                         //2.42 welcome to our store text verified
        String actualWelcome = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Welcome to our store page not found !!", expectedWelcome, actualWelcome);

        Thread.sleep(1000);                                                   //2.43
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        String expectedUrl = "https://demo.nopcommerce.com/";                 //2.44
        String actualUrl = getUrl();
        Assert.assertEquals("Url is Different", expectedUrl, actualUrl);


    }


}
