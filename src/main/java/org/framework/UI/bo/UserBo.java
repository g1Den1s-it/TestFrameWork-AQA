package org.framework.UI.bo;

import org.framework.UI.po.HomePageObject;

public class UserBo {
    public void getPlaylistAndAddMusic() throws InterruptedException {
        Thread.sleep(5000);
        HomePageObject homePageObject = new HomePageObject();

        homePageObject.createPlaylist();
        Thread.sleep(1000);
        homePageObject.search("Whispers in the Dark");
        homePageObject.addMusic();
        homePageObject.showLikesSongs();
    }
}
