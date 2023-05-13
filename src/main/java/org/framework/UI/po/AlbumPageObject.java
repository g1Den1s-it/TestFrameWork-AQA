package org.framework.UI.po;

import org.framework.UI.wrappers.Decorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.framework.Drivers.DriverHelper.driver;

public class AlbumPageObject {
    @FindBy(xpath = "//button[@class=\"sc-button sc-button-cta sc-button-primary sc-button-medium\"]")
    private WebElement ok;
    @FindBy(xpath = "//button[@class=\"sc-button-like sc-button-secondary sc-button sc-button-medium sc-button-responsive\"]")
    private WebElement buttonLike;
    @FindBy(xpath = "//ul[@class=\"systemPlaylistTrackList__list sc-clearfix sc-list-nostyle\"]/li[2]/div/div[@class=\"trackItem__content sc-truncate\"]/a[2]")
    private WebElement music;

    public void LikeAlbum() throws InterruptedException {
        Thread.sleep(3000);
        if(ok.isDisplayed()){
            ok.click();
        }
        buttonLike.click();
    }
    public void LikeSomeMusic() throws InterruptedException {
        Thread.sleep(3000);
        if(ok.isDisplayed()){
            ok.click();
        }
        Thread.sleep(1000);
        music.click();
        Thread.sleep(1000);
    }

    public AlbumPageObject() {
        PageFactory.initElements(new Decorator(driver), this);
    }
}
