package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Nelson Tapia on 8/9/2015.
 */
public class RecentLeads {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@name='new']")
    @CacheLookup
    private WebElement newLeadLink;

    public RecentLeads(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public SetupLead clickNew(){
        newLeadLink.click();
        return new SetupLead(driver);
    }
}
