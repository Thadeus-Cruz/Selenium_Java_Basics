package com.formreport;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.poi.ss.usermodel.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {
    WebDriver driver;
    ExtentReports extent;
    XSSFWorkbook workbook;
    
    @BeforeTest
    public void TestInit() {
        extent = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\asus\\Documents\\College\\Selenium\\Day 9\\formreport\\report\\report.html");
            extent.attachReporter(reporter);
            reporter.config().setTheme(Theme.STANDARD);
            reporter.config().setDocumentTitle("Test Report");
        }
        
        @BeforeMethod
        public void testSetup() throws Exception {
            
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://max-neo-selenium.netlify.app/");
            driver.manage().window().fullscreen();
            FileInputStream fs = new FileInputStream("C:\\Users\\asus\\Documents\\College\\Selenium\\Day 9\\formreport\\logindata.xlsx");
            workbook = new XSSFWorkbook(fs);
        }
        @Test(priority = 1)
        public void Test1() throws IOException, InterruptedException {
            
        ExtentTest test1 = extent.createTest("Test 1");
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        XSSFRow row = sheet.getRow(1);
        String name = row.getCell(0).getCellType() == Cell.CELL_TYPE_NUMERIC ? String.valueOf(row.getCell(0).getNumericCellValue()) : row.getCell(0).getStringCellValue();
        String email = row.getCell(1).getCellType() == Cell.CELL_TYPE_NUMERIC ? String.valueOf(row.getCell(1).getNumericCellValue()) : row.getCell(1).getStringCellValue();
        String date = row.getCell(2).getCellType() == Cell.CELL_TYPE_NUMERIC ? String.valueOf(row.getCell(2).getNumericCellValue()) : row.getCell(2).getStringCellValue();
        String roll = row.getCell(3).getCellType() == Cell.CELL_TYPE_NUMERIC ? String.valueOf(row.getCell(3).getNumericCellValue()) : row.getCell(3).getStringCellValue();
        String username = row.getCell(4).getCellType() == Cell.CELL_TYPE_NUMERIC ? String.valueOf(row.getCell(4).getNumericCellValue()) : row.getCell(4).getStringCellValue();
        String password = row.getCell(5).getCellType() == Cell.CELL_TYPE_NUMERIC ? String.valueOf(row.getCell(5).getNumericCellValue()) : row.getCell(5).getStringCellValue();
        
        driver.findElement(By.xpath("//*[@id='root']/div[3]/div/a[1]/button")).click();
        driver.findElement(By.xpath("//*[@id='root']/div[2]/button[4]")).click();
        driver.findElement(By.xpath("//*[@id='root']/div[1]/div/div/div/div/div/form/span[1]/div[1]/input[1]")).sendKeys(name);
        driver.findElement(By.xpath("//*[@id='root']/div[1]/div/div/div/div/div/form/span[1]/div[1]/input[2]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id='root']/div[1]/div/div/div/div/div/form/span[1]/div[1]/input[3]")).sendKeys(date);
        driver.findElement(By.xpath("//*[@id='root']/div[1]/div/div/div/div/div/form/span[1]/div[1]/input[4]")).sendKeys(roll);
        driver.findElement(By.xpath("//*[@id='root']/div[1]/div/div/div/div/div/form/span[1]/div[2]/select[1]")).click();
        driver.findElement(By.xpath("//*[@id='root']/div[1]/div/div/div/div/div/form/span[1]/div[2]/select[1]/option[2]")).click();
        driver.findElement(By.xpath("//*[@id='root']/div[1]/div/div/div/div/div/form/span[1]/div[2]/select[1]")).click();
        driver.findElement(By.xpath("//*[@id='root']/div[1]/div/div/div/div/div/form/span[1]/div[2]/select[2]/option[11]")).click();
        driver.findElement(By.xpath("//*[@id='root']/div[1]/div/div/div/div/div/form/span[1]/div[2]/input[1]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='root']/div[1]/div/div/div/div/div/form/span[1]/div[2]/input[2]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='male']")).click();
        driver.findElement(By.xpath("//*[@id='root']/div[1]/div/div/div/div/div/form/span[2]/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='root']/div[2]/button[1]")).click();
        Thread.sleep(1000);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        if (driver.getPageSource().contains(name)) {
            test1.log(Status.PASS, "Test 1 : Pass");
        } else {
            test1.log(Status.FAIL, "Test 1 : Fail");
        }
    }
    
    @Test(priority = 3)
    public void Test2() throws IOException, InterruptedException {
        ExtentTest test1 = extent.createTest("Test 2");
        XSSFSheet sheet = workbook.getSheet("Sheet2");
        XSSFRow row = sheet.getRow(1);
        String username = row.getCell(0).getStringCellValue();
        String password = row.getCell(1).getStringCellValue();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='root']/div[3]/div/a[1]/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/button[3]")).click();
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.findElement(By.xpath("//*[@id='root']/div/div[1]/button[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        if (driver.getPageSource().contains("Welcome to the Dashboard")) {
            test1.log(Status.PASS, "Test 2 : Pass");
        } else {
            test1.log(Status.FAIL, "Test 2 : Fail");
        }
    }

    @Test(priority = 2)
    public void Test3() throws IOException, InterruptedException {
        ExtentTest test1 = extent.createTest("Test 3");
        XSSFSheet sheet = workbook.getSheet("Sheet3");
        XSSFRow row = sheet.getRow(1);
        String username = row.getCell(0).getStringCellValue();
        String password = row.getCell(1).getStringCellValue();
        String keyword = row.getCell(2).getStringCellValue();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='root']/div[3]/div/a[1]/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/button[3]")).click();
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.findElement(By.xpath("//*[@id='root']/div/div[1]/button[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        if (driver.getPageSource().contains(keyword)) {
            test1.log(Status.PASS, "Test 3 : Pass");
        } else {
            test1.log(Status.FAIL, "Test 3 : Fail");
        }
    }

    @AfterMethod
    public void testClose() {
        driver.close();
    }

    @AfterTest
    public void destTest() {
        extent.flush();
    }
}
