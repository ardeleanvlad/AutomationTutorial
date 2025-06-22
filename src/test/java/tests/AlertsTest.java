package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest {
   public WebDriver driver;

   @Test
    public void AlertsTestMethod(){
       driver = new ChromeDriver();

       driver.get("https://demoqa.com/");

       driver.manage().window().maximize();

       //wait implicit
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
       alertsMenu.click();

       WebElement alertsElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
       alertsElement.click();

       WebElement alertOkbuttonElement = driver.findElement(By.id("alertButton"));
       alertOkbuttonElement.click();

       Alert alertOk = driver.switchTo().alert();
       alertOk.accept();
       //pt cancel .dismiss();

       WebElement alertWaitButtonElement = driver.findElement(By.id("timerAlertButton"));
       alertWaitButtonElement.click();

       //wait explicit pentru alerta
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.alertIsPresent());

       Alert alertWait = driver.switchTo().alert();
       alertWait.accept();

       WebElement alertOkCancelElement = driver.findElement(By.id("confirmButton"));
       alertOkCancelElement.click();

       Alert alertOkCancel = driver.switchTo().alert();
       alertOkCancel.dismiss();

       WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
       alertPromptElement.click();

       Alert alertPrompt = driver.switchTo().alert();
       alertPrompt.sendKeys("Vlad");
       alertPrompt.accept();

       driver.quit();
    }

}





