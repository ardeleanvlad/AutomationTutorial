package tests;

import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WindowsTest extends SharedData {



    @Test
    public void TestMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);


        WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickElement(alertsMenu);

        WebElement alertsSubMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementHelper.clickElement(alertsSubMenu);

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        elementHelper.clickElement(newTabElement);
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
        elementHelper.clickElement(newWindowElement);
        System.out.println(driver.getCurrentUrl());

        List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsList.get(1));

        System.out.println(driver.getCurrentUrl());

        driver.close();
        driver.switchTo().window(windowsList.get(0));
        System.out.println(driver.getCurrentUrl());
    }
}
