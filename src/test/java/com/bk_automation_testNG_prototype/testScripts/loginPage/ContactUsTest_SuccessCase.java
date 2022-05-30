package com.bk_automation_testNG_prototype.testScripts.loginPage;

import org.testng.annotations.Test;

import com.bk_automation_testNG_prototype.helper.assertion.AssertionHelper;
import com.bk_automation_testNG_prototype.pageObject.Bk_ContactUsPage;
import com.bk_automation_testNG_prototype.testbase.TestBase;

public class ContactUsTest_SuccessCase extends TestBase {
	
	@Test
	public void fillContactInformation_PositiveCase() throws InterruptedException {
		
		Bk_ContactUsPage contactPage = new Bk_ContactUsPage(driver);
		
		contactPage.landOnContactUsPage();
		
		contactPage.fillContactInformationPage();
		
		AssertionHelper.updateTestStatus(contactPage.navigatedToThankYouPage());
		
		
	}

}
