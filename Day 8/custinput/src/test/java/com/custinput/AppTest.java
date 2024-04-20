package com.custinput;


import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest 
{
    WebDriver driver=null;
    @BeforeMethod
    public void bMethod()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://dbankdemo.com/bank/login");
    }
    @Test
    public void shouldAnswerWithTrue()throws InterruptedException, IOException
    {
        this.driver.manage().window().maximize();
        // driver.findElement(By.xpath("//*[@id='username']")).sendKeys("S@gmail.com");
        // driver.findElement(By.xpath("//*[@id='password']")).sendKeys("P@ssword12");
        
        FileInputStream fs = new FileInputStream("../custinput/logindata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        
        XSSFRow row = sheet.getRow(1);
        String username = row.getCell(0).getStringCellValue();
        String password = row.getCell(1).getStringCellValue();
        
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);

        driver.findElement(By.xpath("//*[@id='submit']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(driver.getCurrentUrl().contains("home"));
    }
    @AfterMethod
    public void aMethod(){
        driver.close();
    }
}
