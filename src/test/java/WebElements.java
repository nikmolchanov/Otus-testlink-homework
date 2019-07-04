import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WebElements extends Setup {

    public WebElements(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath="//*[@id=\"tl_login\"]")
    public WebElement loginName;

    @FindBy (css = "#tl_password")
    public WebElement loginPassword ;

    @FindBy (xpath = "//*[@id=\"login\"]/div[3]")
    public WebElement buttonLogin;

    @FindBy(linkText = "Test Specification")
    public WebElement linkTestSpecification;

    @FindBy(className = "clickable")
    public  WebElement buttonSettingProject;

    @FindBy(xpath = "//*[@id=\"new_testsuite\"]")
    public WebElement buttonAddTestSuite;

    @FindBy(name = "container_name")
    public WebElement inputTestSuiteName;

    @FindBy(name = "add_testsuite_button")
    public WebElement buttonSaveTestSuite;

    @FindBy(name = "go_back")
    public WebElement buttonCancel;

    @FindBy(partialLinkText = "Test Project Management")
    public WebElement buttonTestProjectManagement;

    @FindBy(id = "create")
    public WebElement buttonCreateProject;

    @FindBy(name = "tprojectName")
    public WebElement inputNameProject;

    @FindBy(name = "tcasePrefix")
    public WebElement inputPrefixProject;

    @FindBy (name = "doActionButton")
    public WebElement buttonSaveProject;

    @FindBy(xpath = "/html/body/div[3]/div/form/select")
    public WebElement selectTestproject;

    @FindBy(xpath = "/html/body/div/img[2]")
    public WebElement buttonSettingsSuite;

    @FindBy(id = "create_tc")
    public  WebElement buttonAddTestCase;

    @FindBy(id = "testcase_name")
    public WebElement inputNameTestCase;

    @FindBy (id ="do_create_button")
    WebElement buttonSaveTestCase;

    @FindBy(name = "create_step")
    WebElement buttonCreateStep;

    @FindBy(xpath = "//div[@id='cke_1_contents']/iframe")
    public WebElement inputStep;

    @FindBy(xpath = "//div[@id='cke_2_contents']/iframe")
    public WebElement inputResult;

    @FindBy(id = "do_update_step")
    public WebElement buttonSaveStep;
}