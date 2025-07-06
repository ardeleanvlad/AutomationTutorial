package tests;

import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {


    @Test
    public void TestMethod() {

        PageHelper pageHelper = new PageHelper(driver);
        ElementHelper elementHelper = new ElementHelper(driver);


        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementHelper.clickElement(formsMenu);

        WebElement formsSubMenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementHelper.clickElement(formsSubMenu);

        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstnameValue = "Vladut";
        elementHelper.fillElement(firstNameElement,firstnameValue);

        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastNameValue = "Ardelean";
        elementHelper.fillElement(lastNameElement,lastNameValue);

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        String emailValue = "vardy@gmail.com";
        elementHelper.fillElement(emailElement,emailValue);

        WebElement phoneNumberElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String phoneNumberValue = "0454355665";
        elementHelper.fillElement(phoneNumberElement,phoneNumberValue);

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        List<String> subjectsValue = Arrays.asList("Accounting", "Arts", "Maths");
        for(int index = 0; index < subjectsValue.size(); index++) {
            elementHelper.fillElement(subjectsElement, subjectsValue.get(index));
            elementHelper.pressElement(subjectsElement,Keys.ENTER);

        }

        String genderValue = "Female";
        List<WebElement> genderElementList = driver.findElements(By.cssSelector("div[id='genterWrapper'] label[class='custom-control-label']"));
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
        //valorea pozitiva duce scrollul in jos,valoarea negativa duce scrollul in sus
        pageHelper.scrollPage(0, 400);

        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']"));
        List<String> hobbyValue = Arrays.asList("Reading", "Sports");
        for (int index = 0; index < hobbiesElementList.size(); index++){
            if (hobbyValue.contains(hobbiesElementList.get(index).getText())) {
                elementHelper.clickElement(hobbiesElementList.get(index));
            }
        }

        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        String uploadValue = "src/test/resources/android hm portrait.JPEG";
        File file = new File(uploadValue);
        elementHelper.fillElement(uploadElement,file.getAbsolutePath());


        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
        String currentAddressValue = "Str Caprioarei nr. 15 , apt. 17";
        elementHelper.fillElement(currentAddressElement, currentAddressValue);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement stateElement = driver.findElement(By.id("state"));
        elementHelper.clickJSElement(stateElement);

        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "Uttar Pradesh";
        elementHelper.fillElement(stateInputElement,stateValue);
        elementHelper.pressElement(stateInputElement,Keys.ENTER);


        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Agra";
        elementHelper.fillElement(cityInputElement, cityValue);
        elementHelper.pressElement(cityInputElement, Keys.ENTER);


        WebElement submitElement = driver.findElement(By.id("submit"));
        elementHelper.clickElement(submitElement);

        List<WebElement> tableDescriptionList = driver.findElements(By.xpath("//table//td[1]"));
        List<WebElement> tableValueList = driver.findElements(By.xpath("//table//td[2]"));

        Assert.assertEquals(tableDescriptionList.get(0).getText(), "Student Name", "Student Name text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(firstnameValue), "First name text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(lastNameValue), "Last name text is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(1).getText(), "Student Email", "Student email text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(1).getText(), emailValue, "Student email text is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(2).getText(), "Gender", "Gender text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(2).getText(), genderValue, "Gender text is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(3).getText(), "Mobile", "Mobile text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(3).getText(), phoneNumberValue, "Mobile text is not displayed right in the table");

        }
}
