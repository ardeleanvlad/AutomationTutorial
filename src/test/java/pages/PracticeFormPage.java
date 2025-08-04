package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class PracticeFormPage extends BasePage{

public PracticeFormPage(WebDriver driver){
    super(driver);
}

@FindBy(css = "input[placeholder='First Name']")
    private WebElement firstNameElement;
@FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameElement;
@FindBy(css ="input[placeholder='name@example.com']" )
    private WebElement emailElement;
@FindBy(css ="input[placeholder='Mobile Number']" )
    private WebElement phoneNumberElement;
@FindBy(id ="subjectsInput" )
    private WebElement subjectsElement;
@FindBy(css = "div[id='genterWrapper'] label[class='custom-control-label']")
    private List<WebElement> genderElementList;
@FindBy(css = "div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']")
    private List<WebElement> hobbiesElementList;
@FindBy(id = "uploadPicture")
    private WebElement uploadElement;
@FindBy(id ="currentAddress")
    private WebElement currentAddressElement;
@FindBy(id = "state")
    private   WebElement stateElement;
@FindBy(id = "react-select-3-input")
    private WebElement stateInputElement;
@FindBy(id = "city")
private WebElement cityElement;
@FindBy(id = "react-select-4-input")
    private WebElement cityInputElement;
@FindBy(id = "submit")
    private WebElement submitElement;
@FindBy(xpath = "//table//td[1]")
private List<WebElement> tableDescriptionList;
@FindBy(xpath = "//table//td[2]")
private List<WebElement> tableValueList;

public void  fillEntireForm(String firstNameValue,  String lastNameValue,String emailValue,String phoneNumberValue,
                            List<String> subjectsValue, String genderValue, List<String> hobbyValue, String uploadValue,
                            String currentAddressValue, String stateValue,  String cityValue){

    elementHelper.fillElement(firstNameElement,firstNameValue);
    LoggerUtility.infoLog("The user fills first name field with value: " +firstNameValue);

    elementHelper.fillElement(lastNameElement,lastNameValue);
    LoggerUtility.infoLog("The user fills last name field with value: " +lastNameValue);

    elementHelper.fillElement(emailElement,emailValue);
    LoggerUtility.infoLog("The user fills email field with value: " +emailValue);

    elementHelper.fillElement(phoneNumberElement,phoneNumberValue);
    LoggerUtility.infoLog("The user fills phone number field with value: " +phoneNumberValue);

    for(int index = 0; index < subjectsValue.size(); index++) {
        elementHelper.fillPressElement(subjectsElement, subjectsValue.get(index), Keys.ENTER);
        LoggerUtility.infoLog("The user fills subjects field value: " +subjectsValue.get(index));
    }


    switch (genderValue) {
        case "Male":
            elementHelper.clickElement(genderElementList.get(0));
            break;
        case "Female":
            elementHelper.clickElement(genderElementList.get(1));
            break;
        case "Other":
            elementHelper.clickElement(genderElementList.get(2));
            break;

    }
    LoggerUtility.infoLog("The user checks from gender field the value: " +genderValue);
    pageHelper.scrollPage(0, 400);

    for (int index = 0; index < hobbiesElementList.size(); index++){
        if (hobbyValue.contains(hobbiesElementList.get(index).getText())) {
            elementHelper.clickElement(hobbiesElementList.get(index));
            LoggerUtility.infoLog("The user fills hobbies field value: " +hobbiesElementList.get(index).getText());
        }
    }

    File file = new File(uploadValue);
    elementHelper.fillElement(uploadElement,file.getAbsolutePath());
    LoggerUtility.infoLog("The user upload the file :" +file.getAbsolutePath());

    elementHelper.fillElement(currentAddressElement, currentAddressValue);
    LoggerUtility.infoLog("The user fills the address field value: " +currentAddressValue);

    JavascriptExecutor executor = (JavascriptExecutor) driver;

    elementHelper.clickJSElement(stateElement);

    elementHelper.fillPressElement(stateInputElement,stateValue, Keys.ENTER);
    LoggerUtility.infoLog("The user fills the state field value: " +stateValue);

    elementHelper.fillPressElement(cityInputElement, cityValue, Keys.ENTER);
    LoggerUtility.infoLog("The user fills the city field value: " +cityValue);

    elementHelper.clickElement(submitElement);
    LoggerUtility.infoLog("The user clicks on Submit");
}

public void validateFormValues(String firstNameValue, String lastNameValue, String emailValue, String genderValue, String phoneNumberValue, List <String> subjectsValue,
                               List<String> hobbyValue, String filename, String addressValue , String stateValue, String cityValue  ){

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Validate Student Name section
    wait.until(ExpectedConditions.visibilityOf(tableDescriptionList.get(0)));
    elementHelper.validateElementEqualsText(tableDescriptionList.get(0), "Student Name");
    LoggerUtility.infoLog("The user validates the presence of value : Student Name");
    elementHelper.validateElementEqualsText(tableDescriptionList.get(0), "Student Name");

    elementHelper.validateElementContainsText(tableValueList.get(0), firstNameValue);
    LoggerUtility.infoLog("The user validates the presence of value : " +firstNameValue);

    elementHelper.validateElementContainsText(tableValueList.get(0), lastNameValue);
    LoggerUtility.infoLog("The user validates the presence of value : " +lastNameValue);

    elementHelper.validateElementEqualsText(tableDescriptionList.get(1), "Student Email");
    LoggerUtility.infoLog("The user validates the presence of value : Student Email");
    elementHelper.validateElementEqualsText(tableValueList.get(1), emailValue);
    LoggerUtility.infoLog("The user validates the presence of value : " +emailValue);

    elementHelper.validateElementEqualsText(tableDescriptionList.get(2), "Gender");
    LoggerUtility.infoLog("The user validates the presence of value : Gender");
    elementHelper.validateElementEqualsText(tableValueList.get(2), genderValue);
    LoggerUtility.infoLog("The user validates the presence of value : " +genderValue);

    elementHelper.validateElementEqualsText(tableDescriptionList.get(3), "Mobile");
    LoggerUtility.infoLog("The user validates the presence of value : Mobile");
    elementHelper.validateElementEqualsText(tableValueList.get(3), phoneNumberValue);
    LoggerUtility.infoLog("The user validates the presence of value : " +phoneNumberValue);

    elementHelper.validateElementEqualsText(tableDescriptionList.get(5), "Subjects");
    LoggerUtility.infoLog("The user validates the presence of value : Subjects");
    elementHelper.validateElementEqualsText(tableValueList.get(5), String.join(", ", subjectsValue));
    LoggerUtility.infoLog("The user validates the presence of value : " +subjectsValue);

    elementHelper.validateElementEqualsText(tableDescriptionList.get(6), "Hobbies");
    LoggerUtility.infoLog("The user validates the presence of value : Hobbies");
    elementHelper.validateElementEqualsText(tableValueList.get(6), String.join(", ",hobbyValue ));
    LoggerUtility.infoLog("The user validates the presence of value : " +hobbyValue);

    File file = new File(filename);

    elementHelper.validateElementEqualsText(tableDescriptionList.get(7), "Picture");
    LoggerUtility.infoLog("The user validates the presence of value : Picture");
    elementHelper.validateElementEqualsText(tableValueList.get(7), file.getName());
    LoggerUtility.infoLog("The user validates the presence of value : " +filename);

    elementHelper.validateElementEqualsText(tableDescriptionList.get(8), "Address");
    LoggerUtility.infoLog("The user validates the presence of value : Address");
    elementHelper.validateElementEqualsText(tableValueList.get(8), addressValue);
    LoggerUtility.infoLog("The user validates the presence of value : " +addressValue);

    elementHelper.validateElementEqualsText(tableDescriptionList.get(9), "State and City");
    LoggerUtility.infoLog("The user validates the presence of value : State and City");
    elementHelper.validateElementContainsText(tableValueList.get(9), stateValue);
    LoggerUtility.infoLog("The user validates the presence of value : " +stateValue);
    elementHelper.validateElementContainsText(tableValueList.get(9), cityValue);
    LoggerUtility.infoLog("The user validates the presence of value : " +cityValue);
}
}

