package org.framework.UI.po;

import org.framework.Drivers.DriverHelper;
import org.framework.UI.wrappers.Decorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.framework.Drivers.DriverHelper.driver;

public class HomePageObject {
        private static final String URL = "https://soundcloud.com/";

        @FindBy(id = "onetrust-accept-btn-handler")
        private WebElement CookiesButton;
        @FindBy(xpath = "//div[@class=\"frontHero__signin\"]/button[1]")
        private WebElement SingInButton;
    public HomePageObject() {
        if (!URL.equals(driver.getCurrentUrl())){
            driver.get(URL);
            driver.manage().window().maximize();
        }
        PageFactory.initElements(new Decorator(driver), this);
    }
    public void SingIn(){
        CookiesButton.click();
        SingInButton.click();
    }
}
