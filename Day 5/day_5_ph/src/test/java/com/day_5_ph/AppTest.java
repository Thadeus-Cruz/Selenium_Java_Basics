package com.day_5_ph;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{

    @Test
    public void shouldAnswerWithTrue() throws IOException
    {
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.get("https://magento.softwaretestingboard.com/"); 
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
       driver.findElement(By.xpath("//*[@id='search']")).click();
       driver.findElement(By.xpath("//*[@id='search']")).sendKeys("Shoes");;
       driver.findElement(By.xpath("//*[@id='search_mini_form']/div[2]/button")).click();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
       WebElement searchResultsText = driver.findElement(By.xpath("//*[@id='maincontent']/div[1]/h1"));
       if (searchResultsText.isDisplayed() && searchResultsText.getText().contains("Search results for: 'Shoes'")) {
            System.out.println("Search results for 'Shoes' is displayed.");
        } else {
            System.out.println("Search results for 'Shoes' is not displayed.");
        }

        // Capture a screenshot
        File screenshot = ((ChromeDriver) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
        org.apache.commons.io.FileUtils.copyFile(screenshot, new File("search_results.png"));

        WebElement menOption = driver.findElement(By.xpath("//a[text()='Men']"));
        WebElement topsOption = driver.findElement(By.xpath("//a[text()='Tops']"));
        WebElement hoodiesOption = driver.findElement(By.xpath("//a[text()='Hoodies & Sweatshirts']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(menOption).perform();

        try {
            Thread.sleep(1000); // Wait for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.moveToElement(topsOption).perform();

        try {
            Thread.sleep(1000); // Wait for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.navigate().to("https://magento.softwaretestingboard.com/");


    }
}
