package com.cybertek.tests.day7_testNg;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestNGAssertionsDemo {
    @Test
    public void test(){
        Assert.assertEquals("title","Title");
        Assert.assertEquals("url","url");
    }
}
