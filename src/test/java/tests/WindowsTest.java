package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowsTest {

    public WebDriver driver;

    @Test
    public void TestMethod() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");

        driver.manage().window().maximize();

        WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertsMenu.click();

        WebElement alertsSubMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        alertsSubMenu.click();

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        newTabElement.click();
        System.out.println(driver.getCurrentUrl());

        List<String> tabsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(1));
        System.out.println(driver.getCurrentUrl());

        driver.close();
        driver.switchTo().window(tabsList.get(0));
        System.out.println(driver.getCurrentUrl());

        //din cauza reclamei fortam site-ul sa acceseze un url specific
        driver.navigate().to("https://demoqa.com/browser-windows");

        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        newWindowElement.click();
        System.out.println(driver.getCurrentUrl());

        List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsList.get(1));

        System.out.println(driver.getCurrentUrl());

        driver.close();
        driver.switchTo().window(windowsList.get(0));
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }
}
