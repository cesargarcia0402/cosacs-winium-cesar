package stepDefinitions;

import com.unicomer.constants.SystemConstants;
import com.unicomer.utils.ConstantReader;
import com.unicomer.utils.UtilsManager;
import com.unicomer.utils.Wait;
import io.cucumber.java.Before;
import io.cucumber.java.da.Men;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import page.PaymentsPage;
import page.LoginPage;
import page.MenuMainPage;

import java.net.MalformedURLException;
import java.net.URL;

import static com.unicomer.constants.SystemConstants.*;

public class PaymentsSD {

    static String username, password;
    String cosacsPath = "C:\\Users\\cesar_garciaa\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Blue Bridge Solutions, Ltd\\";
    String urlLocal = SystemConstants.COSACS_PROTOCOL+ UtilsManager.getHostname() +SystemConstants.COSACS_PORT;
    WiniumDriver driver;
    DesktopOptions option = new DesktopOptions();

    // valores
    static String customerId = "JMJd000210";
    static String purpose = "Education";

    @Before
    public void setUp() throws MalformedURLException {
        String path = cosacsPath+SystemConstants.COSACS_APP_NAME;
        option.setApplicationPath(path);
        driver = new WiniumDriver(new URL(urlLocal), option);
    }
    @Given("the user login in Cosacs")
    public void Login() {

        LoginPage loginPage = new LoginPage(driver);

        getUsernamePassword();
        loginPage.typeUser(username);
        loginPage.typePassword(password, KEY_ENTER);

        // loginPage.pressEnter();
        Wait.to(20);

    }
    private void getUsernamePassword(){
        ConstantReader.getInstance().setEnv();
        username = ConstantReader.getInstance().getProperties(SystemConstants.COSACS_USERNAME);
        password = ConstantReader.getInstance().getProperties(SystemConstants.COSACS_PASSWORD);

    }


    @When("the user selects the customer menu")
    public void selectOption(){
        MenuMainPage menuMainPage = new MenuMainPage(driver);

        menuMainPage.clickOnMenuControl();
        Wait.to(2);
        menuMainPage.moveMouseRobot();
        Wait.to(2);
        menuMainPage.selectSection(MENU_CUSTOMER);
        Wait.to(2);
        menuMainPage.selectSubsection(9);
        Wait.to(2);
        menuMainPage.enterSubsection(1);
        Wait.to(2);
    }

    @Then("should complete the disbursement")
    public void paymentsCustomer(){
        PaymentsPage paymentsPage = new PaymentsPage(driver);

        paymentsPage.typeCustomerId(customerId, KEY_TAB);
        Wait.to(7);
        paymentsPage.selectPurposeCashLoan(purpose);
        Wait.to(1);
        paymentsPage.clickBtnDisbursement();
        Wait.to(2);
        paymentsPage.validateDialog("5");
        Wait.to(5);
        paymentsPage.clickBtnPrintReceipt();
        Wait.to(5);
        paymentsPage.validateDialog("5");
        Wait.to(5);
        paymentsPage.validateDialog("5");
        Wait.to(5);
        paymentsPage.okMessage();
        //disbursePage.errorMessage();
    }
}
