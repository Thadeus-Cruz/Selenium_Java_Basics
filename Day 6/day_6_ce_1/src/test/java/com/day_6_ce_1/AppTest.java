package com.day_6_ce_1;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.moneycontrol.com/");
        Thread.sleep(15000);
        driver.findElement(By.xpath("//*[@id='search_str']")).click();
        driver.findElement(By.xpath("//*[@id='search_str']")).sendKeys("Reliance Industries");
        driver.findElement(By.xpath("//*[@id='autosuggestlist']/ul/li[1]/a")).click();
        Thread.sleep(5000);

    }
}
