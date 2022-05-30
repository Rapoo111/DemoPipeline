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

public class NidaanLoginPage {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	
	WaitHelper waitHelper;
	
	@FindBy(xpath="//div[@class='content home-page pt-0']")
	public WebElement homePageContent;
	
	@FindBy(xpath="//strong[normalize-space()='Login']")
	public WebElement loginButtonOnHome;
	
	@FindBy(xpath="//h1[contains(text(),'Login')]")
	public WebElement loginText;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_txtUsername")
	public WebElement username;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_txtPassword")
	public WebElement password;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnsignin")
	public WebElement loginButton;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_lblErrorMsg")
	public WebElement loginError;

	@FindBy(xpath="//a[contains(text(),'Forgot Password?')]")
	public WebElement forgotPasswordLink;
	
	@FindBy(xpath="//a[@class='text-info'][normalize-space()='Sign Up']")
	public WebElement signUpLink;
	
	@FindBy(xpath="//h4[normalize-space()='Choose a profile to log in with']")
	public WebElement profileSelectionPage;
	
	@FindBy(xpath="//b[normalize-space()='Doctor']")
	public WebElement doctorProfile;
	
	@FindBy(xpath="//b[normalize-space()='Patient']")
	public WebElement patientProfile;
	
	public NidaanLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		TestBase.logExtentReport("Login Page Object Created");
	}

	public void landOnLoginPage() {
		waitHelper.waitForElement(loginButtonOnHome,30);
		loginButtonOnHome.click();
		log.info("Landed on Login page");
		logExtentReport("Landed on login page");
	}
	
	public void enterUsername(String username) {
		this.username.clear();
		log.info("Entering username..."+username);
		this.username.sendKeys(username);
		logExtentReport("Entered username - "+username);
	}
	
	public void enterPassword(String password) {
		this.password.clear();
		log.info("Entering password..."+password);
		this.password.sendKeys(password);
		logExtentReport("Entered password - "+password);
	}
	
	public void clickOnLoginButton() {
		this.loginButton.click();
		logExtentReport("Clicked on Login button.");
	}
	
	public void loginIntoApplication(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickOnLoginButton();
		
	}
	
	public boolean verifyFailLogin() {
		return new VerificationHelper(driver).isDisplayed(loginError);
	}
	
	public boolean verifySuccessLogOut(){
		return new VerificationHelper(driver).isDisplayed(homePageContent);
	}
	
	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}
	
	
}
