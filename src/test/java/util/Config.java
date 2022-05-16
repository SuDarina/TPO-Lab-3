package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.Cookie;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;

public class Config {

    public static Properties loadProperties(){
        FileInputStream fileInputStream;
        Properties prop = new Properties();
        try {
            fileInputStream = new FileInputStream("/Users/dariasupriadkina/IdeaProjects/TPO-Lab-3/src/test/resources/config.properties");
            prop.load(fileInputStream);
        } catch (IOException e){
            System.out.println("Ошибка в программе: файл config.properties не обнаружен");
            e.printStackTrace();
            return null;
        }
        return prop;
    }

    public static WebDriver getDriver() {
        WebDriver driver;
        try {
            Properties prop = loadProperties();

            assert prop != null;
            if(Objects.equals(prop.getProperty("driver"), "Chrome")){
                 System.setProperty("webdriver.chrome.driver",
                         "/Users/dariasupriadkina/IdeaProjects/TPO-Lab-3/src/test/resources/drivers/chromedriver");
                 ChromeOptions options = new ChromeOptions();
                 options.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.88 Safari/537.36");
                 driver = new ChromeDriver(options);
             } else if(Objects.equals(prop.getProperty("driver"), "Firefox")){
                System.setProperty("webdriver.gecko.driver",
                        "/Users/dariasupriadkina/IdeaProjects/TPO-Lab-3/src/test/resources/drivers/geckodriver");
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.88 Safari/537.36");
                driver = new FirefoxDriver(options);
             } else throw new IllegalArgumentException();


        } catch (IllegalArgumentException e) {
            System.out.println("Where is no suitable driver");
            e.printStackTrace();
            return null;
        }
        //driver.manage().window().setSize(new Dimension(960, 1053));
        return driver;
    }

    public static void setCookies(WebDriver driver) {
        CookieManager cm = new CookieManager();
        ArrayList<Cookie> cookies = (ArrayList<Cookie>) cm.readCookies();
        driver.get("https://www.google.com/adsense/start/");

        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }


    public static void login(WebDriver driver) throws InterruptedException {
       setCookies(driver);
        driver.get("https://www.google.com/adsense/new/u/0/pub-5006573477303631/onboarding");
    }
}
