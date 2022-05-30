package com.bk_automation_testNG_prototype.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.bk_automation_testNG_prototype.helper.assertion.VerificationHelper;
import com.bk_automation_testNG_prototype.helper.browserconfiguration.config.ObjectReader;
import com.bk_automation_testNG_prototype.helper.logger.LoggerHelper;
import com.bk_automation_testNG_prototype.helper.wait.WaitHelper;
import com.bk_automation_testNG_prototype.testbase.TestBase;

/*
 * @author  Rishabh Jain
 *
 */
public class LoginPage {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	
	WaitHelper waitHelper;

	@FindBy(id="username")
	WebElement emailAddress;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="Login")
	WebElement submitLogin;
	
	@FindBy(xpath="//input[@title=\"Search...\"]")
	WebElement searchObject;
	
	@FindBy(id="save")
	WebElement verification;
	
	@FindBy(id="error")
	WebElement loginError;
	
	@FindBy(xpath="//button/div/span/div/span")
	WebElement profileIcon;
	
	@FindBy(linkText = "Log Out")
	WebElement logout;
	
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(emailAddress,ObjectReader.reader.getExplicitWait());
		
		TestBase.logExtentReport("Login Page Object Created");
	
	}
	
	public void enterEmailAddress(String emailAddress){
		this.emailAddress.clear();
		log.info("entering email address...."+emailAddress);
		logExtentReport("entering email address...."+emailAddress);
		this.emailAddress.sendKeys(emailAddress);
	}
	
	public void enterPassword(String password){
		this.password.clear();
		log.info("entering password...."+password);
		logExtentReport("entering password....******");
		this.password.sendKeys(password);
	}
	
	public void clickOnSubmitButton(){
		
		log.info("clicking on submit button...");
		logExtentReport("clicking on submit button...");
		this.submitLogin.click();
		
	}
	
public void clickOnProfileIconButton(){
		
		log.info("clicking on profile icon button...");
		logExtentReport("clicking on profile icon button...");
		this.profileIcon.click();
		
	}
	public void clickOnLogoutButton(){
		
		log.info("clicking on logout button...");
		logExtentReport("clicking on logout button...");
		this.logout.click();
		
	}
	
	public void loginToApplication(String emailAddress, String password){
		enterEmailAddress(emailAddress);
		enterPassword(password);
		clickOnSubmitButton();
		
	}
	
	public boolean verifySuccessLogin(){
		return new VerificationHelper(driver).isDisplayed(searchObject);
	}
	
	public String verifyFailLoginMsg() {
		
		return new VerificationHelper(driver).getText(loginError);
	}
	
	public boolean verifyBlankUserLogin()
	{
		return new VerificationHelper(driver).isDisplayed(emailAddress);
	}
	
	public void verifyUserLogin(boolean result) {
	
		
		Assert.assertEquals(searchObject.isDisplayed(), result);
		logExtentReport("User Login successfully....");
		
		
	}
	
	
	public void logout(){
		clickOnProfileIconButton();
		clickOnLogoutButton();
	}
	
	
	public void verifyUserLogOut(boolean result) {
		
		
		Assert.assertEquals(emailAddress.isDisplayed(), result);
		logExtentReport("User LogOut successfully....");
		
		
	}
	
	
	public boolean verifySuccessLogOut(){
		return new VerificationHelper(driver).isDisplayed(emailAddress);
	}
	
	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}

	
	

}
