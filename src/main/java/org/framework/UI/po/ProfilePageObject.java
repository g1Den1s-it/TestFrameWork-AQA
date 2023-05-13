package org.framework.UI.po;

import org.framework.UI.wrappers.Decorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.framework.Drivers.DriverHelper.driver;

public class ProfilePageObject {

    @FindBy(xpath = "//div[@class=\"header__userNav\"]/a[1]")
    private WebElement slideBar;
    @FindBy(xpath = "//a[@class=\"headerMenu__link profileMenu__profile\"]")
    private WebElement profileLink;
    @FindBy(xpath = "//a[@class=\"headerMenu__link profileMenu__likes\"]")
    private WebElement likes;
    public ProfilePageObject() {
        PageFactory.initElements(new Decorator(driver), this);
    }

    public void goToProfile() throws InterruptedException {
        slideBar.click();
        profileLink.click();
        Thread.sleep(2000);
        slideBar.click();
        likes.click();
    }
}
