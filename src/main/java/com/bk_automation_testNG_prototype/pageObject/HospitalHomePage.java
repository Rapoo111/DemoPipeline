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

public class HospitalHomePage {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	
	WaitHelper waitHelper;
	
	@FindBy(linkText="Home")
	public WebElement homeTab;
	
	@FindBy(linkText="Doctors")
	public WebElement doctorsTab;
	
	@FindBy(linkText=" Contact Us")
	public WebElement contactUsTab;
	
	@FindBy(xpath="//label[normalize-space()='All consultations']")
	public WebElement allConsultationCheckbox;
	
	@FindBy(xpath="//span[@class='user-img']")
	public WebElement profileImage;
	
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Logout']")
	public WebElement logout;

	public HospitalHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		TestBase.logExtentReport("Hospital Home Page Object Created");
	}
	
	public boolean landOnHospitalHomePage() {
		boolean landedOnHospitalHomePage = false;
		VerificationHelper verificationHelper = new VerificationHelper(driver);
		waitHelper.waitForElement(homeTab,10);
		if(driver.getCurrentUrl().contains("Hospital_Home") && (verificationHelper.isDisplayed(homeTab))) {
			landedOnHospitalHomePage = true;
			logExtentReport("Landed on Hospital Home Page");
		}
		return landedOnHospitalHomePage;
	}
	
	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}
}
