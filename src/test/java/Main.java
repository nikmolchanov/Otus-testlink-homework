import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class Main {
    private WebDriver driver;
    private String baseUrl;
    private String projectname;
    private String testcasePrefix;



    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "http://192.168.64.2/login.php"; //мое приложение на macos почему-то сгенерило такой айпишник, локалхлост ни в какую
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        projectname = "OtusProject" + (timestamp.getTime());// генерируем название проекта
        testcasePrefix =  "TC" + (timestamp.getNanos());// генерируем префикс тесткейсов

    }

    @Test
    public void test() throws Exception {
        driver.get(baseUrl);
        authorization("user", "bitnami");
        driver.switchTo().frame(1);
        driver.findElement(By.linkText("Test Project Management")).click();
        driver.findElement(By.id("create")).click();
        driver.findElement(By.name("tprojectName")).click();
        driver.findElement(By.name("tprojectName")).clear();
        driver.findElement(By.name("tprojectName")).sendKeys(projectname);
        driver.findElement(By.name("tcasePrefix")).click();
        driver.findElement(By.name("tcasePrefix")).clear();
        driver.findElement(By.name("tcasePrefix")).sendKeys(testcasePrefix);
        driver.findElement(By.name("doActionButton")).click();
        System.out.println("Успешно");

    }
    //Авторизация в testlink
    private void authorization(String login, String password) {
        driver.findElement(By.id("tl_login")).click();
        driver.findElement(By.id("tl_login")).sendKeys(login);
        driver.findElement(By.id("tl_password")).click();
        driver.findElement(By.id("tl_password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }
}