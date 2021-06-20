package com.cybertek.tests.day8_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ListOfElements {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //save our webelements inside the list (arraylist interface)
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("buttons.size() = " + buttons.size());

        Assert.assertEquals(buttons.size(),6,"verify buttons size");

        // iter keyword is gonna give you list that u last create list
        for (WebElement button : buttons) {
            System.out.println("button.isDisplayed() = " + button.isDisplayed());
            Assert.assertTrue(button.isDisplayed(),"verify the buttons are showed up");
        }

        //click second button
        buttons.get(1).click();
        //after define driver.findelements just hit alt + enter then resunt will be like below
        List<WebElement> elements = driver.findElements(By.tagName("kdfjsk"));

    }

}
