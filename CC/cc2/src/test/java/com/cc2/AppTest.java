package com.cc2;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// import utils.EventHandler;

public class AppTest {
    private static final long PAGE_LOAD_TIME = 10;
    public static WebDriver driver;
    ExtentReports extent;
    XSSFWorkbook workbook;
    
    @BeforeTest
    public void TestInit() {
        extent = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\asus\\Documents\\College\\Selenium\\CC\\cc2\\report\\report.html");
            extent.attachReporter(reporter);
            reporter.config().setTheme(Theme.STANDARD);
            reporter.config().setDocumentTitle("Test Report");
        }
    @BeforeMethod
    public WebDriver beforeMethod() throws Exception {
        // Portal
        // ChromeOptions chromeOptions = new ChromeOptions();
        // driver = new RemoteWebDriver(new URL("http://localhost:4444/"),
        // chromeOptions);
        // driver.manage().window().maximize();
        // driver.get("https://www.barnesandnoble.com/");
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIME));
        // WebDriverListener listener = new EventHandler();
        // driver = new EventFiringDecorator<>(listener).decorate(driver);
        // return driver;
        // Local test
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.barnesandnoble.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIME));
        return driver;
    }

    @Test
    public void test1() throws InterruptedException, IOException , Exception{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        ExtentTest test1 = extent.createTest("Test 1");
        FileInputStream fs = new FileInputStream("C:\\Users\\asus\\Documents\\College\\Selenium\\CC\\cc2\\Book1.xlsx");
        workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        XSSFRow row = sheet.getRow(0);
        String name = row.getCell(0).getCellType() == Cell.CELL_TYPE_NUMERIC ? String.valueOf(row.getCell(0).getNumericCellValue()) : row.getCell(0).getStringCellValue();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[1]/div/a[2]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[2]/div/input[1]")).sendKeys(name);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/span/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(10000);
        String text=driver.findElement(By.xpath("//*[@id='searchGrid']/div/section[1]/section[1]/div/div[1]/div[1]/h1/span")).getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        if (text.equals(name)) {
            test1.log(Status.PASS, "Test 1 : Pass");
        } else {
            test1.log(Status.FAIL, "Test 1 : Fail");
        }
    }
    @Test
    public void test2() throws InterruptedException, IOException , Exception{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        ExtentTest test2 = extent.createTest("Test 2");
        WebElement hover=driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/div/ul/li[5]"));
        Actions action = new Actions(driver);
        action.moveToElement(hover).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/div/ul/li[5]/div/div/div[1]/div/div[2]/div[1]/dd/a[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='product-shelf-2940178047613']/div/div[2]/div[1]/h3/a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='commerce-zone']/div[2]/ul/li[2]/div/div/label/span")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/section/div[2]/div/div[3]/div[2]/div[3]/div[1]/div[1]/form/input[5]")).click();
        Thread.sleep(3000);
        String text=driver.findElement(By.xpath("//*[@id='add-to-bag-main']/div[1]")).getText();
        if (text.equals("Item Successfully Added To Your Cart")) {
            test2.log(Status.PASS, "Test 2 : Pass");
        } else {
            test2.log(Status.FAIL, "Test 2 : Fail");
        }
    }

    @Test
    public void test3() throws InterruptedException, IOException , Exception{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        ExtentTest test3 = extent.createTest("Test 3");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='onetrust-close-btn-container']/button")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,1000)", "");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/main/div[3]/div[3]/div/section/div/div/div/div/div/a[1]")).click();
        js.executeScript("window.scroll(0,800)", "");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='rewards-modal-link']")).click();
        Thread.sleep(5000);
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[7]/div/iframe")));
        String text = driver.findElement(By.xpath("/html/body/div[2]/div")).getText();

        if (text.equals("Sign in or Create an Account")) {
            test3.log(Status.PASS, "Test 3 : Pass");
        } else {
            test3.log(Status.FAIL, "Test 3 : Fail");
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
