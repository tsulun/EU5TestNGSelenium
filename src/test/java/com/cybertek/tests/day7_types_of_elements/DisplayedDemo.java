package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement input=driver.findElement(By.cssSelector("#username"));
        WebElement password=driver.findElement(By.cssSelector("#pwd"));

        Assert.assertFalse(input.isDisplayed(),"input box should be hidden");
        Assert.assertFalse(password.isDisplayed(),"password box should be hidden");

        driver.findElement(By.xpath("//button[.='Start']")).click();
        Thread.sleep(7000);

        Assert.assertTrue(input.isDisplayed(),"input box should be hidden");
        Assert.assertTrue(password.isDisplayed(),"password box should be hidden");
        driver.close();
    }
}
