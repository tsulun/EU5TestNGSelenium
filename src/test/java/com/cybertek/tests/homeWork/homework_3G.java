package com.cybertek.tests.homeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homework_3G {
    @Test
            public void test1(){


    WebDriver driver = WebDriverFactory.getDriver("chrome");
    driver.navigate().to("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

    //locator of message box
        WebElement messageBox = driver.findElement(By.xpath("//div[@id='txtAge']"));

        //Verify “Success – Check box is checked” message is NOT displayed.
        Assert.assertFalse(messageBox.isDisplayed(), "message box is not hidden");
        driver.findElement(By.xpath("//input[@id='isAgeSelected']")).click();

    //Verify “Success – Check box is checked” message is displayed.
        Assert.assertTrue(messageBox.isDisplayed(),"message box is not showed up");

        driver.quit();


    }
}
