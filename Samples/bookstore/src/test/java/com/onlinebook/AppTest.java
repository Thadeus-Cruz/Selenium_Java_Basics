package com.onlinebook;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod()
    {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
    }
    @AfterMethod
    public void afterMethod()
    {
        driver.close();
    }
    @AfterTest
    public void Aftest()
    {
        driver.quit();
    }
    @Test(priority = 1)
    public void Test1()
    {
        driver.get("https://www.barnesandnoble.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[1]/div/a[2]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[2]/div/input[1]")).sendKeys("Chetan Bhagat");
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/span/button")).click();
        String text=driver.findElement(By.xpath("//*[@id='searchGrid']/div/section[1]/section[1]/div/div[1]/div[1]/h1/span")).getText();
        if(text.equals("Chetan Bhagat"))
        {
            System.out.println("text is correct");
        }
        else
        {
            System.out.println("text is not correct");
        }
    }
    
    @Test(priority = 2)
    public void Test2() throws InterruptedException
    {
        driver.get("https://www.barnesandnoble.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
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
        // String text=driver.findElement(By.xpath("//*[@id='add-to-bag-main']/div[1]")).getText();
        // if(text.equals("Item Successfully Added To Your Cart"))
        // {
        //     System.out.println("text is correct");
        // }
        // else
        // {
        //     System.out.println("text is not correct");
        // }
    }
    @Test(priority = 3)
    public void Test3() throws InterruptedException
    {
        driver.get("https://www.barnesandnoble.com/");
        driver.manage().window().maximize();
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
        if(text.equals("Sign in or Create an Account"))
        {
            System.out.println("text is correct");
        }
        else
        {
            System.out.println("text is not correct");
        }
    }

}
