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

public class DoctorHomePage {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	
	WaitHelper waitHelper;
	
	
	@FindBy(xpath="//a[normalize-space()='Home']")
	public WebElement homeTab;
	
	@FindBy(id="ctl00_li_DoctorDashboard")
	public WebElement dashboardTab;
	
	@FindBy(xpath="//a[normalize-space()='My Dashboard']")
	public WebElement myDashboardSubmenu;
	
	@FindBy(xpath="//a[normalize-space()='Call Details']")
	public WebElement callDetailsSubMenu;
	
	@FindBy(xpath="//a[normalize-space()='Monitor Call']")
	public WebElement monitorCallSubMenu;
	
	@FindBy(linkText="My Services")
	public WebElement myServicesTab;
	
	@FindBy(xpath="//a[contains(text(),'Patient Reports')]")
	public WebElement patientReportsSubMenu;
	
	@FindBy(xpath="//a[contains(text(),'Add Prescription')]")
	public WebElement addPrescriptionSubMenu;
	
	@FindBy(xpath="//a[contains(text(),'View History')]")
	public WebElement viewHistorySubMenu;
	
	@FindBy(xpath="//a[contains(text(),'Patient Register')]")
	public WebElement patientRegisterSubMenu;
	
	@FindBy(xpath="//a[contains(text(),'Patient Services')]")
	public WebElement patientServicesSubMenu;
	
	@FindBy(xpath="//a[contains(text(),'Patient Flyer')]")
	public WebElement patientFlyerSubMenu;
	
	@FindBy(xpath="//a[contains(text(),'My Account')]")
	public WebElement myAccountTab;

	@FindBy(xpath="//a[contains(text(),'Appointment')]")
	public WebElement appointmentTab;
	
	@FindBy(xpath="//a[contains(text(),'Book Appointment')]")
	public WebElement bookAppointmentSubMenu;
	
	@FindBy(xpath="//a[contains(text(),'My Calendar')]")
	public WebElement myCalendarSubMenu;
	
	@FindBy(xpath="//a[contains(text(),'Bulk Operations')]")
	public WebElement bulkOperationsSubMenu;
	
	@FindBy(xpath="//a[contains(text(),'FAQ')]")
	public WebElement faqTab;
	
	@FindBy(xpath="//a[contains(text(),'Contact Us')]")
	public WebElement contactUsTab;
	
	@FindBy(xpath="//label[normalize-space()='All consultations']")
	public WebElement allConsultationCheckbox;
	
	@FindBy(xpath="//span[@class='user-img']")
	public WebElement profileImage;
	
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Logout']")
	public WebElement logout;
	
	public DoctorHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		TestBase.logExtentReport("Doctor Home Page Object Created");
	}
	
	public boolean landOnDoctorHomePage() {
		boolean landedOnDoctorHomePage = false;
		VerificationHelper verificationHelper = new VerificationHelper(driver);
		waitHelper.waitForElement(homeTab,30);
		if(driver.getCurrentUrl().contains("Doctor_Home") && (verificationHelper.isDisplayed(homeTab))) {
			landedOnDoctorHomePage = true;
			logExtentReport("Landed on Doctor home page");
		}
		return landedOnDoctorHomePage;
	}
	
	public void navigateToMyDashboard() {
		waitHelper.waitForElement(dashboardTab, 20);
		dashboardTab.click();
		waitHelper.waitForElement(myDashboardSubmenu, 20);
		myDashboardSubmenu.click();
		allConsultationCheckbox.click();
	}
	
	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}

}
