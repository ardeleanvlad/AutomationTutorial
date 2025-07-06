package helperMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementHelper {
    public WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void clickJSElement(WebElement element){
        element.click();
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void printTextElement(WebElement element){
        System.out.println(element.getText());
    }

    public void fillElement(WebElement element, String value){
        element.sendKeys(value);
    }

    public void pressElement(WebElement element, Keys value){
        element.sendKeys(value);
    }
}
