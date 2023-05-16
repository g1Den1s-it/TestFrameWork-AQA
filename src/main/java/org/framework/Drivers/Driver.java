package org.framework.Drivers;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

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
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        System.out.println("Chrome start");
        return driver;
    }

    public WebDriver getFirefox(){
        ChromeDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
        System.out.println("Firefox start");
        return driver;
    }
}
