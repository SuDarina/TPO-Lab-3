package com.example.tpolab3.authUserTest.mainPageTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding
public class MainPage {

    @FindBy(xpath = "//*[@id=\"publisher_center_onboarding_app_container\"]/onboarding/as-exception-handler/onboarding-overview/div[2]/onboarding-card[1]/article/div[2]/button/span")
    public WebElement addInfoButton;

    @FindBy(xpath = "//*[@id=\"publisher_center_onboarding_app_container\"]/onboarding/as-exception-handler/onboarding-overview/div[1]/button/material-icon/i")
    public WebElement addSiteButton;

    @FindBy(xpath = "//*[@id=\"default-acx-overlay-container\"]/div[2]/form/material-dialog/focus-trap/div[2]/div/div[2]/material-input/label/input")
    public WebElement addSiteInput;

    @FindBy(xpath = "//*[@id=\"default-acx-overlay-container\"]/div[3]/form/material-dialog/focus-trap/div[2]/div/div[2]/material-input/label/input")
    public WebElement addSiteInputPlus;


    @FindBy(xpath = "//*[@id=\"default-acx-overlay-container\"]/div[2]/form/material-dialog/focus-trap/div[2]/div/footer/div/button[2]/span")
    public WebElement saveSiteButton;

    @FindBy(xpath = "//*[@id=\"default-acx-overlay-container\"]/div[3]/form/material-dialog/focus-trap/div[2]/div/footer/div/button[2]/span")
    public WebElement saveSiteButtonPlus;

    @FindBy(xpath = "//*[@id=\"publisher_center_onboarding_app_container\"]/onboarding/as-exception-handler/onboarding-overview/div[1]/material-menu/material-button/material-ripple")
    public WebElement sitesDropDown;

    @FindBy(xpath = "//*[@id=\"default-acx-overlay-container\"]/div/material-snackbar-panel/div/div")
    public WebElement confirmingPopUp;

    @FindBy(xpath = "//*[@id=\"default-acx-overlay-container\"]/div[3]/material-dialog/focus-trap/div[2]/div/footer/div/material-button[2]/material-ripple")
    public WebElement confirmDeletingFileButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}