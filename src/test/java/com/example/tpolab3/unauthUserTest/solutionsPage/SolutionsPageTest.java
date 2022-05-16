package com.example.tpolab3.unauthUserTest.solutionsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import util.Config;


import static org.junit.jupiter.api.Assertions.*;


public class SolutionsPageTest {
    static SolutionsPage solutionsPage;
    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = Config.getDriver();
        solutionsPage = new SolutionsPage(driver);
    }


    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    public void getToAutoAdsPageFromHeader() {
        driver.get("https://www.google.com/intl/ru_ru/adsense/start/solutions/");
        solutionsPage.autoAds.click();
        assertEquals("https://www.google.com/intl/ru_ru/adsense/start/solutions/auto-ads/",
                driver.getCurrentUrl());

    }

    @Test
    public void getToAutoAdsPageFromLearnMore() {
        driver.get("https://www.google.com/intl/ru_ru/adsense/start/solutions/");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight / 4)", "");

        solutionsPage.autoAdsMore.click();

        assertEquals("https://www.google.com/intl/ru_ru/adsense/start/solutions/auto-ads/",
                driver.getCurrentUrl());

    }

    @Test
    public void getToResponsiveAdsPageFromHeader() {
        driver.get("https://www.google.com/intl/ru_ru/adsense/start/solutions/");
        solutionsPage.responsiveAds.click();
        assertEquals("https://www.google.com/intl/ru_ru/adsense/start/solutions/responsive-ads/",
                driver.getCurrentUrl());

    }

    @Test
    public void getToResponsiveAdsPageFromLearnMore() {
        driver.get("https://www.google.com/intl/ru_ru/adsense/start/solutions/");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight / 2.25)", "");

        solutionsPage.responsiveAdsMore.click();

        assertEquals("https://www.google.com/intl/ru_ru/adsense/start/solutions/responsive-ads/",
                driver.getCurrentUrl());

    }
}
