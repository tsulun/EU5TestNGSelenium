package com.cybertek.tests.day7_testNg;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestNGAssertionsDemo {

    @Test
    public void test(){
        Assert.assertEquals("title","Title");
        Assert.assertEquals("url","url");
    }

    @Test
    public void test2(){
        String mail="ali_eli23gmail.com";
        Assert.assertTrue(mail.contains("@"),"verify email contains @");
    }
    @Test
    public void test3(){
        Assert.assertNotEquals("one","krasaf");
    }
}
