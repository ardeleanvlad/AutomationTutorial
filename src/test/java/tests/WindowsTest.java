package tests;

import helperMethods.ElementHelper;
import helperMethods.TabHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class WindowsTest extends SharedData {



    @Test
    public void TestMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        TabHelper tabHelper = new TabHelper(driver);


        WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickElement(alertsMenu);

        WebElement alertsSubMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementHelper.clickElement(alertsSubMenu);

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        elementHelper.clickElement(newTabElement);
        System.out.println(driver.getCurrentUrl());

        tabHelper.switchToSpecificTab(1);

        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);

        //din cauza reclamei fortam site-ul sa acceseze un url specific
        driver.navigate().to("https://demoqa.com/browser-windows");

        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        elementHelper.clickElement(newWindowElement);


       tabHelper.switchToSpecificTab(1);
       tabHelper.closeCurrentTab();
       tabHelper.switchToSpecificTab(0);
    }
}
