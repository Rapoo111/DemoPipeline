package com.bk_automation_testNG_prototype.testScripts.loginPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bk_automation_testNG_prototype.helper.assertion.AssertionHelper;
import com.bk_automation_testNG_prototype.pageObject.SignUpPage;
import com.bk_automation_testNG_prototype.testbase.TestBase;

public class SignUpTest extends TestBase{
	
	@DataProvider(name="testData")
	public String[][] readTestData(){
		String [][] data =  getExcelData("NidaanTestData.xlsx","SignUpData");
		return data;
	}
	
	@Test(dataProvider="testData", priority = 0, description = "Sign Up functionality for new user")
	public void verifySignUp(String mobileNumber, String firstName, String lastName, String dob, String accessCode, String email, String language) {
		
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.signUp.click();
		boolean landedOnSignUpPage = signUpPage.landOnSignUpPage();
		if(landedOnSignUpPage) {
			signUpPage.signUpIntoApplication(mobileNumber, firstName, lastName, dob, accessCode, email, language);
			boolean successfullSignUp = signUpPage.verifySuccessfullSignUp();
			if(successfullSignUp) {
				AssertionHelper.updateTestStatus(successfullSignUp);
				test.log(Status.INFO, "TestCase - SignUp Passed");
			} else {
				AssertionHelper.updateTestStatus(successfullSignUp);
			}
		} else {
			AssertionHelper.updateTestStatus(landedOnSignUpPage);
		}
		
	}

}
