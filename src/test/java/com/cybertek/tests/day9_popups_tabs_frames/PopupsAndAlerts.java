package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {
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
    public void test1(){
        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=20f96");
        //
        driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();
        //click no button with txt
        driver.findElement(By.xpath("//button[.='No']")).click();
    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        //click "click for JS Alert Button"
        driver.findElement(By.xpath("//button[1]")).click();

        //switch to JS alert pop up
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //click for JS confirm
        driver.findElement(By.xpath("//button[2]")).click();
        alert.dismiss();

        //click for JS confirm
        driver.findElement(By.xpath("//button[3]")).click();
        alert.sendKeys("fenerbahce");
        alert.accept();


    }
}
