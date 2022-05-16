package com.example.tpolab3.unauthUserTest.mainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import util.Config;


import static org.junit.jupiter.api.Assertions.*;


public class StartPageTest {
    static StartPage startPage;
    static WebDriver driver;
    static boolean okIsClicked;

    private void accessCookies() {
        if(!okIsClicked){
            startPage.ok.click();
            okIsClicked = true;
        }
    }

    @BeforeAll
    static void setUp() {
        driver = Config.getDriver();
        startPage = new StartPage(driver);
        okIsClicked = false;
    }


    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    public void countAvailableSalaryTest() throws InterruptedException {
        driver.get("https://www.google.com/intl/ru_ru/adsense/start/");
        accessCookies();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight / 3.5)", "");
        startPage.region.click();
        Thread.sleep(2000);

        startPage.regionSelected.click();
        Thread.sleep(2000);

        startPage.category.click();
        Thread.sleep(2000);

        startPage.categorySelected.click();
        Thread.sleep(2000);

        startPage.countButton.click();
        Thread.sleep(2000);

        assertTrue(startPage.resultRow.isDisplayed());

    }

    @Test
    public void showSuccessStory() throws InterruptedException {
        driver.get("https://www.google.com/intl/ru_ru/adsense/start/");
        accessCookies();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight / 1.45)", "");
        Thread.sleep(2000);
        startPage.showSuccessStory.click();
        assertEquals("https://www.google.com/intl/ru_ru/adsense/start/",
                driver.getCurrentUrl());
    }

    @Test
    public void checkChangeLanguageFunctionalityInHeader() throws InterruptedException {
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

        driver.get("https://www.google.com/intl/ru_ru/adsense/start/");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");

        startPage.changeLanguage.click();
        startPage.englishOption.click();

        assertEquals(translatedText, startPage.header.getText());
    }

}
