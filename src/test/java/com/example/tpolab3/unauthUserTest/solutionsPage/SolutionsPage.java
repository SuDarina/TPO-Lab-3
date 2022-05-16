package com.example.tpolab3.unauthUserTest.solutionsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.google.com/intl/ru_ru/adsense/start/solutions/
public class SolutionsPage {

    @FindBy(xpath = "/html/body/div[2]/div[1]/nav/ul/li[2]/ul/li[1]/a")
    public WebElement autoAds;

    @FindBy(xpath = "/html/body/div[2]/div[1]/nav/ul/li[2]/ul/li[2]/a")
    public WebElement responsiveAds;

    @FindBy(xpath = "/html/body/main/section[2]/div/div/div[1]/a")
    public WebElement autoAdsMore;

    @FindBy(xpath = "/html/body/main/section[3]/div/div/div[2]/a")
    public WebElement responsiveAdsMore;


    public SolutionsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}