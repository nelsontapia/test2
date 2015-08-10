package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Nelson Tapia on 7/27/2015.
 */
public class LoginHomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    @FindBy(id = "username")
    @CacheLookup
    private WebElement usernameTxt;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordTxt;

    @FindBy(id = "Login")
    @CacheLookup
    private WebElement loginBtn;

    public LoginHomePage() {
        driver = new FirefoxDriver();
        baseUrl = "http://login.salesforce.com/";
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
        driver.get(baseUrl);
        PageFactory.initElements(driver, this);
    }

    public LoginHomePage setUserNameTxt(String username) {
        try {
            wait.until(ExpectedConditions.visibilityOf(usernameTxt));
            usernameTxt.clear();
            usernameTxt.sendKeys(username);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return this;
    }

    public LoginHomePage setPasswordTxt(String password) {
        try {
            passwordTxt.clear();
            passwordTxt.sendKeys(password);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return this;
    }

    public MainApp clickLoginBtn() {
        try {
            wait.until(ExpectedConditions
                    .elementToBeClickable(loginBtn));
            loginBtn.click();
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return new MainApp(driver);
    }
}
