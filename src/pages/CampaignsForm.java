package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Nelson Tapia on 8/10/2015.
 */
public class CampaignsForm {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final String name_salutationlea2 = "name_salutationlea2";
    private static final String lead_Status = "lea13";
    //private String name_salutationlea2_option = "Mr.";

    @FindBy(id = "cpn1")
    @CacheLookup
    private WebElement campaignName;

/*
    @FindBy(id = "name_lastlea2")
    @CacheLookup
    private WebElement leadLastName;

    @FindBy(id = "lea3")
    @CacheLookup
    private WebElement leadCompany;

    @FindBy(id = lead_Status)
    @CacheLookup
    private WebElement leadStatus;
*/
/*
    public CampaignsForm setLeadSalutation(String salutation) {
        wait.until(ExpectedConditions
                .visibilityOf(leadSalutation));

        Select select = new Select(driver.findElement(By.id(name_salutationlea2)));
        select.selectByVisibleText(salutation);
        return this;
    }
    */

    public CampaignsForm setCampaignName(String campName){
        campaignName.clear();
        campaignName.sendKeys(campName);
        return this;
    }

    /*
    public CampaignsForm setSecondNameLead(String newSecondName){
        leadLastName.clear();
        leadLastName.sendKeys(newSecondName);
        return this;
    }

    public CampaignsForm setLeadCompany(String company){
        leadCompany.clear();
        leadCompany.sendKeys(company);
        return this;
    }

    public CampaignsForm setLeadStatus(String sLeadStatus) {
        wait.until(ExpectedConditions
                .visibilityOf(leadStatus));

        Select select = new Select(driver.findElement(By.id(lead_Status)));
        select.selectByVisibleText(sLeadStatus);
        return this;
    }
    */

}
