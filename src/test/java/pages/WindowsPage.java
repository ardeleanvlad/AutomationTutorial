package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage{

    public WindowsPage(WebDriver driver){
        super(driver);

    }

    @FindBy(id = "tabButton")
    private WebElement newTabElement;
    @FindBy(id = "windowButton")
    private WebElement newWindowElement;

    public void dealWithNewTab(){
        elementHelper.clickElement(newTabElement);
        LoggerUtility.infoLog("The user clicks on new tab button");
        tabHelper.switchToSpecificTab(1);
        LoggerUtility.infoLog("The user clicks on second tab opened");
        tabHelper.closeCurrentTab();
        LoggerUtility.infoLog("The user closes the tab");
        tabHelper.switchToSpecificTab(0);
        LoggerUtility.infoLog("The user switches on first tab");
    }

    public void dealWithNewWindow(){
        elementHelper.clickElement(newWindowElement);
        LoggerUtility.infoLog("The user clicks on new window button");
        tabHelper.switchToSpecificTab(1);
        LoggerUtility.infoLog("The user clicks on second window opened");
        tabHelper.closeCurrentTab();
        LoggerUtility.infoLog("The user closes the window");
        tabHelper.switchToSpecificTab(0);
        LoggerUtility.infoLog("The user switches to initial window");
    }

}
