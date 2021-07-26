package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginAsDriver(){
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.usernameinput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }
    @Test
    public void loginAsDriver2(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
    }

    @Test
    public void loginAsStoreManager(){
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.login(username,password);
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }
    @Test
    public void loginAsStoreManager2(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsAStoreManager();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }


}
