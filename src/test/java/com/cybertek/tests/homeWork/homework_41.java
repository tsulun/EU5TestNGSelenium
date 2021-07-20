package com.cybertek.tests.homeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class homework_41 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void question_6() {
        driver.get("https://www.fakemail.net/");
        String email = driver.findElement(By.id("email")).getText();
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[.='Sign Up For Mailing List']")).click();
        //enter valid name
        driver.findElement(By.name("full_name")).sendKeys("ibrahim");
        //Enter email from the Step 2
        driver.findElement(By.name("email")).sendKeys(email);
        //Click Sign Up
        driver.findElement(By.name("wooden_spoon")).click();
        String Expected = "Thank you for signing up. Click the button below to return to the home page.";
        String Actual = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(Actual,Expected,"Verify the Thank you for signing up message is displayed");




    }
    @Test
    public void question_7(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        // click on file upload
        driver.findElement(By.xpath("//a[.='File Upload']")).click();
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
        //
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"File Uploaded!","verify the uploaded message is displayed");
        //getting file name from browser
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        //verify the file name
        Assert.assertEquals(actualFileName,"textfile.txt");
    }
    @Test
    public void question_8(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        // click on file upload
        driver.findElement(By.xpath("//a[.='Autocomplete']")).click();
        //Enter “United States of America” into country input box.
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        //click on submit
        driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
        //verift the expected message
        String expected = "You selected: United States of America";
        String actual = driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertEquals(actual,expected,"Verify that following message is displayed: “You selected: United States of America”");

    }



}
