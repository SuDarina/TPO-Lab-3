package com.example.tpolab3.authUserTest.mainPageTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import util.Config;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AddSiteTest {
    static MainPage mainPage;
    static WebDriver driver;
    static MainPageActions mps;

    @BeforeAll
    static void setUp() {
        driver = Config.getDriver();
        assert driver != null;
        Config.setCookies(driver);
        mainPage = new MainPage(driver);
        mps = new MainPageActions(mainPage, driver);
    }


    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    public void addCorrectSite() throws InterruptedException {
        driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding");
        assertTrue(mps.addSite("a.com"));
    }

    @Test
    public void addCoupleCorrectSites() throws InterruptedException {
        driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding");
        assertTrue(mps.addSite("b.com") && mps.addSite("c.com"));
    }

    @Test
    public void addSiteWithIncorrectDomain() throws InterruptedException {
        driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding");
        assertFalse(mps.addSite("yfgyg"));
    }



}
