package BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class Base {

    public static WebDriver driver;
    public static WebDriverWait wdwait;
    public ExcelReader excelReader;
    public String homepageURL;

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickElementJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
    }

    public void actionDoubleClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public void actionRightClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public void wait(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, 20);
        excelReader = new ExcelReader("C:\\Users\\Dragoljub\\IdeaProjects\\TPC1\\Data.xlsx");
        homepageURL = excelReader.getStringData("URL", 0, 1);

    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        //driver.close();
        //driver.quit();
    }

}
