package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.google.com/adsense/new/u/0/pub-5006573477303631/brand-safety/ca-pub-5006573477303631/scb
public class DelicateCategoriesPage {

    @FindBy(xpath = "//*[@id=\"blocking_controls_app_container\"]/blocking-controls/div/app-container/div/div[2]/sensitive-categories-blocking/div/sensitive-categories-table[1]/pubcontrols-table/div/ess-table/ess-particle-table/div[1]/div/div[2]/div[2]/ess-cell[2]/allow-or-block-toggle/div/div/material-toggle/div/div/div[2]/div")
    public WebElement firstToggle;

    @FindBy(xpath = "//*[@id=\"blocking_controls_app_container\"]/blocking-controls/div/app-container/div/div[2]/sensitive-categories-blocking/div/sensitive-categories-table[1]/pubcontrols-table/div/ess-table/ess-particle-table/div[1]/div/div[2]/div[2]")
    public WebElement firstCell;

    @FindBy(xpath = "//*[@id=\"blocking_controls_app_container\"]/blocking-controls/div/app-container/div/div[2]/sensitive-categories-blocking/div/sensitive-categories-table[1]/pubcontrols-table/div/ess-table/ess-particle-table/div[1]/div/div[2]/div[3]/ess-cell[2]/allow-or-block-toggle/div/div/material-toggle/div/div/div[2]/div")
    public WebElement secondToggle;

    @FindBy(xpath = "//*[@id=\"blocking_controls_app_container\"]/blocking-controls/div/app-container/div/div[2]/sensitive-categories-blocking/div/sensitive-categories-table[1]/pubcontrols-table/div/ess-table/ess-particle-table/div[1]/div/div[2]/div[3]")
    public WebElement secondCell;

    @FindBy(xpath = "//*[@id=\"blocking_controls_app_container\"]/blocking-controls/div/app-container/div/div[2]/sensitive-categories-blocking/div/sensitive-categories-table[1]/pubcontrols-table/div/ess-table/ess-particle-table/div[1]/div/div[2]/div[2]/ess-cell[2]/allow-or-block-toggle/div/div/material-toggle/div/div/div[2]/div")
    public WebElement switchedFirstToggle;



    public DelicateCategoriesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}