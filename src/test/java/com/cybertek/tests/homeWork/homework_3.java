package com.cybertek.tests.homeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homework_3 {

    @Test
    public void test1()  {

    WebDriver driver = WebDriverFactory.getDriver("chrome");
    driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    WebElement message = driver.findElement(By.xpath("//div[@id=\"txtAge\"]"));
    Assert.assertFalse(message.isDisplayed(),"checking message is hidden");

    driver.findElement(By.xpath("//input[@id=\"isAgeSelected\"]")).click();

    Assert.assertTrue(message.isDisplayed(),"checking message is showed up");

    driver.close();

    }

    @Test
    public void test2() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkall = driver.findElement(By.cssSelector("#check1"));
        Assert.assertTrue(checkall.getAttribute("value").contains("Check All"),"Verify “Check All” button text is “Check All”");
        //Click to “Check All” button
        checkall.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Option 1']/input")).isSelected() &&
                                    driver.findElement(By.xpath("//*[text()='Option 2']/input")).isSelected()&&
                                    driver.findElement(By.xpath("//*[text()='Option 3']/input")).isSelected()&&
                                    driver.findElement(By.xpath("//*[text()='Option 4']/input")).isSelected(),"Verify all check boxes are checked");

    //Click to “Uncheck All” button
        checkall.click();

        Assert.assertFalse(driver.findElement(By.xpath("//*[text()='Option 1']/input")).isSelected() &&
                driver.findElement(By.xpath("//*[text()='Option 2']/input")).isSelected()&&
                driver.findElement(By.xpath("//*[text()='Option 3']/input")).isSelected()&&
                driver.findElement(By.xpath("//*[text()='Option 4']/input")).isSelected(),"Verify button text changed to “Uncheck All”");

    driver.quit();
}}
