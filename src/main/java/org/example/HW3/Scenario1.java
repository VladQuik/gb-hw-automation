package org.example.HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Scenario1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a/span[text()='Проекты']"))).build().perform();
        driver.findElement(By.xpath("//span[contains(text(), 'Мои проекты')]")).click();
        driver.findElement(By.xpath("//div/a[text()='Создать проект']")).click();
        driver.findElement(By.name("crm_project[name]")).sendKeys("2342342234");
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/ancestor::a")).click();
        driver.findElement(By.xpath("//div[contains(@id,'select2-drop')]/div/input")).sendKeys("Bins-Haley");
        driver.findElement(By.xpath("//ul/li[1]/div/span[text()='Bins-Haley']")).click();
        driver.findElement(By.xpath("//div[contains(attribute::id,'crm_project_contact')]/a")).click();

        Select selectBusinessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        selectBusinessUnit.selectByVisibleText("Research & Development");
        Select crmProjectCurator = new Select(driver.findElement(By.name("crm_project[curator]")));
        crmProjectCurator.selectByVisibleText("Гумённый Пётр");
        Select crmProjectRp = new Select(driver.findElement(By.name("crm_project[rp]")));
        crmProjectRp.selectByVisibleText("Андреев Сергей");
        Select crmProjectAdministrator = new Select(driver.findElement(By.name("crm_project[administrator]")));
        crmProjectAdministrator.selectByVisibleText("Горячев Алексей");
        Select crmProjectManager = new Select(driver.findElement(By.name("crm_project[manager]")));
        crmProjectManager.selectByVisibleText("Митрофанов Никита");

        driver.findElement(By.xpath("//div[contains(@id, \"s2id_crm_project_contactMain\")]/a")).click();
        driver.findElement(By.xpath("//div[contains(@id,'select2-drop')]/div/input")).sendKeys("Potter Harry");
        driver.findElement(By.xpath("//ul/li[1]/div/span[text()='Potter Harry']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
        Thread.sleep(10000);
        driver.quit();
    }

    static void login(WebDriver driver) {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

    }
}
