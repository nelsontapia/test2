package tests;

import org.junit.Test;
import pages.*;


/**
 * Created by Carlos Gonzales on 7/27/2015.
 */
public class AddProject {

    private MainApp mainApp;
        @Test
        public void setUp() {
            LoginHomePage loginHomePage = new LoginHomePage();
            MainApp mainApp = loginHomePage.setUserNameTxt("nelsontb@gmail.com")
                    .setPasswordTxt("Hercules73")
                    .clickLoginBtn();
            //mainApp.goToBarMenu();
            TopBarMenu topBarMenu = mainApp.goToBarMenu();
            CampaignHome campaignHomePage = topBarMenu.clickTabCampains();
            campaignHomePage.clickNew();

            CreateNewCampaign newCampaign = mainApp.goToCreateNewCampaign();
            newCampaign.setCampaignName("MyCamp");
            newCampaign.saveBtnClick();


            TopBarMenu topBarMenu1 = mainApp.goToBarMenu();
            LeadHome leadHomePage = topBarMenu1.clickTabLead();
            leadHomePage.clickNew();

            CreateNewLead newLead = mainApp.goToCreateNewLead();

            newLead.setFirstNameLead("Nelson");
            newLead.setSecondNameLead("Tapia");
            newLead.setLeadSalutation("Mr.");
            newLead.setLeadCompany("CompanyTest");
            newLead.setLeadStatus("Closed - Converted");
            newLead.saveBtnClick();

        }

}
