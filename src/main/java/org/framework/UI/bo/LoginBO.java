package org.framework.UI.bo;

import org.framework.UI.po.HomePageObject;

public class LoginBO {

    public LoginBO SingIn() throws InterruptedException {
        HomePageObject homePageObject = new HomePageObject();
        Thread.sleep(2000);
        homePageObject.SingIn();


        return this;
    }
}
