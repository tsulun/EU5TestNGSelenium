package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttiributeTest {
    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.navigate().to("http://practice.cybertekschool.com/radio_buttons");

        //locating radio buttons
        WebElement blueRadioBtn = driver.findElement(By.xpath("//input[@id=\"blue\"]"));

        //since checked attribute does not keep any value, it will return ture or false based on the condition
        System.out.println(blueRadioBtn.getAttribute("checked"));

        //trying to get attiribute that not exist return null
        System.out.println(blueRadioBtn.getAttribute("href"));

        //full html of web elements as a string
        blueRadioBtn.getAttribute("outerHTML") ;

        //by innerHTML also you can get text as a third way gettext(),getAttribute(value),getAttribute(outer) with manupulation
        blueRadioBtn.getAttribute("innerHTML") ;



    }
}
