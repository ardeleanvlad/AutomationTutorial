package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertFrameWindowPage extends BasePage{

    public  AlertFrameWindowPage(WebDriver driver){
       super(driver);

    }

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsElement;
    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement framesElement;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    private   WebElement alertsSubMenu;

    public void interactWithAlertsSubMenu(){
        elementHelper.clickJSElement(alertsElement);
        LoggerUtility.infoLog("The user clicks on Alerts Sub Menu");
    }
    public void interactWithFramesSubMenu(){
        elementHelper.clickElement(framesElement);
        LoggerUtility.infoLog("The user clicks on Frames Sub Menu");
    }
    public void interactWithWindowsSubMenu(){
        elementHelper.clickElement(alertsSubMenu);
        LoggerUtility.infoLog("The user clicks on Windows Sub Menu");


    }


}
