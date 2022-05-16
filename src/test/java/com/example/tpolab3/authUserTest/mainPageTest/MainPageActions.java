package com.example.tpolab3.authUserTest.mainPageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class MainPageActions {
     MainPage mainPage;
     WebDriver driver;
     List<WebElement> webElements;

    public MainPageActions(MainPage mainPage, WebDriver driver) {
        this.mainPage = mainPage;
        this.driver = driver;
    }


    private  Map<String, WebElement> getButtonsFromPopUp() {
        Map<String, WebElement> buttons = new HashMap<>();
        for (WebElement el : webElements) {
            if (el.getText().equals("add\n" +
                    "Добавить ещё один сайт")){
                buttons.put("add", el);
            }
            if (el.getText().equals("delete\n" +
                    "Удалить сайт")) {
                buttons.put("delete", el);
            }
        }
        return buttons;
    }

    private Map<String, WebElement> getSitesInTheBeginning() {
        Map<String, WebElement> sites = new HashMap<>();
        for (WebElement el : webElements) {
            if (!(el.getText().equals("add\n" +
                    "Добавить ещё один сайт"))
                    && !(el.getText().equals("delete\n" +
                    "Удалить сайт"))) {

                sites.put(el.getText(), el);
            }
        }

        return sites;
    }

    private Map<String, WebElement> getSites(List<WebElement> list) {
        Map<String, WebElement> sites = new HashMap<>();
        for (WebElement el : list) {
            if (!(el.getText().equals("add\n" +
                    "Добавить ещё один сайт"))
            && !(el.getText().equals("delete\n" +
                    "Удалить сайт"))) {

                sites.put(el.getText(), el);
            }
        }

        return sites;
    }

    private List<WebElement> getSitesList() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(mainPage.sitesDropDown));
            Thread.sleep(2000);
            mainPage.sitesDropDown.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.className("menu-item"))));
            webElements = driver.findElements(By.className("menu-item"));
        } catch (NoSuchElementException | TimeoutException e){
            wait.until(ExpectedConditions.elementToBeClickable(mainPage.addSiteButton));
            webElements = new ArrayList<>();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return webElements;
    }

    private void deleteSitesList() {
        List<WebElement> list = getSitesList();
        for (WebElement el : list){
            if (!(el.getText().equals("add\n" +
                    "Добавить ещё один сайт") || el.getText().equals("delete\n" +
                    "Удалить сайт"))) {
                deleteSite(el.getText());
                list.remove(el);
                if (list.size() == 2) break;
            }

        }
    }

    public void deleteSite(String site) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            List<WebElement> list = getSitesList();
            if (list.isEmpty()) throw new NullPointerException("No sites are added");

            boolean contain = false;
            Map<String, WebElement> sites = getSites(list);
            contain = sites.containsKey(site);
            if (!contain) {
                throw new NullPointerException("Site is not in list");
            }
            wait.until(ExpectedConditions.elementToBeClickable(sites.get(site)));
            sites.get(site).click();

            List<WebElement> list2 = getSitesList();
            WebElement deleteButton = null;
            for (WebElement el : list2) {
                if (el.getText().equals("delete\n" +
                        "Удалить сайт")) {
                    deleteButton = el;
                    break;
                }
            }
            wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
            deleteButton.click();
            wait.until(ExpectedConditions.elementToBeClickable(mainPage.confirmDeletingFileButton));
            mainPage.confirmDeletingFileButton.click();
            wait.until(ExpectedConditions.visibilityOf(mainPage.confirmingPopUp));

        } catch (NullPointerException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    public boolean isContainsSite(String site) {
        List<WebElement> list = getSitesList();
        boolean contains = false;
        for (WebElement we : list){
            if (we.getText().equals(site)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public boolean addSite(String site) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(mainPage.addSiteButton));
            mainPage.addSiteButton.click();
            mainPage.addSiteInput.click();
            mainPage.addSiteInput.sendKeys(site);
            mainPage.saveSiteButton.click();

        } catch (NoSuchElementException | TimeoutException e) {
            List<WebElement> list = getSitesList();

            for (WebElement el : list) {
                if (el.getText().equals("add\n" +
                        "Добавить ещё один сайт")) {
                    el.click();
                    break;
                }
            }
            mainPage.addSiteInputPlus.click();
            mainPage.addSiteInputPlus.sendKeys(site);
            mainPage.saveSiteButtonPlus.click();
        }
        List<WebElement> list = getSitesList();
        Map<String, WebElement> map = getSites(list);
        if(map.containsKey(site)) {
            map.get(site).click();
            return true;
        }
        return false;
    }
}
