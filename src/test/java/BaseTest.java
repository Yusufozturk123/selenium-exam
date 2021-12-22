import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver;
    Exam exam;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\IdeaProjects\\selenium-exam\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.beymen.com/");
        driver.manage().window().maximize();
        exam = new Exam(driver);
     }

    @After
    public void tearDown(){
        driver.quit();
        System.out.println("test tamamlandi.");
    }
}
