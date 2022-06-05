package com.example.tpolab3.unauthUserTest.resourcesPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.ResourcesPage;
import util.Config;


import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


public class ResourcesPageTest {
    ResourcesPage resourcesPage;
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

    private void setConfig(WebDriver driver) {
        resourcesPage = new ResourcesPage(driver);
    }

    @Test
    public void readLocalizationContentArticle() {
        boolean result = true;
        for (WebDriver driver : drivers) {
            setConfig(driver);
            driver.get("https://www.google.com/intl/ru_ru/adsense/start/resources/");
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight / 4)", "");

            resourcesPage.readLocalizationContentButton.click();

            result &= Objects.equals("https://www.google.com/intl/ru_ru/adsense/start/resources/localizing-your-content-can-help/",
                    driver.getCurrentUrl());
        }
        assertTrue(result);

    }

}
