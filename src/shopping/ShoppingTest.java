package shopping;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import utilities.ReusableMethods;

public class ShoppingTest extends ReusableMethods {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldPlaceOrderSuccessfully() throws InterruptedException {
      /*
      1.1 Mouse hover on the “Hot deals” link
		1.2 Mouse hover on the “Sale”  link and click
		1.3 Verify the text “Sale”
		1.4 Mouse hover on “Sort By” and select “Name A-Z”
		1.5 Click on “Add to cart” button of the product “Cup of Mojo Bluetooth
      Speaker”
1.6 Verify the@ message “Product has been added to your cart” display in  green bar
1.7 Click on X sign to close the message
1.8 Click on “Your cart” icon and Click on “View cart” button
1.9 Verify the text “Your shopping cart - 1 item”
clv1.10 Change the Qty = 2
1.11 Verify the text “Your shopping cart - 2 items”
1.12 Verify the Subtotal $39.98
1.13 Verify the total $46.18
1.14 Click on “Go to checkout” button
1.15 Verify the text “Log in to your account”
1.16 Enter Email address
1.17 Click on “Continue” Button
1.18 Verify the text “Secure Checkout”
1.19 Fill all the mandatory fields
1.20 Check the check box “Create an account for later use”
1.21 Enter the password
1.22 Select the Delivery Method to “Local Shipping”Use
1.23 Select Payment Method “COD”
1.24 Verify the total $47.22
1.25 Click on “Place Order” Button
1.26 Verify the text “Thank you for your order”



       */
        mouseHoverAction(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"));
        mouseHoverAction(By.xpath("(//span[contains(text(),'Sale')])[2]")).click();
        String expectedMsg = "Sale";
        String actualMsg = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("USER IS UNABLE TO REACH AT SALE PAGE ", expectedMsg, actualMsg);
        Thread.sleep(1000);
        mouseHoverAction(By.xpath("//span[@class='sort-by-value']"));
        clickOnElement(By.partialLinkText("Name A -"));

        //mouse hover and click on add to cart
        Thread.sleep(2000);
        mouseHoverAndClickOnElement(By.xpath("(//span[contains(text(),'Add to cart')])[1]"));   //ADD to cart
        String expectedmsg = "Product has been added to your cart";
        String actualmsg = getTextFromElement(By.xpath("//div[@id='status-messages']//ul"));
        Assert.assertEquals("Product not shipped in cart", expectedmsg, actualmsg);
        clickOnElement(By.xpath("//a[@title='Close']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@title='Your cart']"));                   //click on your cart icon
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[@class='regular-button cart']"));       //click on view cart
        Thread.sleep(1000);
        String expectedmsgincart = "Your shopping cart - 1 item";
        String actualmsgincart = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Item is not in cart", expectedmsgincart, actualmsgincart);
        System.out.println(actualmsgincart);
        Thread.sleep(1000);

        //Change the quantity=2
        clearValue(By.xpath("//input[@id='amount16']"));
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='amount16']"), "2");


        //1.11 Verify the text “Your shopping cart - 2 items
        Thread.sleep(1000);
        String expectedmsgincart1 = "Your shopping cart - 2 items";
        Thread.sleep(1000);
        String actualmsgincart1 = getTextFromElement(By.xpath("//h1[text()='Your shopping cart - 2 items']"));
        Thread.sleep(1000);
        Assert.assertEquals("Item is not in cart", expectedmsgincart1, actualmsgincart1);

        //verify total and subtotal

        String expectedSubTotal = "Subtotal: $29.98";
        String actualSubtotal = getTextFromElement(By.xpath("//ul[@class='sums']//li[@class='subtotal']"));
        Assert.assertEquals("Subtotoal is not correct", expectedSubTotal, actualSubtotal);

        String expectedTotal = "$32.88";
        String actualTotal = getTextFromElement(By.xpath("//li[@class='total']"));
        Assert.assertEquals("Total not matched", expectedTotal, actualTotal);

        //click on checkout button
        clickOnElement(By.xpath("//span[normalize-space()='Go to checkout']"));
        //verify Log in your account text
        String expectedVerify = "Log in to your account";
        String actualverify = getTextFromElement(By.xpath("//h3[normalize-space()='Log in to your account']"));
        Assert.assertEquals("Log in your account text failed", expectedVerify, actualverify);

        sendTextToElement(By.xpath("//input[@id='email']"), "primetest123@gmail.com");
        clickOnElement(By.xpath("//span[contains(text(),'Continue')]"));

