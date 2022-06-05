package com.example.tpolab3.loginTest;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import util.Config;

import java.util.List;
import java.util.Objects;

public class LoginTest {
    static List<WebDriver> drivers;

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


    @Test
    public void signInWithGoogleAccountWithCorrectData() {
        boolean result = true;
        for(WebDriver driver : drivers) {
            driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding");
            result &= Objects.equals("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding",
                    driver.getCurrentUrl());
        }
        assertTrue(result);
    }

}
