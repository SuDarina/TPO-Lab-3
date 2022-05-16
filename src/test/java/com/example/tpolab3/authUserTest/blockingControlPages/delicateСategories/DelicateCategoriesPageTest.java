package com.example.tpolab3.authUserTest.blockingControlPages.delicateСategories;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Config;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DelicateCategoriesPageTest {
    static DelicateCategoriesPage delicateCategoriesPage;
    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = Config.getDriver();
        assert driver != null;
        Config.setCookies(driver);
        delicateCategoriesPage = new DelicateCategoriesPage(driver);
    }


    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    private boolean switchToLock() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(delicateCategoriesPage.firstToggle));
        WebElement toggle = delicateCategoriesPage.firstCell.findElement(By.className("tgl-btn-underlay"));
        wait.until(ExpectedConditions.elementToBeClickable(toggle));
        toggle.click();
        Thread.sleep(3000);
        boolean result = delicateCategoriesPage.firstCell.getText().equals("Астрология и эзотерика\nhelp_outline\nЗаблокированные");
        wait.until(ExpectedConditions.elementToBeClickable(delicateCategoriesPage.switchedFirstToggle));
        delicateCategoriesPage.switchedFirstToggle.click();
        return result;

    }

    @Test
    public void switchToggleToBlock() throws InterruptedException {
        driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/brand-safety/ca-pub-5006573477303631/scb");
        assertTrue(switchToLock());
    }

    @Test
    public void switchTpggleToUnlock() {

    }
}