        String expectedSecure = "Secure Checkout";
        String actualSecure = getTextFromElement(By.xpath("//h1[normalize-space()='Secure Checkout']"));
        Assert.assertEquals("Secure checkout is failed", expectedSecure, actualSecure);

        //fill all the mandatory fields

        sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"), "Kishan");   //First name
        sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"), "Patel");     //Last name
        sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"), "35 morrill");  //street adress
        clearValue(By.xpath("//input[@id='shippingaddress-city']"));              //clear value Los Angeles
        sendTextToElement(By.xpath("//input[@id='shippingaddress-city']"),"Boston");
         Thread.sleep(1000);

         selectByValueFromDropdown(By.xpath("(//select[@id='shippingaddress-country-code'])[1]"),"US");
         selectByValueFromDropdown(By.xpath("(//select[@id='shippingaddress-state-id'])[1]"),"560");

        clearValue(By.xpath("//input[@id='shippingaddress-zipcode']"));
        sendTextToElement(By.xpath("//input[@id='shippingaddress-zipcode']"), "01545");


//        Thread.sleep(1000);
//        clickOnElement(By.xpath("//input[@id='create_profile']"));    //create your account
//        Thread.sleep(1000);
//
//        sendTextToElement(By.xpath("//input[@id='password']"), "xyz@123");
        Thread.sleep(1000);
        clickOnElement(By.id("method128"));
        clickOnElement(By.id("pmethod6"));
        Thread.sleep(1000);
        String expectedLastTotal = "$33.95";
        String actualLastTotal = getTextFromElement(By.xpath("//div[@class='total clearfix']//span[@class='surcharge-cell']"));
        Assert.assertEquals("Last Total not matched", expectedLastTotal, actualLastTotal);
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[contains(text(),'Place order: $33.95')]"));
        Thread.sleep(1000);
        String expectedThankmsg = "Thank you for your order";
        String actualThankMsg = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Thank you for your order page not found", expectedThankmsg, actualThankMsg);

    }

    @Test

    public void verifyUserShouldClearShoppingCartSuccessfully() throws InterruptedException {

        mouseHoverAction(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"));
        mouseHoverAction(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Bestsellers']")).click();
        Thread.sleep(1000);
        String expectedText1 = "Bestsellers";
        String actualText1 = getTextFromElement(By.xpath("//h1[text()='Bestsellers']"));
        Assert.assertEquals("Bestsellers Text did not match",expectedText1,actualText1);

        mouseHoverAction(By.xpath("//span[@class='sort-by-value']"));
        clickOnElement(By.partialLinkText("Name A -"));
        Thread.sleep(2000);
        mouseHoverAction(By.xpath("//div[@class='product productid-13 ']"));
        clickOnElement(By.xpath("//div[@class='product productid-13 ']//div[@class='add-to-cart-button']"));

        //Verify the message “Product has been added to your cart” display in  green bar and close it
        String expectedMsg = "Product has been added to your cart";
        String actualMsg = getTextFromElement(By.xpath("//li[(text()='Product has been added to your cart')]"));
        Assert.assertEquals("Message did not match", expectedMsg, actualMsg);
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[@class='close']"));
        Thread.sleep(1000);

        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='header-area']/div[1]/div[1]/div[5]/div[4]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[@class='regular-button cart']"));  //view cart
        Thread.sleep(1000);
        String expectedCartItem = "Your shopping cart - 1 item";
        String actualCartItem = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Item Message did not match", expectedCartItem, actualCartItem);

        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));   //Empty cart
        Alert alert = driver.switchTo().alert();
        String expectedPopUp = "Are you sure you want to clear your cart?";
        String actualPopUp = alert.getText();
        Assert.assertEquals("Wrong alert",expectedPopUp,actualPopUp);
        Thread.sleep(1000);
        alert(By.xpath("//a[contains(text(),'Empty your cart')]"));

        String expectedDeleteMsg = "Item(s) deleted from your cart";
        String actualDeleteMsg = getTextFromElement(By.xpath("//li[text()='Item(s) deleted from your cart']"));
        Assert.assertEquals("Item is not deleted from cart", expectedDeleteMsg, actualDeleteMsg);
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[@class='close']"));

        Thread.sleep(1000);
        String expectedEmptyMsg = "Your cart is empty";
        String actualEmptyMsg = getTextFromElement(By.xpath("//h1[text()='Your cart is empty']"));
        Assert.assertEquals("Card is not empty", expectedEmptyMsg, actualEmptyMsg);

    }



}

