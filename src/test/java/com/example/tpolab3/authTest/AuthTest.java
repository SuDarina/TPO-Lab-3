package com.example.tpolab3.authTest;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Config;

public class AuthTest {
    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = Config.getDriver();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    public void signUpWithGoogleAccount() {
        driver.get("https://www.google.com/intl/ru_ru/adsense/start/");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul/li[2]/a")).click();
        assertEquals("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fwww.google.com%2Fadsense%2Fsignup%2Fcreate%3Fsac%3Dtrue&service=adsense&sacu=1&faa=1&hl=ru&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin",
            driver.getCurrentUrl());
    }

}
