package com.cybertek.tests.day2_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class NavigatinDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://google.co.uk");

        Thread.sleep(3000);

        driver.navigate().to("https://cybertekschool.com");

        Thread.sleep(3000);
        driver.navigate().back();

        Thread.sleep(3000);
        driver.navigate().refresh();

        driver.navigate().to("https://practice.cybertekschool.com");
        String title =driver.getTitle();
        System.out.println("title = " + title);


    }
}
