package com.example.tpolab3.authUserTest.blockingControlPages.advertiserUrl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AdvertiserUrlPage;
import util.Config;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdvertiserUrlPageTest {
    AdvertiserUrlPage advertiserUrl;
    static List<WebDriver> drivers;


    @BeforeAll
    static void setUp() {
        drivers = Config.getAllDrivers();
        for (WebDriver d: drivers) {
            Config.setCookies(d);
        }
    }
    private void setConfig(WebDriver driver){
        advertiserUrl = new AdvertiserUrlPage(driver);
    }


    @AfterAll
    static void tearDown() {
        drivers.forEach(WebDriver::quit);
    }

    private boolean unblockUrl(WebDriver driver, String site) {
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
            System.out.println(we.getText());
            System.out.println();
            if(we.getText().equals(site + "\n" +
                    "Разрешено")) {
                return true;
            }
        }


            return false;
    }

    private boolean blockUrl(WebDriver driver, String site) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        boolean result = true;
        for (WebDriver driver : drivers) {
            setConfig(driver);
            driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/brand-safety/ca-pub-5006573477303631/ub");
            result &= blockUrl(driver, "github.com");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(advertiserUrl.closeBlockingMod));
            advertiserUrl.closeBlockingMod.click();
            unblockUrl(driver, "github.com");
        }
        assertTrue(result);
    }

    @Test
    public void unblockUrlTest() {
        boolean result = true;
        for (WebDriver driver : drivers) {
            setConfig(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/brand-safety/ca-pub-5006573477303631/ub");
            blockUrl(driver, "a.com");
            wait.until(ExpectedConditions.elementToBeClickable(advertiserUrl.closeBlockingMod));
            advertiserUrl.closeBlockingMod.click();
            result &= unblockUrl(driver, "a.com");
        }
        assertTrue(result);
    }
}
