package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Nelson Tapia on 7/27/2015.
 */
public class MainApp {

    private WebDriver driver;
    private WebDriverWait wait;

    public MainApp(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public TopBarMenu goToBarMenu() {
        return new TopBarMenu(driver);
    }

    public LeadHome goToLeadHome(){
        return new LeadHome(driver);
    }

    public SetupLead goToSetupLead(){
        return new SetupLead(driver);
    }

    public CreateNewLead goToCreateNewLead(){
        return new CreateNewLead(driver);
    }

    public CreateNewCampaign goToCreateNewCampaign(){
        return new CreateNewCampaign(driver);
    }

    public CreateNewAccount goToCreateNewAccounts(){
        return new CreateNewAccount(driver);
    }
}
