package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.FramesPage;
import pages.IndexPage;
import sharedData.SharedData;

public class FramesTest extends SharedData {



    @Test
    public void AlertsTestMethod() {


        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactOnAlertsFrameWindowMenu();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
        alertFrameWindowPage.interactWithFramesSubMenu();

        FramesPage framesPage = new FramesPage(driver);
        framesPage.dealWithBigIFrame();
        framesPage.dealWithLittleIFrame();

    }
}
