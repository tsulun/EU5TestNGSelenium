package com.cybertek.tests.day7_testNg;

import org.testng.annotations.*;

public class FirstTestNgTest {
    @BeforeClass
    public void setupClass(){
        System.out.println("BEFORE CLASS");
    }
    @Test
    public void test1(){
        System.out.println("My first test case");
    }
    @Test
    public void test2(){
        System.out.println("My second test case");
    }
    @Ignore
    public void test3(){
        System.out.println("My third test case");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("BEFORE METHOD");
        System.out.println("Webdriver, opening browser");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("AFTER METHOD");
        System.out.println("Closing Browser, Quit");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("AFTER CLASS");
        System.out.println("Some reporting here");
    }
}
