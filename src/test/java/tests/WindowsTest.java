package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.IndexPage;
import pages.WindowsPage;
import sharedData.SharedData;

public class WindowsTest extends SharedData {



    @Test
    public void TestMethod() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactOnAlertsFrameWindowMenu();
        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
        alertFrameWindowPage.interactWithWindowsSubMenu();

        WindowsPage windowsPage = new WindowsPage(driver);
        windowsPage.dealWithNewTab();
        windowsPage.dealWithNewWindow();

    }
}
