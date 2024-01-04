package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;
import testUtils.CesarCommonAcc;

import java.util.List;

public class PaymentsPage extends CesarCommonAcc {
    //Login
    static String TXT_CUSTOMER_ID = "txtCustId";
    static String SELECT_PURPOSE = "drpCashLoanPurpose";
    static String BTN_DISBURSEMENT = "btnDisburse";
    static String BTN_PRINT_RECEIPT = "btnPrintReceipt";
    WiniumDriver driver;

    public PaymentsPage(WiniumDriver driver){
        this.driver = driver;
    }

    public void typeCustomerId(String customerId, String key){

        //valueSelect("Education", "drpCashLoanPurpose", driver);
        //TAB
        enterValueToInput(customerId, TXT_CUSTOMER_ID, driver, key);
    }
    public void selectPurposeCashLoan(String purpose){
        //"ENTER")
        valueSelect(purpose, SELECT_PURPOSE, driver);
    }

    public void clickBtnDisbursement(){
        clickOnElement(BTN_DISBURSEMENT, driver);
    }

    //btnPrintReceipt
    public void clickBtnPrintReceipt(){
        clickOnElement(BTN_PRINT_RECEIPT, driver);
    }
    public void validateDialog(String elementId){
        // Localiza todos los elementos con AutomationId "5"
        List<WebElement> botonesOmitir = driver.findElements(By.id("5"));

        if (!botonesOmitir.isEmpty()) {
            WebElement botonOmitir = botonesOmitir.get(0);

            botonOmitir.click();
        } else {
            System.out.println("El botón 'Omitir' no fue encontrado.");
        }
    }

    public void errorMessage(){
        // Localiza todos los elementos con AutomationId "5"
        List<WebElement> botonesOmitir = driver.findElements(By.id("65535"));

        if (!botonesOmitir.isEmpty()) {
            WebElement botonOmitir = botonesOmitir.get(0);

            // Hacer clic en el botón
            botonOmitir.click();
        } else {
            System.out.println("El botón 'Omitir' no fue encontrado.");
        }
    }

    public void okMessage(){
        // Localiza el elemento por su nombre
        WebElement elemento = driver.findElement(By.name("Loan disbursed"));

        String textoActual = elemento.getAttribute("name");

        String textoEsperado = "Loan disbursed";

        Assert.assertEquals(textoEsperado, textoActual);
    }
}
