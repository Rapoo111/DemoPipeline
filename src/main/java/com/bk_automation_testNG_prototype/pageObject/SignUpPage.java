package com.bk_automation_testNG_prototype.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.bk_automation_testNG_prototype.helper.assertion.VerificationHelper;
import com.bk_automation_testNG_prototype.helper.browserconfiguration.config.ObjectReader;
import com.bk_automation_testNG_prototype.helper.logger.LoggerHelper;
import com.bk_automation_testNG_prototype.helper.select.DropDownHelper;
import com.bk_automation_testNG_prototype.helper.wait.WaitHelper;
import com.bk_automation_testNG_prototype.testbase.TestBase;

public class SignUpPage {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	
	WaitHelper waitHelper;
	VerificationHelper verificationHelper = new VerificationHelper(driver);

	@FindBy(xpath = "//a[@class='btn btn-primary mr-2 mr-md-3']")
	public WebElement signUp;
	
	@FindBy(xpath="//h1[normalize-space()='Join Nidaan']")
	public WebElement JoinNidaanText;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_txtMobile")
	public WebElement mobileNumber;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_txtPatientFirstName")
	public WebElement firstName;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_txtPatientLastName")
	public WebElement lastName;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_txtPatientDOB")
	public WebElement dob;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_doctorSearchControl_TxtAccessCode")
	public WebElement doctorAccessCode;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_txtPatientEmail")
	public WebElement emailAddress;
	
	@FindBy(id="ddlPrefferedLanguage")
	public WebElement language;
	
	@FindBy(id="btnRegister")
	public WebElement signUpButton;
	
	@FindBy(id="divmsgshow")
	public WebElement successfullSignUpPopup;
	
	@FindBy(id="PRShowMessage")
	public WebElement patientRegistrationText;
	
	@FindBy(id="btnok")
	public WebElement okButton;
	
	@FindBy(xpath="//h1[normalize-space()='Login']")
	public WebElement loginButton;
	
	@FindBy(xpath = "//p[@class='m-0']")
	public WebElement signUpErrorMesg;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(JoinNidaanText,ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("SignUp Page Object Created");
	}
	
	public boolean  landOnSignUpPage() {
		waitHelper.waitForElement(JoinNidaanText,10);
		return new VerificationHelper(driver).isDisplayed(JoinNidaanText);
	}
	
	public void enterMobileNumber(String mobileNumber){
		this.mobileNumber.clear();
		log.info("Entering mobile number..."+mobileNumber);
		this.mobileNumber.sendKeys(mobileNumber);
		logExtentReport("Entered mobile number - "+mobileNumber);
	}
	
	public void enterFirstName(String firstName){
		this.firstName.clear();
		log.info("Entering first name ...."+firstName);
		this.firstName.sendKeys(firstName);
		logExtentReport("Entered first name - "+firstName);
	}
	
	public void enterLastName(String lastName){
		this.lastName.clear();
		log.info("Entering last name ...."+lastName);
		this.lastName.sendKeys(lastName);
		logExtentReport("Entering last name ...."+lastName);
	}
	
	public void enterDob(String dob){
		this.dob.click();
		this.dob.clear();
		log.info("Entering dob...."+dob);
		this.dob.sendKeys(dob);
		//logExtentReport("Entered dob - "+dob);
	}
	
	public void enterEmail(String emailAddress){
		this.emailAddress.clear();
		log.info("entering email address...."+emailAddress);
		this.emailAddress.sendKeys(emailAddress);
		logExtentReport("entering email address - "+emailAddress);
	}
	
	public void enterDoctorAccessCode(String accessCode){
		this.doctorAccessCode.clear();
		log.info("entering access code...."+accessCode);
		this.doctorAccessCode.sendKeys(accessCode);
		logExtentReport("Enetred doctor access code - "+accessCode);
	}
	
	public void selectLanguage(String language){
		DropDownHelper dropDown = new DropDownHelper(driver);
		log.info("Selecting language from dropdown"+language);
		dropDown.selectUsingValue(this.language, language);
		logExtentReport("Entered language - "+language);
	}
	
	public void clickOnSignUpButton() {
		this.signUpButton.click();
		logExtentReport("Clicked on Sign Up button.");
	}
	
	public void signUpIntoApplication(String mobileNumber, String firstName, String lastName,String dob, String accessCode, String emailAddress,String language) {
		enterMobileNumber(mobileNumber);
		enterFirstName(firstName);
		enterLastName(lastName);
		enterDob(dob);
		enterDoctorAccessCode(accessCode);
		enterEmail(emailAddress);
		selectLanguage(language);
		clickOnSignUpButton();
		
	}
	
	public boolean  verifySuccessfullSignUp() {
		VerificationHelper verificationHelper = new VerificationHelper(driver);
		waitHelper.waitForElement(successfullSignUpPopup,20);
		logExtentReport("Successfull SignUp popup displayed");
		verificationHelper.isDisplayed(patientRegistrationText);
		okButton.click();
		logExtentReport("Clicked on Ok button.");
		return verificationHelper.isDisplayed(loginButton);
	}
	
	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}

}
