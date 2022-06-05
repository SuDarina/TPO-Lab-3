package com.example.tpolab3.unauthUserTest.mainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.StartPage;
import util.Config;


import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class StartPageTest {
    StartPage startPage;
    static boolean okIsClicked;
    static List<WebDriver> drivers;
    JavascriptExecutor jse;

    private void accessCookies() {
        if(!okIsClicked){
            startPage.ok.click();
            okIsClicked = true;
        }
    }

    @BeforeAll
    static void setUp() {
        drivers = Config.getAllDrivers();
        for (WebDriver d: drivers) {
            Config.setCookies(d);
        }
        okIsClicked = false;
    }

    private void setConfig(WebDriver driver){
        startPage = new StartPage(driver);
        jse = (JavascriptExecutor) driver;
    }


    @AfterAll
    static void tearDown() {
        drivers.forEach(WebDriver::quit);
    }

    @Test
    public void countAvailableSalaryTest() throws InterruptedException {
        boolean result = true;
        for (WebDriver driver : drivers) {
            setConfig(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            driver.get("https://www.google.com/intl/ru_ru/adsense/start/");
            accessCookies();

            jse.executeScript("window.scrollTo(0, document.body.scrollHeight / 3.5)", "");

            wait.until(ExpectedConditions.elementToBeClickable(startPage.region));
            startPage.region.click();

            wait.until(ExpectedConditions.elementToBeClickable(startPage.regionSelected));
            startPage.regionSelected.click();

            wait.until(ExpectedConditions.elementToBeClickable(startPage.category));
            startPage.category.click();

            wait.until(ExpectedConditions.elementToBeClickable(startPage.categorySelected));
            startPage.categorySelected.click();

            wait.until(ExpectedConditions.elementToBeClickable(startPage.countButton));
            startPage.countButton.click();

            result &= startPage.resultRow.isDisplayed();
        }

        assertTrue(result);
    }

    @Test
    public void showSuccessStory() throws InterruptedException {
        boolean result = true;
        for(WebDriver driver : drivers) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            setConfig(driver);
            driver.get("https://www.google.com/intl/ru_ru/adsense/start/");
            accessCookies();
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight / 1.45)", "");
            wait.until(ExpectedConditions.elementToBeClickable(startPage.showSuccessStory));
            startPage.showSuccessStory.click();
            result &= Objects.equals("https://www.google.com/intl/ru_ru/adsense/start/",
                    driver.getCurrentUrl());
        }
        assertTrue(result);
    }

    @Test
    public void checkChangeLanguageFunctionalityInHeader() {
        WebDriver driver = drivers.get(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        setConfig(driver);
        driver.get("https://www.google.com/intl/ru_ru/adsense/start/");
        accessCookies();
        String translatedText = """
                AdSense
                Home
                Solutions
                Success Stories
                Resources
                Blog
                Sign in
                Get started""";

        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");

        wait.until(ExpectedConditions.elementToBeClickable(startPage.changeLanguage));
        startPage.changeLanguage.click();

        wait.until(ExpectedConditions.elementToBeClickable(startPage.englishOption));
        startPage.englishOption.click();

        assertEquals(translatedText, startPage.header.getText());
    }
}
