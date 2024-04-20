package com.forms;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://max-neo-selenium.netlify.app/");
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[1]/form/span/input[1]")).sendKeys("Thadeus Cruz Govindapillai");
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[1]/form/span/input[2]")).sendKeys("727822tuad057@skct.edu.in");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/form/span/button")).click();
        Thread.sleep(3000);
    }

}
