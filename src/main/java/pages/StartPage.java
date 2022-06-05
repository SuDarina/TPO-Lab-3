package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.google.com/adsense/start/
public class StartPage {

    @FindBy(xpath = "//*[@id=\"calculator-step-one\"]/div/div[1]/div/button")
    public WebElement region;

    @FindBy(xpath = "//*[@id=\"owned_listbox\"]/li[1]/button")
    public WebElement regionSelected;

    @FindBy(xpath = "//*[@id=\"calculator-step-one\"]/div/div[2]/div/button")
    public WebElement category;

    @FindBy(xpath = "//*[@id=\"owned_listbox\"]/li[6]/button")
    public WebElement categorySelected;

    @FindBy(xpath = "//*[@id=\"calculator-step-one\"]/button")
    public WebElement countButton;

    @FindBy(xpath = "//*[@id=\"calculator-step-two\"]/div[3]/div[1]")
    public WebElement resultRow;

    @FindBy(xpath = "/html/body/main/section[8]/div[2]/div/a")
    public WebElement showSuccessStory;

    @FindBy(xpath = "//*[@id=\"cookieBar\"]/div/span[2]/a[2]")
    public WebElement ok;

    @FindBy(xpath = "//*[@id=\"footer-standard\"]/section[2]/ul[2]/li[2]/select")
    public WebElement changeLanguage;

    @FindBy(xpath = "//*[@id=\"footer-standard\"]/section[2]/ul[2]/li[2]/select/option[26]")
    public WebElement englishOption;

    @FindBy(xpath = " /html/body/div/div[1]")
    public WebElement header;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}