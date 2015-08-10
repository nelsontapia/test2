package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Nelson Tapia on 8/9/2015.
 */
public abstract class LeadForm {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final String name_salutationlea2 = "name_salutationlea2";
    private static final String lead_Status = "lea13";
    //private String name_salutationlea2_option = "Mr.";

    @FindBy(id = name_salutationlea2)
    @CacheLookup
    private WebElement leadSalutation;

    @FindBy(id = "name_firstlea2")
    @CacheLookup
    private WebElement leadFirstName;

    @FindBy(id = "name_lastlea2")
    @CacheLookup
    private WebElement leadLastName;

    @FindBy(id = "lea3")
    @CacheLookup
    private WebElement leadCompany;

    @FindBy(id = lead_Status)
    @CacheLookup
    private WebElement leadStatus;

    @FindBy(id = "lea20_lkwgt")
    @CacheLookup
    private WebElement camplookupBtn;

    public LeadForm setLeadSalutation(String salutation) {
        wait.until(ExpectedConditions
                .visibilityOf(leadSalutation));

        Select select = new Select(driver.findElement(By.id(name_salutationlea2)));
        select.selectByVisibleText(salutation);
        return this;
    }

    public LeadForm setFirstNameLead(String newFirstName){
        leadFirstName.clear();
        leadFirstName.sendKeys(newFirstName);
        return this;
    }

    public LeadForm setSecondNameLead(String newSecondName){
        leadLastName.clear();
        leadLastName.sendKeys(newSecondName);
        return this;
    }

    public LeadForm setLeadCompany(String company){
        leadCompany.clear();
        leadCompany.sendKeys(company);
        return this;
    }

    public LeadForm setLeadStatus(String sLeadStatus) {
        wait.until(ExpectedConditions
                .visibilityOf(leadStatus));

        Select select = new Select(driver.findElement(By.id(lead_Status)));
        select.selectByVisibleText(sLeadStatus);
        return this;
    }

    public LeadForm clickCampLookup(){
        camplookupBtn.click();
        return this;
    }

}
