package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTestPOM{
	
	
	@Test
	public void verifyLogin() {
		
		lp.enterEmail(conf.getAdminUser());
		lp.enterPass(conf.getAdminPass());
        lp.clickCheckBox();
        lp.clickLoginButton();
		
	}
	
	
	@Test(priority = 2)
    public void verifyApplicationTitle() {
   lp.verifyAppTitle("Dashboard / nopCommerce administration");
    }



    @Test(priority = 3)
    public void verifyLogout() {
  lp.clickLogout();

    }



}
