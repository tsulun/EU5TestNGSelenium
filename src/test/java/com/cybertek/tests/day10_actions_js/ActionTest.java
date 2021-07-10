package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
    @Test
    public void hoverTest(){
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1 = driver.findElement(By.tagName("img"));

        //!actions --> class that contains all the user interactions
        //how to create action object -->
         Actions actions = new Actions(driver);
        //perform for implement the action
        //moveToElement --> move your mouse to pointed webelement (hover over)
        actions.moveToElement(img1).perform();
        WebElement viewLink = driver.findElement(By.linkText("View profile"));
        Assert.assertTrue(viewLink.isDisplayed(),"verify view link is displayed");
    }

    @Test
    public void dragAndDrop () throws InterruptedException{
        driver.get("http://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        actions.dragAndDrop(source,target).perform();

        // chaining actions
        Thread.sleep(2000);
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();

    }
    @Test
    public void clickWithJS(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",dropdownLink);
    }
    @Test
    public void typeWithJS() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String text = "hello disabled input";
        jse.executeScript("arguments[0].setAttribute('value','" + text + "')",inputBox);


    }
    @Test
    public void scrollDownAndUp() throws InterruptedException{
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for(int i = 0; i<10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");
        }
        for(int i = 0; i<10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)");
        }



    }
    @Test
    public void scrollToElement() throws InterruptedException{
        driver.get("https://www.amazon.com/");
        WebElement eng = driver.findElement(By.xpath("//span[@class='icp-color-base']"));
        Thread.sleep(2000);
        JavascriptExecutor jse =(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",eng);

    }

}
