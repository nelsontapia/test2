import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Project {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://en.todoist.com/";

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 15);

        driver.get(baseUrl);

        wait.until(ExpectedConditions
                .elementToBeClickable(By.linkText("Login")));
        driver.findElement(By.linkText("Login")).click();

        wait.until(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt(By.className("GB_frame")));
        wait.until(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt("GB_frame"));

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("email")));
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("carledriss@gmail.com");

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("P@ssw0rd");

        wait.until(ExpectedConditions
                .elementToBeClickable(By.linkText("Login")));
        driver.findElement(By.linkText("Login")).click();

        driver.switchTo().defaultContent();
    }

    @Test
    public void testAddProject() throws Exception {
        String projectName = "My project";

        driver.findElement(By.linkText("Add Project")).click();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.name("ta")));
        driver.findElement(By.name("ta")).clear();
        driver.findElement(By.name("ta")).sendKeys(projectName);

        driver.findElement(By.xpath("//span[contains(.,'Add Project')]")).click();

        Assert.assertTrue(isElementPresent(By.xpath("//td[@class='name' and contains(., '" + projectName + "')]")));
    }

    @Test
    public void testEditProject() throws Exception {
        String projectName = "My project";
        String projectNameEdited = "My project Edited";

        WebElement projectElement = driver.findElement(By.xpath("//td[@class='name' and contains(., '" + projectName + "')]"));
        Action action = new Actions(driver)
                .contextClick(projectElement).build();
        action.perform();

        driver.findElement(By.xpath("//td[contains(.,'Edit project')]")).click();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.name("ta")));
        driver.findElement(By.name("ta")).clear();
        driver.findElement(By.name("ta")).sendKeys(projectNameEdited);

        driver.findElement(By.linkText("Save")).click();

        Assert.assertTrue(isElementPresent(By.xpath("//td[@class='name' and contains(., '" + projectName + "')]")));
    }

    @AfterClass
    public void tearDown() throws Exception {
//        driver.quit();
//        String verificationErrorString = verificationErrors.toString();
//        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
//        }
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
