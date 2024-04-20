package com.ms2;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
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

//import utils.EventHandler;

public class AppTest {
    private static final long PAGE_LOAD_TIME = 10;
    public static WebDriver driver;
    ExtentReports extent;
    XSSFWorkbook workbook;
    
    @BeforeTest
    public void TestInit() {
        extent = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\asus\\Documents\\College\\Selenium\\CC\\ms2\\report.html");
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
        // driver.get("https://www.1mg.com/");
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIME));
        // WebDriverListener listener = new EventHandler();
        // driver = new EventFiringDecorator<>(listener).decorate(driver);
        // return driver;
        // Local test
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.1mg.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIME));
        return driver;
    }

    @Test
    public void test1() throws InterruptedException, IOException , Exception{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        ExtentTest test1 = extent.createTest("Test 1");
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        driver.findElement(By.xpath("//*[@id='header']/div[4]/div[1]/ul/li[3]/a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/div[2]/div/button")).click();
        driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[1]/a")).click();
        
        String text=driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/span")).getText();
        if (text.equals("Please enter a valid 10 digit Mobile Number or Email ID")) {
            test1.log(Status.PASS, "Test 1 : Pass");
            File screenshot = ((ChromeDriver) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
            org.apache.commons.io.FileUtils.copyFile(screenshot, new File("test1.png"));
        } else {
            test1.log(Status.FAIL, "Test 1 : Fail");
        }
    }
    
    @Test
    public void test2() throws InterruptedException, IOException , Exception{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        ExtentTest test2 = extent.createTest("Test 2");
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        WebElement hover=driver.findElement(By.xpath("//*[@id='Diabetes__5']"));
        Actions action = new Actions(driver);
        action.moveToElement(hover).perform();
        // Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='header']/div[6]/ul/li[6]/div[2]/ul/li[3]/a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        // Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='category-container']/div[2]/div[1]/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/label[1]/span[2]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='category-container']/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[1]/div/a/div[3]/div[1]")).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        driver.findElement(By.xpath("//*[@id='container']/div/div/div[2]/div[4]/div[1]/div/div[2]/div[1]/div[2]/div[1]/span")).click();
        String text = driver.findElement(By.xpath("//*[@id='container']/div/div/div[2]/div[3]/div[1]/div[1]/h1")).getText();
        
        if (text.contains("Bjain")) {
            test2.log(Status.PASS, "Test 2 : Pass");
            File screenshot = ((ChromeDriver) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
            org.apache.commons.io.FileUtils.copyFile(screenshot, new File("test2.png"));
        } else {
            test2.log(Status.FAIL, "Test 2 : Fail");
        }
    }
    @Test
    public void test3() throws InterruptedException, IOException , Exception{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        ExtentTest test3 = extent.createTest("Test 3");
        FileInputStream fs = new FileInputStream("C:\\Users\\asus\\Documents\\College\\Selenium\\CC\\ms2\\ms2.xlsx");
        workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        XSSFRow row = sheet.getRow(0);
        String name = row.getCell(0).getStringCellValue();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='srchBarShwInfo']")).sendKeys(name);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='srchBarShwInfo-form']/span/div")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='category-container']/div/div[3]/div[2]/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div/div/a/div/div[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='container']/div/div/div[2]/div[2]/div/div/div[1]/div[1]/span[1]/a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='category-container']/div/div[3]/div[2]/div/div/div/div/div/span/div/div")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='header']/div[4]/div[2]/div/div[3]/div/div")).click();
        String text=driver.getCurrentUrl();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        if (text.contains("cart")) {
            test3.log(Status.PASS, "Test 3 : Pass");
            File screenshot = ((ChromeDriver) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
            org.apache.commons.io.FileUtils.copyFile(screenshot, new File("test3.png"));
        } else {
            test3.log(Status.FAIL, "Test 3 : Fail");
        }
    }
    @AfterMethod
    public void testClose() {
        driver.quit();
    }
    
    @AfterTest
    public void destTest() {
        extent.flush();
    }
}