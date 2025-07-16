package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.IndexPage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTablesTest extends SharedData {


    @Test
    public void testMethod(){

        IndexPage indexPage = new IndexPage(driver);
indexPage.interactWithElementsMenu();

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.interactWithWebTablesSubMenu();


        int tableSize = 3;
        String firstnameValue="Vlad";
        String lastnameValue="Ardelean";
        String emailValue="test@test.com";
        String ageValue="27";
        String salaryValue="2500";
        String departmentValue="financiar";
            String editFirstNameValue="Vlad";
            String editLastNameValue="Ardelean";
            String editUserEmailValue="test@gmail.com";
            String editAgeValue="25";
            String editSalaryValue="2500";
            String editDepartmentValue="Financial";

        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.addNewEntry(tableSize, firstnameValue, lastnameValue, emailValue, ageValue, salaryValue, departmentValue);
        webTablePage.editNewEntry(tableSize, firstnameValue, lastnameValue, emailValue, ageValue, salaryValue, departmentValue);


        JavascriptExecutor executor = (JavascriptExecutor) driver;
        webTablePage.deleteNewEntry(tableSize);

    }
}
