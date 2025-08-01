package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {

    private WebDriver driver;

    public FrameHelper(WebDriver driver){
        this.driver = driver;


    }

    public void switchFrameByElement(WebElement element){
        driver.switchTo().frame(element);

    }
    public void switchFrameByString(String value){
        driver.switchTo().frame(value);
    }
    public void switchToParent(){
        driver.switchTo().parentFrame();

    }
    }

