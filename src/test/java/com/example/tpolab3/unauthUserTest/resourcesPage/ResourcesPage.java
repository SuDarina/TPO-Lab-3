package com.example.tpolab3.unauthUserTest.resourcesPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.google.com/intl/ru_ru/adsense/start/resources/
public class ResourcesPage {

    @FindBy(xpath = "/html/body/main/section[2]/div/div[2]/a/button")
    public WebElement readLocalizationContentButton;


    public ResourcesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}