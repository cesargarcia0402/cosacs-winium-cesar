import com.unicomer.constants.SystemConstants;
import com.unicomer.utils.UtilsManager;
import com.unicomer.utils.Wait;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import testUtils.CesarCommonAcc;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CosacWin extends CesarCommonAcc {

    static String cosacsPath = "C:\\Users\\cesar_garciaa\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Blue Bridge Solutions, Ltd\\";


    public WebElement waitForElementPresence(WebDriver driver, By by, int timeoutInSeconds) {
        WebElement element = null;
        int attempts = 0;
        while (attempts < timeoutInSeconds) {
            try {
                element = driver.findElement(by);
                break;
            } catch (Exception e) {
                // Manejar excepciones según sea necesario
            }
            attempts++;
            try {
                Thread.sleep(1000); // Espera 1 segundo antes de volver a intentar
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return element;
    }
    @Test
    public void testingCosac() throws MalformedURLException, AWTException {
        String path = cosacsPath+SystemConstants.COSACS_APP_NAME;
        String urlLocal = SystemConstants.COSACS_PROTOCOL+ UtilsManager.getHostname() +SystemConstants.COSACS_PORT;

        DesktopOptions option = new DesktopOptions();
        option.setApplicationPath(path);

        WiniumDriver driver = new WiniumDriver(new URL(urlLocal), option);
        Wait.to(2);

        enterValueToInput("cesar.garcia", "txtUser", driver,"TAB");
        enterValueToInput("HolaMundo04$$", "txtPassword", driver, "ENTER");

        Wait.to(40);


        System.out.println("Paso 1");
        WebElement thirdMenuItem1 = driver.findElementByXPath("//*[@name='menuControl1']");

        thirdMenuItem1.click();
        Wait.to(2);

        moveMouse("MainTabControl", driver);
        Wait.to(2);

        keyPressRobot("LEFT", 2);
        Wait.to(2);
        keyPressRobot("DOWN", 3);
        Wait.to(2);

        keyPressRobot("ENTER", 1);
        Wait.to(30);


        WebElement abcd = driver.findElement(By.name("Línea abajo"));
        try {
            System.out.println("try");
            Actions actions = new Actions(driver);
            actions.moveToElement(abcd).click().perform();
            Wait.to(2);
            actions.moveToElement(abcd).click().perform();

        } catch (Exception e) {
            System.out.println("catch");
            e.printStackTrace();
        }


        Wait.to(5);


    }

}
