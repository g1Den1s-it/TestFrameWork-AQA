package org.framework.Drivers;

import org.openqa.selenium.WebDriver;

public class DriverHelper {
    public static WebDriver driver;

    public static void setup(String browser){
        Driver Webdriver = new Driver();
        driver = Webdriver.getWebDriver(browser);
    }

    public static void exit(){
        driver.close();
        driver.quit();
    }
}
