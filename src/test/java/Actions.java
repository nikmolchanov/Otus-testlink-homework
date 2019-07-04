import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;


public class Actions extends Setup {

    public Actions(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void OpenPage() {

        driver.navigate().to(host);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    public void  Login() {
        WebElements webElements = new WebElements(driver);
        waiting(webElements.loginName);

        webElements.loginName.clear();
        webElements.loginName.sendKeys(login);

        webElements.loginPassword.clear();
        webElements.loginPassword.sendKeys(password);

        webElements.buttonLogin.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public void OpenTestSpecification() {
        WebElements webElements = new  WebElements(driver);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        waiting(webElements.linkTestSpecification);
        webElements.linkTestSpecification.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public void CreateTestSuite() {
        WebElements webElements = new WebElements(driver);
        driver.switchTo().frame(1);
        waiting(webElements.buttonSettingProject);
        webElements.buttonSettingProject.click();

        waiting(webElements.buttonAddTestSuite);
        webElements.buttonAddTestSuite.click();

        waiting(webElements.inputTestSuiteName);
        webElements.inputTestSuiteName.clear();
        webElements.inputTestSuiteName.sendKeys("test5");
        webElements.buttonSaveTestSuite.click();

        waiting(webElements.buttonCancel);
        webElements.buttonCancel.click();
    }

    public void CreateTestCase() {
        WebElements webElements = new WebElements(driver);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.switchTo().frame("treeframe");

        driver.findElement(By.partialLinkText("test5")).click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.switchTo().frame("workframe");
        webElements.buttonSettingsSuite.click();

        waiting(webElements.buttonAddTestCase);
        webElements.buttonAddTestCase.click();

        waiting(webElements.inputNameTestCase);
        webElements.inputNameTestCase.clear();
        webElements.inputNameTestCase.sendKeys("test case 12");
        webElements.buttonSaveTestCase.click();

        CreateStep();

    }

    public void CreateProject() {

        WebElements webElements = new WebElements(driver);
//        driver.switchTo().frame(1);
//        webElements.buttonTestProjectManagement.click();
//        waiting(webElements.buttonCreateProject);
//        webElements.buttonCreateProject.click();
//        webElements.inputNameProject.clear();
//        webElements.inputNameProject.sendKeys("test qa 1");
//        webElements.inputPrefixProject.sendKeys("qa1");
//        webElements.buttonSaveProject.click();
        driver.switchTo().frame(0);
        webElements.selectTestproject.sendKeys("qa1:test qa 122");
    }

    public void ClickCreateStep() {
        WebElements webElements = new WebElements(driver);
        waiting(webElements.buttonCreateStep);
        webElements.buttonCreateStep.click();

    }

    public void CreateStep() {
        WebElements webElements = new WebElements(driver);
        waiting(webElements.buttonCreateStep);
        webElements.buttonCreateStep.click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.switchTo().frame("workframe");
        waiting(webElements.inputStep);
        driver.switchTo().frame(webElements.inputStep);
        driver.switchTo().activeElement().sendKeys("test qa test ");

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.switchTo().frame("workframe");
        driver.switchTo().frame(webElements.inputResult);
        driver.switchTo().activeElement().sendKeys("result test qa test ");

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.switchTo().frame("workframe");
        webElements.buttonSaveStep.click();

        // 2 шаг
        //  driver.switchTo().defaultContent();
        //  driver.switchTo().frame(1);
        // driver.switchTo().frame("workframe");
        // waiting(webElements.inputStep);
        // driver.switchTo().frame(webElements.inputStep);
        System.out.println(driver.switchTo().activeElement().getTagName());

    }
}
