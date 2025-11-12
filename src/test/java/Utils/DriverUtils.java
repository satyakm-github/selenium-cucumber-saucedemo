package Utils;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtils {

    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Browser started successfully");
    }

//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//            System.out.println("Browser closed");
//        }
//    }

}
