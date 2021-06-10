package com.cybertek.tests.homeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework_2 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement home = driver.findElement(By.xpath("//a[@href='/']"));
        System.out.println(home.getText());

        WebElement ForgotP = driver.findElement(By.xpath("//h2"));
        System.out.println(ForgotP.getText());
        WebElement EmailText = driver.findElement(By.xpath("//label[@for='email']"));
        System.out.println(EmailText.getText());
        WebElement EmailInput = driver.findElement(By.xpath("//input[@type='text']"));
        EmailInput.sendKeys("deneme@gmail.com");

        WebElement Retrieve = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        System.out.println(Retrieve.getText());
        driver.quit();
    }

}
