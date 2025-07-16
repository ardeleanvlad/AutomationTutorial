package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage{

    public  IndexPage(WebDriver driver){
       super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alertsElement;
    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement elementsMenu;
    @FindBy(xpath = "//h5[text()='Forms']")
    public WebElement formsMenu;

    public void interactOnAlertsFrameWindowMenu(){
        elementHelper.clickJSElement(alertsElement);

    }
    public void interactWithElementsMenu(){
        elementHelper.clickElement(elementsMenu);
    }

    public void interactWithFormsMenu(){
        elementHelper.clickElement(formsMenu);
    }
}
