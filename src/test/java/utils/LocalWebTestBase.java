package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class LocalWebTestBase {

    public WebDriver driver;

    // Assumption made that this could be related to a web-based TestNG Project, hence the fake URL below
    String url = "https://www.ag_cell_number_validator.com/";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}