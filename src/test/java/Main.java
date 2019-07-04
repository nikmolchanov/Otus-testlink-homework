import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main extends Config  {


    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void test() {

        Actions actions = new Actions(driver);
        actions.OpenPage();
        actions.Login();
        actions.CreateProject();

        actions.OpenTestSpecification();
        actions.CreateTestSuite();
        actions.CreateTestCase();

    }


    @After
    public void finish() {
        // driver.quit();
    }
}