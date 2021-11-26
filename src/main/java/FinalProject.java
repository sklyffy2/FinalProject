import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class FinalProject {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void Login() throws Exception {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("qazwsx1234");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("kibosav861@ingfix.com");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(dependsOnMethods = "Login")
    public void WomenCategory() throws Exception {

        driver.findElement(By.xpath("//a[@title='Women']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement Women = driver.findElement(By.xpath("//span[@class='cat-name']"));
        Assert.assertTrue(Women.isDisplayed());

    }

    @Test(dependsOnMethods = "WomenCategory")
    public void SelectItem() throws Exception {
        driver.findElement(By.xpath("//a[normalize-space()='Faded Short Sleeve T-shirts']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement FadedTshirt = driver.findElement(By.xpath("//h1[contains (text(),'Faded Short Sleeve')]"));
        Assert.assertTrue(FadedTshirt.isDisplayed());
    }

    @Test(dependsOnMethods = "SelectItem")
    public void AddToCart() throws Exception {
        driver.findElement(By.xpath("//span[normalize-space()='Add to cart']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[normalize-space()='Proceed to checkout']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @Test(dependsOnMethods = "SelectItem")
    public void ContinueShopping() throws Exception {
        driver.findElement(By.xpath("//a[@title='Continue shopping']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement FadedTshirt = driver.findElement(By.xpath("//h1[contains (text(),'Faded Short Sleeve')]"));
        Assert.assertTrue(FadedTshirt.isDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.close();
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


