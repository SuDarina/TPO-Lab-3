package com.example.tpolab3.authUserTest.mainPageTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.mainPage.MainPage;
import pages.mainPage.MainPageActions;
import util.Config;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageSimpleTest {
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
    public void getToPaymentsPage()  {
        boolean result = true;
        for (WebDriver driver : drivers) {
            setConfig(driver);
            driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(mainPage.addInfoButton));
            mainPage.addInfoButton.click();
            result &= Objects.equals("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding/payments",
                    driver.getCurrentUrl());
        }
        assertTrue(result);
    }

}
