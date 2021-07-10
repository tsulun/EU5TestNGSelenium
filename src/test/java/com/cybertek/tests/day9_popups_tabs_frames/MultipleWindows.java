package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1500);
        // driver.quit();
    }
    @Test
    public void switchWindowsTest(){
        driver.get("http://practice.cybertekschool.com/windows");

        //get title
        System.out.println("title before new window -" + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("title after clicking -" + driver.getTitle());

        String currentWindow = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if(!windowHandle.equals(currentWindow)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        System.out.println("title after clicking -" + driver.getTitle());
        //loop through each window if there are many tabs
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            //whenever you title equals to your expected window title
            if(driver.getTitle().equals("New Window"));
            break;

        }
    }
}
