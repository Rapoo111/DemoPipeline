package com.bk_automation_testNG_prototype.testScripts.loginPage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bk_automation_testNG_prototype.helper.assertion.AssertionHelper;
import com.bk_automation_testNG_prototype.helper.browserconfiguration.config.ObjectReader;
import com.bk_automation_testNG_prototype.pageObject.QscSignInPage;
import com.bk_automation_testNG_prototype.pageObject.SignUpPage;
import com.bk_automation_testNG_prototype.testbase.TestBase;

public class Qsc_SignIn_SuccessTest extends TestBase{
	
	
	@Test(description = "SignIn into QSC staging website with valid credentials")
	public void SignIn_SuccessfullTest() throws InterruptedException, IOException {
		
		QscSignInPage signInPage = new QscSignInPage(driver);
		boolean landedOnSignInPage = signInPage.landOnSignInPage();
		if(landedOnSignInPage) {
			signInPage.signIntoQscApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
			boolean successfullSignIn = signInPage.verifySuccessfullSignIn();
			if(successfullSignIn) {
				AssertionHelper.updateTestStatus(successfullSignIn);
				test.log(Status.INFO, "TestCase - SignIn Passed");
			} else {
				AssertionHelper.updateTestStatus(successfullSignIn);
			}
		} else {
			AssertionHelper.updateTestStatus(landedOnSignInPage);
		}
		
	}

}
