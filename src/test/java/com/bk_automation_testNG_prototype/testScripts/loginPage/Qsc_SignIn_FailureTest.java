package com.bk_automation_testNG_prototype.testScripts.loginPage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bk_automation_testNG_prototype.helper.assertion.AssertionHelper;
import com.bk_automation_testNG_prototype.helper.browserconfiguration.config.ObjectReader;
import com.bk_automation_testNG_prototype.pageObject.QscSignInPage;
import com.bk_automation_testNG_prototype.testbase.TestBase;

public class Qsc_SignIn_FailureTest extends TestBase {

	//@Test(description = "SignIn into QSC staging website with invalid credentials")
	public void SignIn_FailureTest() throws InterruptedException, IOException {

		QscSignInPage signInPage = new QscSignInPage(driver);
		
			signInPage.signIntoQscApplication_Failure(ObjectReader.reader.getInvalidUserName(), ObjectReader.reader.getInvalidPassword());
			//signInPage.verifyFailureMessage();
			AssertionHelper.updateTestStatus(signInPage.verifyFailureMessage());
			test.log(Status.INFO, "TestCase - SignIn Failed");


	}

}
