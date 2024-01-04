package stepDefinitions;

public class LoginSD {

   /* static String username, password;
    String cosacsPath = "C:\\Users\\Valencia-PC\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Blue Bridge Solutions, Ltd\\";
    String urlLocal = SystemConstants.COSACS_PROTOCOL+ UtilsManager.getHostname() +SystemConstants.COSACS_PORT;
    WiniumDriver driver;
    DesktopOptions option = new DesktopOptions();

    // valores
    static String customerId = "JMJd000207";
    static String purpose = "Education";
    static String keyLogin = "ENTER";
    static String keyTab = "TAB";


    @Before
    public void setUp() throws MalformedURLException {
        String path = cosacsPath+SystemConstants.COSACS_APP_NAME;
        option.setApplicationPath(path);
        driver = new WiniumDriver(new URL(urlLocal), option);
    }
    @Given("the user opens Cosacs")
    public void Login() {

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


    @When("the user into uat with the credentials")
    public void selectOption(){
        MenuMainPage menuMainPage = new MenuMainPage(driver);
        menuMainPage.selectSection("CUSTOMER");
        Wait.to(2);
        menuMainPage.selectSubsection(9);
        Wait.to(2);
        menuMainPage.enterSubsection(1);
        Wait.to(2);
    }

    @Then("should be visible menu")
    public void disburseCustomer(){
        DisbursePage disbursePage = new DisbursePage(driver);

        disbursePage.typeCustomerId(customerId, keyTab);
        Wait.to(7);
        disbursePage.selectPurposeCashLoan(purpose);
        Wait.to(1);
        disbursePage.clickBtnDisbursement();
        Wait.to(2);
        disbursePage.validateDialog("5");
        Wait.to(5);
        disbursePage.clickBtnPrintReceipt();
        Wait.to(5);
        disbursePage.okMessage();
    }*/
}
