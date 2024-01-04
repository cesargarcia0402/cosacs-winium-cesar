import com.unicomer.constants.SystemConstants;
import com.unicomer.utils.ConstantReader;
import com.unicomer.utils.UtilsManager;
import com.unicomer.utils.Wait;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import page.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

public class CosacPOM {

    static String username, password;
    String cosacsPath = "C:\\Users\\walther\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Blue Bridge Solutions, Ltd\\";
    String urlLocal = SystemConstants.COSACS_PROTOCOL+ UtilsManager.getHostname() +SystemConstants.COSACS_PORT;
    DesktopOptions option = new DesktopOptions();
    static String keyLogin = "ENTER";

    @Before
    public void setUp(){
        String path = cosacsPath+SystemConstants.COSACS_APP_NAME;
        option.setApplicationPath(path);
    }
    @Test
    public void testWithPOM() throws MalformedURLException {
        WiniumDriver driver = new WiniumDriver(new URL(urlLocal), option);
        LoginPage loginPage = new LoginPage(driver);

        getUsernamePassword();
        loginPage.typeUser(username);
        loginPage.typePassword(password, keyLogin);

       // loginPage.pressEnter();
        Wait.to(4);

    }
    private void getUsernamePassword(){
        ConstantReader.getInstance().setEnv();
        username = ConstantReader.getInstance().getProperties(SystemConstants.COSACS_USERNAME);
        password = ConstantReader.getInstance().getProperties(SystemConstants.COSACS_PASSWORD);

    }

}

