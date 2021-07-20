package com.cybertek.tests.homeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class homework_4 {
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
    public void question_1() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        // we dont need to scroll down it is gonna open autamatically
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.name("birthday")).sendKeys("123");
        String expected = "The date of birth is not valid";
        String actual = driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();
        Assert.assertEquals(actual,expected,"verifying error message appear on screen");
        System.out.println(driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).isDisplayed());

    }
    @Test
    public void question_2(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='C++']")).isDisplayed(),"verify c++ is displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Java']")).isDisplayed(),"verify java is displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='JavaScript']")).isDisplayed(),"verify javascript is displayed");
    }
    @Test
    public void question_3(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.cssSelector("input.form-control")).sendKeys("a");
        String expected = "first name must be more than 2 and less than 64 characters long";
        String actual = driver.findElement(By.xpath("//*[starts-with(text(),'first name must be')]")).getText();
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void question_4(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("a");
        String expected = "The last name must be more than 2 and less than 64 characters long";
        String actual = driver.findElement(By.xpath("//small[@data-bv-for='lastname' and contains(text(),'The')]")).getText();
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void question_5(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        // valid name
        driver.findElement(By.cssSelector("input.form-control")).sendKeys("Tugkan");
        //valid lastname
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("sulun");
        //valid username
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("tugkan35");
        //valid password
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("tugkan35");
        //valid phone
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("571-454-4698");
        //valid email
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("tugkan35@gmail.com");
        //gender selection
        driver.findElement(By.cssSelector("input[name='gender' ][value='male']")).click();
        //valid dob
        driver.findElement(By.name("birthday")).sendKeys("01/31/1993");
        //department selection
        WebElement department = driver.findElement(By.cssSelector("select[name='department' ]"));
        Select departmenDropDown = new Select(department);
        /*
                List<WebElement> options = departmenDropDown.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        */
        departmenDropDown.selectByValue("DE");
        //Jobtitle
        WebElement jobtitle = driver.findElement(By.cssSelector("select[name='job_title' ]"));
        Select jobtitleDropDown = new Select(jobtitle);
        jobtitleDropDown.selectByIndex(2);
        //programming language selection
        driver.findElement(By.xpath("//*[.='Java']")).click();
        //click on sign up
        driver.findElement(By.id("wooden_spoon")).click();

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.xpath("//*[starts-with(text(),'You')]")).getText();
        Assert.assertEquals(actual,expected,"verifying signing up successfully with valid credentials");


    }

}
