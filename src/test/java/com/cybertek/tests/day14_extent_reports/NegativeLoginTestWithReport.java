package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {
    @Test
    public void wrongPasswordTest() {
        extentLogger = report.createTest("wrong password test");

        LoginPage loginPage=new LoginPage();
        loginPage.usernameinput.sendKeys("user1");
        extentLogger.info("enter username ; user1");
        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("enter password ; somepassword");
        loginPage.loginBtn.click();
        extentLogger.info("click login button");

/*
    driver.findElement(By.id("prependedInput")).sendKeys("user1");
    driver.findElement(By.id("prependedInput2")).sendKeys("somepassword");
    driver.findElement(By.id("_submit")).click();
*/
        extentLogger.info("verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        //we re not gonna see below line if our assertion fails
        extentLogger.pass("wrong password test is passed");
    }
    @Test
    public void wrongUsernameTest(){
        extentLogger = report.createTest("wrong username test");
        LoginPage loginPage=new LoginPage();

        loginPage.usernameinput.sendKeys("someusername");
        extentLogger.info("enter username ; someusername");

        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("enter username ; UserUser123");

        loginPage.loginBtn.click();
        extentLogger.info("click login button");

        extentLogger.info("verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login1");
        extentLogger.pass("wrong username test is passed");
    }

}
