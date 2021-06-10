package com.cybertek.tests.day3_webElement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cybertekschool.com/forgot_password");

        WebElement retriveDetailsbutton = driver.findElement(By.id("details-button"));
        retriveDetailsbutton.click();

        WebElement retriveProceedbutton = driver.findElement(By.id("proceed-link"));
        retriveProceedbutton.click();

        String expectedURL = driver.getCurrentUrl();
        WebElement retrivePasswordbutton = driver.findElement(By.id("form_submit"));
        retrivePasswordbutton.click();
        String actualURL = driver.getCurrentUrl();

        if(expectedURL.equals(actualURL)){
            System.out.println("PASS");
        }
        else
            System.out.println("FAIL");

        //driver.quit();
    }
}
