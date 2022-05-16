package com.example.tpolab3.authUserTest.mainPageTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Config;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DeleteSiteTest {
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
    public void deleteSiteInList() {
        driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding");
        mps.deleteSite("a.com");
        assertFalse(mps.isContainsSite("a.com"));
    }

    @Test
    public void deleteCoupleOfSites() {
        driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding");
        mps.deleteSite("b.com");
        mps.deleteSite("c.com");
        assertFalse(mps.isContainsSite("b.com") || mps.isContainsSite("c.com"));
    }
}
