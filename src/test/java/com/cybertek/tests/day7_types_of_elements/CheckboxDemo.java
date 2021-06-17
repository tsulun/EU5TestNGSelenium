package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxDemo {
    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        //locating checkboxes
        WebElement checkbox1 = driver.findElement(By.cssSelector("#box1"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("#box2"));

        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());//(ctrl + d duplicate the line)
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());

        //verify which one is selected
        Assert.assertFalse(checkbox1.isSelected(),"checkbox1 is not selected");
        Assert.assertTrue(checkbox2.isSelected(),"checkbox2 is selected");

        //how to check checkboxes
        checkbox1.click();
        //verify after click
        Assert.assertTrue(checkbox1.isSelected(),"checkbox1 is selected");
        //how to uncheck checkboxes
        checkbox2.click();
        //verify after click
        Assert.assertFalse(checkbox2.isSelected(),"checkbox1 is not selected");

        driver.quit();




    }
}
