package com.example.tpolab3.authUserTest.mainPageTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.mainPage.MainPage;
import pages.mainPage.MainPageActions;
import util.Config;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class DeleteSiteTest {
    MainPage mainPage;
    MainPageActions mps;
    static List<WebDriver> drivers;


    @BeforeAll
    static void setUp() {
        drivers = Config.getAllDrivers();
        for (WebDriver d: drivers) {
            Config.setCookies(d);
        }
    }


    @AfterAll
    static void tearDown() {
        drivers.forEach(WebDriver::quit);
    }

    private  void setConfig(WebDriver driver){
        mainPage = new MainPage(driver);
        mps = new MainPageActions(mainPage, driver);
    }

    @Test
    public void deleteSiteInList() throws InterruptedException {
        boolean result = false;
        for(WebDriver driver : drivers) {
            setConfig(driver);
            driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding");
            mps.addSite("a.com");
            mps.deleteSite("a.com");
            result |= mps.isContainsSite("a.com");
        }
        assertFalse(result);
    }

    @Test
    public void deleteCoupleOfSites() throws InterruptedException {
        boolean result = false;
        for(WebDriver driver : drivers) {
            setConfig(driver);
            driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding");
            mps.addSite("b.com");
            mps.deleteSite("b.com");
            mps.addSite("c.com");
            mps.deleteSite("c.com");
            result |= (mps.isContainsSite("b.com") || mps.isContainsSite("c.com"));
        }
        assertFalse(result);
    }
}
