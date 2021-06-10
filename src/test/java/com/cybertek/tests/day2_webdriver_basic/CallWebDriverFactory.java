package com.cybertek.tests.day2_webdriver_basic;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.co.uk/");
        String title = driver.getTitle();
        System.out.println("title = " + title);

        String url=driver.getCurrentUrl();
        System.out.println("url = " + url);

        driver.close();
        Thread.sleep(3000);
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cybertekschool.com/forgot_password");
        Thread.sleep(7000);
        driver.get("https://www.google.co.uk/");

    }
}
