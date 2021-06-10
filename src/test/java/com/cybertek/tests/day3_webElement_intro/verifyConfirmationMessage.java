package com.cybertek.tests.day3_webElement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement retriveinputbx = driver.findElement(By.name("email"));
        retriveinputbx.sendKeys("tugkan31@gmail.com");
        String name = retriveinputbx.getAttribute("value");
        if(name.equals("tugkan31@gmail.com")){
            System.out.println("TEST1 PASS");
        }
        else {
            System.out.println("TEST1 FAIL");
        }

        WebElement retrivePasswordbutton = driver.findElement(By.id("form_submit"));
        retrivePasswordbutton.click();

        WebElement con = driver.findElement(By.name("confirmation_message"));
        String message = con.getText();
        if(message.equals("Your e-mail's been sent!")){
            System.out.println("TEST2 PASS");
        }
        else {
            System.out.println("TEST2 FAIL");
        }

        driver.quit();

    }
}
