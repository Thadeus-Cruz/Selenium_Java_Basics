package com.google;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 String email="22ads.thadeuscruzgovindapillai@skct.edu.in";
 String password="Cruz@12345";
 * Unit test for simple App.
 */
public class AppTest 
{
    
    @Test
    public void Test1() throws InterruptedException
    {
        String email="22aiml.infantlidwina.r@skct.edu.in";
        String password="skct12345@infantlidwinar.";
        // String code="import java.io.*; import java.util.Scanner;";
        // String code1="public class Main {public static void main(String[] args) {try {PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter(\"sample.txt\")));String str = \"Hi hello!, I am \n\";fout.print(str);fout.close(); Scanner scanner = new Scanner(System.in); String s = scanner.nextLine(); scanner.close(); PrintWriter of = new PrintWriter(new BufferedWriter(new FileWriter(\"sample.txt\", true))); of.print(s); System.out.println(\"Data appended successfully\"); of.close(); BufferedReader f = new BufferedReader(new FileReader(\"sample.txt\")); String word; while ((word = f.readLine()) != null) { System.out.print(word + \" \"); } f.close(); } catch (IOException e) { System.out.println(\"No such file found\"); } } }";
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("about:config");
        Thread.sleep(2000);
        driver.findElement(By.id("warningButton")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("about-config-search")).sendKeys("clipboardevent");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/table/tr[1]/td[2]/button")).click();
        Thread.sleep(2000);
        driver.get("https://skct892.examly.io");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.id("email")).sendKeys(email);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".t-bg-primary")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".t-bg-primary")).click();
        Thread.sleep(10000);
        driver.get("https://skct892.examly.io/mycourses/details?id=752bfffc-2a4e-414f-85f8-e3c60ef0ff7c&type=mypractices");
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(7000);
        List<WebElement> elements = driver.findElements(By.className("caretPos"));
        elements.get(1).click();
        elements.clear();
        driver.findElement(By.xpath("//*[@id='pannel18']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("testButtonsID")).click();
        Thread.sleep(10000);
        // Get the set of window handles
        Set<String> windowHandles = driver.getWindowHandles();
        String newWindow = windowHandles.toArray(new String[windowHandles.size()])[windowHandles.size() - 1];
        driver.switchTo().window(newWindow);
        Thread.sleep(5000);
        // driver.findElement(By.id("tt-start-accept")).click();
        driver.findElement(By.id("tt-start-confirm")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("tt-start-accept")).click();
        driver.manage().window().fullscreen();
        Thread.sleep(40000);
        driver.findElement(By.id("tt-playground-alert-accept")).click();
        Thread.sleep(60000);
        //driver.findElement(By.xpath("/html/body/app-root/div/div/div/test-taking/testtaking-playground/div/div[4]/resize-divider/div/div[3]/content-right/div/div[2]/testtaking-answer/div/div/div/programming-answer/div/div[3]/div[2]/div[1]/textarea")).sendKeys(code, Keys.ENTER,code1);
        Thread.sleep(120000);
        for(int i=0;i<6;i++)
        {
            driver.findElement(By.xpath("//*[@id=\'programme-compile\']")).click();
            Thread.sleep(30000);
        }
        for(int i=0;i<2;i++)
        {
            driver.findElement(By.xpath("//*[@id=\'tt-footer-submit-answer\']")).click();
            Thread.sleep(30000);
        }
        driver.findElement(By.xpath("//*[@id=\'tt-header-submit\']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\'name\']")).sendKeys("END");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"undefinedYes1\"]")).click();
        Thread.sleep(10000);
        driver.quit();
        };

}

