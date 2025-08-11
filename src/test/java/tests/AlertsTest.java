package tests;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;
import suite.Suite;

import static suite.Suite.SANITY_SUITE;

public class AlertsTest extends SharedData {


   @Test(groups = {Suite.REGRESSION_SUITE, Suite.SANITY_SUITE,  Suite.ALERTWINDOWFRAME_SUITE})
    public void AlertsTestMethod(){

      ElementHelper elementHelper = new ElementHelper(getDriver());
      AlertHelper alertHelper = new AlertHelper(getDriver());

    IndexPage indexPage = new IndexPage(getDriver());
    indexPage.interactOnAlertsFrameWindowMenu();

       AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
       alertFrameWindowPage.interactWithAlertsSubMenu();

       AlertPage alertPage = new AlertPage(getDriver());
       alertPage.dealAlertOk();
       alertPage.dealAlertTimer();
       alertPage.dealAlertCancel();
       alertPage.dealAlertPrompt("vlad");
    }

}





