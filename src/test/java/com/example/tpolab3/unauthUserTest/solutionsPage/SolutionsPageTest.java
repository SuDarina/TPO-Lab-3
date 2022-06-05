package com.example.tpolab3.unauthUserTest.solutionsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.SolutionsPage;
import util.Config;


import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


public class SolutionsPageTest {
    SolutionsPage solutionsPage;
    static List<WebDriver> drivers;

    @BeforeAll
    static void setUp() {
        drivers = Config.getAllDrivers();
        for (WebDriver d : drivers) {
            Config.setCookies(d);
        }
    }


    @AfterAll
    static void tearDown() {
        drivers.forEach(WebDriver::quit);
    }

    private void setConfig(WebDriver driver){
        solutionsPage = new SolutionsPage(driver);
    }

    @Test
    public void getToAutoAdsPageFromHeader() {
        boolean result = true;
        for(WebDriver driver : drivers) {
            setConfig(driver);
            driver.get("https://www.google.com/intl/ru_ru/adsense/start/solutions/");
            solutionsPage.autoAds.click();
            result &= Objects.equals("https://www.google.com/intl/ru_ru/adsense/start/solutions/auto-ads/",
                    driver.getCurrentUrl());
        }
        assertTrue(result);

    }

    @Test
    public void getToAutoAdsPageFromLearnMore() {
        boolean result = true;
        for (WebDriver driver : drivers) {
            setConfig(driver);
            driver.get("https://www.google.com/intl/ru_ru/adsense/start/solutions/");
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight / 4)", "");

            solutionsPage.autoAdsMore.click();

            result &= Objects.equals("https://www.google.com/intl/ru_ru/adsense/start/solutions/auto-ads/",
                    driver.getCurrentUrl());
        }
        assertTrue(result);
    }

    @Test
    public void getToResponsiveAdsPageFromHeader() {
        boolean result = true;
        for (WebDriver driver : drivers) {
            setConfig(driver);
            driver.get("https://www.google.com/intl/ru_ru/adsense/start/solutions/");
            solutionsPage.responsiveAds.click();
            result &= Objects.equals("https://www.google.com/intl/ru_ru/adsense/start/solutions/responsive-ads/",
                    driver.getCurrentUrl());
        }
        assertTrue(result);

    }

    @Test
    public void getToResponsiveAdsPageFromLearnMore() {
        boolean result = true;
        for(WebDriver driver : drivers) {
            setConfig(driver);
            driver.get("https://www.google.com/intl/ru_ru/adsense/start/solutions/");
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight / 2.25)", "");

            solutionsPage.responsiveAdsMore.click();

            result &= Objects.equals("https://www.google.com/intl/ru_ru/adsense/start/solutions/responsive-ads/",
                    driver.getCurrentUrl());
        }
        assertTrue(result);
    }
}
