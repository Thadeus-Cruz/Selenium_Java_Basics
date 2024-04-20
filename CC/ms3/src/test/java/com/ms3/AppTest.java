package com.ms3;
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
// import utils.EventHandler;

public class AppTest {
    private static final long PAGE_LOAD_TIME = 10;
    public static WebDriver driver;
    ExtentReports extent;
    XSSFWorkbook workbook;
    
    @BeforeTest
    public void TestInit() {
        extent = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter("/home/coder/project/workspace/Project/report.html");
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
        // driver.get("https://www.jiomart.com/");
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIME));
        // WebDriverListener listener = new EventHandler();
        // driver = new EventFiringDecorator<>(listener).decorate(driver);
        // return driver;
        // Local test
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.jiomart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIME));
        return driver;
    }

    @Test
    public void test1() throws InterruptedException, IOException , Exception{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        ExtentTest test1 = extent.createTest("Test 1");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        WebElement hover=driver.findElement(By.xpath("//*[@id='nav_link_8583']"));
        Actions action = new Actions(driver);
        action.moveToElement(hover).perform();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        hover=driver.findElement(By.xpath("//*[@id='nav_link_8924']"));
        action = new Actions(driver);
        action.moveToElement(hover).perform();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        driver.findElement(By.xpath("//*[@id='top_menu_cat']/span")).click();
        driver.findElement(By.xpath("//*[@id='left_tab']/div[8]")).click();
        driver.findElement(By.xpath("//*[@id='tab_8584']/div/div[2]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id='sub-category-9242']/a[2]/div[1]/div")).click();
        driver.findElement(By.xpath("//*[@id='category_filter']/div/ul/li[1]/div/label/span")).click();
        driver.findElement(By.xpath("//*[@id='dropdownMenuButton']/button")).click();
        driver.findElement(By.xpath("//*[@id='sort_container']/li[4]/div/div/label/div")).click();
        driver.findElement(By.xpath("//*[@id='603714488']/div[2]/div[2]/div/div[1]")).click();
        String text=driver.findElement(By.xpath("//*[@id='pdp_product_name']")).getText();
        if (text.contains("Strolley Duffle Bag")) {
            test1.log(Status.PASS, "Test 1 : Pass");
        } else {
            test1.log(Status.FAIL, "Test 1 : Fail");
        }
        File screenshot = ((ChromeDriver) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
        org.apache.commons.io.FileUtils.copyFile(screenshot, new File("test1.png"));
    }
    
    @Test
    public void test2() throws InterruptedException, IOException , Exception{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        ExtentTest test2 = extent.createTest("Test 2");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/footer/div[1]/div/div[1]/div[1]/div[7]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='plp-category-desk']/div[6]/div/div[1]/div[2]/div/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='category-7493']/div/div/div/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='600939327']/div[2]/div[2]/div/div[1]")).click();
        js.executeScript("window.scrollTo(0, 100)", "");
        driver.findElement(By.xpath("/html/body/main/section/section[2]/div/div/div[1]/div/div[3]/div/button")).click();
        String text = driver.findElement(By.xpath("//*[@id='pdp_product_name']")).getText();
        if (text.contains("Dates")) {
            test2.log(Status.PASS, "Test 2 : Pass");
        } else {
            test2.log(Status.FAIL, "Test 2 : Fail");
        }
        File screenshot = ((ChromeDriver) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
        org.apache.commons.io.FileUtils.copyFile(screenshot, new File("test2.png"));
    }


    @Test
    public void test3() throws InterruptedException, IOException , Exception{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        ExtentTest test3 = extent.createTest("Test 3");
        FileInputStream fs = new FileInputStream("/home/coder/project/workspace/ms3.xlsx");
        workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        XSSFRow row = sheet.getRow(0);
        String name = row.getCell(0).getStringCellValue();
        driver.findElement(By.xpath("//*[@id='autocomplete-0-input']")).sendKeys(name, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='490997893']/div[2]/div[3]/div/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/header/section[1]/div")).click();
        driver.navigate().to("https://www.jiomart.com/checkout/cart");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='login-container']/jds-container[4]/section/div/jds-button/button")).click();
        Thread.sleep(1000);
        String text=driver.findElement(By.xpath("//*[@id='sign-heading']")).getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        if (text.contains("Sign in to JioMart")) {
            test3.log(Status.PASS, "Test 3 : Pass");
        } else {
            test3.log(Status.FAIL, "Test 3 : Fail");
        }
        File screenshot = ((ChromeDriver) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
        org.apache.commons.io.FileUtils.copyFile(screenshot, new File("test3.png"));
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