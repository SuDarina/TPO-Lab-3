package com.example.tpolab3.authUserTest.mainPageTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.mainPage.MainPage;
import pages.mainPage.MainPageActions;
import util.Config;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AddSiteTest {
    MainPage mainPage;
    static List<WebDriver> drivers;
    MainPageActions mps;

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

    private void setConfig(WebDriver driver){
        mainPage = new MainPage(driver);
        mps = new MainPageActions(mainPage, driver);
    }

    @Test
    public void addCorrectSite() throws InterruptedException {
        boolean result = true;
        for (WebDriver d : drivers) {
            setConfig(d);
            d.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding");
            try {
                result &= mps.addSite("a.com");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mps.deleteSite("a.com");
        }
        assertTrue(result);
    }

    @Test
    public void addCoupleCorrectSites() throws InterruptedException {
        boolean result = true;
        for(WebDriver driver : drivers) {
            setConfig(driver);
            driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding");
            result &= (mps.addSite("b.com") && mps.addSite("c.com"));
            mps.deleteSite("b.com");
            mps.deleteSite("c.com");
        }
        assertTrue(result);
    }

    @Test
    public void addSiteWithIncorrectDomain() throws InterruptedException {
        boolean result = false;
        for (WebDriver driver : drivers) {
            setConfig(driver);
            driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding");
            result |= mps.addSite("yfgyg");
        }
        assertFalse(result);
    }
}
