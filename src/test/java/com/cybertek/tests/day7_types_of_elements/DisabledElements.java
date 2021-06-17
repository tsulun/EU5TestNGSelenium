package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {
    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.navigate().to("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioBtn = driver.findElement(By.id("green"));


        //verify greent radio button is enabled or not
        Assert.assertFalse(greenRadioBtn.isEnabled());

        greenRadioBtn.click();

        Assert.assertFalse(greenRadioBtn.isSelected());
        driver.quit();
    }
    @Test
    public void test2() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.navigate().to("http://practice.cybertekschool.com/dynamic_controls");

        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
        input.sendKeys("some message");



    }
}
