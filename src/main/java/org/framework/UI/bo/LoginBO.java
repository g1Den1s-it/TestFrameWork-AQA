package org.framework.UI.bo;

import org.framework.UI.po.LoginPageObject;
import org.testng.Assert;
import org.framework.UI.po.HomePageObject;

public class LoginBO {

    public LoginBO SingIn() throws InterruptedException {
        HomePageObject homePageObject = new HomePageObject();
        homePageObject.SingIn();

        LoginPageObject loginPageObject = new LoginPageObject();
        loginPageObject.inputEmail("aqa.sound.test@gmail.com");
        loginPageObject.inputPassword("JC6Z8vo&78UK");

        return this;
    }

}
