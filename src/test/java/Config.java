import org.openqa.selenium.WebDriver;

public class Config {
    protected WebDriver driver;
    public String host = "http://192.168.64.2/login.php"; //мое приложение на macos почему-то сгенерило такой айпишник, локалхлост ни в какую"
    //private static final String host1 = "http://localhost:8080/testlink/index.php";
    public String login = "user";
    public String password = "bitnami";
    public String nameTestSuite_1 = "test Suite 1";
    public String nameCasePrefix = "otus_";

    public Config(WebDriver driver) {

        this.driver = driver;
    }

    public Config() {
    }
}


