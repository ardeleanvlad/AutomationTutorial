package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage{

    public  AlertPage(WebDriver driver){
        super(driver);

    }

    @FindBy(id = "alertButton")
    private WebElement alertOkbuttonElement;
    @FindBy(id = "timerAlertButton")
    private WebElement alertWaitButtonElement;
    @FindBy(id = "confirmButton")
    private WebElement alertOkCancelElement;
    @FindBy(id = "promtButton")
    private WebElement alertPromptElement;

    public void dealAlertOk(){
        elementHelper.clickElement(alertOkbuttonElement);
        LoggerUtility.infoLog("The user clicks on Alert Ok Button");
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("The user deals with Alert Ok presence");
    }
    public void dealAlertTimer(){
        elementHelper.clickElement(alertWaitButtonElement);
        LoggerUtility.infoLog("The user clicks on Alert Timer Button");
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("The user deals with Alert Ok presence");
    }

    public void dealAlertCancel(){
        elementHelper.clickJSElement(alertOkCancelElement);
        LoggerUtility.infoLog("The user clicks on Alert Ok Cancel Button");
        alertHelper.dismissAlert();
        LoggerUtility.infoLog("The user deals with Alert Ok Cancel presence");
    }

    public void dealAlertPrompt(String value){
        elementHelper.clickElement(alertPromptElement);
        LoggerUtility.infoLog("The user clicks on Alert Prompt Button");
        alertHelper.fillAlert(value);
        LoggerUtility.infoLog("The user fills with the value:" + value);
    }
}
