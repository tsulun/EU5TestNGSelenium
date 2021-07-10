package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUploadTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/upload");
        //type should be file !!!
        //locating file button
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\tugka\\Desktop\\media_8d5_8d5452f3-fbd0-44fb-a0b5-e8c4f9df1ec1_image.png");
        driver.findElement(By.id("file-submit")).click();

        //getting file name from browser
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        //verify the file name
        Assert.assertEquals(actualFileName,"media_8d5_8d5452f3-fbd0-44fb-a0b5-e8c4f9df1ec1_image.png");

    }
    @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/upload");
        //creating dynamic way of the file path;
        //dynamic part
        String projectPath = System.getProperty("user.dir");
        //static part
        String filePath = "src/test/resources/textfile.txt";
        String fullPath = projectPath+"/"+filePath;
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys(fullPath);
        //clicking upload button
        driver.findElement(By.id("file-submit")).click();

        //getting file name from browser
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        //verify the file name
        Assert.assertEquals(actualFileName,"textfile.txt");

    }
}
