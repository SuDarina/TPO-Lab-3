package com.example.tpolab3.authUserTest.blockingControlPages.advertiserUrl;

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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdvertiserUrlPageTest {
    static AdvertiserUrlPage advertiserUrl;
    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = Config.getDriver();
        assert driver != null;
        Config.setCookies(driver);
        advertiserUrl = new AdvertiserUrlPage(driver);
    }


    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    private boolean unblockUrl(String site) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(advertiserUrl.table));
        List<WebElement> list =  driver.findElements(By.className("particle-table-row"));
        for (WebElement we : list) {
            if(we.getText().equals(site + "\n" +
                    "Заблокированные")) {
                WebElement toggle = we.findElement(By.className("tgl-btn-underlay"));
                wait.until(ExpectedConditions.elementToBeClickable(toggle));
                toggle.click();
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfAllElements(advertiserUrl.statuses));
        List<WebElement> list2 =  driver.findElements(By.className("particle-table-row"));
        for (WebElement we : list2) {
            if(we.getText().equals(site + "\n" +
                    "Разрешено")) {
                return true;
            }
        }


            return false;
    }

    private boolean blockUrl(String site) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(advertiserUrl.inputField));
        advertiserUrl.inputField.click();
        advertiserUrl.inputField.sendKeys(site);

        wait.until(ExpectedConditions.elementToBeClickable(advertiserUrl.searchButton));
        advertiserUrl.searchButton.click();

        wait.until(ExpectedConditions.visibilityOf(advertiserUrl.resultCell));
        if(advertiserUrl.resultCell.getText().equals(site)) {
            wait.until(ExpectedConditions.elementToBeClickable(advertiserUrl.blockingSwitcher));
            advertiserUrl.blockingSwitcher.click();
            wait.until(ExpectedConditions.visibilityOf(advertiserUrl.urlStatus));
            return advertiserUrl.urlStatus.getText().equals("Заблокированные");
        }
        return false;
    }


    @Test
    public void blockUrlTest() {
        driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/brand-safety/ca-pub-5006573477303631/ub");
        assertTrue(blockUrl("github.com"));
    }

    @Test
    public void unblockUrlTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/brand-safety/ca-pub-5006573477303631/ub");
        blockUrl("a.com");
        wait.until(ExpectedConditions.elementToBeClickable(advertiserUrl.closeBlockingMod));
        advertiserUrl.closeBlockingMod.click();

        assertTrue(unblockUrl("a.com"));
    }
}
