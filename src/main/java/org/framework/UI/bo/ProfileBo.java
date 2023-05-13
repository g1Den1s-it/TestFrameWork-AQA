package org.framework.UI.bo;

import org.framework.UI.po.AlbumPageObject;
import org.framework.UI.po.HomePageObject;
import org.framework.UI.po.MusicPageObject;
import org.framework.UI.po.ProfilePageObject;

public class ProfileBo {

    public ProfileBo showListLike() throws InterruptedException {
        ProfilePageObject profilePageObject = new ProfilePageObject();
        profilePageObject.goToProfile();

        HomePageObject homePageObject = new HomePageObject();
        homePageObject.goToHome();
        homePageObject.clickAlbum();

        AlbumPageObject albumPageObject = new AlbumPageObject();
        albumPageObject.LikeSomeMusic();

        MusicPageObject musicPageObject = new MusicPageObject();
        musicPageObject.likeMusic();

        return this;
    }
}
