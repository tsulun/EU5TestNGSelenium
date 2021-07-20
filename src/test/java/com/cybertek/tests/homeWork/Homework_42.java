package com.cybertek.tests.homeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Homework_42 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        driver.quit();

    }
    @DataProvider(name = "StatusCodes")
    public Object[][] codeData() {
        return new Object[][] {
                { "This page returned a 200 status code.", new Integer(200) },
                { "This page returned a 301 status code.", new Integer(301)},
                { "This page returned a 404 status code.", new Integer(404)},
                { "This page returned a 500 status code.", new Integer(500)},
        };
    }


    @Test(dataProvider = "StatusCodes")
    public void question_8(String exp,Integer i) {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        // click on file upload
        driver.findElement(By.xpath("//a[.='Status Codes']")).click();
        //click on the links
        driver.findElement(By.xpath("//a[.='" + i + "']")).click();
        //getting actual message
        String actual = driver.findElement(By.tagName("p")).getText();
        actual=actual.substring(0,actual.indexOf(".")+1);
        String expected = exp;
        Assert.assertEquals(actual, expected);
    }


}
