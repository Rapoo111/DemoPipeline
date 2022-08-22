package com.bk_automation_testNG_prototype.pageObject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.bk_automation_testNG_prototype.helper.assertion.VerificationHelper;
import com.bk_automation_testNG_prototype.helper.logger.LoggerHelper;
import com.bk_automation_testNG_prototype.helper.wait.WaitHelper;
import com.bk_automation_testNG_prototype.testbase.TestBase;

public class QscSignInPage {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	
	WaitHelper waitHelper;
	VerificationHelper verificationHelper = new VerificationHelper(driver);

	@FindBy(xpath = "//div[@class='user-modal']")
	public WebElement loginPage;
	
	@FindBy(id="user_email")
	public WebElement userNameField;
	
	@FindBy(name="commit")
	public WebElement continueBtn;
	
	@FindBy(id="password")
	public WebElement passwordField;
	
	@FindBy(id="kc-login")
	public WebElement signInBtn;
	
	@FindBy(xpath="//div[@class='reflect-profile']")
	public WebElement qscPage;
	
	
	
	
	public QscSignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(JoinNidaanText,ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("SignUp Page Object Created");
	}
	
	public boolean  landOnSignInPage() {
		waitHelper.waitForElement(loginPage,10);
		return new VerificationHelper(driver).isDisplayed(loginPage);
	}
	
	public void enterUsername(String username){
		this.userNameField.clear();
		log.info("Entering username..."+username);
		this.userNameField.sendKeys(username);
		logExtentReport("Entered username - "+username);
	}
	
	public void clickOnContinue() {
		waitHelper.WaitForElementClickable(continueBtn, 5);
		this.continueBtn.click();
		log.info("Clicked on continue button...");
		logExtentReport("Clicked on continue button... ");
	}
	
	public void enterPassword(String password){
		this.passwordField.clear();
		log.info("Entering password..."+password);
		this.passwordField.sendKeys(password);
		logExtentReport("Entered password - "+password);
	}
	
	public void clickOnSignInBtn() {
		this.signInBtn.click();
		log.info("Clicked on signIn  button...");
		logExtentReport("Clicked on signIn button... ");
	}
	
	public boolean verifySuccessfullSignIn() {
		VerificationHelper verificationHelper = new VerificationHelper(driver);
		waitHelper.waitForElement(qscPage,5);
		logExtentReport("Successfully logged into QSC website");
		verificationHelper.isDisplayed(qscPage);
		return verificationHelper.isDisplayed(qscPage);
	}
	
	public void signIntoQscApplication(String username, String password) throws InterruptedException, IOException {
		
		enterUsername(username);
		clickOnContinue();
		enterPassword(password);
		clickOnSignInBtn();
		Thread.sleep(4000);
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\AutoIT\\QSCADMINISTRATORS.exe");
		driver.get("https://wwwdev.qsc.com/index.php?id=15382");
		Thread.sleep(6000);
		driver.get("https://iddev.qsc.com/my-qsc");
		Thread.sleep(6000);
	}
	
	public void signIntoQscApplication_Failure(String username, String password) throws InterruptedException, IOException {
		
		enterUsername(username);
		clickOnContinue();
		enterPassword(password);
		clickOnSignInBtn();
	}
	
	public boolean verifyFailureMessage() {
		//WebDriverWait wait = new WebDriverWait(driver,1);
		//wait.until(ExpectedConditions.visibilityOf(qscPage));
		boolean errMsg = qscPage.isDisplayed();
		return errMsg;
	}
	
	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}

}
