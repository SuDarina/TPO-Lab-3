package com.example.tpolab3.authUserTest.blockingControlPages.advertiserUrl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.google.com/adsense/new/u/0/pub-5006573477303631/brand-safety/ca-pub-5006573477303631/ub
public class AdvertiserUrlPage {

    @FindBy(xpath = "//*[@id=\"blocking_controls_app_container\"]/blocking-controls/div/app-container/div/div[2]/url-blocking/div/search-bar/material-input/div/div[1]/label/input")
    public WebElement inputField;

    @FindBy(xpath = "//*[@id=\"default-acx-overlay-container\"]/div[5]/search-card/material-dialog/focus-trap/div[2]/div/div[2]/div/div[2]/div/div/url-table/pubcontrols-table/div/ess-table/ess-particle-table/div[1]/div/div[2]/div[2]/ess-cell[1]/url-cell/div")
    public WebElement siteSpan;

    @FindBy(xpath = "//*[@id=\"default-acx-overlay-container\"]/div[2]/search-card/material-dialog/focus-trap/div[2]/div/div[2]/div/div[2]/div/div/url-table/pubcontrols-table/div/ess-table/ess-particle-table/div[1]/div/div[2]/div[2]/ess-cell[2]/allow-or-block-toggle/div/div/material-toggle/div/div/div[2]/div/div")
    public WebElement blockingSwitcher;

    @FindBy(xpath = "//*[@id=\"blocking_controls_app_container\"]/blocking-controls/div/app-container/div/div[2]/url-blocking/div/div[2]/url-table/pubcontrols-table/div/ess-table/ess-particle-table/div[1]/div/div[2]/div[2]/ess-cell[2]/allow-or-block-toggle/div/div/simple-html/span")
    public WebElement urlStatus;

    @FindBy(xpath = "//*[@id=\"blocking_controls_app_container\"]/blocking-controls/div/app-container/div/div[2]/url-blocking/div/search-bar/div/material-button/div")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"default-acx-overlay-container\"]/div[2]/search-card/material-dialog/focus-trap/div[2]/div/div[2]/div/div[2]/div/div/url-table/pubcontrols-table/div/ess-table/ess-particle-table/div[1]/div/div[2]/div[2]/ess-cell[1]")
    public WebElement resultCell;

    @FindBy(xpath = "//*[@id=\"default-acx-overlay-container\"]/div[2]/search-card/material-dialog/focus-trap/div[2]/div/div[2]/div/div[3]/material-button/div")
    public WebElement closeBlockingMod;

    @FindBy(xpath = "//*[@id=\"blocking_controls_app_container\"]/blocking-controls/div/app-container/div/div[2]/url-blocking/div/div[2]/url-table/pubcontrols-table/div/ess-table/ess-particle-table/div[1]/div/div[2]")
    public WebElement table;

    @FindBy(className = "blocking-status")
    public WebElement statuses;
    public AdvertiserUrlPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}