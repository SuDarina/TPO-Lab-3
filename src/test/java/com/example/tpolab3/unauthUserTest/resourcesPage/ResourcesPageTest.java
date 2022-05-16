package com.example.tpolab3.unauthUserTest.resourcesPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import util.Config;


import static org.junit.jupiter.api.Assertions.*;


public class ResourcesPageTest {
    static ResourcesPage resourcesPage;
    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = Config.getDriver();
        resourcesPage = new ResourcesPage(driver);
    }


    @AfterAll
    static void tearDown() {
        driver.quit();
    }


    @Test
    public void readLocalizationContentArticle() throws InterruptedException {
        driver.get("https://www.google.com/intl/ru_ru/adsense/start/resources/");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight / 4)", "");

        resourcesPage.readLocalizationContentButton.click();

        assertEquals("https://www.google.com/intl/ru_ru/adsense/start/resources/localizing-your-content-can-help/",
                driver.getCurrentUrl());

    }

   }
