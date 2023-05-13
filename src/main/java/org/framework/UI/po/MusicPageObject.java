package org.framework.UI.po;

import org.framework.UI.wrappers.Decorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.framework.Drivers.DriverHelper.driver;

public class MusicPageObject {
    @FindBy(xpath = "//div[@class=\"sc-button-group sc-button-group-medium\"]/button[1]")
    private WebElement buttonLike;
    public void likeMusic() throws InterruptedException {
        buttonLike.click();

    }
    public MusicPageObject() {
        PageFactory.initElements(new Decorator(driver), this);
    }
}
