package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xPathLocator {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://www.amazon.co.uk/");

        WebElement button1 = driver.findElement(By.xpath("//*[@type='text']"));
        button1.sendKeys("selenium");

        WebElement button2 = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        button2.click();

        WebElement searchResult = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        if (searchResult.getText().substring(searchResult.getText().indexOf("of ")+3,searchResult.getText().indexOf(" results for")).equals("223"))
            System.out.println("pass");
        else{
            System.out.println(searchResult.getText().substring(searchResult.getText().indexOf("of ")+3, searchResult.getText().indexOf(" results for")));
        }

    }
}
