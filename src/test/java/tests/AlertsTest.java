package tests;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;

public class AlertsTest extends SharedData {


   @Test
    public void AlertsTestMethod(){

      ElementHelper elementHelper = new ElementHelper(driver);
      AlertHelper alertHelper = new AlertHelper(driver);

    IndexPage indexPage = new IndexPage(driver);
    indexPage.interactOnAlertsFrameWindowMenu();

       AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
       alertFrameWindowPage.interactWithAlertsSubMenu();

       AlertPage alertPage = new AlertPage(driver);
       alertPage.dealAlertOk();
       alertPage.dealAlertTimer();
       alertPage.dealAlertCancel();
       alertPage.dealAlertPrompt("vlad");
    }

}





