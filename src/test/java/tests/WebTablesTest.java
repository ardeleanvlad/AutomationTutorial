package tests;

import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;
import java.util.List;

public class WebTablesTest extends SharedData {


    @Test
    public void testMethod(){

        ElementHelper elementHelper = new ElementHelper(driver);


        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementHelper.clickElement(elementsMenu);

        WebElement elementsSubMenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementHelper.clickElement(elementsSubMenu);



        List<WebElement> tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int tableSize = 3;
        Assert.assertEquals(tableList.size(), tableSize);

        //identificam un element
        WebElement addElement=driver.findElement(By.id("addNewRecordButton"));
        elementHelper.clickElement(addElement);

        WebElement firstnameElement=driver.findElement(By.id("firstName"));
        String firstnameValue="Vlad";
        elementHelper.fillElement(firstnameElement,firstnameValue);


        WebElement lastnameElement=driver.findElement(By.id("lastName"));
        String lastnameValue="Ardelean";
        elementHelper.fillElement(lastnameElement, lastnameValue);


        WebElement emailElement=driver.findElement(By.id("userEmail"));
        String emailValue="test@test.com";
        elementHelper.fillElement(emailElement, emailValue);


        WebElement ageElement=driver.findElement(By.id("age"));
        String ageValue="27";
        elementHelper.fillElement(ageElement, ageValue);


        WebElement salaryElement=driver.findElement(By.id("salary"));
        String salaryValue="2500";
        elementHelper.fillElement(salaryElement, salaryValue);


        WebElement departmentElement=driver.findElement(By.id("department"));
        String departmentValue="financiar";
        elementHelper.fillElement(departmentElement, departmentValue);


        WebElement submitElement=driver.findElement(By.id("submit"));
        elementHelper.clickElement(submitElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize +1);

        //edit functionality
        WebElement editElement=driver.findElement(By.id("edit-record-4"));
        elementHelper.clickElement(editElement);

        WebElement editFirstNameElement=driver.findElement(By.id("firstName"));
        String editFirstNameValue="Vlad";
        editFirstNameElement.clear();
        elementHelper.fillElement(editFirstNameElement, editFirstNameValue);

        WebElement editLastNameElement=driver.findElement(By.id("lastName"));
        String editLastNameValue="Ardelean";
        editLastNameElement.clear();
        elementHelper.fillElement(editLastNameElement, editLastNameValue);

        WebElement editUserEmailElement=driver.findElement(By.id("userEmail"));
        String editUserEmailValue="test@gmail.com";
        editUserEmailElement.clear();
        elementHelper.fillElement(editUserEmailElement, editUserEmailValue);

        WebElement editAgeElement=driver.findElement(By.id("age"));
        String editAgeValue="25";
        editAgeElement.clear();
        elementHelper.fillElement(editAgeElement, editAgeValue);

        WebElement editSalaryElement=driver.findElement(By.id("salary"));
        String editSalaryValue="2500";
        editSalaryElement.clear();
        elementHelper.fillElement(editSalaryElement, editSalaryValue);

        WebElement editDepartmentElement=driver.findElement(By.id("department"));
        String editDepartmentValue="Financial";
        editDepartmentElement.clear();
        elementHelper.fillElement(editDepartmentElement, editDepartmentValue);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement editLine = driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(editLine);


        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize +1);

        //delete element

       WebElement deleteElement=driver.findElement(By.id("delete-record-4"));
       elementHelper.clickElement(deleteElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize);
    }
}
