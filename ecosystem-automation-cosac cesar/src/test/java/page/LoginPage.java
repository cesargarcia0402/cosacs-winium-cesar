package page;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.WiniumDriver;
import testUtils.CesarCommonAcc;

public class LoginPage extends CesarCommonAcc {

    //Login
    static String TXT_USER = "txtUser";
    static String TXT_PASSWORD = "txtPassword";
    WiniumDriver driver;

    public LoginPage(WiniumDriver driver){
        this.driver = driver;
    }

    public void typeUser(String user){

        enterValueToInput(user, TXT_USER, driver,"");
    }
    public void typePassword(String password, String key){
        //"ENTER")
        enterValueToInput(password, TXT_PASSWORD, driver, key) ;
    }
    public void pressEnter(){
        driver.findElement(By.id("txtPassword")).submit();
    }

}
