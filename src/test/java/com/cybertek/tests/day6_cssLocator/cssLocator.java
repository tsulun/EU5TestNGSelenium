package com.cybertek.tests.day6_cssLocator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class cssLocator {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
    }
}
