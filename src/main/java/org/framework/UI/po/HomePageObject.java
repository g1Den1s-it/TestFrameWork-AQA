package org.framework.UI.po;

import org.framework.UI.wrappers.Decorator;
import org.framework.UI.wrappers.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.framework.Drivers.DriverHelper.driver;

public class HomePageObject {
    private static final String URL = "https://open.spotify.com/";

    @FindBy(xpath = "//div[@class=\"LKFFk88SIRC9QKKUWR5u\"]/button[2]")
    private Element signInButton;
    @FindBy(xpath = "//ul/li[1]/button[1]")
    private Element googleButton;
    @FindBy(xpath = "//ul[@class=\"QuHe04rU4bj0Z5U9E2Tk\"]/li[2]/a")
    private Element search;
    @FindBy(xpath = "//input[@class=\"Type__TypeElement-sc-goli3j-0 eMzEmF QO9loc33XC50mMRUCIvf\"]")
    private  Element inputSearch;
    @FindBy(xpath = "//button[@class=\"Button-sc-1dqy6lx-0 jVhTjB ksmcxhImUuj3_s1lcIm0 OMCDc2F7g_AufJAtaKfL TxO7Ee8iwqBpkgznKHsd ufICQKJq0XJE5iiIsZfj caTDfb6Oj7a5_8jBLUSo vOp2HlcPkxOHebo3If32 eZnAGhYcXE4Bt0a7958z\"]")
    private Element createPlaylistButton;
    @FindBy(xpath = "//ul[@class=\"encore-dark-theme SboKmDrCTZng7t4EgNoM\"]/li[1]/button")
    private Element newPlaylist;
    @FindBy(xpath = "//div[@class=\"HkbHLcqgUfXruL5xVi28\"]")
    private Element music;
    @FindBy(xpath = "//button[@class=\"RbsCNNM9a0WkFCM2UzBA\"]")
    private Element like;
    @FindBy(xpath = "//div[@class=\"JUa6JJNj7R_Y3i4P8YUX\"]/div/li[1]//button[@class=\"RowButton-sc-xxkq4e-0 iQutdu\"]")
    private Element likesSongs;
    @FindBy(xpath = "//button[@class=\"Button-sc-1dqy6lx-0 drEYjZ encore-over-media-set Fxnb0xe6bL7I7W8V0p6C\"]")
    private Element profileButton;
    @FindBy(xpath = "//div[@class=\"RP2rRchy4i8TIp1CTmb7\"]")
    private Element likesSongsDiv;
    @FindBy(xpath = "//button[@class=\"RbsCNNM9a0WkFCM2UzBA control-button control-button-heart SPC4uzYXJmknkCGKpxHw\"]")
    private Element unLike;
    @FindBy(xpath = "//div[text()=\"Whispers in the Dark\"]/../../../..")
    private Element currentMusic;
    @FindBy(xpath = "//button[@class=\"onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon\"]")
    private Element cookies;


    public HomePageObject() {
        PageFactory.initElements(new Decorator(driver), this);
        if (!URL.equals(driver.getCurrentUrl())){
            driver.get(URL);
            driver.manage().window().maximize();
        }
    }
    public void SingIn(){
        signInButton.getWebElement().click();
        googleButton.getWebElementAndWait().click();
    }
    public void search(String music){
        search.getWebElementAndWaitBeClickable().click();
        inputSearch.getWebElementAndWait().sendKeys(music);
    }
    public void createPlaylist(){
        createPlaylistButton.getWebElementAndWait().click();
        newPlaylist.getWebElementAndWait().click();
    }
    public void addMusic(){
        music.getWebElementAndWait().click();
        like.getWebElementAndWaitBeClickable().click();
    }

    public void showLikesSongs() throws InterruptedException {
        Thread.sleep(2000);
        likesSongs.getWebElementAndWait().click();
    }
    public boolean isLogin(){
        return profileButton.getWebElement().isDisplayed();
    }
    public boolean isLikesSongs(){
        return likesSongsDiv.getWebElementAndWait().isDisplayed();
    }

    public void deleteMusic(String s) {
        currentMusic.getWebElementAndWait().click();

        currentMusic.getWebElement().click();
        cookies.getWebElement().click();

        unLike.getWebElementAndWaitBeClickable().click();
    }
}
