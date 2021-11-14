package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class CrmTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//ul[@class=\"nav nav-multilevel main-menu\"]/li/a/span[.=\"Расходы\"]"))).build().perform();
        driver.findElement(By.xpath("//span[.=\"Заявки на расходы\"]")).click();


        Thread.sleep(5000);

        driver.quit();

    }

    static void login(WebDriver driver) {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();




    }
}
