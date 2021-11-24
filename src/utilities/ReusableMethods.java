package utilities;

import homepage.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ReusableMethods extends BaseTest {

    public void clickOnElement(By by) {                     //this method will click on element
        driver.findElement(by).click();
    }

    public String getTextFromElement(By by) {               //this method will get text from element
        return driver.findElement(by).getText();
    }

    public void sendTextToElement(By by, String text) {      //this method will send text to the element
        driver.findElement(by).sendKeys(text);
    }

    public void selectByVisibleTextFromDropDwon(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    public void selectByValueFromDropdown(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }

    public void selectByMouseHoverToElement(By by, String text) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).moveToElement(driver.findElement(by)).click().build().perform();
    }

    public WebElement mouseHoverAction(By by) {
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(by);
        actions.moveToElement(target).build().perform();
        return target;
    }

    public void mouseHoverAndClickOnElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();

    }

    public void clearValue(By by) {
        driver.findElement(by).clear();
    }

    public String alert(By by) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return null;
    }

    public String getUrl() {
        String actualUrl = driver.getCurrentUrl();
        return actualUrl;
    }


}
