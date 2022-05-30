package com.bk_automation_testNG_prototype.testScripts.loginPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bk_automation_testNG_prototype.helper.assertion.AssertionHelper;
import com.bk_automation_testNG_prototype.helper.excel.ExcelHelper;
import com.bk_automation_testNG_prototype.helper.wait.WaitHelper;
import com.bk_automation_testNG_prototype.pageObject.DoctorHomePage;
import com.bk_automation_testNG_prototype.pageObject.HospitalHomePage;
import com.bk_automation_testNG_prototype.pageObject.NidaanLoginPage;
import com.bk_automation_testNG_prototype.pageObject.PatientHomePage;
import com.bk_automation_testNG_prototype.pageObject.SignUpPage;
import com.bk_automation_testNG_prototype.testbase.TestBase;

public class NidaanLoginTest extends TestBase{
	
	@DataProvider(name="testData")
	public String[][] readValidTestData(){
		//String [][] data =  getExcelData("LoginData");
		String [][] data =  getExcelData("NidaanTestData.xlsx","LoginData");
		return data;
	}
	
	@DataProvider(name="InvalidtestData")
	public String[][] readInvalidTestData(){
		//String [][] data =  getExcelData("InvalidLoginData");
		String [][] data =  getExcelData("NidaanTestData.xlsx","LoginData");
		return data;
	}
	
	@Test(dataProvider="testData", priority = 1, description = "Login with valid credentials")
	public void verifyLogin_ValidCredentials(String userType,String username, String password) {
		NidaanLoginPage login = new NidaanLoginPage(driver);
		DoctorHomePage doctor = new DoctorHomePage(driver);
		login.landOnLoginPage();
		
		switch(userType) {
		
		case "Patient" : login.loginIntoApplication(username, password);
						 AssertionHelper.updateTestStatus(new PatientHomePage(driver).landOnPatientHomePage());
						 break; 
			
		case "Doctor" :  login.loginIntoApplication(username, password);
						 login.doctorProfile.click();
						 if(new DoctorHomePage(driver).landOnDoctorHomePage()) {
							 doctor.navigateToMyDashboard();
						 }
						 AssertionHelper.updateTestStatus(new DoctorHomePage(driver).landOnDoctorHomePage());
						 break;
			
		case "Hospital" : login.loginIntoApplication(username, password);
						  AssertionHelper.updateTestStatus(new HospitalHomePage(driver).landOnHospitalHomePage());
						  break;
			
		}
		
	}
	
	
	//@Test(dataProvider="InvalidtestData", priority = 1, description = "Login with valid credentials")
	public void verifyLogin_InValidCredentials(String userType,String username, String password) {
		NidaanLoginPage login = new NidaanLoginPage(driver);
		login.landOnLoginPage();
		WaitHelper waitHelper =  new WaitHelper(driver);
		switch(userType) {
		
		case "Patient" : login.loginIntoApplication(username, password);
						 waitHelper.waitForElement(login.loginError, 10);
						 //AssertionHelper.updateTestStatus(login.verifyFailLogin());
						 AssertionHelper.updateTestStatus(new PatientHomePage(driver).landOnPatientHomePage());
						 break; 
			
		case "Doctor" :  login.loginIntoApplication(username, password);
					     waitHelper.waitForElement(login.loginError, 10);
						 //AssertionHelper.updateTestStatus(login.verifyFailLogin());
						 AssertionHelper.updateTestStatus(new PatientHomePage(driver).landOnPatientHomePage());
						 break;
			
		case "Hospital" : login.loginIntoApplication(username, password);
						  waitHelper.waitForElement(login.loginError, 10);
						  //AssertionHelper.updateTestStatus(login.verifyFailLogin());
						  AssertionHelper.updateTestStatus(new PatientHomePage(driver).landOnPatientHomePage());
						  break;
			
		}
		
	}
	

}
