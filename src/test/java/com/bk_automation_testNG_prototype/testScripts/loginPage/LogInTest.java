package com.bk_automation_testNG_prototype.testScripts.loginPage;

import org.testng.annotations.Test;

import com.bk_automation_testNG_prototype.helper.assertion.AssertionHelper;
import com.bk_automation_testNG_prototype.helper.browserconfiguration.config.ObjectReader;
import com.bk_automation_testNG_prototype.pageObject.LoginPage;
import com.bk_automation_testNG_prototype.testbase.TestBase;
/*
 * @author  Rishabh Jain
 *
 */
public class LogInTest extends TestBase {


	//@Test(priority = 0, description = "Login with valid credentials")
	public void LoginWithValidCredentials() {
		
		loginPage = new LoginPage(driver);
		loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		
		boolean status = loginPage.verifySuccessLogin();
		if(status)
		{
			loginPage.logout();
			status = loginPage.verifySuccessLogOut();
			AssertionHelper.updateTestStatus(status);
		}
		else
		{
			AssertionHelper.updateTestStatus(status);
		}	
	}

	

}