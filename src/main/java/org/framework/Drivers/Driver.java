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
//        Map<String, Object> listBrowser = new HashMap<String, Object>();
//
//        listBrowser.put("chrome", getChromeDriver());
//        listBrowser.put("firefox", getFirefox()); // викликає функцію підчас додаванні
//
//        try {
//            listBrowser.get(browser);
//        }catch (Exception e){
//            System.out.println("ERRRRRRRRRRRRRRRROOOOOR" + e.getMessage());
//        }

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
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        ChromeDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
        System.out.println("Firefox start");
        return driver;
    }
}
