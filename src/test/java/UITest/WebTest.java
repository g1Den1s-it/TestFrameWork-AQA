package UITest;


import org.framework.Drivers.DriverHelper;
import org.framework.UI.bo.LoginBO;
import org.framework.UI.bo.UserBo;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTest {

    @BeforeTest
    public void setup(){
        DriverHelper.setup("chrome");
    }//firefox doesn't work

    @Test
    void EndToEnd() throws InterruptedException {
        LoginBO loginBO = new LoginBO();
        loginBO.SingIn();

        UserBo userBo = new UserBo();
        userBo.getPlaylistAndAddMusic();
    }

    @AfterTest
    public void finish(){
        DriverHelper.exit();
    }

}
