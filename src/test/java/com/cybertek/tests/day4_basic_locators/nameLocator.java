package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocator {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        driver.manage().window().maximize();
        WebElement clickName = driver.findElement(By.name("full_name"));
        clickName.sendKeys("tugkan sulun");

        WebElement clickMail = driver.findElement(By.name("email"));
        clickMail.sendKeys("tsulun16@gmail.com");

        WebElement clickSignUp = driver.findElement(By.name("wooden_spoon"));
        clickSignUp.click();


    }
}
