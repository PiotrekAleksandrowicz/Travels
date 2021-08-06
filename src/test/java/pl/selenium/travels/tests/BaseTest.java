package pl.selenium.travels.tests;



import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.selenium.travels.utils.DriverFactory;

public class BaseTest implements ITestListener {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



}
