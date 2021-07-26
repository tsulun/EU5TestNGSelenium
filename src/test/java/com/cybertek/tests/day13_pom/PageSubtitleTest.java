package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test case
 * Open Chrome browser
 * Login as a Driver
 * Verify that page subtitle is Quick Launchpad
 * Go to Activities -> Calendar Events
 * verify that page subtitle is Calendar Events
 */
public class PageSubtitleTest extends TestBase {
    @Test
    public void test1(){
        LoginPage login = new LoginPage();
        login.loginAsDriver();
        String expected = "Quick Launchpad";
        DashboardPage dashboardPage = new DashboardPage();
        String actual= dashboardPage.getPageSubTitle();
        Assert.assertEquals(expected,actual,"verifying page title");
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        actual=calendarEventsPage.getPageSubTitle();
        Assert.assertEquals(actual,"Calendar Events", "verifying title");


    }
}
