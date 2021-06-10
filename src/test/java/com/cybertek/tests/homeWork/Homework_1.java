package com.cybertek.tests.homeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homework_1 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.co.uk/");

        driver.findElement(By.cssSelector("#gh-ac")).sendKeys("Daft punk");
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
        System.out.println(driver.findElement(By.cssSelector("h1.srp-controls__count-heading>span")).getText());
        driver.quit();

        driver=WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.co.uk/");

        driver.findElement(By.cssSelector("#gh-ac")).sendKeys("Selenium");
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
        System.out.println(driver.getTitle().contains("Selenium"));
        driver.close();

        driver=WebDriverFactory.getDriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.cssSelector("input[name='search']")).sendKeys("selenium webdriver");
        driver.findElement(By.cssSelector("input[name='go']")).click();
        driver.findElement(By.cssSelector("[href='/wiki/Selenium_(software)']")).click();
        System.out.println(driver.getCurrentUrl().endsWith("Selenium_(software)"));
        driver.quit();

    }
}
