package com.example.tpolab3.loginTest;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import util.Config;

public class LoginTest {
    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = Config.getDriver();
        assert driver != null;
        Config.setCookies(driver);
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    public void signInWithGoogleAccountWithCorrectData() throws InterruptedException {
        driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding");
        Thread.sleep(2000);
        assertEquals("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding",
                    driver.getCurrentUrl());
    }

}
