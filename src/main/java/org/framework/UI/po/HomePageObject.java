package org.framework.UI.po;

import org.framework.Drivers.DriverHelper;
import org.framework.UI.wrappers.Decorator;
import org.framework.UI.wrappers.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.framework.Drivers.DriverHelper.driver;

public class HomePageObject {
        private static final String URL = "https://soundcloud.com/";
        @FindBy(xpath = "//a[@class=\"header__navMenuItem sc-mr-1x selected\"]")
        private Element home;
        @FindBy(id = "onetrust-accept-btn-handler")
        private WebElement CookiesButton;
        @FindBy(xpath = "//div[@class=\"frontHero__signin\"]/button[1]")
        private WebElement SingInButton;
        @FindBy(xpath = "//div[@class=\"webAuthContainerWrapper\"]/iframe")
        private WebElement signWindow;
        @FindBy(xpath = "//div[@class=\"form-row\"]/button[@class=\"sc-button sc-button-large provider-button google-plus-signin sc-button-google\"]")
        private WebElement googleSignIn;
        @FindBy(id = "identifierId")
        private WebElement emailInput;
        @FindBy(xpath = "//button[@class=\"VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b\"]")
        private WebElement nextButton;
        @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
        private WebElement passwordInput;
        @FindBy(xpath = "//div[@class=\"header__userNav\"]")
        private WebElement userNav;
        @FindBy(xpath = "//div[@class=\"tileGallery__sliderPanel\"]/div[1]")
        private WebElement album;

    public HomePageObject() {
        if (!URL.equals(driver.getCurrentUrl())){
            driver.get(URL);
            driver.manage().window().maximize();
        }
        PageFactory.initElements(new Decorator(driver), this);
    }
    public void SingIn() throws InterruptedException {
        CookiesButton.click();
        SingInButton.click();
        Thread.sleep(2000);

        driver.switchTo().frame(signWindow);
        googleSignIn.click();

        //switch to a new window
        String currentWindowHandle = driver.getWindowHandle();
        for(String windowHandle : driver.getWindowHandles()){
            if(!windowHandle.equals(currentWindowHandle)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(2000);
        emailInput.sendKeys("aqa.sound.test@gmail.com");
        nextButton.click();
        Thread.sleep(2000);
        passwordInput.sendKeys("JC6Z8vo&78UK");
        nextButton.click();
        driver.switchTo().window(currentWindowHandle);
    }
    public boolean isLogin(){
        if(userNav.isDisplayed()){
            return true;
        }
        return false;
    }
    public void goToHome(){
        home.getWebElement().click();
    }
    public void clickAlbum(){
        album.click();
    }
}
