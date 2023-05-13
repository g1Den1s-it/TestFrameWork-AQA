package org.framework.UI.bo;

import org.testng.Assert;
import org.framework.UI.po.HomePageObject;

public class LoginBO {

    public LoginBO SingIn() throws InterruptedException {
        HomePageObject homePageObject = new HomePageObject();
        Thread.sleep(2000);
        homePageObject.SingIn();
        Thread.sleep(5000);
        Assert.assertTrue(homePageObject.isLogin());
        return this;
    }

}
