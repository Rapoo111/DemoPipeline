package com.bk_automation_testNG_prototype.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.bk_automation_testNG_prototype.helper.assertion.VerificationHelper;
import com.bk_automation_testNG_prototype.helper.logger.LoggerHelper;
import com.bk_automation_testNG_prototype.helper.wait.WaitHelper;
import com.bk_automation_testNG_prototype.testbase.TestBase;

public class PatientHomePage {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	
	WaitHelper waitHelper;
	
	@FindBy(xpath="//div[@id='divtiles']")
	public WebElement patientHomePage;
	
	@FindBy(linkText="Home")
	public WebElement homeTab;
	
	@FindBy(xpath="//span[@class='user-img']")
	public WebElement profileImage;
	
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Logout']")
	public WebElement logout;
	
	public PatientHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		TestBase.logExtentReport("Patient Home Page Object Created");
	}
	
	public boolean landOnPatientHomePage() {
		boolean landedOnPatientHomePage = false;
		VerificationHelper verificationHelper = new VerificationHelper(driver);
		waitHelper.waitForElement(homeTab,10);
		if(driver.getCurrentUrl().contains("Patient_Home") && (verificationHelper.isDisplayed(patientHomePage))) {
			landedOnPatientHomePage = true;
			logExtentReport("Landed on Patient Home Page");
		}
		return landedOnPatientHomePage;
	}
	
	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}
	
	
	
}


