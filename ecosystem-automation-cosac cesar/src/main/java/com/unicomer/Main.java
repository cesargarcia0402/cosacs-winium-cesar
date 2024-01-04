package com.unicomer;

import com.unicomer.constants.SystemConstants;
import com.unicomer.utils.UtilsManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    static String cosacsPath = "C:\\Users\\Valencia-PC\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Blue Bridge Solutions, Ltd\\";

    public static void  main(String[] args) throws InterruptedException, MalformedURLException {
        String path = cosacsPath+SystemConstants.COSACS_APP_NAME;
        String urlLocal = SystemConstants.COSACS_PROTOCOL+ UtilsManager.getHostname() +SystemConstants.COSACS_PORT;

        DesktopOptions option = new DesktopOptions();
        option.setApplicationPath(path);

        WiniumDriver driver = new WiniumDriver(new URL(urlLocal), option);
        Thread.sleep(1000);
        WebElement txtUsuario = driver.findElement(By.id("txtUser"));
        txtUsuario.sendKeys("kevin.valencia");

        WebElement txtClave = driver.findElement(By.id("txtPassword"));
        txtClave.sendKeys("Uholamundo12345$$");
        txtClave.submit();

        Thread.sleep(4000);
    }

}
