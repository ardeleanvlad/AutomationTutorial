package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.FramesPage;
import pages.IndexPage;
import sharedData.SharedData;
import suite.Suite;

public class FramesTest extends SharedData {



    @Test(groups = {Suite.REGRESSION_SUITE, Suite.SANITY_SUITE, Suite.ALERTWINDOWFRAME_SUITE})
    public void AlertsTestMethod() {


        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactOnAlertsFrameWindowMenu();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.interactWithFramesSubMenu();

        FramesPage framesPage = new FramesPage(getDriver());
        framesPage.dealWithBigIFrame();
        framesPage.dealWithLittleIFrame();

    }
}
