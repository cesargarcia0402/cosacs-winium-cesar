package testUtils;

import com.unicomer.utils.Wait;
import org.hamcrest.core.IsNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CesarCommonAcc {

    public void enterValueToInput(String text, String elementId, WebDriver driver, String key) {

        WebElement element = driver.findElement(By.id(elementId));
        element.sendKeys(text);

        if (!(key == null || key.isEmpty())) {
            try {
                Robot robot = new Robot();
                switch (key.toUpperCase()) {
                    case "ENTER":
                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                        break;
                    case "TAB":
                        robot.keyPress(KeyEvent.VK_TAB);
                        robot.keyRelease(KeyEvent.VK_TAB);
                        break;
                    // Otros casos según sea necesario
                    default:
                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                }
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }

    //drpCashLoanPurpose
    public void valueSelect(String text, String elementId, WebDriver driver){
        WebElement element = driver.findElement(By.id(elementId));

        // Hacer clic en el cuadro combinado para abrir las opciones
        element.click();

        Wait.to(1);

        // Realizar la búsqueda en el cuadro combinado (en este ejemplo, se busca "ItemToSelect")
        element.findElement(By.name(text)).click();
    }
    //btnDisburse
    public void clickOnElement(String elementId, WebDriver driver) {
        driver.findElement(By.id(elementId)).click();
    }

    public void clickOnElementByName(String elementId, WebDriver driver) {
        driver.findElement(By.name(elementId)).click();
    }

    public void moveMouse(String elementId, WebDriver driver){
        WebElement mainTabControl = driver.findElement(By.id(elementId));

        // Utiliza Actions para mover el mouse
        Actions actions = new Actions(driver);
        actions.moveToElement(mainTabControl).build().perform();
    }

    public static void keyPressRobot(String key, int iterations) {
        try {
            Robot robot = new Robot();
            int keyCode;

            switch (key.toUpperCase()) {
                case "ENTER":
                    keyCode = KeyEvent.VK_ENTER;
                    break;
                case "TAB":
                    keyCode = KeyEvent.VK_TAB;
                    break;
                case "LEFT":
                    keyCode = KeyEvent.VK_LEFT;
                    break;
                case "DOWN":
                    keyCode = KeyEvent.VK_DOWN;
                    break;
                // Otros casos según sea necesario
                default:
                    keyCode = KeyEvent.VK_ENTER;
            }

            for (int i = 0; i < iterations; i++) {
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
                Wait.to(1);
            }

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }


}
