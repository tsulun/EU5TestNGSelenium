package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iFrameTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/iframe");
        //how to switch frames
        //1. switch using by id or name attribute of iframe
        driver.switchTo().frame("mce_0_ifr");
        //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        //send keys
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith");
        //in order to action with whole page you should switch back to main html
        //goes back to first frame, useful when we switch multiple frames
        driver.switchTo().defaultContent();

        //2. Switching with INDEX

        driver.switchTo().frame(0); // you dont count main html as a index!!
        //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        //send keys
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with index");
        //goes back to parent frame, useful when we switch multiple frames
        driver.switchTo().parentFrame();

        //3. Switching with WEBELEMENT
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with Web element ");


    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        //you can swith one frame at a time in the nested frames you cant go through right away
        //switching to top frame
        driver.switchTo().frame("frame-top");
        //top has 3 frame and switching to middle one
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        //you should go parent frame first cuz maybe middle has also some child frames
        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        //go to main html then switch bottom
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }

}
