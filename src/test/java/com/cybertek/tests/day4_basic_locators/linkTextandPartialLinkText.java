package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class linkTextandPartialLinkText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement link1= driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        link1.click();
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(10000);
        driver.navigate().back();
        WebElement link4=driver.findElement(By.partialLinkText("Example 4"));
        link4.click();

    }
}
