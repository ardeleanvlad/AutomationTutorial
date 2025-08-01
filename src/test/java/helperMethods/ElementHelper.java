package helperMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ElementHelper {
    private WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void clickJSElement(WebElement element){
        waitVisibleElement(element);
        element.click();
    }

    public void clickElement(WebElement element){
        waitVisibleElement(element);
        element.click();
    }

    public void printTextElement(WebElement element){
        waitVisibleElement(element);
        System.out.println(element.getText());
    }

    public void fillElement(WebElement element, String value){
        waitVisibleElement(element);
        element.sendKeys(value);
    }

    public void pressElement(WebElement element, Keys value){
        waitVisibleElement(element);
        element.sendKeys(value);
    }

    public void clearElement(WebElement element){
        waitVisibleElement(element);
        element.clear();
    }

    public void validateListSize(List<WebElement> elementsList, int expectedSize){
        waitForVisibleList(elementsList);
        Assert.assertEquals(elementsList.size(), expectedSize, "Actual elements list size: "+ elementsList.size() +" is different than " + expectedSize);
    }

    public void validateElementContainsText(WebElement element, String expectedText){
        Assert.assertTrue(element.getText().contains(expectedText), "Actual element text : " +element.getText()+ "is different than " +expectedText);
    }

    public void clearFillElement(WebElement element, String value){
        element.clear();
        fillElement(element, value);

    }

    public void fillPressElement(WebElement element,String value, Keys keyValue){
        waitVisibleElement(element);
       fillElement(element, value);
       pressElement(element, keyValue);

    }

    public void waitVisibleElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibleList(List<WebElement> elementsList){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfAllElements(elementsList));
    }

    public void validateElementEqualsText(WebElement element, String expectedText){
        Assert.assertEquals(element.getText(), expectedText, "Actual element text : " +element.getText()+ "is different than " +expectedText);
    }
}
