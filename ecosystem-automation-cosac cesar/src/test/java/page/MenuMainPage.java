package page;

import org.openqa.selenium.winium.WiniumDriver;
import testUtils.CesarCommonAcc;

import static com.unicomer.constants.SystemConstants.*;

public class MenuMainPage extends CesarCommonAcc {
    static String MAIN_TAB_CONTROL = "MainTabControl";
    static String MENU_CONTROL = "menuControl1";
    WiniumDriver driver;

    public MenuMainPage(WiniumDriver driver){
        this.driver = driver;
    }

    public void clickOnMenuControl(){
        clickOnElementByName(MENU_CONTROL, driver);
    }

    public void moveMouseRobot(){
        moveMouse(MAIN_TAB_CONTROL, driver);
    }
    public void selectSection(String section){

        int iterations;

        switch (section.toUpperCase()) {
            case MENU_WAREHOUSE:
                iterations = 0;
                keyPressRobot(KEY_LEFT, iterations);
                break;
            case MENU_SERVICE:
                iterations = 1;
                keyPressRobot(KEY_LEFT, iterations);
                break;
            case MENU_TRANSACTIONS:
                iterations = 2;
                keyPressRobot(KEY_LEFT, iterations);
                break;
            case MENU_CREDIT:
                iterations = 3;
                keyPressRobot(KEY_LEFT, iterations);
                break;
            case MENU_CUSTOMER:
                iterations = 4;
                keyPressRobot(KEY_LEFT, iterations);
                break;
            default:
                iterations = 0;
                keyPressRobot(KEY_LEFT, iterations);
        }

    }

    public void selectSubsection(int position) {
        keyPressRobot(KEY_DOWN, position);
    }

    public void enterSubsection(int quantity) {
        keyPressRobot(KEY_ENTER, quantity);
    }


}
