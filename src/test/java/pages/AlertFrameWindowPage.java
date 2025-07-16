package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertFrameWindowPage extends BasePage{

    public  AlertFrameWindowPage(WebDriver driver){
       super(driver);

    }

@FindBy(xpath = "//span[text()='Alerts']")
    public WebElement alertsElement;
    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement framesElement;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    public  WebElement alertsSubMenu;

    public void interactWithAlertsSubMenu(){

        elementHelper.clickJSElement(alertsElement);
    }
    public void interactWithFramesSubMenu(){

        elementHelper.clickElement(framesElement);
    }
    public void interactWithWindowsSubMenu(){
        elementHelper.clickElement(alertsSubMenu);
    }


}
