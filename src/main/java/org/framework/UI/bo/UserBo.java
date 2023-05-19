package org.framework.UI.bo;

import org.framework.UI.po.HomePageObject;
import org.testng.Assert;

public class UserBo {
    private HomePageObject homePageObject = new HomePageObject();
    public void getPlaylistAndAddMusic() throws InterruptedException {
        Thread.sleep(5000);

        Assert.assertTrue(homePageObject.isLogin());

        homePageObject.createPlaylist();
        Thread.sleep(1000);



//
    }

    public void addPlaylist() throws InterruptedException {
        homePageObject.createPlaylist();
    }

    public void addMusicLike(String whispersInTheDark) throws InterruptedException {
        homePageObject.search("Whispers in the Dark");
        homePageObject.addMusic();
        homePageObject.showLikesSongs();
        Assert.assertTrue(homePageObject.isLikesSongs());
        Thread.sleep(5000);
    }

    public void likes() throws InterruptedException {
        homePageObject.showLikesSongs();
    }

    public void deleteMusic(String Music) {
        homePageObject.deleteMusic("Whispers in the Dark");
    }
}
