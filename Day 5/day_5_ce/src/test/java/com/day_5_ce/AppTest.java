package com.day_5_ce;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException
    {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[3]/div/div/h4/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        driver.findElement(By.linkText("Cart")).click();
        Thread.sleep(5000);
        String title = driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[2]")).getText();
        String price = driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[3]")).getText();
        System.out.println(title + price);
    }
}
