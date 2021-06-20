package com.cybertek.tests.day8_types_of_elements;

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

public class SelectDropdownTest {
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
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        //1-locate your dropdown just like any other web element with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));
        //2-create select object by passing that element as a constructer
        Select stateDropdown= new Select(dropdownElement);

        List<WebElement> options = stateDropdown.getOptions();
        System.out.println("options.size() = " + options.size());

        //verify that first selection is Select a state
        String expectedOption = "Select a State";
        Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(),expectedOption,"verify first option is Slect a state");

        //how to select smth from dropdown
        //1.select using visible text
        Thread.sleep(2000);
        expectedOption = "Virginia";

        stateDropdown.selectByVisibleText("Virginia");
        Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(),expectedOption,"verify virginia is selected");

        //2.select using index
        Thread.sleep(2000);
        expectedOption = "Wyoming";

        stateDropdown.selectByIndex(51);
        Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(),expectedOption,"verify wyoming is selected");

        //3.select using value
        Thread.sleep(2000);
        expectedOption = "Texas";

        stateDropdown.selectByValue("TX");
        Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(),expectedOption,"verify texas is selected");
    }
}
