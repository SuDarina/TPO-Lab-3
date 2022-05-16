package com.example.tpolab3.authUserTest.mainPageTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Config;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class MainPageSimpleTest {
    static MainPage mainPage;
    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = Config.getDriver();
        assert driver != null;
        Config.setCookies(driver);
        mainPage = new MainPage(driver);
    }


    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    public void getToPaymentsPage()  {
        driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.addInfoButton));
        mainPage.addInfoButton.click();
        assertEquals("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding/payments",
                driver.getCurrentUrl());
    }

}
