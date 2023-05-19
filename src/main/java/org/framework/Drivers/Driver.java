package org.framework.Drivers;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver {
    private static WebDriver driver;

    public WebDriver getWebDriver(String browser){
        if(driver != null){
            return driver;
        }

        if(browser == "chrome"){
            driver = getChromeDriver();
        } else if (browser == "firefox") {
            driver = getFirefox();
        }
        return driver;
    }

    public WebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        System.out.println("Chrome start");
        return driver;
    }

    public WebDriver getFirefox(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
        System.out.println("Firefox start");
        return driver;
    }
}
