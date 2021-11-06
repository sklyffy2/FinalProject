import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FinalProject {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testFinalproject() throws Exception {
        // Label: Test
        // ERROR: Caught exception [ERROR: Unsupported command [resizeWindow | 1920,969 | ]]
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("qazwsx1234");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("kibosav861@ingfix.com");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
        driver.findElement(By.cssSelector("a.sf-with-ul")).click();
        driver.findElement(By.linkText("T-shirts")).click();
        driver.findElement(By.id("layered_id_feature_5")).click();
        driver.findElement(By.id("layered_id_attribute_group_3")).click();
        driver.findElement(By.cssSelector("a.button.lnk_view.btn.btn-default > span")).click();
        driver.findElement(By.id("view_scroll_right")).click();
        driver.findElement(By.cssSelector("span.span_link.no-print")).click();
        driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
        driver.findElement(By.id("group_1")).click();
        new Select(driver.findElement(By.id("group_1"))).selectByVisibleText("L");
        driver.findElement(By.id("color_14")).click();
        driver.findElement(By.cssSelector("button[name=\"Submit\"] > span")).click();
        driver.findElement(By.cssSelector("span.continue.btn.btn-default.button.exclusive-medium > span")).click();
        driver.findElement(By.cssSelector("div.breadcrumb.clearfix > a[title=\"Tops\"]")).click();
        driver.findElement(By.linkText("Delivery")).click();
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("shirt");
        driver.findElement(By.name("submit_search")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}


