package com.day_4_1_basics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException
    {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.shoppersstop.com/");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.className("user-icon")).click();
    }
}
