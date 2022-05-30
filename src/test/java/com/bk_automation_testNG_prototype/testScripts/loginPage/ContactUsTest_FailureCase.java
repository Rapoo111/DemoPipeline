package com.bk_automation_testNG_prototype.testScripts.loginPage;

import org.testng.annotations.Test;

import com.bk_automation_testNG_prototype.helper.assertion.AssertionHelper;
import com.bk_automation_testNG_prototype.pageObject.Bk_ContactUsPage;
import com.bk_automation_testNG_prototype.testbase.TestBase;

public class ContactUsTest_FailureCase extends TestBase {

	
	@Test
	public void fillContactInformation_NegativeCase() throws InterruptedException {
		
		Bk_ContactUsPage contactPage = new Bk_ContactUsPage(driver);
		
		contactPage.landOnContactUsPage();
		contactPage.fillContactInformation();
		contactPage.waitForErrorMessage();
		
		AssertionHelper.updateTestStatus(contactPage.navigatedThankYouPage());
		
	}

}
