package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExamples {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables ");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void test1() {
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());
        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));
    }

    @Test
    public void test2() {
        // how many columns we have
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id=\"table1\"]//th"));
        System.out.println(columns.size());
        for (WebElement element : columns) {
            System.out.println(element.getText());
        }
        //number of rows (approach1)
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id=\"table1\"]//tr"));
        System.out.println(rows.size());
        //approach2(without header)
        List<WebElement> rows2 = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr"));
        System.out.println(rows2.size());

    }

    @Test //get row
    public void test3() {
        //print he second row information
        System.out.println(driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[2]")).getText());
        //print the specific rows
        List<WebElement> secondRowData = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr[2]/td"));
        WebElement sec2[] = new WebElement[secondRowData.size()];
        secondRowData.toArray(sec2);
        for (int i = 0; i < sec2.length - 1; i++) {
            System.out.print(sec2[i].getText() + " ");

        }
    }

    @Test //get all cell in one row
    public void test4() {
        List<WebElement> allCellsInOneRow = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr[3]/td"));
        for (WebElement element : allCellsInOneRow) {
            System.out.println(element.getText());
        }
        //get a single line
        System.out.println(driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[3]/td[5]")).getText());
    }

    @Test
    public void printAllCellByIndex() {
        int rowNumber = getNumberOfRows();
        int colNumber = getNumberOfColumns();
        System.out.println("rowNumber = " + rowNumber);
        System.out.println("colNumber = " + colNumber);
        for (int i = 1; i <= rowNumber; i++) {
            for (int j = 1; j <= colNumber; j++) {
                System.out.print(driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[" + i + "]/td[" + j + "]")).getText() + " ");

            }
            System.out.println("");
        }

    }

    @Test
    public void getCellInRelationToAnotherCellInSameRow() {
        String firstname = "John";
        //find the element with text() first then move the parent(..) then point out the cell which is wanted with indexing
        String xpath="//table[@id=\"table1\"]//td[.='"+firstname+"']/../td[3]";
        WebElement email=driver.findElement(By.xpath(xpath));
        System.out.println("email.getText() = " + email.getText());


    }

    private int getNumberOfColumns() {
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id=\"table1\"]//th"));
        return columns.size();
    }

    private int getNumberOfRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr"));
        return rows.size();
    }
}

